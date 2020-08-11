package runners;
import org.testng.annotations.AfterClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = "src\\main\\java\\features\\Get_User_API.feature"
        ,glue={"step"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
 //       plugin = { "pretty" },
        monochrome = true
        )
public class Get_User_API_Step_Runner extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void writeExtentReport() {
		
		com.cucumber.listener.Reporter.assignAuthor("Shailesh Hase");
		
		
	}
	
	
	
	

}

	
	
