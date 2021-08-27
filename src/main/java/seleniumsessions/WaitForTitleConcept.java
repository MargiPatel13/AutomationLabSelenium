package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://mail.rediff.com/cgi-bin/login.cgi");
		
		ElementUtil elUtil = new ElementUtil(driver);
				
		//title 
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		if(wait.until(ExpectedConditions.titleIs("Rediffmail"))) {
//			System.out.println(driver.getTitle()+" correct title");
//		}
		
		String title = waitForTitleContains("Rediffmail", 5);
		 System.out.println(title);
		
		 String titleis =waitForTitleIs("Rediffmail", 5);
		 System.out.println(titleis);
	}
	
	public static String waitForTitleContains(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleContains(titleValue))) {
			return driver.getTitle();
		}
		return null;
	}
	
	public static String waitForTitleIs(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleIs(titleValue))) {
			return driver.getTitle();
		}
		return null;
	}

}
