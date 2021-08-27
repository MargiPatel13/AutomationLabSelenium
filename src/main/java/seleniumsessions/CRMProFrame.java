package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CRMProFrame {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			
			BrowserUtil brUtil = new BrowserUtil();
			driver = brUtil.launchBrowser("chrome");
			brUtil.launchUrl("https://classic.crmpro.com/");
			
			ElementUtil elUtil = new ElementUtil(driver);
			
			By uname = By.name("username");
			By pass = By.name("password");
			By login = By.xpath("//input[@value='Login']");
			
			elUtil.doSendKeys(uname, "groupautomation");
			elUtil.doSendKeys(pass, "Test@12345");
			elUtil.doClick(login);
			
			Thread.sleep(3000);
			driver.switchTo().frame("mainpanel");
			
			Actions actions = new Actions(driver); 
			
			By contacts = By.linkText("CONTACTS"); 
			WebElement contactElement = elUtil.getElement(contacts);
			
			actions.moveToElement(contactElement).perform();		
			Thread.sleep(2000);
			
			By newContact = By.linkText("New Contact"); 
			WebElement newContactElement = elUtil.getElement(newContact);
			newContactElement.click();
			
			By firstName = By.id("first_name"); 
			elUtil.doSendKeys(firstName, "Margi");		
			By middleName = By.id("middle_initial"); 
			elUtil.doSendKeys(middleName, "M");
			By lastName = By.id("surname"); 
			elUtil.doSendKeys(lastName, "Patel");
			
			By savebtn = By.xpath("//input[@value='Save']"); 
			elUtil.doClick(savebtn);
			

	}

}
