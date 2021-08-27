package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyElementIsPresent {
	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/login");

		By forgotPwd = By.linkText("Forgotten Password");
		if (isElementExist(forgotPwd)) {
			System.out.println("Pass");
		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static boolean isElementExist(By locator) {
		List<WebElement> listElement = getElements(locator);

		if (listElement.size() > 0) {
			System.out.println("element is present");
			return true;
		}
		return false;
	}

}
