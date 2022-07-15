package com.cognizant.treatments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetail {

	/**
	 * instance variables
	 * @Id for primary key attribute
	 * @SequenceGenerator @Generatedvalue to automatically generate id's
	 */
	
	@Id
	@SequenceGenerator(name = "mySeqGen", sequenceName = "myDbSeq", initialValue = 1)
	@GeneratedValue(generator = "mySeqGen")
	private long id;

	private String name;

	private int age;

	private String ailment;

	private String treatmentPackageName;

	private String treatmentCommencementDate;

}
