package pom.pages;

import wrappers.GenericWrappers;

public class newBookpage extends GenericWrappers{
	
	public PassengerInfo clickNewBook() {
		clickByXpath(prop.getProperty("newBookpage.clickNewBook"));
		return new PassengerInfo();
		
	}

}
