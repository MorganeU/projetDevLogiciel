package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.model.Weather;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
// describe this class using @Api annotation from swagger
@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Weather Entity!!!!")
public class WeatherController {

    // je créé une liste
    List<Weather> weather = new ArrayList<Weather>();
    {
        weather.add(new Weather("Nice", "06200", "France", "il fait 16 degrés"));
        weather.add(new Weather("Marseille", "13000", "France", "il fait 28 degrés"));
        weather.add(new Weather("Rome", "00100", "Italie", "il fait 15 degrés"));
        weather.add(new Weather("Barcelone", "08980", "Espagne","il fait 20 degrés" ));
    }

    // add http response for getStudent operation : 200 / 401 / 403 / 404 (use ApiResponses annotation)
    @ApiOperation(value = "Get list of Weather in the System ", response = Iterable.class, tags = "getWeathers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})

    @RequestMapping(value = "/getWeathers")
    public List<Weather> getWeathers() {
        return weather;
    }


    // Get Weather by ville_name
    @ApiOperation(value = "Get specific Weather in the System by city name", response = Weather.class, tags = "getWeather")
    @RequestMapping(value = "/getWeather/{villeName}")
    public Weather getWeatherByCityName(@PathVariable(value = "villeName") String villeName) {
        // return student
        return weather.stream().filter(x -> x.getName().equalsIgnoreCase(villeName)).collect(Collectors.toList()).get(0);
    }

    // Get Weather by zipcode
    @ApiOperation(value = "Get specific Weather in the System by zipcode", response = Weather.class, tags = "getWeather")
    @RequestMapping(value = "/getWeather/{zipcode}")
    public Weather getWeatherByZipcode(@PathVariable(value = "zipcode") String zipcode) {
        // return student
        return weather.stream().filter(x -> x.getZipcode().equalsIgnoreCase(zipcode)).collect(Collectors.toList()).get(0);
    }

    // 3-get Weather by country
    @ApiOperation(value = "Get specific Weather in the System by Country in the System ", response = Weather.class, tags = "getWeatherByCountry")
    @RequestMapping(value = "/getWeatherByCountry/{country}")
    public List<Weather> getStudentByCountry(@PathVariable(value = "country") String country) {
        return weather.stream().filter(x -> x.getPays().equalsIgnoreCase(country)).collect(Collectors.toList());
    }
}
