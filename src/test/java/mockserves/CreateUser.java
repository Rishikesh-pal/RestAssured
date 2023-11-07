package mockserves;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateUser {


    @Test
    public void createUser()
    {
        HashMap<String, String> zerothElement = new HashMap<String, String>();

        zerothElement.put("id", "1000");
        zerothElement.put("type", "grains");

        HashMap<String, String> firstElement = new HashMap<String, String>();

        firstElement.put("id", "1001");
        firstElement.put("type", "beverage");

        List<HashMap<String, String>> mainObject = new ArrayList<HashMap<String,String>>();

        mainObject.add(zerothElement);
        mainObject.add(firstElement);




        RestAssured.baseURI = "https://a02187b2-75ef-49bf-a23d-a45a6a7ac83e.mock.pstmn.io";




        given()

                .body(mainObject)

                .header("Content-Type", "application/json")

                .header("x-mock-match-request-body", "true")

                .log().all()

                .when()

                .post("/post_request")

                .then()

                .log().all()

                .extract()

                .response();

    }

}
