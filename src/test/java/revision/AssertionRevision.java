package revision;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AssertionRevision {

    @Test
    public void getAllWorkspaces(){
        baseURI = "https://api.getpostman.com/workspaces";
        Response response = given()
                .contentType(ContentType.JSON)
                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-e29a9d28772779d6615ebdc0e9d5f30cc0")
                .when()
                .get()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("workspaces[0].name",equalTo("My Workspace"))
                .body("workspaces[0]",hasKey("name"))
                .body("workspaces[0]",hasEntry("type","personal"))
                .body("workspaces.name",hasItem("My Workspace"))
                .body("workspaces[0].name",equalToIgnoringCase("MY WORKSPACE"))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        System.out.println("workspace id of "+jsonPath.getString("workspaces[1].name") +
                " is "+jsonPath.getString("workspaces[1].id"));

        String output = response.asPrettyString();
        JsonPath jsonPath1 = new JsonPath(output);
        System.out.println(jsonPath1.getString("workspaces[1].name"));

    }

}
