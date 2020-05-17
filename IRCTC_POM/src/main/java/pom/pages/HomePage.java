package pom.pages;

import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {
	
	/*public HomePage(ChromeDriver driver, ExtentTest test) {
		
		this.driver = driver;
		this.test = test;
		
	}*/
	
	
	public HomePage covid19Alert() {
		clickByXpath(prop.getProperty("HomePage.covid19Alert"));
		return new HomePage();
	}
	
	public RegistrationPage clickOnRegister() {
		clickByXpath(prop.getProperty("HomePage.clickOnRegister"));
		return new RegistrationPage();
	}
	
	public HomePage mouseHoverOnStays() {
		
		mouseHover(prop.getProperty("HomePage.mouseHoverOnStays"));
		return new HomePage();
		
	}
	
	public Accomodation clickOnLounge() {
		clickByXpath(prop.getProperty("HomePage.clickOnLounge"));
		return new Accomodation();
		
	
	}
	
	

}
