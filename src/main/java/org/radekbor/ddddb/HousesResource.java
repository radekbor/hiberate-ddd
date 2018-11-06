package org.radekbor.ddddb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HousesResource {

    private static final Logger log = LoggerFactory.getLogger(HouseRequest.class);

    @Autowired
    HousesResource(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    private HouseRepository houseRepository;

    @PostMapping(value = "/house")
    public void createHouse(@RequestBody HouseRequest houseRequest) {
        log.info(houseRequest.toString());
    }

    @RequestMapping(value = "/house")
    public List<House> getHouses() {
        return houseRepository.findAll();
    }
}
