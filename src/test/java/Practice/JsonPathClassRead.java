package Practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class JsonPathClassRead {


    //To read jsonusing jsonPath class -->
    @Test
   public void method1(){
       RestAssured.baseURI = "https://api.getpostman.com";
       Response response = given()
               .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-e29a9d28772779d6615ebdc0e9d5f30cc0")
               .when()
               .get("/workspaces/04fd5610-5655-4be4-8b96-829ee0448fdd")
               .then()
               .extract().response();
       String out = response.asPrettyString();
       System.out.println(out);
        JsonPath jsonPath = new JsonPath(out);
        System.out.print("Workspace name is + "+ jsonPath.getString("workspace.name"));
   }
}
