package com.cognizant.treatments.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.treatments.client.AuthClient;
import com.cognizant.treatments.model.AuthResponse;
import com.cognizant.treatments.model.PatientDetail;
import com.cognizant.treatments.model.TreatmentPlan;
import com.cognizant.treatments.service.IPTreatmentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 *
 *         With the @SpringBootTest annotation, Spring Boot provides a
 *         convenient way to start up an application context to be used in a test
 * 		   @AutoConfigureMockMvc can be applied to a test class to enable and configure
 *         auto-configuration of MockMvc
 */
@AutoConfigureMockMvc
@SpringBootTest
class IPTreatmentControllerTest {

	/**
	 * @MockBean allow to mock a class or an interface and to record and verify
	 * behaviors on it
	 */
	@MockBean
	AuthClient authClient;

	@Autowired
	MockMvc mockMvc;

	@MockBean
	IPTreatmentServiceImpl ipTreatmentServiceImpl;

	/**
	 * to test all the patient details list is fetched properly
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_GetAllPatients200() throws Exception {
		PatientDetail patient=new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-10-03");
		List<TreatmentPlan> treatmentPlans = new ArrayList<TreatmentPlan>();
		treatmentPlans.add(new TreatmentPlan(1l, patient, "Test 1, Test 2", "Package1", "Dr. A.K Mishra", 15000, "In Progress", "2021-03-10", "2021-03-20"));
		when(ipTreatmentServiceImpl.getAllPlans()).thenReturn(treatmentPlans);
		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		MvcResult result=mockMvc.perform(get("/iptms/getallplans").header("Authorization", "Bearer Token")).andReturn();
		String expected="[{\"id\":1,\"ptDetail\":{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-10-03\"},\"testDetails\":\"Test 1, Test 2\",\"packageName\":\"Package1\",\"specialist\":\"Dr. A.K Mishra\",\"cost\":15000.0,\"status\":\"In Progress\",\"treatmentCommencementDate\":\"2021-03-10\",\"treatmentEndDate\":\"2021-03-20\"}]";
		String actual=result.getResponse().getContentAsString();
		assertEquals(expected, actual);

	}
	
	/**
	 * to test that all ongoing patients list is fetched properly
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_GetAllOnGoingPatients200() throws Exception {
		PatientDetail patient=new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-10-03");
		List<TreatmentPlan> treatmentPlans = new ArrayList<TreatmentPlan>();
		treatmentPlans.add(new TreatmentPlan(1l, patient, "Test 1, Test 2", "Package1", "Dr. A.K Mishra", 15000, "In Progress", "2021-03-10", "2021-03-20"));
		when(ipTreatmentServiceImpl.getAllOnGoingplans()).thenReturn(treatmentPlans);
		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		MvcResult result=mockMvc.perform(get("/iptms/getallongoingtreatments").header("Authorization", "Bearer Token")).andReturn();
		String expected="[{\"id\":1,\"ptDetail\":{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-10-03\"},\"testDetails\":\"Test 1, Test 2\",\"packageName\":\"Package1\",\"specialist\":\"Dr. A.K Mishra\",\"cost\":15000.0,\"status\":\"In Progress\",\"treatmentCommencementDate\":\"2021-03-10\",\"treatmentEndDate\":\"2021-03-20\"}]";
		String actual=result.getResponse().getContentAsString();
		assertEquals(expected, actual);

	}

	/**
	 * to test that a patient detail is fetched properly
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_GetPatient() throws Exception {
		PatientDetail patient=new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-10-03");
		when(ipTreatmentServiceImpl.getPatient(1l)).thenReturn(patient);
		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		MvcResult result=mockMvc.perform(get("/iptms/getpatient/1").header("Authorization", "Bearer Token")).andReturn();
		String expected="{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-10-03\"}";
		String actual=result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	/**
	 * to test that the list of all plans are fetched properly
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_GetAPlan() throws Exception {
		PatientDetail patient=new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-03-11");
		TreatmentPlan treatmentPlan = new TreatmentPlan(1l, patient, "Test 1, Test 2", "Package1", "Dr. A.K Mishra", 15000.0, "In Progress", "2021-03-11", "2021-03-20");
		when(ipTreatmentServiceImpl.getPlan(1l)).thenReturn(treatmentPlan);
		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		MvcResult result=mockMvc.perform(get("/iptms/getplan/1").header("Authorization", "Bearer Token")).andReturn();
		String expected="{\"id\":1,\"ptDetail\":{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-03-11\"},\"testDetails\":\"Test 1, Test 2\",\"packageName\":\"Package1\",\"specialist\":\"Dr. A.K Mishra\",\"cost\":15000.0,\"status\":\"In Progress\",\"treatmentCommencementDate\":\"2021-03-11\",\"treatmentEndDate\":\"2021-03-20\"}";
		String actual=result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	/**
	 * to test the functioning of update status
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_UpdatePlan() throws Exception {
		PatientDetail patient=new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-03-11");
		TreatmentPlan newTreatmentPlan = new TreatmentPlan(1l, patient, "Test 1, Test 2", "Package1", "Dr. A.K Mishra", 15000.0, "Completed", "2021-03-11", "2021-03-20");
		when(ipTreatmentServiceImpl.getPlan(1l)).thenReturn(newTreatmentPlan);
		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		mockMvc.perform(put("/iptms/updateplan/1").content(asJsonString(newTreatmentPlan)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer Token")).andReturn();
		MvcResult result=mockMvc.perform(get("/iptms/getplan/1").header("Authorization", "Bearer Token")).andReturn();
		String expected="{\"id\":1,\"ptDetail\":{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-03-11\"},\"testDetails\":\"Test 1, Test 2\",\"packageName\":\"Package1\",\"specialist\":\"Dr. A.K Mishra\",\"cost\":15000.0,\"status\":\"Completed\",\"treatmentCommencementDate\":\"2021-03-11\",\"treatmentEndDate\":\"2021-03-20\"}";
		String actual=result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	/**
	 * to test the functioning of formulating treatment timetable
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_FormulateTreatmentTimetable() throws Exception {
		PatientDetail patient=new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-03-11");
		TreatmentPlan treatmentPlan = new TreatmentPlan(1l, patient, "Test 1, Test 2", "Package1", "Dr. A.K Mishra", 15000.0, "In Progress", "2021-03-11", "2021-03-20");
		when(ipTreatmentServiceImpl.getTreatmentPlan(patient,15000)).thenReturn(treatmentPlan);
		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.post("/iptms/formulatetreatmenttimetable/15000").content(asJsonString(patient)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer Token")).andReturn();
		String expected="{\"id\":1,\"ptDetail\":{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-03-11\"},\"testDetails\":\"Test 1, Test 2\",\"packageName\":\"Package1\",\"specialist\":\"Dr. A.K Mishra\",\"cost\":15000.0,\"status\":\"In Progress\",\"treatmentCommencementDate\":\"2021-03-11\",\"treatmentEndDate\":\"2021-03-20\"}";
		String actual=result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
