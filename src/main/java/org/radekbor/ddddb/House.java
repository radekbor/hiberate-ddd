package org.radekbor.ddddb;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class House {

    @Id
    private Integer id;
    private String city;
    private String street;
    private Integer buildingNumber;
    private Integer subNumber;


    public Integer getId() {
        return id;
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
