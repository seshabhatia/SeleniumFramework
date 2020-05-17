package pom.pages;

import wrappers.GenericWrappers;

public class Booking extends GenericWrappers {
	
	public newBookpage clickBook() {
		clickByXpath(prop.getProperty("Booking.clickBook"));
		return new newBookpage();
	}

}
