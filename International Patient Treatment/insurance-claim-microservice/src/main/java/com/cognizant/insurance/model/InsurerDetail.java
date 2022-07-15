package com.cognizant.insurance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
@Entity
@Table(name = "insurer_detail")
public class InsurerDetail {

	/**
	 * instance variables
	 * 
	 * @Id helps in defining the primary key
	 */
	@Id
	private long id;
	private String insurerName;
	private String insurerPackageName;
	private double insuranceAmountLimit;
	private int disbursementDuration;
}
