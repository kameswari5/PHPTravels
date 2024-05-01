Feature: Request form for phptravels of application

Background: 
   Given User is on Request Form page


  Scenario: Request Form with valid credentials
    
   When Enter the FirstName as "testFirst",LastName as "testLast",BusinessName as "testBusiness" and Email as "test@gmail.com"
   Then Enter firstNumber and enter secondNumber
   Then the result should be sum of two numbers
   And click submit button
   Then User should see Message "Demonstration"
