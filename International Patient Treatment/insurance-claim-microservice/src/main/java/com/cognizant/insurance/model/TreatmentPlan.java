package com.cognizant.insurance.model;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TreatmentPlan {

	/**
	 * instance variables
	 * 
	 * @Id helps in defining the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = PatientDetail.class)
	@JoinColumn(name = "tp_pt_id")
	private PatientDetail ptDetail; 
	private String testDetails; 
	private String packageName; 
	private String specialist;
	private double cost;
	private String status;
	private String treatmentCommencementDate;
	private String treatmentEndDate;

}
