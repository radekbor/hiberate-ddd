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

    private House() {
        // For Hibernate
    }

    public House(Integer id, String city, String street, Integer buildingNumber, Integer subNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.subNumber = subNumber;
    }

    public House(Integer id, String city, String street, Integer buildingNumber) {
        this(id, city, street, buildingNumber, null);
    }

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
