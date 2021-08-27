package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xpath_axes {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://classic.crmpro.com/");
		ElementUtil elUtil = new ElementUtil(driver);
		
		By uname = By.name("username");
		elUtil.doSendKeys(uname, "groupautomation");
		By pass = By.name("password");
		elUtil.doSendKeys(pass, "Test@12345");
		By login = By.xpath("//input[@value='Login']");
		elUtil.doClick(login);
		
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
				
		By contacts = By.linkText("CONTACTS"); 
		elUtil.doClick(contacts);
		
		//selectContact("Aastha Grover");
		//selectContact("Alex Wonder");
		
		//String companyName = getCompanyName("Aastha Grover");
	//	System.out.println(companyName);
		
//		System.out.println(getPhone("Aastha Grover"));
//		System.out.println(getHomePhone("Aastha Grover"));
//		System.out.println(getMobileNo("Aastha Grover"));
//		System.out.println(getEmail("Aastha Grover"));
		
	//Assignment 1: company, phone, homePhone, mobile, email - single function and return a list<> - getContactDetails
		//1.	
		//System.out.println(getContactDetails("Aastha Grover"));

		//2.
//		List<String> contactLists = getContactDetails("Akashay patil");
//		if(!contactLists.isEmpty()) {
//			System.out.println(contactLists);
//		}else {
//			System.out.println("no contact details found");
//		}
		
		//3.
		//getContactDetails("Aastha Grover");
		//getContactDetails("Akashay patil");

		//Assignment 2: Bowling Score list for bhuvneshwar Kumar- single function and return a list<> - getBowlingScoreDetails - cricInfo.com

		//Assignment 3:  click on all the checkbox in contact table -  CRMPRO(capture one common attribute) than start forloop and .click()
			//input[@name='contact_id']//parent::td//following-sibling ::input
			//input[@name='contact_id']/parent::td/parent::tr/following-sibling::tr/td/input
//		By checkBox = By.xpath("//input[@name='contact_id']//parent::td//following-sibling ::input");
//		List<WebElement> clickCheckBox = driver.findElements(checkBox);
//		for( int j = 0; j<clickCheckBox.size(); j++) {
//			clickCheckBox.get(j).click();
//		}
		selectAllContacts();
		
	}
	
	public static void selectContact(String name) {
		By checkBox = By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td/input[@type='checkbox']");
		driver.findElement(checkBox).click();
	}
	public static void selectAllContacts() {
		By checkBox = By.xpath("//input[@name='contact_id']//parent::td//following-sibling ::input");
		List<WebElement> clickCheckBox = driver.findElements(checkBox);
		for( int j=0; j<clickCheckBox.size(); j++) {
			clickCheckBox.get(j).click();
		}
	}
	
	public static String getCompanyName(String name) {
		By companyName = By.xpath("//a[text()='"+name+"']//parent::td//following-sibling::td/a[@context='company']");
		return driver.findElement(companyName).getText();
	}
	
	public static String getPhone(String name) {
		 By phone = By.xpath("(//a[text()='"+name+"']//parent::td//following-sibling::td/span[@context='phone'])[1]");
		 return	 driver.findElement(phone).getText();	
	}
	
	public static String getHomePhone(String name) {
		 By homePhone = By.xpath("(//a[text()='"+name+"']//parent::td//following-sibling::td/span[@context='phone'])[2]");
		 return driver.findElement(homePhone).getText();
	}
	public static String getMobileNo(String name) {
		 By mobile = By.xpath("(//a[text()='"+name+"']//parent::td//following-sibling::td/span[@context='phone'])[3]");
		 return	 driver.findElement(mobile).getText();	
	}
	public static String getEmail(String name) {
		 By email = By.xpath("//a[text()='"+name+"']//parent::td//following-sibling::td/a[contains(@href,'mailto')]");
		 return	 driver.findElement(email).getText();	
	}
	
	public static List<String> getContactDetails(String name) {
		By contact = By.xpath("//a[text()='"+name+"']//parent::td//following-sibling::td");
		List<WebElement> contactDetails = driver.findElements(contact);
		 
		List<String> contactDetailsList = new ArrayList<String>();
		
		for(int i=0; i<contactDetails.size(); i++) {
			if(i<=4) {
			String text = contactDetails.get(i).getText();
				contactDetailsList.add(text);
			}
		}
		if(!contactDetailsList.isEmpty()) {
			System.out.println(contactDetailsList);
		}else {
			System.out.println("no contact details found");
		}
		return contactDetailsList;	 
	}
}
