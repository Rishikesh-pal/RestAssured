package nov9;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Headers {
    @Test
    public void getAWorkspace(){
        RestAssured.baseURI = "https://api.getpostman.com";
               Response response= given()
                .header("X-Api-Key","PMAK-653fddfb74bc26002a7fffb9-e29a9d28772779d6615ebdc0e9d5f30cc0")
                .when()
                .get("/workspaces/")
                .then()
                .log().all()
                       .extract().response();
        /**
         * 	Fetching and validating the results from response header
         */
        System.out.println(response.getHeader("Content-Type"));
        System.out.println(response.getHeader("Date"));

        /**
         * Fetching complete header value
         */
        List<Header> allHeaders = response.getHeaders().asList();
        System.out.println(allHeaders.get(2));
        System.out.println(allHeaders.get(1));
        System.out.println(response.getContentType());
    }
}
