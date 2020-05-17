package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

import javax.sound.midi.SysexMessage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import utils.Report;

public class GenericWrappers extends Report implements Wrappers{
	
	public static RemoteWebDriver driver;
	
	public static Properties prop;
	
	public void logReport(String status, String desc) {
		long number = takeSnap();
		if(status.equalsIgnoreCase("pass")) {
			test.log(LogStatus.PASS, desc+test.addScreenCapture(System.getProperty("user.dir")+"/screenshots/image"+number+".jpg"));
		}else if(status.equalsIgnoreCase("fail")) {
			test.log(LogStatus.FAIL, desc+test.addScreenCapture(System.getProperty("user.dir")+"/screenshots/image"+number+".jpg"));
		}
		
		
	}
	
	public void loadObjects() {
		
		prop = new Properties();
		try {
			prop.load(new FileInputStream("./src/test/java/Object.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void invokeApp(String browser, String url, boolean bflag) {
		// TODO Auto-generated method stub
		
		try {
			
			if(bflag) {
				
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setBrowserName(browser);
				dc.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(new URL("http://192.168.86.152:4444/wd/hub"), dc);
				
			}else if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
			}
			//System.out.println("The "+browser+" browser launched successfully and loaded the url as - "+url);
			logReport("Pass", "The "+browser+" browser launched successfully and loaded the url as - "+url);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			//System.err.println("Timeout exception");
			logReport("Fail", "Timeout exception");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		try {
			waitForTextBox("id", idValue);
			driver.findElementById(idValue).sendKeys(data);
			//System.out.println("The Element with id value "+idValue+" is found and entered data as "+data);
			logReport("Pass", "The Element with id value "+idValue+" is found and entered data as "+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with id value "+idValue+" is not found and entered data as ");
			logReport("Fail", "The Element with id value "+idValue+" is not found and entered data as"+data);
		}catch (ElementNotVisibleException e) {
			//System.err.println("The Element with id value "+idValue+"is not visible");// TODO: handle exception
			logReport("Fail", "The Element with id value "+idValue+"is not visible");
		}catch (ElementNotInteractableException e) {
			//System.err.println("The Element with id value "+idValue+"is Not Interactable");// TODO: handle exception
			logReport("Fail", "The Element with id value "+idValue+"is Not Interactable");
		}catch (WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");// TODO: handle exception
			logReport("Fail", "The browser got closed due to unknown error");
		
		}
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			//System.out.println("The Element with name value "+nameValue+"is found and entered data as"+data);
			logReport("Pass", "The Element with name value "+nameValue+"is found and entered data as"+data);
		} catch (NoSuchElementException e) {
			//System.err.println("The Element with name value "+nameValue+"is Not Found");}
			logReport("Fail", "The Element with name value "+nameValue+"is Not Found");}
			catch(ElementNotVisibleException e) {
				//System.err.println("The Element with name value "+nameValue+"is not visible");
				logReport("Fail", "The Element with name value "+nameValue+"is not visible");
			}catch(ElementNotInteractableException e) {
				//System.err.println("The Element with name value "+nameValue+"is Not Interactable");
				logReport("Fail", "The Element with name value "+nameValue+"is Not Interactable");
			}catch (WebDriverException e) {
				//System.err.println("The browser got closed due to unknown error");
				logReport("Fail", "The browser got closed due to unknown error");
			}//finally {				takeSnap();// TODO Auto-generated catch block	}
		
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The Element with Xpath value "+xpathValue+"is found and entered data as"+data);
			logReport("Pass", "The Element with Xpath value "+xpathValue+"is found and entered data as"+data);
		} catch ( NoSuchElementException e) {
			System.err.println("The Element with Xpath value "+xpathValue+" has No Such Element");
			logReport("Fail", "The Element with Xpath value "+xpathValue+" has No Such Element");
			// TODO Auto-generated catch block
		} catch(ElementNotVisibleException e) {
			//System.err.println("The Element with Xpath value "+xpathValue+" is not visible ");
			logReport("Fail", "The Element with Xpath value "+xpathValue+" is not visible ");
		} catch(ElementNotInteractableException e) {
		  // System.err.println("The Element with Xpath value "+xpathValue+" is not interactable");
			logReport("Fail", "The Element with Xpath value "+xpathValue+" is not interactable");
		} catch(WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}//finally {takeSnap();}

	}

	public void verifyTitle(String title) {
		try {
			String ttl = driver.getTitle();
			System.out.println("The Actual title is"+ttl);
			
			if (ttl.equals(title)){
				//System.out.println("The Actual Title - "+ttl+" and the expected title - "+title+" both are same");}
				logReport("Pass", "The Actual Title - "+ttl+" and the expected title - "+title+" both are same");}
				else { 
					//System.out.println("title not verified");
					logReport("Fail", "title not verified");// if else is this righ for log report
				
			}
		} catch (NoSuchWindowException e) {
			//System.err.println("No Such Window");// TODO Auto-generated catch block
			logReport("Fail", "No Such Window");
		}catch (WebDriverException e){
				//System.err.println("The browser got closed due to unknown error");
				logReport("Fail", "The browser got closed due to unknown error");
		}//finally {takeSnap();	}
		
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String verTxtbyID = driver.findElementById(id).getText();
			if (verTxtbyID.equals(text)) {
				//System.out.println("text verified by id");
				logReport("Pass", "text verified by id");
			}
			else {
				//System.out.println("text NOT verified by id");
				logReport("Fail", "text NOT verified by id");
			}
		} catch (NoSuchElementException e) {
			//System.err.println("Element with the id value"+id+"is not found");// TODO Auto-generated catch block
			logReport("Fail", "Element with the id value"+id+"is not found");
		} catch(ElementNotVisibleException e) {
			//System.err.println("Element with the id value"+id+"is not visible");
			logReport("Fail", "Element with the id value"+id+"is not visible");
		} catch (ElementNotInteractableException e) {
			//System.err.println("Element with the id value"+id+"is not interactable");
			logReport("Fail", "Element with the id value"+id+"is not interactable");
		}catch (WebDriverException e) {
			//System.err.println("WebDriver exception");
			logReport("Fail", "WebDriver exception");
		}
		//finally {			takeSnap();		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		try {
			String verTxtbyX = driver.findElementByXPath(xpath).getText();// TODO Auto-generated method stub
			if(verTxtbyX.equals(text)) {
				//System.out.println("Text verified by xpath");
				logReport("Pass", "Text verified by xpath");
			}
			else {
				//System.out.println("Text NOT verified by Xpath");
				logReport("Fail", "Text NOT verified by Xpath");
			}
		} catch (NoSuchElementException e) {
			//System.err.println("Element with the xPath value"+xpath+"is not found");// TODO Auto-generated catch block
			logReport("Fail", "Element with the xPath value"+xpath+"is not found");
		}catch (ElementNotVisibleException e) {
			//System.err.println("Element with the xPath value"+xpath+"isnot visible");
			logReport("Fail", "Element with the xPath value"+xpath+"isnot visible");
		}catch (ElementNotInteractableException e) {
			//System.err.println("Element with the xPath value"+xpath+"isnot interactable");
			logReport("Fail", "Element with the xPath value"+xpath+"isnot interactable");
		}catch(WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}//finally {		takeSnap();		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String verTxtbyX =driver.findElementByXPath(xpath).getText();// TODO Auto-generated method stub
			if(verTxtbyX.contains(text)) {
				//System.out.println("Text present in XPath with value"+xpath);
				logReport("Pass", "Text present in XPath with value"+xpath);
			}else {
				//System.out.println("Text is not contained in Xpath with value"+xpath);
				logReport("Fail", "Text is not contained in Xpath with value"+xpath);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("Element with the xPath value"+xpath+"is not found");
			logReport("Fail", "Element with the xPath value"+xpath+"is not found");
		} catch (ElementNotVisibleException e) {
			//System.err.println("Element with the xPath value"+xpath+"is not visible");
			logReport("Fail", "Element with the xPath value"+xpath+"is not visible");
		} catch (ElementNotInteractableException e) {
			//System.err.println("Element with the xPath value"+xpath+"is not interactable");
			logReport("Fail", "Element with the xPath value"+xpath+"is not interactable");
		} catch (WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}//finally {			takeSnap();		}
	}

	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			//System.out.println("Element with the id value"+id+"is found");
			logReport("Pass", "Element with the id value"+id+"is found");
			
		}catch(NoSuchElementException e) {
			//System.err.println("Element with the id value"+id+"is not found");
			logReport("Fail", "Element with the id value"+id+"is not found");
		}catch (ElementNotVisibleException e) {
			//System.err.println("Element with the id value"+id+"is NOT VISIBLE");
			logReport("Fail", "Element with the id value"+id+"is NOT VISIBLE");
		}catch(ElementClickInterceptedException e) {
			//System.err.println("element click intercepted");
			logReport("Fail", "element click intercepted");
		}catch(ElementNotInteractableException e) {
			System.err.println("Element with the id value"+id+"is not interactable");
			logReport("Fail", "Element with the id value"+id+"is not interactable");
		}catch (WebDriverException e) {
			System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}
		}

	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();// TODO Auto-generated method stub
			//System.out.println("Element with the id value"+classVal+"is found");
			logReport("Pass", "Element with the id value"+classVal+"is found");
		} catch (NoSuchElementException e) {
			//System.err.println("Element with the id value"+classVal+"is not found");
			logReport("Fail", "Element with the id value"+classVal+"is not found");
		} catch (ElementNotVisibleException e) {
			System.err.println("Element with the id value"+classVal+"is not visible ");
			logReport("Fail", "Element with the id value"+classVal+"is not visible ");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("Element click intercepted");
			logReport("Fail", "Element click intercepted");
		} catch (ElementNotInteractableException e) {
			//System.err.println("Element with the id value"+classVal+"is not interactable");
			logReport("Fail", "Element with the id value"+classVal+"is not interactable");
		} catch(WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		} 
		}

	public void clickByName(String name) {
		try {
			driver.findElementByName(name).click();
			//System.out.println("Element with the id value"+name+"is found");
			logReport("Pass", "Element with the id value"+name+"is found");
		} catch (NoSuchElementException e) {
			//System.err.println("Element with the id value"+name+"is not found");
			logReport("Fail", "Element with the id value"+name+"is not found");
		} catch (ElementNotVisibleException e) {
			//System.err.println("Element with the id value"+name+"is not visible");
			logReport("Fail", "Element with the id value"+name+"is not visible");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("Element click intercepted");
			logReport("Fail", "Element click intercepted");
		} catch (ElementNotInteractableException e) {
			//System.err.println("Element with the id value"+name+"is not interactable");
			logReport("Fail", "Element with the id value"+name+"is not interactable");
		} catch (WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}
	}

	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("Element with the value"+name+"is found");
			logReport("Pass","Element with the value"+name+"is found");
		} catch (NoSuchElementException e) {
			//System.err.println("Element with the value"+name+"is not found");
			logReport("Fail", "Element with the value"+name+"is not found");
		} catch (ElementNotVisibleException e) {
			//System.err.println("Element with the value"+name+"is not visible");
			logReport("Fail", "Element with the value"+name+"is not visible");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("Element click intercepted");
			logReport("Fail", "Element click intercepted");
		} catch (ElementNotInteractableException e) {
			//System.err.println("Element with the value"+name+"is not interactable");
			logReport("Fail", "Element with the value"+name+"is not interactable");
		} catch (WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		} 
	}

	public void clickByLinkNoSnap(String name) {
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("Element with the value"+name+"is found");
			logReport("Pass", "Element with the value"+name+"is found");
		} catch (NoSuchElementException e) {
			//System.err.println("Element with the value"+name+"is not found");
			logReport("Fail", "Element with the value"+name+"is not found");
		} catch (ElementNotVisibleException e) {
			//System.err.println("Element with the value"+name+"is not visible");
			logReport("Fail", "Element with the value"+name+"is not visible");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("Element click intercepted");
			logReport("Fail", "Element click intercepted");
		} catch (ElementNotInteractableException e) {
			//System.err.println("Element with the value"+name+"is not interactable");
			logReport("Fail", "Element with the value"+name+"is not interactable");
		} catch (WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}
		
	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("Element with the value"+xpathVal+"is found");
			logReport("Pass","Element with the value"+xpathVal+"is found");
		} catch (NoSuchElementException e) {
			//System.err.println("Element with the value"+xpathVal+"is not found");
			logReport("Fail", "Element with the value"+xpathVal+"is not found");
		} catch (ElementNotVisibleException e) {
			//System.err.println("Element with the value"+xpathVal+"is not visible");
			logReport("Fail","Element with the value"+xpathVal+"is not visible");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("Element click intercepted");
			logReport("Fail", "Element click intercepted");
		} catch (ElementNotInteractableException e) {
			//System.err.println("Element with the value"+xpathVal+"is not interactable");
			logReport("Fail", "Element with the value"+xpathVal+"is not interactable");
		} catch (WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		} 
		
	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("the element with the value"+xpathVal+"is found");
			logReport("Pass", "the element with the value"+xpathVal+"is found");
		} catch (NoSuchElementException e) {
			//System.err.println("the element with the value"+xpathVal+"is not found");
			logReport("Fail", "the element with the value"+xpathVal+"is not found");
		} catch (ElementNotVisibleException e) {
			//System.err.println("the element with the value"+xpathVal+"is not visible");
			logReport("Fail", "the element with the value"+xpathVal+"is not visible");
		} catch (ElementClickInterceptedException e) {
			//System.err.println("Element with the value"+xpathVal+" click intercepted");
			logReport("Fail", "Element with the value"+xpathVal+" click intercepted");
		} catch (ElementNotInteractableException e) {
			//System.err.println("the element with the value"+xpathVal+"is not interactable");
			logReport("Fail", "the element with the value"+xpathVal+"is not interactable");
		} catch (WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		} 
		
	}

	public String getTextById(String idVal) {
		String txt = null;
		try {
			txt = driver.findElementById(idVal).getText();
			//System.out.println(txt);
			logReport("Pass", "the element with the value"+idVal+"is found and the test is"+txt);
		} catch (NoSuchElementException e) {
			//System.err.println("the element with the value"+idVal+"is not found");
			logReport("Fail", "the element with the value"+idVal+"is not found");
		} catch(ElementNotVisibleException e) {
			//System.err.println("the element with the value"+idVal+"is not visible");
			logReport("Fail", "the element with the value"+idVal+"is not visible");
		} catch(ElementNotInteractableException e) {
			//System.err.println("the element with the value"+idVal+"is not interactable");
			logReport("Fail", "the element with the value"+idVal+"is not interactable");
		} catch(WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}
		return txt ;
	}

	public String getTextByXpath(String xpathVal) {
		String txt = null;
		try {
			txt = driver.findElementByXPath(xpathVal).getText();
			//System.out.println(txt);
			logReport("Pass", "the element with the value"+xpathVal+"is found and the text is"+txt);
		} catch (NoSuchElementException e) {
			//System.err.println("the element with the value"+xpathVal+"is not found");
			logReport("Fail", "the element with the value"+xpathVal+"is not found");
		} catch(ElementNotVisibleException e) {
			//System.err.println("the element with the value"+xpathVal+"is not visible");
			logReport("Fail", "the element with the value"+xpathVal+"is not visible");
		} catch(ElementNotInteractableException e) {
			//System.err.println("the element with the value"+xpathVal+"is not interactable");
			logReport("Fail", "the element with the value"+xpathVal+"is not interactable");
		} catch(WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}
		return txt;
	}

	public void selectVisibileTextById(String id, String value) {
		try {
			waitForDropdown("id", id, value);
			WebElement VTId = driver.findElementById(id);
			Select VisTxtId = new Select(VTId);
			VisTxtId.selectByVisibleText(value);
			
			logReport("Pass", "the element with the value"+id+"is found");
			
		} catch (NoSuchElementException e) {
			//System.err.println("the element with the value"+id+"is not found");
			logReport("Fail", "the element with the value"+id+"is not found");
		} catch(ElementNotVisibleException e) {
			//System.err.println("the element with the value"+id+"is notvisible");
			logReport("Fail", "the element with the value"+id+"is notvisible");
		} catch(ElementNotInteractableException e) {
			//System.err.println("the element with the value"+id+"is not interactable");
			logReport("Fail", "the element with the value"+id+"is not interactable");
		} catch(WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}
		
	}
	public void selectVisibleTextByName(String name, String value) {
		try {
			WebElement VisTxtName = driver.findElementByName(name);
			Select VTN = new Select(VisTxtName);
			VTN.selectByVisibleText(value);
			
			logReport("Pass", "The element with name value"+name+"is found");
		} catch (NoSuchElementException e) {
			//System.err.println("The element with name value"+name+"is not found");
			logReport("Fail", "The element with name value"+name+"is not found");
		}catch (ElementNotVisibleException e) {
			//System.err.println("The element with name value"+name+"is not visible");
			logReport("Fail", "The element with name value"+name+"is not visible");
		}catch(ElementNotInteractableException e) {
			//System.err.println("The element with name value"+name+"is not interactable");
			logReport("Fail", "The element with name value"+name+"is not interactable");
		}catch (WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}
	}

	public void selectIndexById(String id, int value) {
		try {
			WebElement VInId = driver.findElementById(id);
			Select VisInId = new Select(VInId);
			VisInId.selectByIndex(value);
			
			logReport("Pass", "the element with the value"+id+"is found");
			
		} catch (NoSuchElementException e) {
			//System.err.println("the element with the value"+id+"is not found");
			logReport("Fail", "the element with the value"+id+"is not found");
		} catch(ElementNotVisibleException e) {
			//System.err.println("the element with the value"+id+"is not visible");
			logReport("Fail", "the element with the value"+id+"is not visible");
		} catch(ElementNotInteractableException e) {
			//System.err.println("the element with the value"+id+"is not interactable");
			logReport("Fail", "the element with the value"+id+"is not interactable");
		} catch(WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}
		
	}
	
	public void selectVisibleTextByXpath(String xPathValue,String value) {
		try {
			WebElement val=driver.findElementByXPath(xPathValue);
			Select VisTxtXP= new Select(val);
			VisTxtXP.selectByVisibleText(value);
			
			logReport("Pass", "The element with xPath value "+xPathValue+"is not found");
		} catch (NoSuchElementException e) {
			System.err.println("The element with xPath value "+xPathValue+"is not found");
			logReport("Fail", "The element with xPath value "+xPathValue+"is not found");
			// TODO Auto-generated catch block
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with xPath value" +xPathValue+ "is not visible");
			logReport("Fail", "The element with xPath value" +xPathValue+ "is not visible");
		} catch(ElementNotInteractableException e) {
			System.err.println("The element with xPath value"+ xPathValue +"is not interactable");
			logReport("Fail", "The element with xPath value"+ xPathValue +"is not interactable");

		} catch(WebDriverException e) {
			System.err.println("The element with xPath value" +xPathValue+"throwing an unknown error");
			logReport("Fail", "The element with xPath value"+ xPathValue +"is not interactable");

		}
	}

	public void switchToParentWindow() {
		try {
			Set<String> id= driver.getWindowHandles();
			for(String i:id) {
				driver.switchTo().window(i);
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void switchToLastWindow() {
		try {
			Set<String> allids = driver.getWindowHandles();
			for (String id : allids) {
				driver.switchTo().window(id);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			
			logReport("Pass", "Alert Accepted");//???
		} catch (NoAlertPresentException e) {
			//System.err.println("No Such Alert");
			logReport("Fail", "No Such Alert");
		} catch(WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}
		}
		
	

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			logReport("Pass", "Alert dismissed");
		} catch (NoAlertPresentException e) {
			//System.err.println("No Such Alert");
			logReport("Fail", "No Such Alert");
		} catch(WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}
		
	}

	public String getAlertText() {
		String txt =null;
		try {
		 txt = driver.switchTo().alert().getText();
		 //System.out.println("The Alert text is"+txt);
		 logReport("Pass", "The Alert text is"+txt);
		} catch (NoAlertPresentException e) {
			//System.err.println("No Alert present");
			logReport("Fail", "No Alert present");
		} catch (WebDriverException e) {
			//System.err.println("The browser got closed due to unknown error");
			logReport("Fail", "The browser got closed due to unknown error");
		}
		return txt;
	}
	public void mouseHover(String xPathValue) {
		
		try {
			WebElement stays = driver.findElementByXPath(xPathValue);
			Actions act = new Actions(driver);
			// Mouse Hover
			act.moveToElement(stays).perform();
			logReport("Pass", "mouseHover successful");
		} catch (NoSuchElementException e) {
			//System.err.println("the element with the value"+xPathValue+"is not found");
			logReport("Fail", "the element with the value"+xPathValue+"is not found");
		} catch (ElementNotVisibleException e){
			//System.err.println("The element with the value"+xPathValue+"is not visible");
			logReport("Fail", "The element with the value"+xPathValue+"is not visible");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The element with value"+xPathValue+"is not interactable");
			logReport("Fail", "The element with value"+xPathValue+"is not interactable");
		}catch(WebDriverException e) {
			//System.err.println("This browser is throwing an unknown error");
			logReport("Fail", "This browser is throwing an unknown error");
		}
	}
	
	public long takeSnap() {
		long snapNumber = System.currentTimeMillis();
		File pic = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/screenshots/image"+snapNumber+".jpg");
		try {
			FileUtils.copyFile(pic, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return snapNumber;
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			logReport("Pass", "closed browser");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logReport("Fail", "browser did not close");
		}
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectValueById(String idValue, String value) {
		WebElement VId=driver.findElementById(idValue);
		Select ValbyId = new Select(VId);
		ValbyId.selectByValue(value);// TODO Auto-generated method stub
		
	}

	public void threadSleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println("Interrupted");
		}// TODO Auto-generated method stub
		
	}

	public void keyboardActionUsingXpath(String xpath, String action) {
		// TODO Auto-generated method stub
		
		try {
			if(action.equalsIgnoreCase("tab")) {
				driver.findElementByXPath(xpath).sendKeys(Keys.TAB);
			}else if(action.equalsIgnoreCase("enter")) {
				driver.findElementByXPath(xpath).sendKeys(Keys.ENTER);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void waitForTextBox(String locType, String locValue) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			if(locType.equalsIgnoreCase("id")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locValue)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void waitForDropdown(String locType, String locValue, String dropdwonValue) {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		if(locType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(By.id(locValue), By.xpath("//option[text()='"+dropdwonValue+"']")));
		}else if(locType.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(By.name(locValue), By.xpath("//option[text()='"+dropdwonValue+"']")));
		}
		
	}

}
