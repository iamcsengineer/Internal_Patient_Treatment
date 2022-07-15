package com.cognizant.treatments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@EnableFeignClients
@SpringBootApplication
public class IpTreatmentsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpTreatmentsMicroserviceApplication.class, args);
	}

}
