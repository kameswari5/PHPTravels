package stepDefinitions;


import helper.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.RequestFormPage;

public class Steps {
    WebDriver driver;
	RequestFormPage rf;

	@Given("User is on Request Form page")
	public void user_is_on_request_form_page() {
		 driver= BrowserUtil.startBrowser();
		 System.out.println("Browser has started");
	     System.out.println("User is on request form page");
	     rf=new RequestFormPage(driver);
	}

	@When("Enter the FirstName as {string},LastName as {string},BusinessName as {string} and Email as {string}")
	public void enter_the_first_name_as_last_name_as_business_name_as_and_email_as(String string, String string2, String string3, String string4) {
	System.out.println("Entering details");
	     rf.firstNameMethod(string);
	     rf.lastNameMethod(string2);
	     rf.businessNameMethod(string3);
	     rf.emailMethod(string4);
	}

	@Then("Enter firstNumber and enter secondNumber")
	public void enter_first_number_and_enter_second_number() {
	   System.out.println("Enterning two numbers");
	     rf.enterNumber1();
	     rf.enterNumber2();
	}
	@Then("the result should be sum of two numbers")
	public void the_result_should_be_sum_of_two_numbers() {
	   System.out.println("Doing sum of two numbers");
	     rf.result();
	}

	@Then("click submit button")
	public void click_submit_button() {
		System.out.println("clicking submit button");
	     rf.submit();
	}

	
	@Then("User should see Message {string}")
	public void user_should_see_message(String string) {
	    System.out.println("user sholud see the message");
	    String actualText=rf.getMessage();
	    System.out.println("actualText message :"+actualText);
		Assert.assertEquals("Demonstration", actualText);
	}
}
