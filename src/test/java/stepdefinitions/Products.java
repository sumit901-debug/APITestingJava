package stepdefinitions;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static org.junit.Assert.*;

public class Products {

    public int statusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    public JSONObject requestParams;
    public String s;


    @Given("I hit the url of get products api endpoint")
    public void iHitTheUrlOfGetProductsApiEndpoint() {

        RestAssured.baseURI = "https://fakestoreapi.com/";

    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {

        httpRequest = RestAssured.given();
        response =  httpRequest.get("products");

    }
//    @Then("I receive the response code as {int}")
//    public void i_receive_the_response_code_as(Integer int1) {
//
////        ResponseCode = response.getStatusCode();
//
//    }

    @Then("I receive the response code as {string}")
    public void iReceiveTheResponseCodeAs(String int1) {
//        int responseCode = Integer.parseInt(String.valueOf(response.getStatusCode())); // Convert String to int
        ResponseCode = response.getStatusCode();

        assertEquals(Integer.parseInt(int1),ResponseCode);
    }


    @Then("I verify that the rate of the first  product is {double}")
    public void i_verify_that_the_rate_of_the_first_product_is(Double expectedRate) {
        body = response.getBody();

        JsonPath jsnpath = body.jsonPath();

        Double actualRate = jsnpath.getDouble("rating[0].rate");

        assertEquals(expectedRate, actualRate);
    }


    @Given("I hit the url of post products api endpoint")
    public void iHitTheUrlOfPostProductsApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = RestAssured.given();
        requestParams = new JSONObject();

    }


    @And("I pass the request body of product title {}")
    public void iPassTheRequestBodyOfProductTitle(String title) {
        requestParams.put("title", title);
        requestParams.put("price",13.5);
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://i.pravatar.cc");
        requestParams.put("cateogry","electronic");
        httpRequest.body(requestParams.toJSONString());
        response =httpRequest.post("products");
        body = response.getBody();
        JsonPath jsnpath = response.jsonPath();
        s = jsnpath.getJsonObject("id").toString();
        System.out.println("Id is ="+s);
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());



    }


    @Then("I receive the response body with id as {int}")
    public void i_receive_the_response_body_with_id_as(Integer int1) {
        assertEquals(s,String.valueOf(int1));
    }



    @Given("I hit the url of put product api endpoint")
    public void i_hit_the_url_of_put_product_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        requestParams = new JSONObject();
    }


//    @When("I pass the url of products in the request with {int}")
//    public void i_pass_the_url_of_products_in_the_request_with(String productnumber) {
//        httpRequest = RestAssured.given();
//        requestParams.put("title", "test product");
//        requestParams.put("price","13.5");
//        requestParams.put("description","lorem ipsum set");
//        requestParams.put("image","https://i.pravatar.cc");
//        requestParams.put("cateogry","electronic");
//        httpRequest.body(requestParams.toJSONString());
//        response = httpRequest.put("products/"+ productnumber);
//        body = response.getBody();
//        JsonPath jsnpath = response.jsonPath();
////        s = jsnpath.getJsonObject("id").toString();
//        s = jsnpath.getString("id");
//        System.out.println(response.getStatusLine());
//        System.out.println(body.asString());
//    }



//    @When("I pass the url of products in the request with {string}")
//    public void i_pass_the_url_of_products_in_the_request_with(String productnumber) {
//        httpRequest = RestAssured.given();
//        requestParams.put("title", "test product");
//        requestParams.put("price","13.5");
//        requestParams.put("description","lorem ipsum set");
//        requestParams.put("image","https://i.pravatar.cc");
//        requestParams.put("cateogry","electronic");
//        httpRequest.body(requestParams.toJSONString());
//        response = httpRequest.put("products/"+ productnumber);
//        body = response.getBody();
//        JsonPath jsnpath = response.jsonPath();
////        s = jsnpath.getJsonObject("id").toString();
//        s = jsnpath.getString("id");
//        System.out.println(response.getStatusLine());
//        System.out.println(body.asString());
//    }

//    @When("I pass the url of products in the request with {string}")
//    public void iPassTheUrlOfProductsInTheRequestWith(String productnumber) {
//        httpRequest = RestAssured.given();
//        requestParams.put("title", "test product");
//        requestParams.put("price","13.5");
//        requestParams.put("description","lorem ipsum set");
//        requestParams.put("image","https://i.pravatar.cc");
//        requestParams.put("cateogry","electronic");
//        httpRequest.body(requestParams.toJSONString());
//        response = httpRequest.put("products/"+ productnumber);
//        body = response.getBody();
//        JsonPath jsnpath = response.jsonPath();
////        s = jsnpath.getJsonObject("id").toString();
//        s = jsnpath.getString("id");
//        System.out.println(response.getStatusLine());
//        System.out.println(body.asString());
//    }

//    @When("I pass the url of products in the request with {string}")
//    public void i_pass_the_url_of_products_in_the_request_with(String productnumber) {
//        httpRequest = RestAssured.given();
//        requestParams.put("title", "test product");
//        requestParams.put("price","13.5");
//        requestParams.put("description","lorem ipsum set");
//        requestParams.put("image","https://i.pravatar.cc");
//        requestParams.put("cateogry","electronic");
//        httpRequest.body(requestParams.toJSONString());
//        response = httpRequest.put("products/"+ productnumber);
//        body = response.getBody();
//        JsonPath jsnpath = response.jsonPath();
////        s = jsnpath.getJsonObject("id").toString();
//        s = jsnpath.getString("id");
//        System.out.println(response.getStatusLine());
//        System.out.println(body.asString());
//    }

    @When("I pass the url of products in the request with {string}")
    public void i_pass_the_url_of_products_in_the_request_with(String string) {
        httpRequest = RestAssured.given();
        requestParams.put("title", "test product");
        requestParams.put("price","13.5");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://i.pravatar.cc");
        requestParams.put("cateogry","electronic");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.put("products/"+ string);
        body = response.getBody();
        JsonPath jsnpath = response.jsonPath();
//        s = jsnpath.getJsonObject("id").toString();
        s = jsnpath.getString("id");
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }

//    @Given("I hit the url of delete product api endpoint")
//    public void iHitTheUrlOfDeleteProductApiEndpoint() {
//        RestAssured.baseURI = "https://fakestoreapi.com/";
//        requestParams = new JSONObject();
//    }
//
//    @When("I pass the url of delete products in the request with {}")
//    public void iPassTheUrlOfDeleteProductsInTheRequestWith(String productnumber) {
//        httpRequest = RestAssured.given();
//        requestParams.put("title", "test product");
//        requestParams.put("price","13.5");
//        requestParams.put("description","lorem ipsum set");
//        requestParams.put("image","https://i.pravatar.cc");
//        requestParams.put("cateogry","electronic");
//        httpRequest.body(requestParams.toJSONString());
//        response = httpRequest.delete("products/"+ productnumber);
//        ResponseBody body = response.getBody();
//        JsonPath jsnpath = response.jsonPath();
//        s = jsnpath.getJsonObject("id").toString();
//        System.out.println(response.getStatusLine());
//        System.out.println(body.asString());
//    }

    @Given("I hit the url of delete product api endpoint")
    public void i_hit_the_url_of_delete_product_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        requestParams = new JSONObject();
    }
    @When("I pass the url of delete products in the request with {int}")
    public void i_pass_the_url_of_delete_products_in_the_request_with(String productnumber) {
        httpRequest = RestAssured.given();
        requestParams.put("title", "test product");
        requestParams.put("price","13.5");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://i.pravatar.cc");
        requestParams.put("cateogry","electronic");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.delete("products/"+ productnumber);
        ResponseBody body = response.getBody();
        JsonPath jsnpath = response.jsonPath();
        s = jsnpath.getJsonObject("id").toString();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
    }

}
