package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ProjectWrappers extends GenericWrappers{
	
	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}
	
	
	@BeforeClass
	public void beforeClass() {
		startTest(testCaseName, testCaseDescription);
		test.assignAuthor(testCaseAuthor);
		test.assignCategory(testCaseCategeory);
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		loadObjects();
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search", true);
	}
	
	
	@AfterMethod
	public void afterMethod() {
		closeAllBrowsers();
	}
	
	@AfterClass
	public void afterClass() {
		endTest();
	}
	
	@AfterTest
	public void afterTest() {
		//Reserved
	}
	
	@AfterSuite
	public void afterSuite() {
		endReport();
	}
	
}
