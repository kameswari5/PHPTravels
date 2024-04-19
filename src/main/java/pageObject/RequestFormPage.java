package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestFormPage {
	WebDriver driver;
	String value1;
	String value2;
	public RequestFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='business_name']")
	WebElement businessName;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement email;
	
	@FindBy(xpath="//h4//span[@id='numb1']")
	WebElement number1;
	
	@FindBy(xpath="//h4//span[@id='numb2']")
	WebElement number2;
	
	@FindBy(xpath = "//input[@id='number']")
	WebElement Result;
	
	@FindBy(xpath="//div//button[@id='demo']")
	WebElement Submit;
	
	@FindBy(xpath= "//div//h1[@class='mb-0']")
	WebElement message;
	
	
	public void firstNameMethod(String FirstName) {
		firstName.clear();
		firstName.sendKeys(FirstName);
	}
	
	public void lastNameMethod(String LastName) {
		lastName.clear();
		lastName.sendKeys(LastName);
	}
	
	public void businessNameMethod(String BusinessName) {
		businessName.clear();
		businessName.sendKeys(BusinessName);
	}
	
	public void emailMethod(String Email) {
		email.clear();
		email.sendKeys(Email);
	}
	
	public void enterNumber1() {
	value1=number1.getText();
		System.out.println("value1 :"+value1);
	}
	
	public void enterNumber2() {
		value2=number2.getText();
		System.out.println("value2 :"+value2);
	}
	
	public void result() {
		System.out.println("Result method starting");
		int firstNumber = Integer.parseInt(number1.getText());
        int secondNumber = Integer.parseInt(number2.getText());
        int sum = firstNumber + secondNumber;
        System.out.println("value added to result :"+sum);
       Result.sendKeys(Integer.toString(sum));
	}
	
	public void submit() {
		Submit.click();
	}
	
	public String getMessage() {
		String text=message.getText();
		System.out.println("The message was "+text);
		return text;
	}
}