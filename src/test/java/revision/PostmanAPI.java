package revision;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PostmanAPI {

    @Test
    public void createWorkspace(){
        baseURI = "https://api.getpostman.com/workspaces";
        Response response = given()
                .body("{\n" +
                        "    \"workspace\": {\n" +
                        "        \"name\": \"New Workspaces created RA2\",\n" +
                        "        \"type\": \"personal\",\n" +
                        "        \"description\": \"New workspace created using Automation\"\n" +
                        "    }\n" +
                        "}")
                .header("Content-Type","application/json")
                .header("X-Api-Key","PMAK-653fddfb74bc26002a7ffa9dd6615ebdc0e9d5f30cc0")
                .when()
                .post()
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());
    }

    @Test
    public void getAllWorkspaces(){
        baseURI = "https://api.getpostman.com/workspaces";
        Response response = given()
                .header("Content-Type","application/json")
                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-e29a972779d6615ebdc0e9d5f30cc0")
                .when()
                .get()
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        System.out.println("workspace id of "+jsonPath.getString("workspaces[1].name") +
                " is "+jsonPath.getString("workspaces[1].id"));

        String output = response.asPrettyString();
        JsonPath jsonPath1 = new JsonPath(output);
        System.out.println(jsonPath1.getString("workspaces[1].name"));

    }

    @Test
    public void getAWorkspace(){
        baseURI = "https://api.getpostman.com/workspaces/";
        Response response = given()
                .header("Content-Type","application/json")
                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-28772779d6615ebdc0e9d5f30cc0")
                .pathParam("workspaceId","189a5f53-b586-4da8-83fd-97f20c35ef00")
                .when()
                .get("{workspaceId}")
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());

    }

    //demo for multiple path param/queryparam
    @Test
    public void demo(){
        baseURI = "https://api.getpostman.com/workspaces/";
        Response response = given()
                .header("Content-Type","application/json")
                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-e29a72779d6615ebdc0e9d5f30cc0")
                .pathParam("workspaceId","qwerty")
                .pathParam("workspaceId2","123456789")
                .pathParams("workspaceId3","12345678","workspaceId4","561265878"
                , "workspaceId5","788783977")
                .queryParam("location","12345678")
                .queryParam("location2","qwertyuio")
                .queryParams("location3","1234567890","location4","tuvdufviy")
                .log().all()
                .when()
                .get("{workspaceId}/{workspaceId2}")
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());
    }
}
