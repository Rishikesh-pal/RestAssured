package postmanapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetAllWorkspaces {

    @Test
    public void getAllWorkspaces(){
        RestAssured.baseURI = "https://api.getpostman.com";
        Response response = given()
                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-6ad239cd98dd8f954a183f8397260b1348")
                .when()
                .get("/workspaces")
                .then()
                .extract()
                .response();
        System.out.println(response.asPrettyString());
    }
}
