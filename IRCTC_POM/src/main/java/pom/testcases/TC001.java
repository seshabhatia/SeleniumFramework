package pom.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC001 extends ProjectWrappers {
	
	@BeforeTest
	public void beforeTest() {
		
		testCaseName = "TC001";
		testCaseDescription = "IRCTC Reg";
		testCaseAuthor = "Sesha";
		testCaseCategeory = "Dryrun";
		
	}
	
	
	
	@Test
	public void irctcRegPage() {
		
		HomePage obj = new HomePage();
		obj.covid19Alert()
		.clickOnRegister()
		.waitOnRegistrationPage()
		.enterUserName("HarryPotter")
		.enterPassword("Password7")
		.enterConfirmPassword("Password7")
		.enterSecQues()
		.enterSecAns("doggy")
		.prefLang()
		.firstName("Harry")
		.midName("Pot")
		.lastName("Potter")
		.gender("M")
		.DOB("Apr", "1980")
		.Occupation("Self Employed")
		.Marital("Married")
		.country("India")
		.email("noemail@gmail.com")
		.isd("91")
		.mobile("9090909090")
		.nationality("India")
		.flatNo("1234")
		.Street("ABC LaneS")
		.area("Manovikas")
		.pin("500009")
		.state("ANDHRA PRADESH")
		.city("Hyderabad")
		
		.postOffice("Manovikasnagar S.O ")
		.phone("27897671")
		.resOffice("No")
		.offFlat("4321")
		.offStreet("CBA lane")
		.offArea("Secunderabad")
		.offCountry("India")
		.offPin("500003")
		.offState("ANDHRA PRADESH")
		.offCity("Hyderabad")
		.offPostOff("Secunderabad H.O")
		.offPhone("276767676")
		.clickTerms();
	}

}
