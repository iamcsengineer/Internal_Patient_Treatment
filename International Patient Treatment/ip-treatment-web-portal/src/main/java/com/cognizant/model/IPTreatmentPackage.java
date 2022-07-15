package com.cognizant.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IPTreatmentPackage {

private long id;
private String ailmentCategory;
PackageDetail packageDetail;
@Override
public String toString() {
	return "IPTreatmentPackage [id=" + id + ", ailmentCategory=" + ailmentCategory + ", packageDetail=" + packageDetail
			+ "]";
}

 }