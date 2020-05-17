package utils;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Sample_Report {

	
	@Test
	public void report() {
		
		// 1st startReport
		ExtentReports extent = new ExtentReports("./reports/samplereport.html");
		
		// 2nd step is startTest
		ExtentTest test = extent.startTest("TC001", "IRCTC Reg");
		
		// 3rd logStatus
		test.log(LogStatus.PASS, "The Test Step is Passed");
		test.log(LogStatus.FAIL, "Test Step Failes");
		test.log(LogStatus.PASS, "The Test Step is Passed");
		test.log(LogStatus.FAIL, "Test Step Failes");
		test.log(LogStatus.PASS, "The Test Step is Passed");
		test.log(LogStatus.FAIL, "Test Step Failes");
		test.log(LogStatus.PASS, "The Test Step is Passed");
		test.log(LogStatus.FAIL, "Test Step Failes");
		
		// 4th endTest
		extent.endTest(test);
		
		
		//5th EndReport
		extent.flush();
		
	}
	
	
	
}
