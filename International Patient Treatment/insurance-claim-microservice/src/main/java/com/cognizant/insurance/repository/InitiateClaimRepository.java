package com.cognizant.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.insurance.model.InitiateClaim;


public interface InitiateClaimRepository extends JpaRepository<InitiateClaim, Long>{

}
