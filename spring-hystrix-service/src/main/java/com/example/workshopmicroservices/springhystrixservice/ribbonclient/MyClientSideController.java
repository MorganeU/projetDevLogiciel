package com.example.workshopmicroservices.springhystrixservice.ribbonclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// this is a REST controller
@RestController
public class MyClientSideController {
	// create a rest template bean and make it load balanced
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// auto-inject it
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/client/frontend")
	public String hi(@PathVariable String id) {
		// we gonna return a randomString using our rest object
		String randomString = this.restTemplate.getForObject("http://server/backend", String.class);
		return "Server Response :: " + randomString;
	}
}
