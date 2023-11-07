package RestAssuredTests;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class PatghParam {

    @Test
    public void pathParam(){
        RestAssured.baseURI = "https://api.getpostman.com";
        given()
                .header("x-api-key","PMAK-653fddfb74bc26002a7fffb9-e29a9d28772779d6615ebdc0e9d5f30cc0")
                .pathParams("workspaceid1","1","workspaceid2","2","workspaceid3","3")
//                .pathParam("workspaceid1","d994453d-d459-432e-ae6e-3773ee02ae5d")
//                .pathParam("workspaceid2","d994453d-d459-432e-ae6e-3773ee02ae5d")
//                .pathParam("workspaceid3","d994453d-d459-432e-ae6e-3773ee02ae5d")
                .log().all()
                .when()
                .get("/workspaces/{workspaceid1}/{workspaceid2}/{workspaceid3}")
                .then()
                .log().all();
    }
}
