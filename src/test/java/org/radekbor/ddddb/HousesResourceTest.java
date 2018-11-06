package org.radekbor.ddddb;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HousesResourceTest {

    private static final Logger log = LoggerFactory.getLogger(HousesResourceTest.class);

    @LocalServerPort
    int port;

    @Test
    public void shouldBeAbleToSendWhenNoSetters() throws JSONException {
        JSONObject jsonObject = createHouseRequest(1, "London");

        sendHouseRequest(jsonObject)
                .statusCode(200);
    }

    @Test
    public void shouldNotBeAbleToSendWhenNoSettersAndInvalidCity() throws JSONException {
        JSONObject jsonObject = createHouseRequest(1, "X");

        sendHouseRequest(jsonObject)
                .statusCode(400);
    }

    private ValidatableResponse sendHouseRequest(JSONObject jsonObject) {
        log.info("House Request:" + jsonObject.toString());
        return given().port(port).with()
                .body(jsonObject.toString())
                .contentType(ContentType.JSON)
                .post("house")
                .then();
    }

    private JSONObject createHouseRequest(int buildingNumber, String city) throws JSONException {
        return new JSONObject()
                .put("city", city)
                .put("street", "HighStreet")
                .put("buildingNumber", buildingNumber)
                .put("subNumber", 25);
    }


}