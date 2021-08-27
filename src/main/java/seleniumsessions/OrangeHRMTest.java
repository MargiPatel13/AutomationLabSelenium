package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMTest {

	public static void main(String[] args) {
		//TODO  to use BrowserUtil and ElementUtil
		
		String browser = "chrome";

		BrowserUtil browserUtil = new BrowserUtil();		
		WebDriver driver = browserUtil.launchBrowser(browser);
		browserUtil.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		System.out.println(browserUtil.getPageTitle());
		System.out.println(browserUtil.getPageUrl());

		ElementUtil elementUtil = new ElementUtil(driver);
		
		By ftname = By.id("Form_submitForm_FirstName");
		By ltname = By.id("Form_submitForm_LastName");
		By email = By.id("Form_submitForm_Email");
		By jobTitle = By.id("Form_submitForm_JobTitle");
		By company = By.id("Form_submitForm_CompanyName");
		By phoneNumber = By.id("Form_submitForm_Contact");
	
		
		elementUtil.doSendKeys(ftname, "margi");
		elementUtil.doSendKeys(ltname, "Patel");
		elementUtil.doSendKeys(email, "margi@test.com");
		elementUtil.doSendKeys(jobTitle, "QA");
		elementUtil.doSendKeys(company, "Google");
		elementUtil.doSendKeys(phoneNumber, "6000000000");

		browserUtil.quitBrowser();

	}

}
