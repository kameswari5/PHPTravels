package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)				
@CucumberOptions(
		features="Features",
		glue={"stepDefinitions"},
		plugin= {"pretty:target/cucumber/cucumber.txt",
				"html:target/cucumber-reports",
				"json:target/cucumber/report.json",
				"junit:target/cucumber/Cucumber.xml"},
		monochrome = true
		)						

public class TestRunner {

}
