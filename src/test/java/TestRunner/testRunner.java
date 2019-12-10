package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
					features = "src/test/java/Feature/Leaves.feature",
					glue= "StepDefinition",
					//format = { "pretty" , "html:test-output/abc.html" , "json:json_output/xyz.json" } ,
					dryRun=false,
					strict=true,
					monochrome=true
							//tags={"@Second"}
		
			
		)
					



public class testRunner extends AbstractTestNGCucumberTests {
	
	
	

}