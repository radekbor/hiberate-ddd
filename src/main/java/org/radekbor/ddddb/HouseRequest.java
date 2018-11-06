package org.radekbor.ddddb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HouseRequest {

    private String city;
    private String street;
    private Integer buildingNumber;
    private Integer subNumber;

    @JsonCreator
    public HouseRequest(
            @JsonProperty("city") String city,
            @JsonProperty("street") String street,
            @JsonProperty("buildingNumber") Integer buildingNumber,
            @JsonProperty("subNumber") Integer subNumber) {
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.subNumber = subNumber;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", city, street, buildingNumber, subNumber);
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public Integer getSubNumber() {
        return subNumber;
    }
}
