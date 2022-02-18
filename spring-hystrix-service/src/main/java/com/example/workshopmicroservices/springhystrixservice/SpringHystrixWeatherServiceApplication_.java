package com.example.workshopmicroservices.springhystrixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
// we gonna use a hystrix circuit breaker
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SpringHystrixWeatherServiceApplication_ {

    public static void main(String[] args) {
        SpringApplication.run(SpringHystrixWeatherServiceApplication_.class, args);
    }
}
