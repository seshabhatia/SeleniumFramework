package pom.pages;

import wrappers.GenericWrappers;

public class Summary extends GenericWrappers {
	public Summary clickTerms() {
		clickByXpath(prop.getProperty("Summary.clickTerms"));
		return this;
	}/*click makePayment(){
		clickByXpath("/html/body/app-root/app-fulllayout/div/app-summary/main/div/div[1]/div[7]/button[2]");
	}*/

}
