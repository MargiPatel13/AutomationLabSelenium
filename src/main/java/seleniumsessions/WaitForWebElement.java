package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWebElement {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		ElementUtil elUtil = new ElementUtil(driver);
		
		By email_id = By.id("input-email");
		By password = By.id("input-password");
		By login = 	By.xpath("//input[@value='Login']");

		By navigationBar = By.cssSelector("aside#column-right a");
		By Newsletter = By.linkText("Newsletter");
		
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		WebElement emailEle = wait.until(ExpectedConditions.visibilityOfElementLocated(email_id));
		
		//waitForElementVisible(email_id, 5);
//		elUtil.doSendKeys(email_id, "mp@test.com");
//		elUtil.doSendKeys(password,"mp@123");

//		waitForElementsToBeVisible(login, 5);
//		elUtil.doClick(login);
		
		List<WebElement> navigationLinks = waitForElementsToBeVisible(navigationBar, 6);
		for(WebElement e : navigationLinks) {
			System.out.println(e.getText());
		}
		
		if(getElementsTextList(navigationBar, 9).contains("Newsletter")) {
			System.out.println("Test Passed");
		}
		
		clickWhenReady(Newsletter, 5);
		
		
	}
	
	public static WebElement getElement(By locator) {
		return	driver.findElement(locator);
	}
	
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement waitForElementVisibleUsingWebElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	
	public static List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static List<String> getElementsTextList(By locator, int timeOut) {
		List<WebElement> list = waitForElementsToBeVisible(locator, timeOut);
		List<String> textList = new ArrayList<String>();
		for(WebElement e : list) {
			textList.add(e.getText());
		}
		return textList;
	}
	
	public static void waitForTheElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void clickWhenReady(By locator, int timeOut) {
		waitForTheElementToBeClickable(locator, timeOut);
	}
	
}
