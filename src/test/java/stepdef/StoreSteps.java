package stepdef;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static pages.Store.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class StoreSteps {

    public int ResponseCode;
    public ResponseBody body;


    @Given("I hit the url of get api for purchase order")
    public void i_hit_the_url_of_get_api_for_purchase_order() {
        iHitTheBaseUrl();
    }

    @When("I pass the url of get api for purchase order with the ID {string}")
    public void i_pass_the_url_of_get_api_for_purchase_order_with_the_ID(String id) {
        ipasstheurlofgetapiforpurchaseorderwiththeID(id);
    }

    @Then("I receive the response code {int}")
    public void i_receive_the_response_code(int code) {
        ResponseCode = response.getStatusCode();
        verifyRecievingTheExpectedResponseCode(ResponseCode, code);
    }

    @Then("I verify that the response body is equal to")
    public void i_verify_that_the_response_body_is_equal_to(DataTable data) {
        List<List<String>> dataTable = data.asLists(String.class);
        iVerifyThatTheResponseBodyIsEqualTo(dataTable);
    }

    @Given("I hit the url of post api to place an order")
    public void i_hit_the_url_of_post_api_to_place_an_order() {
        iHitTheBaseUrlWithContentType();
    }

    @When("I pass the request body of post api to place an order")
    public void i_pass_the_request_body_of_post_api_to_place_an_order(DataTable data) {
        List<List<String>> rows = data.asLists(String.class);
        iPrepareTheRequestBody(rows);
        iPassTheRequestBodyOfPostApiToPlaceAnOrder();
    }

    ;

    @Given("I hit the url of get api for Returning Pet Invetories By Status")
    public void i_hit_the_url_of_get_api_for_Returning_Pet_Invetories_By_Status() {
        iHitTheBaseUrlWithContentType();
    }

    @When("I pass the url of get api for Returning Pet Invetories By Status")
    public void i_Pass_The_Url_Of_Get_Api_For_Returning_Pet_Invetories_By_Status() {
        iPassTheUrlOfGetApiForReturningPetInvetoriesByStatus();
    }

    @Given("I hit the url of delete api for purchased order")
    public void iHitTheUrlOfDeleteApiForPurchasedOrder() {
        iHitTheBaseUrlWithContentType();

    }

    @When("I pass the url of delete api for purchased order with the ID {string}")
    public void i_Pass_The_Url_Of_Delete_Api_For_Purchased_Order_With_The_ID(String id) {
        iPassTheUrlOfDeleteApiForPurchasedOrderWithTheID(id);
    }
}
