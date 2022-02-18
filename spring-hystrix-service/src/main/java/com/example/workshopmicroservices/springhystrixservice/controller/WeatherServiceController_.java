package com.example.workshopmicroservices.springhystrixservice.controller;

import com.example.workshopmicroservices.springhystrixservice.delegate.WeatherServiceDelegate_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class WeatherServiceController_ {

    // auto-inject StudentServiceDelegate
    @Autowired
    WeatherServiceDelegate_ weatherServiceDelegate;

    // endpoint to get students (/getWeather/{name})
    @RequestMapping(value = "/getWeatherDetails/{ville_name}", method = RequestMethod.GET)
    // this method must return a student after calling method tagged by hystrix
    public String getStudents(@PathVariable String ville_name) {
        System.out.println("Going to call student service to get data!");
        return weatherServiceDelegate.callWeatherServiceAndGetData(ville_name);
    }
}
