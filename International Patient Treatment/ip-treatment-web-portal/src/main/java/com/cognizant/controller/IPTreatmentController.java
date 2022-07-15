package com.cognizant.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.clients.AuthenticationFeign;
import com.cognizant.clients.ICClient;
import com.cognizant.clients.IPTFClient;
import com.cognizant.clients.IPTOFClient;
import com.cognizant.model.Admin;
import com.cognizant.model.IPTreatmentPackage;
import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.model.TreatmentPlan;
import com.cognizant.service.AuthFeignService;
import com.cognizant.service.PortalService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IPTreatmentController {

	
	@SuppressWarnings("unused")
	@Autowired
	private AuthenticationFeign authClient;
	
	@Autowired
	IPTFClient iPTFClient;
	
	@Autowired
	IPTOFClient iPTFOClient;
	
	@Autowired
	ICClient iCClient;
	
	@Autowired
	private AuthFeignService feignService;
	
	@Autowired
	private PortalService portalService;
	
	
	@GetMapping(value = "/")
	public ModelAndView getLoginPage() {
		log.info("START :: Method :: getLoginPage() :: ");
		return new ModelAndView("login");
	}
	
	@PostMapping(value = "/login")
	public ModelAndView getLogin(@ModelAttribute("user") Admin user, HttpServletRequest request) {
		log.info("START :: Method :: getLogin() :: ");
		Admin admin = null;
		try {
			@SuppressWarnings("unchecked")
			LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) feignService.getToken(user).getBody();
			// response = feignService.getToken(user);
			admin = new Admin(map.get("userid"), map.get("upassword"), map.get("uname"), map.get("authToken"));

		} catch (Exception e) {
			ModelAndView mAV = new ModelAndView("login");
			String invalidLogin="Username or password is Incorrect";
			mAV.addObject("error", invalidLogin);
			
			return mAV;
		}
		request.getSession().setAttribute("token", "Bearer " + admin.getAuthToken());
		request.getSession().setAttribute("name", admin.getUserid());
		return new ModelAndView("AdminDashboard");
	}
	
	
	@GetMapping(value = "/admindashboard")
	public ModelAndView getDashboard(HttpServletRequest request) {
		log.info("START :: Method :: getDashboard() :: ");
		String token = (String) request.getSession().getAttribute("token");
		if(token!=null) {
			
		return new ModelAndView("AdminDashboard");
		}
		else {
			return new ModelAndView("redirect:/");
		}
		}
	
	
	@PostMapping(value = "/register")
	public ModelAndView getRegister(@RequestParam("pId") String id, @RequestParam("cost") int cost,
			@RequestParam("pName") String pack, @RequestParam("aName") String ailment) {
		log.info("START :: Method :: getRegister() :: ");
		ModelAndView mAV = new ModelAndView("registration");
		mAV.addObject("pack", pack);
		mAV.addObject("ailment", ailment);
		mAV.addObject("cost", cost);
		return mAV;
	}
	
	@PostMapping(value = "/registerSubmit")
	public ModelAndView registerPatient(@RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("ailment") String ailment, @RequestParam("treatmentPackageName") String pkg,
			@RequestParam("cost") int cost, HttpServletRequest request) {
		log.info("START :: Method :: registerPatient() :: ");
		PatientDetail patient = new PatientDetail(0, name, age, ailment, pkg, null);
		if (patient.getTreatmentPackageName().equalsIgnoreCase("Package 1"))
			patient.setTreatmentPackageName("package1");
		else if (patient.getTreatmentPackageName().equalsIgnoreCase("Package 2"))
			patient.setTreatmentPackageName("package2");
		String token = (String) request.getSession().getAttribute("token");
		TreatmentPlan tp = portalService.registerPatient(token, patient, cost);
		System.out.println(tp);
		ModelAndView mAV = new ModelAndView("particulartreatplan");
		mAV.addObject("plan", tp);
		return mAV;
	}
	
	

	@GetMapping(value = "/patients")
	public ModelAndView getPatients(HttpServletRequest request) {
		log.info("START :: Method :: getPatients() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			ModelAndView mAV = new ModelAndView("patients");
			List<TreatmentPlan> patient = portalService.getTreatmentPlanList(token);
			mAV.addObject("patient", patient);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}

	}
	
	@GetMapping(value = "/ongoingTreatments")
	public ModelAndView getTreatmentPlans(HttpServletRequest request) {
		log.info("START :: Method :: getTreatmentPlans() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			ModelAndView mAV = new ModelAndView("treatplan");
			List<TreatmentPlan> patient = portalService.getOnGoingTreatmentPlanList(token);
			mAV.addObject("patient", patient);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}

	}
	
	@GetMapping(value = "/ongoingTreatmentsnew")
	public ModelAndView getTreatmentPlansNew(HttpServletRequest request) {
		log.info("START :: Method :: getTreatmentPlans() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			ModelAndView mAV = new ModelAndView("treatmentplan");
			List<TreatmentPlan> patient = portalService.getOnGoingTreatmentPlanList(token);
			mAV.addObject("patient", patient);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}

	}


	
	@GetMapping(value = "/specialist")
	public ModelAndView getSpecialist(HttpServletRequest request) {
		log.info("START :: Method :: getSpecialist() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			ModelAndView mAV = new ModelAndView("Specialist");
			List<SpecialistDetail> specialists = portalService.getSpecialistDetail(token);
			mAV.addObject("specialist", specialists);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@GetMapping(value = "/packages")
	public ModelAndView getPackages(HttpServletRequest request) {
		log.info("START :: Method :: getPackages() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");

		if (token != null) {
			ModelAndView mAV = new ModelAndView("packages");
			List<IPTreatmentPackage> pckgresponse = portalService.getPackageDetail(token);
			mAV.addObject("package", pckgresponse);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	

	@GetMapping(value = "/insurer")
	public ModelAndView getInsurer(HttpServletRequest request) {
		log.info("START :: Method :: getInsurer() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {
			ModelAndView mAV = new ModelAndView("insurer");
			List<InsurerDetail> insurer = portalService.getInsurerDetail(token);
			mAV.addObject("insurer", insurer);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@GetMapping(value = "/claimInsurance")
	public ModelAndView claimInsurance(@RequestParam("id") int ptId, HttpServletRequest request) {
		log.info("START :: Method :: claimInsurance() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");
		if (token != null) {

			ModelAndView mAV = new ModelAndView("claim");
			List<InsurerDetail> insurers = portalService.claimInsurance(token);
			mAV.addObject("ptId", ptId);
			mAV.addObject("insurers", insurers);
			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}

	}
	
	
	@PostMapping(value = "/initiateClaim")
	public ModelAndView initiateClaim(@RequestParam("ptId") long ptId, @RequestParam String pckgName,
			HttpServletRequest request) {
		log.info("START :: Method :: initiateClaim() :: ");
		String token = (String) request.getSession().getAttribute("token");
		@SuppressWarnings("unused")
		String name = (String) request.getSession().getAttribute("name");

		if (token != null) {
			InsurerDetail ins = portalService.getInsurerDetail(pckgName, token);
			PatientDetail pt = portalService.getPatientDetail(ptId, token);
			TreatmentPlan tp = portalService.getTreatmentDetail(ptId, token);
			System.out.println(tp.getTreatmentCommencementDate());
			System.out.println(pt.getId() + " " + tp.getSpecialist() + " " + tp.getTreatmentCommencementDate() + " "
					+ tp.getTreatmentEndDate() + " " + pt.getName() + " " + tp.getStatus() + " " + pt.getAilment() + " "
					+ tp.getPackageName() + " " + tp.getTestDetails() + " " + ins.getInsurerName() + " "
					+ ins.getInsurerPackageName() + " " + ins.getInsuranceAmountLimit() + " "
					+ ins.getDisbursementDuration() + " " + tp.getCost() + " " + 6 + " " + pt.getAge() + " " + 0);
			InitiateClaim ic = new InitiateClaim(1, tp.getSpecialist(), tp.getTreatmentCommencementDate(),
					tp.getTreatmentEndDate(), pt.getName(), tp.getStatus(), pt.getAilment(), tp.getPackageName(),
					tp.getTestDetails(), ins.getInsurerName(), ins.getInsurerPackageName(),
					ins.getInsuranceAmountLimit(), ins.getDisbursementDuration(), tp.getCost(), 6, pt.getAge(), 0);
			int amt = portalService.initiateClaim(token, ic);
			portalService.updatePlan(ptId, token);
			ModelAndView mAV = new ModelAndView("final");
			mAV.addObject("Outstanding", amt);
			mAV.addObject("InsurAmt", ins.getInsuranceAmountLimit());
			mAV.addObject("total", tp.getCost());

			return mAV;
		} else {
			return new ModelAndView("redirect:/");
		}

	}
	
	@GetMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		log.info("START :: Method :: logout() :: ");
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}

}
