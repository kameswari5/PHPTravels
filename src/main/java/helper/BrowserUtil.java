package helper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {

	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName,String url) {
		if(browserName.equalsIgnoreCase("chrome"))	{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\meetr\\OneDrive\\Desktop\\geckodriver-v0.34.0-win32\\geckodriver.exe");
			driver= new FirefoxDriver();
			driver.manage().window().maximize();	
			driver.navigate().to(url);
		}
		return driver;
		
	}

}
