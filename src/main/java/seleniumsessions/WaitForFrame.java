package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame {
	static WebDriver driver;

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://classic.crmpro.com/");
		
		ElementUtil elUtil = new ElementUtil(driver);
		
		By uname = By.name("username");
		By pass = By.name("password");
		By login = By.xpath("//input[@value='Login']");
		
		elUtil.doSendKeys(uname, "groupautomation");
		elUtil.doSendKeys(pass, "Test@12345");
		elUtil.doClick(login);
		
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainpanel"));
		
		waitForFrameAndSwitchToIt("mainpanel", 5);
		
		By contact = By.linkText("CONTACTS");
		elUtil.doClick(contact);
	}
	
	public static void waitForFrameAndSwitchToIt(String frameName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
	}
	
	public static void waitForFrameAndSwitchToIt(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public static void waitForFrameAndSwitchToIt(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	public static void waitForFrameAndSwitchToIt(WebElement webElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
	}
	

}
