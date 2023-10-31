package postmanapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetAWorkspace {

    @Test
    public void getAWorkspace(){
        RestAssured.baseURI = "https://api.getpostman.com";
        Response response = given()
                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-e29a9d28772779d6615ebdc0e9d5f30cc0")
                .when()
                .get("/workspaces/04fd5610-5655-4be4-8b96-829ee0448fdd")
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());
    }
}
