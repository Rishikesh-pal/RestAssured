package revision;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexJson {

    @Test
    public void test(){
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
        JsonPath jsonPath= new JsonPath(json);
        System.out.println( jsonPath.getString("courses.size()"));//. Print No of courses returned by API
        System.out.println(jsonPath.getString("dashboard.purchaseAmount"));//Print Purchase Amount
        //Print Title of the first course
        System.out.println(jsonPath.getString("courses[1].title"));
        //4. Print All course titles and their respective Prices
        int list = jsonPath.getInt("courses.size()");
        for (int i = 0; i < list; i++) {
            System.out.println("Course : "+jsonPath.getString("courses["+i+"].title")

                +"\nPrice : " + jsonPath.getInt("courses["+i+"].price")
            );
        }
        //5. Print no of copies sold by RPA Course
        System.out.println(jsonPath.getInt("courses[2].copies"));
        //6. Verify if Sum of all Course prices matches with Purchase Amount
        int sum=0;
        for (int i = 0; i < list; i++) {
            sum = sum + (jsonPath.getInt("courses["+i+"].price")*jsonPath.getInt("courses["+i+"].copies"));
        }
        System.out.println(sum);
        Assert.assertEquals(sum,jsonPath.getInt("dashboard.purchaseAmount"));


    }
}
