package RestAssuredTests;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class QureyParam {
    @Test
    public void queryParameter(){
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .queryParams("foo1","bar1","foo2","bar2","foo3","bar3")
//                .queryParam("foo1","bar1")
//                .queryParam("foo2","bar2")
//                .queryParam("foo3","bar3")
                .log().all()
                .when()
                .get("/get")
                .then()
                .log().all();
    }
}
