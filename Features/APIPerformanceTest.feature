Feature: Measure API response time

Background:
   Given I have a valid API endpoint "/posts"

  Scenario: Measure response time of an API endpoint

                When I make a request to the API with number Of requests 3
                Then the response time should be less than 30000 milliseconds and average response time 3000 milliseconds



  Scenario: Measure response time of an API endpoint

                When I make a request to the API with number Of requests 3 and request body:
      """
       {
        "title": "New post",
        "body": "This is a new post",
        "userId": 1
      }
      """
               Then the post response time should be less than 5000 milliseconds and average response time 2000 milliseconds