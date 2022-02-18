package com.howtodoinjava.demo.model;

import io.swagger.annotations.ApiModelProperty;

public class Weather {

    @ApiModelProperty(notes = "Name of the city", name = "name", required = true, value = "test name")
    private String ville_name;
    @ApiModelProperty(notes = "Zipcode numero", name = "zipcode", required = true, value = "test zipcode")
    private String zipcode;
    @ApiModelProperty(notes = "Name of the country", name = "country", required = true, value = "test country")
    private String pays;
    @ApiModelProperty(notes = "What is the meteo", name = "meteo", required = true, value = "test meteo")
    private String meteo;

    public Weather(String name, String zipcode, String pays, String meteo) {
        this.ville_name = name;
        this.zipcode = zipcode;
        this.pays = pays;
        this.meteo = meteo;
    }

    public String getName() {
        return ville_name;
    }

    public void setName(String name) {
        this.ville_name = name;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }
}
