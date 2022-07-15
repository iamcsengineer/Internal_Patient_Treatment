package com.cognizant.offerings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(scanBasePackages = { "com.cognizant" })
@EnableFeignClients
public class IpTreatmentOfferingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpTreatmentOfferingsApplication.class, args);
	}

	/**
	 * to create bean for Rest Template to auto wiring the Rest Template object
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
