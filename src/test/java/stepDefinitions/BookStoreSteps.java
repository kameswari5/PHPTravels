package stepDefinitions;

import org.junit.Assert;

import com.google.gson.JsonObject;

import helper.JsonUtil;
import helper.RestAssuredUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BookStoreSteps {

	public RequestSpecification request;
	public Response response;
	public String baseURI = "https://jsonplaceholder.typicode.com";

	RestAssuredUtil restAssuredUtil = new RestAssuredUtil(baseURI);

	@Given("I want to execute API request")
	public void i_want_to_execute_api_request() {
		System.out.println("Started scenerio: Send a GET request to the specified endpoint");
		System.out.println("Started step: I want to execute API request");
		request = RestAssured.given();
	}

	@When("I send a GET request to endpoint \"([^\"]*)\"$")
	public void i_send_a_get_request_to_endpoint(String endpoint) {
		System.out.println("Started step: I send a GET request to endpoint");
		response = restAssuredUtil.getRequest(endpoint);
	//	System.out.println("Response of GET Request :" + response.asString());
	}

	@Then("I should receive a {int} status code")
	public void i_should_receive_a_status_code(int statusCode) {
		System.out.println("Started step: I should receive a status code");
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, actualStatusCode);
	}

	@Then("the response body should contain \"([^\"]*)\"$")
	public void the_response_body_should_contain(String expectedResult) {
		System.out.println("Started step: The response body should contain String");
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains(expectedResult));
	}
	
	@Given("want to execute API request")
	public void want_to_execute_api_request() {
		System.out.println("Started scenerio: Send a POST request to the specified endpoint");
		System.out.println("Started step: I want to execute API request");
		request = RestAssured.given();
	}

	@When("I send a POST request to endpoint {string} with request body:")
	public void PostRequest(String endpoint, String requestBody) {
		System.out.println("Started step: I send a POST request to endpoint with request body");
		response = restAssuredUtil.postRequest(endpoint, requestBody);
	//	System.out.println("RequestBody : " + requestBody);
	//	System.out.println("Post request response :" + response.asString());
	}

	@Then("should receive a {int} status code")
	public void should_receive_a_status_code(int statusCode) {
		System.out.println("Started step : should receive a status code");
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, actualStatusCode);
	}

	@Then("response body should contain \"([^\"]*)\"$")
	public void response_body_should_contain(String expectedResult) {
		System.out.println("Started step : response body should contain");
		String responseBody = response.getBody().asString();
		JsonObject jsonObject = JsonUtil.getJsonObject(responseBody);
		int id = jsonObject.get("id").getAsInt();
		Assert.assertEquals(id > 0, true);
	}
}
