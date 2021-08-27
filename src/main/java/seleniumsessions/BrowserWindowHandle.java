package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowHandle {

	static WebDriver driver;

	public static void main(String[] args) {
					//browser window popup/new tab window/new browser window
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://opensource-demo.orangehrmlive.com/"); 		// parent window
		ElementUtil elUtil = new ElementUtil(driver);
		
		elUtil.doClick(By.xpath("//img[@alt='OrangeHRM on twitter']")); 		//child window -- twitter page
		
		Set<String> sethandles = driver.getWindowHandles();
		Iterator<String> it = sethandles.iterator();
		
		String parentWindowID = it.next();
		System.out.println("parent window id is : " + parentWindowID);
		
		String childWindowId = it.next();
		System.out.println("child window id is : " + childWindowId);
		
		//switching: to child window
		driver.switchTo().window(childWindowId);
		System.out.println("child window url : " + driver.getCurrentUrl());
		
		driver.close();		//close the child window
		
		//switching: to parent window
		driver.switchTo().window(parentWindowID);
		System.out.println("parent window url : " + driver.getCurrentUrl());
	}

}
