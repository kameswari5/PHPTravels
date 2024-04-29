package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredUtil {

    public  static String baseURI;


    public RestAssuredUtil(String baseURI) {
        this.baseURI= baseURI;
    }

    public static Response getRequest(String endpoint) {
        System.out.println("Started step: RestAssuredUtil get Request method");
        return RestAssured.get(baseURI + endpoint);
    }

    public static Response postRequest(String endpoint, String requestBody) {
        System.out.println("Started step : RestAssuredUtil postRequest Method");
        return RestAssured.given().body(requestBody).post(baseURI + endpoint);
    }

    public static Response putRequest(String endpoint, String requestBody) {
        System.out.println("Started step :RestAssuredUtil putRequest Method");
        return RestAssured.given().body(requestBody).put(baseURI +endpoint);
    }

    public static Response deleteRequest(String endpoint) {
        System.out.println("Started step: RestAssuredUtil deleteRequest Method");
        return RestAssured.delete(baseURI +endpoint);
    }
}
