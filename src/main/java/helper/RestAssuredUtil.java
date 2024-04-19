package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredUtil {

	public  String baseURI;
   
    
    public RestAssuredUtil(String baseURI) {  
        this.baseURI= baseURI;      
    }

    public Response getRequest(String endpoint) {
    	System.out.println("Started step: RestAssuredUtil get Request method");
    	 return RestAssured.get(baseURI + endpoint);
    }

    public Response postRequest(String endpoint, String requestBody) {
    	System.out.println("Started step : RestAssuredUtil postRequest Method");
    	return RestAssured.given().body(requestBody).post(baseURI + endpoint);
    }

    public Response putRequest(String endpoint, String requestBody) {
    	System.out.println("Started step :RestAssuredUtil putRequest Method");
        return RestAssured.given().body(requestBody).put(baseURI +endpoint);
    }

    public Response deleteRequest(String endpoint) {
    	System.out.println("Started step: RestAssuredUtil deleteRequest Method");
        return RestAssured.delete(baseURI +endpoint);
    }
}
