package com.cognizant.auth.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.auth.model.Admin;
import com.cognizant.auth.repository.UserRepository;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		With the @SpringBootTest annotation, Spring Boot provides a 
 * 		convenient way to start up an application context to be used in a test
 * 		@RunWith is an annotation to use test runners
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerDetailsServiceTest {
	
	/**
	 * @InjectMocks annotation can be used to inject mock fields into a test object automatically
	 */
	@InjectMocks
	CustomerDetailsService customerDetailService;

	@Mock
	UserRepository userRepository;

	/**
	 * to test the test_loadUserByUsername()
	 */
	@Test
	public void test_loadUserByUsernameTest() {
		
		Admin user1=new Admin("admin","admin","admin", null);
		Optional<Admin> data =Optional.of(user1) ;
		when(userRepository.findById("admin")).thenReturn(data);
		UserDetails loadUserByUsername = customerDetailService.loadUserByUsername("admin");
		assertEquals(user1.getUserid(),loadUserByUsername.getUsername());
	}

}
