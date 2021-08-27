package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Pagination {

	static WebDriver driver;

	public static void main(String[] args) {
		
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
		
		elUtil.waitForFrameAndSwitchToIt("mainpanel", 3);
		
		By contacts = By.linkText("CONTACTS"); 
	 	elUtil.doClick(contacts);
	 	
	 	By byPagination = By.xpath("(//div[@class='pagination'])[1]/a");
	 	List<WebElement> pages = elUtil.getElements(byPagination);
	 		 	
//	 	int i=0;
//	 	while(true) {
//	 		String contactName = "Mythili Panyam";
//		 	if(elUtil.getElements(By.linkText(contactName)).size() > 0) {   //if more than one same name is available still condition will be true.
//		 		selectContact(contactName);		//if the same name available more than once, then it will select the first one.
//		 		break;
//		 	}
//		 	else { //pagination logic
//		 		try {
//		 			pages.get(i).click();
//		 		} 
//		 		catch(Exception e) {
//		 			e.printStackTrace();
//		 			System.out.println("Sorry, We couldn't find any contact with that name");
//		 			break;
//		 		}
//		 		pages = elUtil.getElements(byPagination);
//		 	}
//			i++;
//	 	}

	}
	
	public static void selectContact(String name) {
		By checkBox = By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td/input[@type='checkbox']");
		driver.findElement(checkBox).click();
	}

}
