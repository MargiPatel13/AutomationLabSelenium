package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssignmentFillFormsUsingStringLocator {
	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/register");

		ElementUtil elUtil = new ElementUtil(driver);
		
		String fName = "input-firstname";
		String lName = "input-lastname";
		String email = "input-email";
		String telephone = "input-telephone";
		String password = "input-password";
		String confirmPass = "input-confirm";
		
		WebElement firstName = elUtil.getElement("id", fName);
		WebElement lastName = elUtil.getElement("id", lName);
		WebElement emailId = elUtil.getElement("id", email);
		WebElement phone = elUtil.getElement("id", telephone);
		WebElement pass = elUtil.getElement("id", password);
		WebElement cPass = elUtil.getElement("id", confirmPass);
		
		//firstName.sendKeys("Margi");
		elUtil.doSendKeys(firstName, "Margi");
		elUtil.doSendKeys(lastName, "Patel");
		elUtil.doSendKeys(emailId, "margi@test.com");
		elUtil.doSendKeys(phone, "9000054000");
		elUtil.doSendKeys(pass, "dsfsdfsdf");
		elUtil.doSendKeys(cPass, "sdfsdfsdfds");

	}

}
