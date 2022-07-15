package com.cognizant.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class InsurerDetail {

	
	
	private long id;
	private String insurerName;
	private String insurerPackageName;
	private int insuranceAmountLimit;
	private int disbursementDuration;
	
	@Override
	public String toString() {
		return "InsurerDetail [id=" + id + ", insurerName=" + insurerName + ", insurerPackageName=" + insurerPackageName
				+ ", insuranceAmountLimit=" + insuranceAmountLimit + ", disbursementDuration=" + disbursementDuration
				+ "]";
	}
}
