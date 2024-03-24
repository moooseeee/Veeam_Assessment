package pages;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utility.Configuration.*;

public class Store {
    public static RequestSpecification httpRequest;
    public static Response response;

    public static JSONObject requestParams;

    public static void iHitTheBaseUrl() {
        RestAssured.baseURI = BaseUrl;
    }

    public static void ipasstheurlofgetapiforpurchaseorderwiththeID(String id) {
        httpRequest = given();
        response = httpRequest.get(GetDeletePostUrl + id);
    }

    public static void iPassTheUrlOfDeleteApiForPurchasedOrderWithTheID(String id) {
        httpRequest = given();
        response = httpRequest.delete(GetDeletePostUrl + id);
    }

    public static void iHitTheBaseUrlWithContentType() {
        RestAssured.baseURI = BaseUrl;
        httpRequest = given().contentType("application/json");
        requestParams = new JSONObject();
    }

    public static void verifyRecievingTheExpectedResponseCode(int responseCode, int expectedResponseCode) {
        assertEquals(responseCode, expectedResponseCode);
    }

    public static void iVerifyThatTheResponseBodyIsEqualTo(List<List<String>> dataTable) {
        JsonPath json = response.jsonPath();
        int size = dataTable.size();
        for (int i = 0; i <= size - 1; i++) {
            String s = json.getJsonObject(dataTable.get(i).get(0)).toString();
            assertEquals(dataTable.get(i).get(1), s);

        }
    }

    public static void iPrepareTheRequestBody(List<List<String>> dataTable) {
        for (int i = 0; i <= dataTable.size() - 1; i++) {
            requestParams.put(dataTable.get(i).get(0), dataTable.get(i).get(1));
        }
        httpRequest.body(requestParams.toJSONString());

    }

    public static void iPassTheRequestBodyOfPostApiToPlaceAnOrder() {
        response = httpRequest.post(GetDeletePostUrl);
    }

    public static void iPassTheUrlOfGetApiForReturningPetInvetoriesByStatus() {
        httpRequest = given();
        response = httpRequest.get(GetInventoryUrl);
    }
}

