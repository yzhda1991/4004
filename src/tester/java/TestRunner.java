package tester.java;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty"
				}, 
				
		features = { "src/tester/feature" },
	tags = {"@Tester"}
		
)
public class TestRunner {

	
	

}
