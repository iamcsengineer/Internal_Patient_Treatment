package com.cognizant.treatments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.treatments.model.PatientDetail;



public interface PatientDetailRepository extends JpaRepository<PatientDetail, Long> {

	/**
	 * query to select patient detail based on patient id
	 * 
	 * @param id
	 * @return PatientDetail
	 */
	
	@Query("Select p from PatientDetail p where p.id =?1")
	PatientDetail getPatientById(long id);
}
