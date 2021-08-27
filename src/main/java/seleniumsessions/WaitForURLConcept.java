package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForURLConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		ElementUtil elUtil = new ElementUtil(driver);
		
		By registerUrl = By.linkText("Register");
		elUtil.getElement(registerUrl).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		if(wait.until(ExpectedConditions.urlContains("/register"))) {
//			System.out.println(driver.getCurrentUrl());
//		}
		
		//System.out.println(waitForUrlContains("/register", 5));
		//waitForUrlToBe("/register", 5);
		
		System.out.println(waitForUrlMatches("reg", 5));
	}
	
	public static String waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	public static String waitForUrlToBe(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.urlToBe(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	public static String waitForUrlMatches(String urlRegEx, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.urlMatches(urlRegEx))) {
			return driver.getCurrentUrl();
		}
		return null;
	}

}
