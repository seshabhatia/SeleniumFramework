package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitProperties {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//button[text()='Ok']").click();
		
		//driver.findElementByXPath("//a[text()=' REGISTER ']").click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// text boxes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		
		driver.findElementById("userName").sendKeys("HarryPorter123");
		
		
	}
	
}
