package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsSendKeysAndClick {
	static WebDriver driver;

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		
		ElementUtil elUtil = new ElementUtil(driver);
		
		By email = By.id("input-email");
		By pass = By.id("input-password");
		By login = By.xpath("//input[@value='Login']");
		
//		WebElement userEmail = elUtil.getElement(email);
//		WebElement password = elUtil.getElement(pass);
//		WebElement userLogin = elUtil.getElement(login);
//	
//		Actions actions = new Actions(driver); 
//		actions.sendKeys(userEmail, "naveenanimation20@gmail.com").perform();
//		actions.sendKeys(password, "Selenium12345").perform();
//		actions.click(userLogin).perform();
		
		doActionsSendKeys(email, "naveenanimation20@gmail.com");
		doActionsSendKeys(pass, "Selenium12345");
		doActionsClick(login);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions actions = new Actions(driver);
		actions.sendKeys(getElement(locator), value).perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions actions = new Actions(driver);
		actions.click(getElement(locator)).perform();
	}
}
