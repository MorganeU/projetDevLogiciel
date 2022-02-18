package com.example.workshopmicroservices.springhystrixservice.ribbonclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
// this is a Discovery client
@EnableDiscoveryClient
// configure a ribbon client (this is a server)
@RibbonClient(name = "server", configuration = RibbonConfiguration.class)
public class RibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}
}
