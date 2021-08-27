package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuggestionListUsingXpath {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {

			BrowserUtil brUtil = new BrowserUtil();
			driver = brUtil.launchBrowser("chrome");

			brUtil.launchUrl("http://automationpractice.com/index.php/");
			ElementUtil elUtil = new ElementUtil(driver);
			
			By search = By.name("search_query");
			WebElement searchText = elUtil.getElement(search);
			searchText.sendKeys("dress");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='ac_results']//li[text()='Casual Dresses > Printed ']")).click();
			
	}

}
