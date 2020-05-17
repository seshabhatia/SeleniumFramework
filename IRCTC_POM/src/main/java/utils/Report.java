package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static String testCaseName, testCaseDescription, testCaseAuthor, testCaseCategeory;
	
	public void startReport() {
		
		extent = new ExtentReports("./reports/report.html");
		
	}
	
	
	public void startTest(String testName, String description) {
		
		test = extent.startTest(testName, description);
		
	}
	
	
	
	public void endTest() {
		extent.endTest(test);
	}
	
	public void endReport() {
		extent.flush();
	}
	

}
