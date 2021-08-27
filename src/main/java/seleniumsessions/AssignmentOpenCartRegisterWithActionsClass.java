package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignmentOpenCartRegisterWithActionsClass {

		static WebDriver driver;

		public static void main(String[] args) {
			
			BrowserUtil brUtil = new BrowserUtil();
			driver = brUtil.launchBrowser("chrome");
			brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/register");
			
			ElementUtil elUtil = new ElementUtil(driver);
			
			By fname = By.id("input-firstname");
			By lname = By.id("input-lastname");
			By email = By.id("input-email");
			By telephone = By.id("input-telephone");
			By pass = By.id("input-password");
			By confirmPass = By.id("input-confirm");
			By privacyCheck = By.name("agree");
			By submit = By.xpath("//input[@value='Continue']");
						
			elUtil.doActionsSendKeys(fname, "Margi");
			elUtil.doActionsSendKeys(lname, "Patel");
			elUtil.doActionsSendKeys(email, "margi.patel013@gmail.com");
			elUtil.doActionsSendKeys(telephone, "6476476476");

			elUtil.doActionsSendKeys(pass, "Selenium12345");
			elUtil.doActionsSendKeys(confirmPass, "Selenium12345");
			
			elUtil.doActionsClick(privacyCheck);
			elUtil.doActionsClick(submit);

			By accountCreated = By.xpath("//div[@id='content']/h1");

			String confirmationText = elUtil.doGetText(accountCreated);
			
			if(confirmationText.equals("Your Account Has Been Created!")) {
				System.out.println("\"Your Account Has Been Created\" Test Passed");
			}else {
				System.out.println("\"Your Account Has Been Created\" Test Failed");

			}
			
	}

}
