package pom.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.pages.Accomodation;
import pom.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC003 extends ProjectWrappers{
	
	@BeforeTest
	public void beforeTest(){
		testCaseName = "TC003";
		testCaseDescription = "IRCTC Booking";
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
		.clickBookCoach()
		.waitOnLoginPage()
		.clickNewUser()
		.enterUserId("HarryPotter")
		.enterPassword("Password7")
		.enterConfirmPwd("Password7")
		.secQues("What is your pet name?")
		.secAns("doggy")
		.DOB("Apr", "2000")
		.gender("Male")
		.marital("Married")
		.email("emale@gmail.com")
		.occupation("Self Employed")
		.firstName("Harry")
		.middleName("Pot")
		.lastName("Potter")
		.nationality("Indian")
		.flat("1234")
		.street("ABC lane")
		.area("Sikh")
		.country("India")
		.isdPrefix("91")
		.mobile("9090909090")
		.Pin("500009")
		.city("Hyderabad")
		.state("ANDHRA PRADESH")
		.postOffice("Manovikasnagar S.O");
		
		
	
	}

}
