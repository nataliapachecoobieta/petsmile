package runner;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin = "pretty",
	features ="src/test/java/features",
	glue = {"StepDefiniton"}
	
)
public class TestRunner {
	@Test
	public void test(){}
}
