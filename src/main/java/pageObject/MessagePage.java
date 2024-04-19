package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage {
	
	WebDriver driver;
	
	public MessagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[@class='text-center cw mt-3']")
	WebElement message;
	
	
	public String getMessage() {
		String text=message.getText();
		System.out.println(text);
		return text;
	}

}
