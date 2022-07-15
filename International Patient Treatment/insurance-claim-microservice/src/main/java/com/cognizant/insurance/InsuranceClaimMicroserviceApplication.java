package com.cognizant.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class InsuranceClaimMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceClaimMicroserviceApplication.class, args);
	}

}
