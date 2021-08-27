package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchSuggestion {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {

			BrowserUtil brUtil = new BrowserUtil();
			driver = brUtil.launchBrowser("chrome");

			brUtil.launchUrl("https://www.google.com/");
			
			ElementUtil elUtil = new ElementUtil(driver);
			
			By search = By.name("q");
			WebElement searchText = elUtil.getElement(search);
			searchText.sendKeys("Naveen AutomationLabs");
			
			Thread.sleep(2000);
			By searchSuggList = By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']//span");
			List<WebElement> suggestionList = elUtil.getElements(searchSuggList);
			
			for(WebElement e : suggestionList) {
				String text = e.getText();
				System.out.println(text);
				
				if(text.equals("naveen automationlabs resume")) {
					e.click();
					break;
				} 
			}
			
	}

}
