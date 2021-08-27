package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("http://mrbool.com/");
		
		ElementUtil elUtil = new ElementUtil(driver);
		
		By menulink = By.className("menulink");
//		WebElement contentMenu = elUtil.getElement(menulink);
//		Actions action = new Actions(driver);
//		action.moveToElement(contentMenu).perform();
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.linkText("COURSES")).click();
		
		By subMenuLink = By.linkText("COURSES");
		doTwoLevelMenuHandle(menulink, subMenuLink);
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doTwoLevelMenuHandle(By superMenu, By subMenu) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(superMenu)).perform();
		Thread.sleep(2000);
		getElement(subMenu).click();
	}
	
	public static void doThreeLevelMenuHandle(By superMenu1, By superMenu2, By subMenu) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(superMenu1)).perform();
		Thread.sleep(2000);
		action.moveToElement(getElement(superMenu2)).perform();
		Thread.sleep(2000);
		getElement(subMenu).click();
	}

}
