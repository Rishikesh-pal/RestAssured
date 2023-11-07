package Practice;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Test12 {

//    {
//        "bookstore": {
//        "name": "Books'R'Us",
//                "location": {
//            "street": "123 Book Street",
//                    "city": "Bookville",
//                    "zipcode": "54321"
//        },
//        "books": [
//        {
//            "isbn": "978-1234567890",
//                "title": "The Art of Fiction",
//                "authors": [
//            "John Smith",
//                    "Jane Doe"
//        ],
//            "price": 19.99
//        },
//        {
//            "isbn": "978-0987654321",
//                "title": "History of Science",
//                "authors": [
//            "David Brown"
//        ],
//            "price": 24.99
//        }
//    ]
//    }
//    }
    @Test
    public void practiseRestAssured(){
        ArrayList<String> author1 = new ArrayList<String>();
        author1.add("John Smith");
        author1.add("Jane Doe");

        ArrayList<String> author2 = new ArrayList<String>();
        author2.add("David Brown");

        HashMap<String,Object> book1 = new HashMap<String,Object>();
        book1.put("isbn","978-1234567890");
        book1.put("title", "The Art of Fiction");
        book1.put("authors",author1);
        book1.put("price", 19.99);

        HashMap<String,Object> book2 = new HashMap<String,Object>();
        book2.put("isbn", "978-0987654321");
        book2.put("title", "History of Science");
        book2.put("authors",author2);
        book2.put("price", 24.99);

        ArrayList<HashMap<String,Object>> bookList =new ArrayList<HashMap<String,Object>>();
        bookList.add(book1);
        bookList.add(book2);

        HashMap<String,Object> location = new HashMap<String,Object>();
        location.put("street", "123 Book Street");
        location.put("city", "Bookville");
        location.put( "zipcode", "54321");

        HashMap<String,Object> bookstore = new HashMap<String,Object>();
        bookstore.put("name", "Books'R'Us");
        bookstore.put("location",location);
        bookstore.put("books",bookList);

        HashMap<String,Object> main= new HashMap<String,Object>();
        main.put("bookstore",bookstore);

        RestAssured.baseURI = "https://de9009e3-62de-44c4-9545-6373bbe2d3d1.mock.pstmn.io";
        Response response = given().header("Content-Type","application/json")
                .header("x-mock-match-request-body","true")
                .body(main)
                .log().all()
                .when()
                .post("/practiceRestAssured")
                .then()
                .extract()
                .response();
        // 1. Using json path method

        JsonPath jsonPath =response.jsonPath();
        String productId = jsonPath.getString("orders[0].products[0].product_id");
        System.out.println(productId);

        Integer size = jsonPath.getInt("orders[0].products.size()"); //sie() method used to get the size of the array
        System.out.println(size);

        for (int i = 0; i < size; i++) {
            String ans = null;
            if (jsonPath.getString("orders[0].products[" + i + "].product_id")
                    .equals("1002")) {
                ans = jsonPath.getString("orders[0].products[" + i + "].name");
                Assert.assertEquals(ans, "Widget B");

            }
//            Assert.assertEquals(ans, "Widget B");

        }




     }
}
