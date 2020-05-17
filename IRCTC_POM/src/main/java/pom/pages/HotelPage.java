package pom.pages;

import wrappers.GenericWrappers;

public class HotelPage extends GenericWrappers { 
	
	public HotelPage clickLogIn() {
		clickByXpath(prop.getProperty("HotelPage.clickLogIn"));
		return this;
			
	}public HotelPage clickGuestLogin() {
		clickByXpath(prop.getProperty("HotelPage.clickGuestLogin"));
		
		return this;
	}public HotelPage enterGuestEmail(String email) {
		enterByName(prop.getProperty("HotelPage.enterGuestEmail"), email);
		return this;
	}public HotelPage enterGuestMobile(String mobile) {
		enterByName(prop.getProperty("HotelPage.enterGuestMobile"), mobile);
		return this;
	}public HotelPage clickSubmit() {
		clickByXpath(prop.getProperty("HotelPage.clickSubmit"));
		return this;
	}
	public HotelPage enterDestination(String value) {
		enterByXpath(prop.getProperty("HotelPage.enterDestination"), value);
		return this;
	}public HotelPage clickChkIn() {
		clickByXpath(prop.getProperty("HotelPage.clickChkIn1"));
		clickByXpath(prop.getProperty("HotelPage.clickChkIn2"));
		clickByXpath(prop.getProperty("HotelPage.clickChkIn3"));
		clickByXpath(prop.getProperty("HotelPage.clickChkIn4"));
		clickByXpath(prop.getProperty("HotelPage.clickChkIn5"));
		return this;
	}public HotelPage clickChkOut() {
		clickByXpath(prop.getProperty("HotelPage.clickChkOut1"));
		clickByXpath(prop.getProperty("HotelPage.clickChkOut2"));
		clickByXpath(prop.getProperty("HotelPage.clickChkOut3"));
		clickByXpath(prop.getProperty("HotelPage.clickChkOut4"));
		clickByXpath(prop.getProperty("HotelPage.clickChkOut5"));
		return this;
		
	}public HotelPage roomsguest(String room,String adult,String child) {
		clickByName(prop.getProperty("HotelPage.roomsguest1"));
		clickByName(prop.getProperty("HotelPage.roomsguest2"));
		selectVisibleTextByName(prop.getProperty("HotelPage.roomsguest2"), room);
		clickByName(prop.getProperty("HotelPage.roomsguest3"));
		selectVisibleTextByName(prop.getProperty("HotelPage.roomsguest3"), adult);
		clickByName(prop.getProperty("HotelPage.roomsguest4"));
		selectVisibleTextByName(prop.getProperty("HotelPage.roomsguest4"), child);
		clickByXpath(prop.getProperty("HotelPage.roomsguest5"));
		return this;
	}public Booking clickFindHotel() {
		clickByXpath(prop.getProperty("HotelPage.clickFindHotel"));
		return new Booking();
	
}
}
