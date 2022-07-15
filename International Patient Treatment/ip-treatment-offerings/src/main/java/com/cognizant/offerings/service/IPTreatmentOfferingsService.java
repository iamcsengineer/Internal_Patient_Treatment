package com.cognizant.offerings.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.offerings.model.IPTreatmentPackage;
import com.cognizant.offerings.model.SpecialistDetail;


@Service
public interface IPTreatmentOfferingsService {

	/**
	 * to return all the treatment packages
	 * 
	 * @return List<IPTreatmentPackage>
	 */
	public List<IPTreatmentPackage> getIPTreatmentPackages();
	
	/**
	 * to return the treatment package based on ailment category
	 * and package name
	 * 
	 * @param packageName
	 * @param category
	 * @return IPTreatmentPackage
	 */
	public IPTreatmentPackage getIPTreatmentPackageByAilmentCategoryAndName(String packageName, String category);
	
	/**
	 * to return the list of specialists details
	 * 
	 * @return List<SpecialistDetail>
	 */
	public List<SpecialistDetail> getSpecialists();
}
