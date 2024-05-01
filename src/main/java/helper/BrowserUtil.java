package helper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class BrowserUtil {
	  static WebDriver driver;
      static ConfigFileReaderUtil configFileReader = new ConfigFileReaderUtil();
	public static WebDriver startBrowser() {
		String browserName=configFileReader.getProperty("browserName");
		if(browserName.equalsIgnoreCase("Firefox"))	{
			System.setProperty("webdriver.gecko.driver",configFileReader.getDriverPath());
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			driver.navigate().to(configFileReader.getApplicationUrl());
		}
		else {
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}
		return driver;
	}
}
