package pom.pages;

import wrappers.GenericWrappers;

public class publicUserReg extends GenericWrappers{
	public publicUserReg enterUserId(String data) {
		enterById(prop.getProperty("publicUserReg.enterUserId"), data);
		// TODO Auto-generated constructor stub
		return this;
	}public publicUserReg enterPassword(String data) {
		enterById(prop.getProperty("publicUserReg.enterPassword"), data);
		return this;
	}public publicUserReg enterConfirmPwd(String data){
		enterById(prop.getProperty("publicUserReg.enterConfirmPwd"), data);
		return this;
	}public publicUserReg secQues(String value){
		clickById(prop.getProperty("publicUserReg.secQues"));
		selectVisibileTextById(prop.getProperty("publicUserReg.secQues"), value);
		return this;
	}public publicUserReg secAns(String data){
		enterById(prop.getProperty("publicUserReg.secAns"), data);
		return this;
		
	}public publicUserReg DOB(String month, String year) {
		clickById(prop.getProperty("publicUserReg.DOB1"));
		selectVisibleTextByXpath(prop.getProperty("publicUserReg.DOB2"), month);
		selectVisibleTextByXpath(prop.getProperty("publicUserReg.DOB3"), year);
		clickByXpath(prop.getProperty("publicUserReg.DOB4"));//date is it selected correctly??
		return this;
	}public publicUserReg gender(String value) {
		if(value.equalsIgnoreCase("Male")){
			clickByXpath(prop.getProperty("publicUserReg.gender1"));
		}else if(value.equalsIgnoreCase("Female")) {
			clickByXpath(prop.getProperty("publicUserReg.gender2"));
		}else if(value.equalsIgnoreCase("Transgender")) {
			clickByXpath(prop.getProperty("publicUserReg.gender3"));
		}else if(value.equalsIgnoreCase("Institution")) {
			clickByXpath(prop.getProperty("publicUserReg.gender4"));
		}
		return this;
	}public publicUserReg marital(String status) {
		if(status.equalsIgnoreCase("Married")) {
			clickByXpath(prop.getProperty("publicUserReg.marital1"));
		}else if (status.equalsIgnoreCase("UnMarried")) {
			clickByXpath(prop.getProperty("publicUserReg.marital2"));
		}
		return this;
	}
	public publicUserReg email(String email) {
		enterById(prop.getProperty("publicUserReg.email"), email);
		return this;
	}public publicUserReg occupation(String occupation) {
		clickById(prop.getProperty("publicUserReg.occupation"));
		selectVisibileTextById(prop.getProperty("publicUserReg.occupation"), occupation);
		return this;
	}public publicUserReg firstName(String fname){
		enterByName(prop.getProperty("publicUserReg.firstName"), fname);
		return this;
	}public publicUserReg middleName(String mName){
		enterById(prop.getProperty("publicUserReg.middleName"), mName);
		return this;
	}public publicUserReg lastName(String lName){
		enterById(prop.getProperty("publicUserReg.lastName"), lName);
		return this;
	}public publicUserReg nationality(String nationality) {
		clickById(prop.getProperty("publicUserReg.nationality"));
		selectValueById(prop.getProperty("publicUserReg.nationality"), nationality);
		return this;
	}public publicUserReg flat(String flat) {
		enterById(prop.getProperty("publicUserReg.flat"), flat);
		return this;
	}public publicUserReg street(String lane) {
		enterById(prop.getProperty("publicUserReg.street"), lane);
		return this;
	}public publicUserReg area(String area) {
		enterById(prop.getProperty("publicUserReg.area"), area);
		return this;
	}public publicUserReg country(String value) {
		clickById(prop.getProperty("publicUserReg.country"));
		selectVisibileTextById(prop.getProperty("publicUserReg.country"), value);
		return this;
	}public publicUserReg isdPrefix(String value) {
		enterById(prop.getProperty("publicUserReg.isdPrefix"), value);
		return this;
	}public publicUserReg mobile(String mobile) {
		enterById(prop.getProperty("publicUserReg.mobile"), mobile);
		// TODO Auto-generated constructor stub
		return this;
	}public publicUserReg Pin(String Pin) {
		enterById(prop.getProperty("publicUserReg.Pin"), Pin);
		return this;
	}public publicUserReg city(String city) {
		enterById(prop.getProperty("publicUserReg.city"), city);
		selectValueById(prop.getProperty("publicUserReg.city"), city);
		// TODO Auto-generated constructor stub
		return this;
	}public publicUserReg state(String value) {
		clickById(prop.getProperty("publicUserReg.state"));
		selectValueById(prop.getProperty("publicUserReg.state"), value);
		return this;
	}public publicUserReg postOffice(String value) {
		clickById(prop.getProperty("publicUserReg.postOffice"));
		selectVisibileTextById(prop.getProperty("publicUserReg.postOffice"), value);
		return this;
	}

}
