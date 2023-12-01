package ecom;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Placeorder extends BaseData {

    @Test
    public void placingOrderTest()
    {
        RestAssured.baseURI = "https://www.rahulshettyacademy.com";

        given()

                .body("{\"orders\": [\r\n"
                        + "        {\r\n"
                        + "        \"country\": \"India\", \r\n"
                        + "        \"productOrderedId\" : \""+productId+"\"\r\n"
                        + "        }\r\n"
                        + "    ]\r\n"
                        + "}")

                .header("Content-Type", "application/json")
                .header("Authorization", token)

                .when()

                .post("api/ecom/order/create-order")

                .then()

                .log().all()

                .extract()

                .response();



    }
}
