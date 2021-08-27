package seleniumsessions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitConcept {
static WebDriver driver;
	
	public static void main(String[] args) {
		
//		1. Implicitly wait 
//		2. Explicitly wait ----> WebDriverWait (class) ---→ FLuentWait (class) ---→ Wait(Interface)
	
		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		br.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		ElementUtil elUtil= new ElementUtil(driver);

		By email_id = By.id("input-email");
		By password = By.id("input-password");
		By login = 	By.xpath("//input[@value='Login']");
	
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(email_id));
//		elUtil.doSendKeys(email_id, "mp@test.com");
	
		//waitForElementPresence(email_id, 5, 2000);
		waitForElementPresence(email_id, 5);
		elUtil.doSendKeys(email_id, "mp@test.com");

		elUtil.doSendKeys(password,"mp@123");
		elUtil.doClick(login);
		
	}
	
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementPresence(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, intervalTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
}
