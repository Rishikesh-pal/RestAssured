package revision;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class SendBody {

    @Test
    public void createUser(){
        baseURI = "https://petstore.swagger.io/v2";
        given()
                .body(JsonBody.getBody())
                .header("Content-Type","application/json")
                .pathParam("path","user")
                .log().all()
                .when()
                .post("/{path}")
                .then()
                .log().all();
    }

    @Test
    public void sendBodyAsMap(){
        Map<Object, Object> body = new HashMap<>();
        body.put("id","0");
        body.put("username","james.lhadfh");
        body.put("firstName","Will");
        body.put("lastName","Smith");
        body.put("email","will@fgujhfujh.com");
        body.put("password","uhsdsdghh");
        body.put("phone","78378781233");
        body.put("userStatus","0");
        baseURI = "https://petstore.swagger.io/v2";
        given()
                .body(body)
                .header("Content-Type","application/json")
                .pathParam("path","user")
                .log().all()
                .when()
                .post("/{path}")
                .then()
                .log().all();
    }
}
