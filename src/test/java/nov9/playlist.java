package nov9;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class playlist {

    @Test
    public void test(){
        RestAssured.basePath = "https://api.spotify.com/";

        given()
                .header("Authorization", "Bearer BQAdgkKtVdok5R7GBtrHF2omfqP-biiWJVpMw1JAsCkhb9QLH5Cg7VpaKi43dsgRDf8yoZqv9nmu0_BL_rElVTYt9ZWOvsg76GHCgjvoLz2j937wbOgB9ecyEF0iDbZzQkftPuMxSQHFRdd2msl-6L9TiHs8Wmf3RSrat7o578Z3on138Tm4RgcFlez2hVNSLYE-25GRiaCQuGbfODqNKbU8nunr0eUbUyglgm5AEUSvsL2W8SQsZw9aF8IIYKa1MGKJd4VwlIixw0hj")
                .body("{\r\n"
                        + "    \"name\": \"My Playlist\",\r\n"
                        + "    \"description\": \"This is my playlist of old songs.\",\r\n"
                        + "    \"public\": false\r\n"
                        + "}")
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                .post("v1/users/31z53r6umg5bm7udfjxxxg42emyi/playlists")

                .then()
                .log().all();
    }
}
