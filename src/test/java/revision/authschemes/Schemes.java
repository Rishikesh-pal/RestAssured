package revision.authschemes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Schemes {
    @Test
    public void basicAuth()
    {
        RestAssured.baseURI = "https://postman-echo.com/";
        given()
		.auth()
		.basic("postman", "password")
//                .header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")
                .log().all()
                .when()
                .get("basic-auth")
                .then()
                .log().all();
    }


    @Test
    public void digestAuth()
        {
            RestAssured.baseURI = "https://postman-echo.com";
            given()
                    .log().all()
                    .auth()
                    .digest("postman", "password")
                    .when()
                    .get("digest-auth")
                    .then()
                    .log().all();
        }

    @Test
    public void apiKey(){
        baseURI = "https://api.getpostman.com/workspaces/";
        Response response = given()
                .header("Content-Type","application/json")
                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-e29a9d28772779d6615ebdc0e9d5f30cc0")
                .pathParam("workspaceId","189a5f53-b586-4da8-83fd-97f20c35ef00")
                .when()
                .get("{workspaceId}")
                .then()
                .extract().response();
        System.out.println(response.asPrettyString());

    }

    @Test
    public void bearerToken(){
        baseURI = "https://api.github.com/";
        given()
                .header("accept","application/vnd.github+json")
                .header("Authorization","Bearer ghp_6hO8c4Nl0RE7O6f6Tm0xY47g")
                .header("X-GitHub-Api-Version","2022-11-28")
                .body("{\"name\":\"RestAsssuredRepo\",\"description\":\"This is a repo created using automation!\",\"homepage\":\"https://github.com\",\"private\":false,\"is_template\":true}")
                .log().all()
                .when()
                .post("/user/repos")
                .then()
                .log().all();
    }

    //WAP to fetch all the created repository for a user:
    //curl -L \ -H "Accept: application/vnd.github+json" \
    // -H "Authorization: Bearer <YOUR-TOKEN>" \
    // -H "X-GitHub-Api-Version: 2022-11-28"
    // \ https://api.github.com/users/USERNAME/repos

    @Test
    public void task(){
        baseURI = "https://api.github.com/";
        given()
                .header("accept","application/vnd.github+json")
                .header("Authorization","Bearer ghp_6hO8c4Nl0RE7O9F6f6Tm0xY47g")
                .header("X-GitHub-Api-Version","2022-11-28")
                .log().all()
                .when()
                .post("/users/Rishi0109/repos")
                .then()
                .log().all();
    }


}
