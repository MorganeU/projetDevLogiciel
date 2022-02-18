package com.example.workshopmicroservices.springhystrixservice.delegate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

public class WeatherServiceDelegate_ {
    @Autowired
    RestTemplate restTemplate;

    // implement a callWeatherService method and enabled it by hystrix. we wanna return Weather detail with a normal flow
    @HystrixCommand(fallbackMethod = "callWeatherServiceAndGetData_Fallback") // ca va appeler fallback si service non utilisable
    public String callWeatherServiceAndGetData(String ville_name) {
        System.out.println("Getting School details for " + ville_name);
        String response = restTemplate
                .exchange("http://localhost:8098/getStudentDetailsForSchool/{schoolname}"  // this a http exchange
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, ville_name).getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return "NORMAL FLOW !!! - School Name -  " + ville_name + " :::  Student Details " + response + " -  " + new Date();
    }

    @SuppressWarnings("unused")
    // implement a fallback method : dit quand le circuit breaker est utilisé et donc que le service est non utilisable
    private String callWeatherServiceAndGetData_Fallback(String ville_name) {
        System.out.println("Weather Service is down!!! fallback route enabled...");
        return "CIRCUIT BREAKER ENABLED!!!No Response From Weather Service at this moment. Service will be back shortly - " + new Date();
    }

    // this is a bean
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
