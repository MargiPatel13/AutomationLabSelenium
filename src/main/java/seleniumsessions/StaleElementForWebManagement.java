package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaleElementForWebManagement {
static WebDriver driver;
	
	public static void main(String[] args) {
		
		//stale --> not fresh
		//click, refresh, navigation to another page
		//back and forward navigation
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		ElementUtil elUtil = new ElementUtil(driver);
		
		By email = By.id("input-email");
		WebElement email_ele = elUtil.getElement(email);
		email_ele.sendKeys("amdavad@gm.com");

		driver.navigate().refresh();
		
		email = By.id("input-email");
		email_ele.sendKeys("amdavad@gm.com");
		
		
	}

}
