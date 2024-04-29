package helper;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIPerformanceUtil {

    public static void testGetApiPerformance(String url, int numberOfRequests) {
        for (int i = 0; i < numberOfRequests; i++) {
            Response response = RestAssuredUtil.getRequest(url);
        }
    }

   public static void testPostApiPerformance(String url, int numberOfRequests,String requestBody) {
        for (int i = 0; i < numberOfRequests; i++) {
            Response response = RestAssuredUtil.postRequest(url,requestBody);
        }
    }
}
