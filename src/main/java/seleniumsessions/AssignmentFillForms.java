package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignmentFillForms {
	
	public static void main(String[] args) {
		
		String browser = "chrome";
		BrowserUtil browserUtil = new BrowserUtil();		
		WebDriver driver = browserUtil.launchBrowser(browser);
		
		browserUtil.launchUrl("https://demo.opencart.com/index.php?route=account/register");
		System.out.println(browserUtil.getPageTitle());
		System.out.println(browserUtil.getPageUrl());

		ElementUtil elementUtil = new ElementUtil(driver);
		
		By ftname = By.id("input-firstname");
		By ltname = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By Password = By.id("input-password");
		By ConfirmPass = By.id("input-confirm");

		elementUtil.doSendKeys(ftname, "margi");
		elementUtil.doSendKeys(ltname, "Pat");
		elementUtil.doSendKeys(email, "margi@test.com");
		elementUtil.doSendKeys(telephone, "0000999900");
		elementUtil.doSendKeys(Password, "1234@Automation");
		elementUtil.doSendKeys(ConfirmPass, "1234@Automation");
	
		browserUtil.quitBrowser();

	}
	
}