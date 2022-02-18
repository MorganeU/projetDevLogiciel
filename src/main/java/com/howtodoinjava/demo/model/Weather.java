package com.howtodoinjava.demo.model;

public class Weather {

    private String ville_name;
    private String zipcode;
    private String pays;
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
