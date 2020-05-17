package pom.pages;

import wrappers.GenericWrappers;

public class CharterPage extends GenericWrappers {
	public CharterPage clickEnquiry() {
		clickByXpath(prop.getProperty("CharterPage.clickEnquiry"));
		return this;
		
	}public CharterPage enterName(String applicantName) {
		enterByName(prop.getProperty("CharterPage.enterName"), applicantName);
		return this;
	}public CharterPage enterOrg(String Org) {
		enterByName(prop.getProperty("CharterPage.enterOrg"), Org);
		return this;
	}public CharterPage enterAddress(String Address) {
		enterByName(prop.getProperty("CharterPage.enterAddress"), Address);
		return this;
	}public CharterPage enterMobile(String Mobile) {
		enterByName(prop.getProperty("CharterPage.enterMobile"), Mobile);
		return this;
	}public CharterPage enterEmail(String email) {
		enterByName(prop.getProperty("CharterPage.enterEmail"), email);
		return this;
	}public CharterPage clickRequest(String value) {//check this if value required?
		clickByName(prop.getProperty("CharterPage.clickRequest"));
		selectVisibleTextByName(prop.getProperty("CharterPage.clickRequest"), value);
		return this;
	}public CharterPage enterOrigin(String value) {
		enterByName(prop.getProperty("CharterPage.enterOrigin"), value);
		return this;
	}public CharterPage enterDest(String value) {
		enterByName(prop.getProperty("CharterPage.enterDest"), value);
		return this;
	}public CharterPage enterDeparture( ) {
		clickByName(prop.getProperty("CharterPage.enterDeparture1"));
		clickByXpath(prop.getProperty("CharterPage.enterDeparture2"));//how to select date
		clickByXpath(prop.getProperty("CharterPage.enterDeparture3"));
		return this;
		
	}public CharterPage enterArrival() {
		clickByName(prop.getProperty("CharterPage.enterArrival1"));
		clickByXpath(prop.getProperty("CharterPage.enterArrival2"));//date selection
		clickByXpath(prop.getProperty("CharterPage.enterArrival3"));
		return this;
		
	}public CharterPage enterDuration(String duration) {
		enterByName(prop.getProperty("CharterPage.enterDuration"), duration);
		return this;
	}
	public CharterPage enterPassanger(String passCt) {
		enterByName(prop.getProperty("CharterPage.enterPassanger"), passCt);
		return this;
	}public CharterPage enterPurpose(String charterPurpose) {
		enterByName(prop.getProperty("CharterPage.enterPurpose"), charterPurpose);
		return this;
	}public CharterPage enterAdditional(String addServices) {
		enterByName(prop.getProperty("CharterPage.enterAdditional"), addServices);
		return this;
	}public CharterPage clickSubmit() {
		clickByXpath(prop.getProperty("CharterPage.clickSubmit"));
		return this;
	}

}
