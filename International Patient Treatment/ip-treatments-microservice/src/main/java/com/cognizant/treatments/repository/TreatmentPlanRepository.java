package com.cognizant.treatments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.treatments.model.TreatmentPlan;



public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan, Long> {

	

	/**
	 * query to select treatment plan based on patient id
	 * 
	 * @param id
	 * @return TreatmentPlan
	 */
	
	@Query("select t from TreatmentPlan t left join fetch t.ptDetail p where p.id= :id")
	public TreatmentPlan getPlanUser(@Param("id") long id);
 
	/**
	 * query to show the list of available treatment plans
	 * 
	 * @return List<TreatmentPlan>
	 */
	@Query("select t from TreatmentPlan t where t.status = 'In progress'") public
	  List<TreatmentPlan> getAllOnGoingplans();
	 
	/**
	 * query to show the list of All available treatment plans
	 * 
	 * @return List<TreatmentPlan>
	 */
	@Query("select t from TreatmentPlan t")
	public List<TreatmentPlan> getAllplans();
}
