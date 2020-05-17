package pom.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC004 extends ProjectWrappers {
	@BeforeTest
	public void beforeTest(){
		testCaseName = "TC004";
		testCaseDescription = "IRCTC Reg2";
		testCaseAuthor = "Sesha";
		testCaseCategeory = "Dryrun";
	}
	
	@Test
	public void irctcRegPage() {
		HomePage obj = new HomePage();
		obj.covid19Alert()
		.mouseHoverOnStays()
		.clickOnLounge()
		.switcToAccomodationPage()
		.waitOnAccomodationPage()
		.clickMenu()
		.clickCharter()
		.clickEnquiry()
		.enterName("HarryPotter")
		.enterOrg("WHO")
		.enterAddress("1234 abc lane hyderabad")
		.enterMobile("9090909090")
		.enterEmail("orgemail@gmail.com")
		.clickRequest("Saloon Charter")
		.enterOrigin("Chennai")
		.enterDest("New Delhi")
		.enterDeparture()
		.enterArrival()
		.enterDuration("14")
		.enterPurpose("travel")
		.enterAdditional("N/a")
		.clickSubmit();
		
	}

}
