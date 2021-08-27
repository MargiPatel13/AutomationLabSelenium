package seleniumsessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignWindondowHandles {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://opensource-demo.orangehrmlive.com/"); 		// parent window
		ElementUtil elUtil = new ElementUtil(driver);
		
		//case 1: open all the child window and switch to one from another child window
		
//		elUtil.doClick(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")); 	//child window -- LinkedIn page
//		elUtil.doClick(By.xpath("//img[@alt='OrangeHRM on Facebook']")); 		//child window -- FB page
//		elUtil.doClick(By.xpath("//img[@alt='OrangeHRM on twitter']")); 		//child window -- twitter page
//		elUtil.doClick(By.xpath("//img[@alt='OrangeHRM on youtube']")); 		//child window -- youTube page
//		
//		Set<String> winSet = driver.getWindowHandles();
//		Iterator<String> iterator = winSet.iterator();	//1
//		//List<String> handlesList = new ArrayList<String>(winSet); //2
//
//		String mainWindow =	iterator.next();
//		String linkedInWindow =	iterator.next();
//		String facebookWindow =	iterator.next();
//		String twitterWindow = iterator.next();
//		String youtubeWindow = iterator.next();
//		
//		System.out.println(mainWindow);
//		
//		driver.switchTo().window(linkedInWindow);
//		System.out.println(linkedInWindow);
//		driver.close();
//		
//		driver.switchTo().window(facebookWindow);
//		System.out.println(facebookWindow);
//		driver.close();
//
//		driver.switchTo().window(twitterWindow);
//		System.out.println(twitterWindow);
//		driver.close();
//
//		driver.switchTo().window(youtubeWindow);
//		System.out.println(youtubeWindow);
//		driver.close();
//
//		driver.switchTo().window(mainWindow);
//		System.out.println(mainWindow);
		
		//case 2: open one child window and switch to it from parent window - repeat
		elUtil.doClick(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")); 	//child window -- LinkedIn page

		Set<String> set = driver.getWindowHandles();
		Iterator<String> iterator = set.iterator();	
		String mainWindow =	iterator.next();
		String linkedInWindow =	iterator.next();

		driver.switchTo().window(linkedInWindow);
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(mainWindow);
	
		elUtil.doClick(By.xpath("//img[@alt='OrangeHRM on Facebook']")); //child window -- FB page
		set = driver.getWindowHandles();
		iterator = set.iterator();	
		mainWindow =	iterator.next();
		String facebookWindow =	iterator.next();
		
		driver.switchTo().window(facebookWindow);
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(mainWindow);

		elUtil.doClick(By.xpath("//img[@alt='OrangeHRM on twitter']")); 		//child window -- twitter page
		set = driver.getWindowHandles();
		iterator = set.iterator();	
		mainWindow = iterator.next();
		String twitterWindow = iterator.next();
		
		driver.switchTo().window(twitterWindow);
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(mainWindow);
		

		elUtil.doClick(By.xpath("//img[@alt='OrangeHRM on youtube']")); 		//child window -- youTube page
		set = driver.getWindowHandles();
		iterator = set.iterator();	
		mainWindow = iterator.next();
		String youtubeWindow = iterator.next();
		
		driver.switchTo().window(youtubeWindow);
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(mainWindow);
		driver.quit();
	}

}
