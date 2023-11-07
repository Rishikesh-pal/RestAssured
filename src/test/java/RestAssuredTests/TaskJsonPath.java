package RestAssuredTests;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class TaskJsonPath {

    @Test
    public void task(){
        String json = "{\n" +
                "\"dashboard\": {\n" +
                "\"purchaseAmount\": 910,\n" +
                "\"website\": \"www.abc.com\"\n" +
                "},\n" +
                "\"courses\": [\n" +
                "{\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\"price\": 50,\n" +
                "\"copies\": 6\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Cypress\",\n" +
                "\"price\": 40,\n" +
                "\"copies\": 4\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"RPA\",\n" +
                "\"price\": 45,\n" +
                "\"copies\": 10\n" +
                "}\n" +
                "]\n" +
                "}\n";

//        1. Print No of courses returned by API
//        2. Print Purchase Amount
//        3. Print Title of the first course
//        4. Print All course titles and their respective Prices
//        5. Print no of copies sold by RPA Course
//        6. Verify if Sum of all Course prices matches with Purchase Amount

        JsonPath jsonPath = new JsonPath(json);
        int size = jsonPath.getInt("courses.size()");
        System.out.println("Number courses : "+size);
        System.out.println("Purchased amount : "+jsonPath.getInt("dashboard.purchaseAmount"));
        System.out.println("Title of first course : "+ jsonPath.getString("courses[0].title"));
        for (int i = 0; i < size; i++) {
            System.out.println("Course Title is : "+jsonPath.getString("courses["+i+"].title") +
                    "\nPrise is : "+ jsonPath.getInt("courses["+i+"].price"));
        }

        for (int i = 0; i < size; i++) {
            if(Objects.equals(jsonPath.getString("courses[" + i + "].title"), "RPA"))
                System.out.println("no of copies sold by RPA Course : "+jsonPath.getString("courses["+i+"].copies"));
        }

        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
        int sum =0;
        for (int i = 0; i < size; i++) {
            sum = (jsonPath.getInt("courses["+i+"].price")*jsonPath.getInt("courses["+i+"].copies")) + sum;
        }
        Assert.assertEquals(sum,purchaseAmount);

    }
}
