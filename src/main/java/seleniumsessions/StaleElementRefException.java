package seleniumsessions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaleElementRefException {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//stale --> not fresh
		//click, refresh, navigation to another page
		//back and forward navigation
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://www.freshworks.com/");
		
		ElementUtil elUtil = new ElementUtil(driver);
		By footer = By.xpath("(//ul[@class='footer-nav'])[1]//a");
		List<WebElement> footerList = elUtil.getElements(footer);
		
		for(int i = 0; i<footerList.size(); i++) {
			footerList.get(i).click();
			footerList = elUtil.getElements(footer);
		}
		
		
	}

}
