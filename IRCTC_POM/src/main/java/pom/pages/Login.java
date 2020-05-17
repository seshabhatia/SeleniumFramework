package pom.pages;

import wrappers.GenericWrappers;

public class Login extends GenericWrappers{
	
	public publicUserReg clickNewUser() {
		clickByXpath(prop.getProperty("Login.clickNewUser"));
		return new publicUserReg();
		
	}public Login waitOnLoginPage() {
		threadSleep();
		return this;
	}
	

}
