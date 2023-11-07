package postmanapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateWorkspace {
    //Fetching the data from the response:
    //1. using jsonPath method
    //2. using JsonPath class
    //3. Serialization and Deserialization

//    @Test
//    public void createWorkspace(){
//        Test12.baseURI = "https://api.getpostman.com/";
//        Response response = given()
//                .body("{\n" +
//                        "    \"workspace\": {\n" +
//                        "        \"name\": \"Workspace_created_by_restassured_3\",\n" +
//                        "        \"type\": \"personal\",\n" +
//                        "        \"description\": \"This workspace is created by restassured automation\"\n" +
//                        "    }\n" +
//                        "}")
//                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-e29a9d28772779d6615ebdc0e9d5f30cc0")
//                .header("Content-Type","application/json")
//                .when()
//                .post("workspaces")
//                .then()
//                .extract().response();
//        System.out.println(response.asPrettyString());
//
//        JsonPath jsonPath = response.jsonPath();
//        System.out.println("Workspace Name : " + jsonPath.getString("workspace.name"));
//        System.out.println("Workspace ID : " + jsonPath.getString("workspace.id"));
//
//    }

    //Create workspace =>response ID =>get workspace =>O/p

    String workspaceID;
    String workspaceName_post;
    @Test
    public void createWorkspaceUsingRestassured(){
        RestAssured.baseURI = "https://api.getpostman.com/";
        Response response = given()
                .body("{\n" +
                        "    \"workspace\": {\n" +
                        "        \"name\": \"Workspace_created_by_restassured_exapmle_2\",\n" +
                        "        \"type\": \"personal\",\n" +
                        "        \"description\": \"This workspace is created by restassured automation\"\n" +
                        "    }\n" +
                        "}")
                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-e29a9d28772779d6615ebdc0e9d5f30cc0")
                .header("Content-Type","application/json")
                .when()
                .post("workspaces")
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());
        JsonPath jsonPath = response.jsonPath();
        workspaceID = jsonPath.getString("workspace.id");
        System.out.println("Workspace ID : " + workspaceID);
        workspaceName_post = jsonPath.getString("workspace.name");
    }

    @Test
    public void getWokspaceUsingRestassured(){
        baseURI="https://api.getpostman.com/";
        Response response = given()
                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-e29a9d28772779d6615ebdc0e9d5f30cc0")
                .when()
                .get("/workspaces/"+ workspaceID)
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());
        JsonPath jsonPath = response.jsonPath();
        String workspaceName_get = jsonPath.getString("workspace.name");
        Assert.assertEquals(workspaceName_get,workspaceName_post);

    }
}
