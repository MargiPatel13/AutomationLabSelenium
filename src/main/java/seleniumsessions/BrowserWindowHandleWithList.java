package seleniumsessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleWithList {
	static WebDriver driver;

	public static void main(String[] args) {
		//browser window popup/new tab window/new browser window

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://opensource-demo.orangehrmlive.com/"); 		// parent window
		ElementUtil elUtil = new ElementUtil(driver);
		
		elUtil.doClick(By.xpath("//img[@alt='OrangeHRM on twitter']")); 		//child window -- twitter page

		Set<String> handles = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>(handles);

		String parentWindowID = handlesList.get(0); //because arrayList always maintain the order
		String childWidnowID = handlesList.get(1);

		driver.switchTo().window(childWidnowID);
		System.out.println("child window url : " + driver.getCurrentUrl());

		//driver.close();// close the child window

		driver.switchTo().window(parentWindowID);
		System.out.println("parent window url : " + driver.getCurrentUrl());
		
		//Assignment: 

	}

}
