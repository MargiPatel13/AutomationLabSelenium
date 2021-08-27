package seleniumsessions;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		ElementUtil elUtil = new ElementUtil(driver);

		By email_id = By.id("input-email");
		By password = By.id("input-password");
		By login = By.xpath("//input[@value='Login']");

//		Wait<WebDriver> waitF = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofMillis(2000))
//				.ignoring(Exception.class);
//
//		 waitF.until(ExpectedConditions.presenceOfElementLocated(email_id)).sendKeys("m@gm.com");
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.withTimeout(Duration.ofSeconds(10))
//			.pollingEvery(Duration.ofMillis(2000))
//			.ignoring(NoSuchElementException.class);
//	
//		wait.until(ExpectedConditions.presenceOfElementLocated(password)).sendKeys("mssdcom");
		
		waitForElementWithFluentWait(email_id, 10, 2000).sendKeys("m@m.com");
		waitForElementWithFluentWait(password, 5, 1000).sendKeys("asesvrewbfre");

	}
	
	public static WebElement waitForElementWithFluentWait(By locator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static  WebDriver waitForFrameWithFluentWait(By locator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
}