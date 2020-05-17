package pom.pages;

import wrappers.GenericWrappers;

public class PassengerInfo extends GenericWrappers {
	
	public PassengerInfo clickTitle(String title) {
		clickByXpath(prop.getProperty("PassengerInfo.clickTitle"));
		selectVisibleTextByXpath(prop.getProperty("PassengerInfo.clickTitle"), title);
		return this;
	}public PassengerInfo enterFname(String Fname) {
		enterByName(prop.getProperty("PassengerInfo.enterFname"), Fname);
		return this;
		
	}public PassengerInfo enterLname(String Lname) {
		enterByName(prop.getProperty("PassengerInfo.enterLname"), Lname);
		return this;//automatically populated number and email??
	}public PassengerInfo GST(String value) {
		clickByName(prop.getProperty("PassengerInfo.GST"));
		selectVisibleTextByName(prop.getProperty("PassengerInfo.GST"), value);
		return this;
	}public Summary clickGo() {
		clickByXpath(prop.getProperty("PassengerInfo.clickGo"));
		return new Summary();
	}

}
