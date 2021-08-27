package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class implicitlyWait {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		br.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		ElementUtil elUtil = new ElementUtil(driver);
		By email_id = By.id("input-email");
		By password = By.id("input-password");
		By login = 	By.xpath("//input[@value='Login']");
		
		elUtil.doSendKeys(email_id, "mp@test.com");
		elUtil.doSendKeys(password, "mp@123");
		elUtil.doClick(login);

	}
}
