package pom.pages;

import wrappers.GenericWrappers;

public class RegistrationPage extends GenericWrappers {
	
	
	public RegistrationPage waitOnRegistrationPage() {
		threadSleep();
		return this;
	}
	
	
	public RegistrationPage enterUserName(String data) {
		
		enterById(prop.getProperty("RegistrationPage.enterUserName"), data);
		return this;
	}
	public RegistrationPage enterPassword(String data) {
		enterById(prop.getProperty("RegistrationPage.enterPassword"), data);
		return this;
	}
	public RegistrationPage enterConfirmPassword(String data) {
		enterById(prop.getProperty("RegistrationPage.enterConfirmPassword"), data);
		return this;
	}
	public RegistrationPage enterSecQues() {
		clickByXpath(prop.getProperty("RegistrationPage.enterSecQues1"));
		clickByXpath(prop.getProperty("RegistrationPage.enterSecQues2"));
		return this;
	}
	public RegistrationPage enterSecAns(String data) {
		enterByXpath(prop.getProperty("RegistrationPage.enterSecAns"), data);
		return this;
	}
	public RegistrationPage prefLang() {
		clickByXpath(prop.getProperty("RegistrationPage.prefLang1"));
		 clickByXpath(prop.getProperty("RegistrationPage.prefLang2"));//preferred language
		return this;
	}
	public RegistrationPage firstName(String data) {
		enterById("firstName", data);
		return this;
	}
	public RegistrationPage midName(String data) {
		enterById("middleName", data);
		return this;
	}
	public RegistrationPage lastName(String data) {
		enterById("lastname", data);
		return this;
	}
	public RegistrationPage gender(String gender) {
		if(gender.equalsIgnoreCase("male")) {
		clickByXpath(prop.getProperty("RegistrationPage.gender1"));
		}else if(gender.equalsIgnoreCase("female")) {
			clickByXpath(prop.getProperty("RegistrationPage.gender2"));
		}else if(gender.equalsIgnoreCase("Transgender")) {
			clickByXpath(prop.getProperty("RegistrationPage.gender3"));
		}
		return this;
	}
	public RegistrationPage DOB(String month,String year) {
		clickByXpath(prop.getProperty("RegistrationPage.DOB1"));
		selectVisibleTextByXpath(prop.getProperty("RegistrationPage.DOB2"), month);
		selectVisibleTextByXpath(prop.getProperty("RegistrationPage.DOB3"), year);
		clickByXpath(prop.getProperty("RegistrationPage.DOB4"));
		return this;
		
	}
	public RegistrationPage Occupation(String designation) {
		clickByXpath(prop.getProperty("RegistrationPage.Occupation1"));
		if(designation.equalsIgnoreCase("GOVERNMENT")) {
			clickByXpath(prop.getProperty("RegistrationPage.Occupation2"));
		}else if(designation.equalsIgnoreCase("PUBLIC")) {
			clickByXpath(prop.getProperty("RegistrationPage.Occupation3"));
		}else if(designation.equalsIgnoreCase("PRIVATE")) {
			clickByXpath(prop.getProperty("RegistrationPage.Occupation4"));
		}else if(designation.equalsIgnoreCase("PROFESSIONAL")) {
			clickByXpath(prop.getProperty("RegistrationPage.Occupation5"));
		}else if(designation.equalsIgnoreCase("SELF EMPLOYED")) {
			clickByXpath(prop.getProperty("RegistrationPage.Occupation6"));
		}else if(designation.equalsIgnoreCase("STUDENT")) {
			clickByXpath(prop.getProperty("RegistrationPage.Occupation7"));
		}else if(designation.equalsIgnoreCase("OTHER")) {
			clickByXpath(prop.getProperty("RegistrationPage.Occupation8"));
		}
		return this;
	}public RegistrationPage Marital(String status) {
		if (status.equalsIgnoreCase(" Married")){
			clickByXpath(prop.getProperty("RegistrationPage.Marital1"));
		}else if(status.equalsIgnoreCase(" Unmarried")) {
			clickByXpath(prop.getProperty("RegistrationPage.Marital2"));
		}
		return this;
		
	}public RegistrationPage country(String country) {
		clickByXpath(prop.getProperty("RegistrationPage.country1"));//do i need this stmt?
		selectVisibleTextByXpath(prop.getProperty("RegistrationPage.country2"), country);
		return this;
	}public RegistrationPage email(String data) {
		enterById(prop.getProperty("RegistrationPage.email"), data);
		return this;
	}public RegistrationPage isd(String data) {
		enterById(prop.getProperty("RegistrationPage.isd"), data);
		return this;
	}public RegistrationPage mobile(String number) {
		enterById(prop.getProperty("RegistrationPage.mobile"), number);
		return this;
	}public RegistrationPage nationality(String nationality) {
		selectVisibleTextByXpath(prop.getProperty("RegistrationPage.nationality"), nationality);
		return this;
		
	}public RegistrationPage flatNo(String number) {
		enterByXpath(prop.getProperty("RegistrationPage.flatNo"), number);
		return this;
	}public RegistrationPage Street(String name) {
		enterByXpath(prop.getProperty("RegistrationPage.Street"), name);
		return this;
	}public RegistrationPage area(String name) {
		enterByXpath(prop.getProperty("RegistrationPage.area"), name);
		return this;
	}public RegistrationPage pin(String pin) {
		enterByName(prop.getProperty("RegistrationPage.pin"), pin);
		return this;
	}public RegistrationPage state(String state) {
		enterById(prop.getProperty("RegistrationPage.state"), state);
		return this;
	}public RegistrationPage city(String city) {
		enterById(prop.getProperty("RegistrationPage.city"), city);
		return this;
	}public RegistrationPage postOffice(String postOffice) {
		enterById(prop.getProperty("RegistrationPage.postOffice"), postOffice);
		return this;
	}public RegistrationPage phone(String phone) {
		enterById("resPhone", phone);
		return this;
	}public RegistrationPage resOffice(String resOffice) {
		if (resOffice.equalsIgnoreCase("Yes")){
			clickByXpath(prop.getProperty("RegistrationPage.resOffice1"));
		}else if (resOffice.equalsIgnoreCase("No")){
			clickByXpath(prop.getProperty("RegistrationPage.resOffice2"));
		}
		return this;
	}public RegistrationPage offFlat(String offFlat) {
		enterByXpath(prop.getProperty("RegistrationPage.offFlat"), offFlat);
		return this;
	}public RegistrationPage offStreet(String offStreet) {
		enterByXpath(prop.getProperty("RegistrationPage.offStreet"), offStreet);
		return this;
	}public RegistrationPage offArea(String offArea) {
		enterByXpath(prop.getProperty("RegistrationPage.offArea"), offArea);
		return this;
	}public RegistrationPage offCountry(String offCountry) {
		selectVisibleTextByXpath(prop.getProperty("RegistrationPage.offCountry"), offCountry);
		return this;
	}public RegistrationPage offPin(String offPin) {
		enterById(prop.getProperty("RegistrationPage.offPin"), offPin);
		return this;
	}public RegistrationPage offState(String offState) {
		enterById(prop.getProperty("RegistrationPage.offState"), offState);
		return this;
	}public RegistrationPage offCity(String offCity) {
		enterById(prop.getProperty("RegistrationPage.offCity"), offCity);
		return this;
	}public RegistrationPage offPostOff(String offPO) {
		enterById(prop.getProperty("RegistrationPage.offPostOff"), offPO);
		return this;
	}public RegistrationPage offPhone(String offPhone) {
		enterById(prop.getProperty("RegistrationPage.offPhone"), "offPhone");
		return this;
	}public RegistrationPage clickTerms() {
		clickByXpath(prop.getProperty("RegistrationPage.clickTerms"));
		return this;
	}
}
