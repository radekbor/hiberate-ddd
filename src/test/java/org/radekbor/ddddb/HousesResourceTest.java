package org.radekbor.ddddb;

import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.with;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HousesResourceTest {

    private static final Logger log = LoggerFactory.getLogger(HousesResourceTest.class);

    @LocalServerPort
    int port;

    @Test
    public void shouldBeAbleToSendWhenNoSetters() throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("city", "London");
        jsonObject.put("street", "HighStreet");
        jsonObject.put("buildingNumber", 1);
        jsonObject.put("subNumber", 25);

        log.info(jsonObject.toString());

        given().port(port).with()
                .body(jsonObject.toString())
                .contentType(ContentType.JSON)
                .post("house")
                .then()
                .statusCode(200);


    }
}