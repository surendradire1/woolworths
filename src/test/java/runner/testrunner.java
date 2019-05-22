package runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features = "src/test/resources/Features",
		 glue= {"stepdefinitions"},
		 plugin = {"pretty","html:target/cucumber_html_report","json:target/cucumber.json"}
	)

public class testrunner {
	
}
