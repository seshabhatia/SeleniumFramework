package pom.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC01 extends ProjectWrappers{
	@BeforeTest
	public void beforeTest() {
		testCaseName = "TC01";
		testCaseDescription = "IRCTC Reg3";
		testCaseAuthor = "Sesha";
		testCaseCategeory = "Dryrun";
	}
	@Test
	public void irctcRegPage() {
		
		HomePage obj = new HomePage();
		obj.covid19Alert()
		.mouseHoverOnStays()
		.clickOnLounge()
		.clickIRCTC()
		.clickLogIn()
		.clickGuestLogin()
		.enterGuestEmail("noemail@gmail.com")
		.enterGuestMobile("9090909090")
		.clickSubmit()
		.enterDestination("New Delhi")
		.clickChkIn()
		.clickChkOut()
		.roomsguest("1", "3", "0")
		.clickFindHotel()
		.clickBook()
		.clickNewBook()
		.clickTitle("Mr")
		.enterFname("Harry")
		.enterLname("Potter")
		.GST("No")
		.clickGo();
		
		
	}

}
