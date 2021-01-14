package com.microservice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
    @JsonProperty("country_id")
    private int countryId;

    @JsonProperty("country_name")
    private String countryName;

    public int getCountryId() {
        return this.countryId;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String toString() {
        return "Country(countryId=" + this.getCountryId() + ", countryName=" + this.getCountryName() + ")";
    }
}

