package step;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import extend.ExtentReporterNG;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import util.DataDriver;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

import io.restassured.specification.RequestSpecification;
public class Get_All_Users_API_Step_Driver
{
	Response resp;
	SoftAssert softAssertion ;
	String path ;
	
	
	@Given("^Test Get All Users API End pont \"([^\"]*)\" is deployed verificatrion data driver \"([^\"]*)\" is ready$")
	public void test_City_API_End_pont_is_deployed_verificatrion_data_driver_is_ready(String arg1, String arg2) throws Throwable {
		softAssertion= new SoftAssert();
		File f = new File(arg2);
        RestAssured.baseURI = arg1;
        
			
		Assert.assertEquals(f.exists(), true);
	}

	@When("^Test Get All Users API Tester send a request at \"([^\"]*)\"$")
	public void test_City_API_Tester_send_a_request_at(String arg1) throws Throwable {
	   path = arg1;
	}

	@Then("^Test Get All Users API header JSONPath value Verification is carried out via data driver from \"([^\"]*)\" at worksheet (\\d+) from row (\\d+) to row (\\d+) feed and verification data is pulled from columns (\\d+) and (\\d+)$")
	public void test_Get_instructions_API_header_JSONPath_value_Verification_is_carried_out_via_data_driver_from_at_worksheet_from_row_to_row_feed_and_verification_data_is_pulled_from_columns_and(String arg1, int arg2, int arg3, int arg4, int arg5, int arg6) throws Throwable {
	        
		DataDriver dd = new DataDriver();
		
		List<String> col_key_list = dd.getcolval(arg1, arg2, arg5, arg3, arg4);
		List<String> col_val_list = dd.getcolval(arg1, arg2, arg6, arg3, arg4);
		
		int assertflag = 0;
		String result = "true";
		int index =0;
		String col_val;
		
		
		for (String col_key : col_key_list )
		{
			
		
			col_val = col_val_list.get(index);
			index ++;
			
			
			
			if (path.contains("{para}"))
			{
			
		//	resp = when().get(path,col_param);
		//	System.out.println(path+ " " + col_param);
			}
			else
			{
				resp = when().get(path);
				
			}
		    
			
           result = Boolean.toString(resp.jsonPath().getList(col_key).contains(col_val));
			
			
			
			if (result == "false")
	        {
			assertflag = 1;
	       
			com.cucumber.listener.Reporter.addStepLog("Verification :  Responce header received is " + resp.getStatusCode() + " , for JSON path \"" + col_key +  "\" value  \"" + col_val +"\" does not exsits in list" );
			softAssertion.assertEquals(resp.jsonPath().getList(col_key).contains(col_val),col_val,"Verifying JSON Path value list");
	        }
			else
			{
				com.cucumber.listener.Reporter.addStepLog("Verification : Responce header received is " + resp.getStatusCode() + " , for JSON path \"" + col_key +  "\" value is \"" + col_val + "\" do exsits in list"  );
				}
			
	        
		
	        
		}
		
		if (assertflag ==1)
        {
		com.cucumber.listener.Reporter.addStepLog("one or more tests have failed \n" );		       
		com.cucumber.listener.Reporter.setTestRunnerOutput("FAIL");
       // softAssertion.assertEquals(assertflag, 0, "Error at step 6") ;
        
        }
	
	}

	@Then("^Test Get All Users API Gather all soft /hard asertion report$")
	public void gather_report() throws Throwable {
		softAssertion.assertAll();  
		
	}
}
