package pom.pages;

import wrappers.GenericWrappers;

public class Accomodation extends GenericWrappers{
	
	public Accomodation switcToAccomodationPage() {
		switchToLastWindow();
		return this;
	}
	
	public Accomodation clickMenu() {
		clickByXpath(prop.getProperty("Accomodation.clickMenu"));
		return this;
	}public  Login clickBookCoach() {
		clickByXpath(prop.getProperty("Accomodation.clickBookCoach"));//whats the return?
		return new Login();
		
	}public CharterPage clickCharter() {
		clickByXpath(prop.getProperty("Accomodation.clickCharter"));
		return new CharterPage();
		
	}public HotelPage clickIRCTC() {
		clickByXpath(prop.getProperty("Accomodation.clickIRCTC"));
		return new HotelPage();

}public Accomodation waitOnAccomodationPage() {
	threadSleep();
	return this;}
}
