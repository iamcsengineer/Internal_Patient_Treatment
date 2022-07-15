package com.cognizant.model;





import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InitiateClaim {

	private long id;
	private String specialist;
	private String treatmentCommencementDate;
	private String treatmentEndDate;
	private String patientName;
	private String patientStatus;
	private String ailment;
	private String treatmentPackageName;
	private String testDetail;
	private String insurerName;
	private String insurerPackageName;
	private int insuranceAmountLimit;
	private int disbursementDuration;
	private int treatmentEndDateCost;
	private int treatmentDurationinWeeks;
	private int age;
	private int finalCost;

}

