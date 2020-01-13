package com.example.healthcarepatient.data_models;

public class Country {
    private String countrycode;
    private String countryname;

    public Country(String countryname, String countrycode) {
        this.countryname = countryname;
        this.countrycode = countrycode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
}
