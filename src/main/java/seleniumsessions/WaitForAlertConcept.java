package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlertConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://mail.rediff.com/cgi-bin/login.cgi");
		
		ElementUtil elUtil = new ElementUtil(driver);
		
		elUtil.doClick(By.name("proceed"));
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println(alert.getText());
//		alert.accept();
	
		//waitForAlert(5).accept();
//		Alert a = waitForAlert(5);
//		a.getText();
//		a.accept();
		
		waitForAlert(5);
		System.out.println(getAlertText(5));
		acceptAlert(5);
		

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
	
	public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);	
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}
	
	public static void acceptAlert(int timeOut) {
		 waitForAlert(timeOut).accept();
	}
	
	public static void dismissAlert(int timeOut) {
		 waitForAlert(timeOut).accept();
	}
	
	public static void sendkeysOnAlert(int timeOut, String value) {
		 waitForAlert(timeOut).sendKeys(value);
	}
}
