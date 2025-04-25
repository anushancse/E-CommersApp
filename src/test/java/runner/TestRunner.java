package runner;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        
        features = "src/test/resources/Features",

        glue = "StepDefinitions", 
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

      monochrome = true
)
public class TestRunner   {


}




