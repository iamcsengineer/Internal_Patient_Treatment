package com.cognizant.offerings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.offerings.client.AuthClient;
import com.cognizant.offerings.exception.InvalidTokenException;
import com.cognizant.offerings.exception.PackageDetailNotFoundException;
import com.cognizant.offerings.model.AuthResponse;
import com.cognizant.offerings.model.IPTreatmentPackage;
import com.cognizant.offerings.model.SpecialistDetail;
import com.cognizant.offerings.repository.IPTreatmentOfferingsPackageDetailRepository;
import com.cognizant.offerings.repository.IPTreatmentOfferingsSpecialistDetailRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class IPTreatmentOfferingsServiceImpl implements IPTreatmentOfferingsService{

	/**
	 * autowires the AuthClient(feign client) to communicate with authorization
	 * microservice autowires the IPTreatmentOfferingsService
	 * autowires the IPTreatmentOfferingsPackageDetailRepository and
	 * IPTreatmentOfferingsSpecialistDetailRepository
	 */
	@Autowired
	AuthClient authClient;
	
	@Autowired
	IPTreatmentOfferingsPackageDetailRepository ipTreatmentOfferingsPackageDetailRepository;
	
	@Autowired
	IPTreatmentOfferingsSpecialistDetailRepository ipTreatmentOfferingsSpecialistDetailRepository;
	
	/**
	 * to return list of all the treatment package
	 * 
	 * @return List<IPTreatmentPackage>
	 */
	public List<IPTreatmentPackage> getIPTreatmentPackages() {
		log.info("START :: Method :: getIPTreatmentPackages() :: ");
		List<IPTreatmentPackage> packageDetail = ipTreatmentOfferingsPackageDetailRepository.findAll();
		log.info("packagedetail{}:", packageDetail);
		log.info("END :: Method :: getIPTreatmentPackages() :: ");
		return packageDetail;
	}
	
	/**
	 * to return the treatment package based on ailment category
	 * and package name
	 * 
	 * @param packageName
	 * @param category
	 * @return IPTreatmentPackage
	 */
	public IPTreatmentPackage getIPTreatmentPackageByAilmentCategoryAndName(String packageName, String category) {
		log.info("START :: Method :: getIPTreatmentPackageByAilmentCategoryAndName() :: ");
		IPTreatmentPackage packageDetail = null;
		if (packageName.equalsIgnoreCase("package1"))
			packageDetail = ipTreatmentOfferingsPackageDetailRepository.findByName("Package1", category);
		else
			packageDetail = ipTreatmentOfferingsPackageDetailRepository.findByName("Package2", category);
		
		if (packageDetail == null) {
			throw new PackageDetailNotFoundException(packageName);
		}

		log.info("packagedetail{}:", packageDetail);
		log.info("END :: Method :: getIPTreatmentPackageByAilmentCategoryAndName() :: ");
		return packageDetail;
	}

	/**
	 * to return the list of specialists details
	 * 
	 * @return List<SpecialistDetail>
	 */
	public List<SpecialistDetail> getSpecialists() {
		log.info("START :: Method :: getSpecialists() :: ");
		List<SpecialistDetail> specialistDetail = ipTreatmentOfferingsSpecialistDetailRepository.findAll();
		log.info("packagedetail{}:", specialistDetail);
		log.info("END :: Method :: getSpecialists() :: ");
		return specialistDetail;
	}
	
	/**
	 * to validate the token
	 * 
	 * @param token
	 * @return AuthResponse
	 */
	public AuthResponse validateToken(String token) {

		AuthResponse authResponse = null;
		try {
			authResponse = authClient.verifyToken(token);
			if (!authResponse.isValid()) {
				throw new InvalidTokenException();
			}
		} catch (Exception e) {
			throw new InvalidTokenException();
		}

		return authResponse;
	}

}
