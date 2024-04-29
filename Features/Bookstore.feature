Feature: Test Book store API application

Background:
    Given I want to execute API request

Scenario: Send a GET request to the specified endpoint

    When I send a GET request to endpoint "/posts"
    Then I should receive a 200 status code
    And the response body should contain "title"
    
  
  Scenario: Create a new resource using POST request

    When  I send a POST request to endpoint "/posts" with request body:
      """
       {
        "title": "New post",
        "body": "This is a new post",
        "userId": 1
      }
      """
    Then should receive a 201 status code
    And response body should contain "101"