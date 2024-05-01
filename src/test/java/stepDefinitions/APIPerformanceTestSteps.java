package stepDefinitions;

import helper.APIPerformanceUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class APIPerformanceTestSteps {

    public long startTime;
    public long responseTime;
    public long averageResponseTime;
    String endpoint = "";
    @Given("I have a valid API endpoint {string}")
    public void i_have_a_valid_api_endpoint(String endpoint) {
        this.endpoint = endpoint;
        System.out.println("When I had valid endpoint");
    }
    @When("I make a request to the API with number Of requests {int}")
    public void i_make_a_get_request_to_the_api_with_number_of_requests(int numberOfRequests) {
        startTime = System.currentTimeMillis();
        System.out.println("Start Time :"+startTime);
        System.out.println("I make a request to the API started");
        APIPerformanceUtil.testGetApiPerformance(endpoint, numberOfRequests);
        System.out.println("I make a request to the API completed");
        long endTime = System.currentTimeMillis();
        System.out.println("End Time :"+endTime);
        responseTime = endTime - startTime;
        System.out.println("Response Time :"+responseTime);
        System.out.println("Response time for " + numberOfRequests + " GET requests: " + responseTime + " ms");
        averageResponseTime= responseTime / numberOfRequests;
        System.out.println("Average time per GET request: " +  averageResponseTime + " ms");
    }


    @Then("the response time should be less than {int} milliseconds and average response time {int} milliseconds")
    public void the_get_response_time_should_be_less_than_milliseconds_and_average_response_time_milliseconds(int expectedResponseTime, int avgResponseTime) {
    System.out.println("Response time should be less than " + expectedResponseTime + " milliseconds");
        assertTrue(responseTime < expectedResponseTime);
        System.out.println("Average Response time should be less than " + avgResponseTime + " milliseconds");
        assertTrue(averageResponseTime < avgResponseTime);
    }

    @When("I make a request to the API with number Of requests {int} and request body:")
    public void i_make_a_post_request_to_the_api_with_number_of_requests_and_request_body(int numberOfRequests , String requestBody) {

        startTime = System.currentTimeMillis();
        System.out.println("Start Time :"+startTime);
        System.out.println("I make a request to the API started");
        APIPerformanceUtil.testPostApiPerformance(endpoint,numberOfRequests,requestBody);
        System.out.println("I make a request to the API completed");
        long endTime = System.currentTimeMillis();
        System.out.println("End Time :"+endTime);
        responseTime = endTime - startTime;
        System.out.println("Response Time :"+responseTime);
        System.out.println("Response time for " + numberOfRequests + " GET requests: " + responseTime + " ms");
        averageResponseTime= responseTime / numberOfRequests;
        System.out.println("Average time per GET request: " +  averageResponseTime + " ms");
    }


    @Then("the post response time should be less than {int} milliseconds and average response time {int} milliseconds")
    public void the_post_response_time_should_be_less_than_milliseconds_and_average_response_time_milliseconds(int expectedResponseTime, int avgResponseTime) {
        System.out.println("Response time should be less than " + expectedResponseTime + " milliseconds");
        assertTrue(responseTime < expectedResponseTime);
        System.out.println("Average Response time should be less than " + avgResponseTime + " milliseconds");
        assertTrue(averageResponseTime < avgResponseTime);
    }
}