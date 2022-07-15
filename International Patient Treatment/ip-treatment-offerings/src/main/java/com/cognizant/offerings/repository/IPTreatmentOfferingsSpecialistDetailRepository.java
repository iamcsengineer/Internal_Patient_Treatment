package com.cognizant.offerings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.offerings.model.SpecialistDetail;


@Repository
public interface IPTreatmentOfferingsSpecialistDetailRepository extends JpaRepository<SpecialistDetail, Long>{

}
