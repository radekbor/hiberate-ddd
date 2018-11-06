package org.radekbor.ddddb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HouseRequest {

    private static final Logger log = LoggerFactory.getLogger(HouseRequest.class);

    @Length(min = 3)
    private String city;
    private String street;
    private Integer buildingNumber;
    private Integer subNumber;

    @JsonCreator
    public static HouseRequest createHouseRequest(
            @JsonProperty("city") String city,
            @JsonProperty("street") String street,
            @JsonProperty("buildingNumber") Integer buildingNumber,
            @JsonProperty("subNumber") Integer subNumber) {
        log.info("createHouseRequest used, instead of using constructor directly");
        return new HouseRequest(city, street, buildingNumber, subNumber);
    }

    private HouseRequest(String city,
                         String street,
                         Integer buildingNumber,
                         Integer subNumber) {
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
