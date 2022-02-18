package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.model.Weather;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WeatherController {

    // je créé une liste
    List<Weather> weather = new ArrayList<Weather>();
    {
        weather.add(new Weather("Nice", "06200", "France", "il fait 16 degrés"));
        weather.add(new Weather("Marseille", "13000", "France", "il fait 28 degrés"));
        weather.add(new Weather("Rome", "00100", "Italie", "il fait 15 degrés"));
        weather.add(new Weather("Barcelone", "08980", "Espagne","il fait 20 degrés" ));
    }

    @RequestMapping(value = "/getWeathers")
    public List<Weather> getWeathers() {
        return weather;
    }

    // Get Weather by ville_name
    @RequestMapping(value = "/getWeather/{villeName}")
    public Weather getWeatherByCityName(@PathVariable(value = "villeName") String villeName) {
        // return student
        return weather.stream().filter(x -> x.getName().equalsIgnoreCase(villeName)).collect(Collectors.toList()).get(0);
    }

    // Get Weather by zipcode
    @RequestMapping(value = "/getWeather/{zipcode}")
    public Weather getWeatherByZipcode(@PathVariable(value = "zipcode") String zipcode) {
        // return student
        return weather.stream().filter(x -> x.getZipcode().equalsIgnoreCase(zipcode)).collect(Collectors.toList()).get(0);
    }

    // 3-get Weather by country
    @RequestMapping(value = "/getWeatherByCountry/{country}")
    public List<Weather> getStudentByCountry(@PathVariable(value = "country") String country) {
        return weather.stream().filter(x -> x.getPays().equalsIgnoreCase(country)).collect(Collectors.toList());
    }
}
