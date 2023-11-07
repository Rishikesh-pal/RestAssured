package RestAssuredTests;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonPathClass {

    @Test
    public void jsonPathClass(){
        String json = "{\r\n"
                + "    \"data\": {\r\n"
                + "        \"id\": 2,\r\n"
                + "        \"email\": \"janet.weaver@reqres.in\",\r\n"
                + "        \"first_name\": \"Janet\",\r\n"
                + "        \"last_name\": \"Weaver\",\r\n"
                + "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\r\n"
                + "    },\r\n"
                + "    \"support\": {\r\n"
                + "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
                + "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
                + "    }\r\n"
                + "}";
        JsonPath jsonPath = new JsonPath(json);
        System.out.println(jsonPath.getString("data.id"));
    }
}
