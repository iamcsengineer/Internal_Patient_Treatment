package com.cognizant.offerings.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PackageDetail {

	/**
	 * instance variables
	 */
	private String treatmentPackageName;
	private String testDetails;
	private int cost;
	private int treatmentDurationInWeeks;
}
