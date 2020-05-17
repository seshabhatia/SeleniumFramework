package utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtables {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://erail.in/");
		
		driver.findElementById("buttonFromTo").click();
		
		Thread.sleep(5000);
		
		List<WebElement> loc = driver.findElementsByXPath("//*[@id=\"divTrainsList\"]/table/tbody/tr/td[2]");
		
		for (WebElement webElement : loc) {
			
			String text = webElement.getText();
			System.out.println(text);
			
		}
		
		
	}

}
