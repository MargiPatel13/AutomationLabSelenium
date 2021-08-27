package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssignmentSuggestionList {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");

		//brUtil.launchUrl("http://automationpractice.com/index.php/");
		brUtil.launchUrl("https://www.google.com/");

		ElementUtil elUtil = new ElementUtil(driver);
		
		//Assignment suggestion list 
//		By search = By.name("search_query");
//		WebElement searchText = elUtil.getElement(search);
//		searchText.sendKeys("dress");
//		
//		Thread.sleep(2000);
//		
//		By searchList = By.xpath("//div[@class='ac_results']//li");
//		List<WebElement> suggestionList = elUtil.getElements(searchList);
//		
//		for(WebElement e : suggestionList) {
//			String text = e.getText();
//			System.out.println(text);
//			
//			if(text.equals("Casual Dresses > Printed Dress")) {
//				e.click();
//				break;
//			} 
//		}
		
		
		//Assignment suggestion list using direct xpath for specific option click: google
	
		By search = By.name("q");
		WebElement searchText = elUtil.getElement(search);
		searchText.sendKeys("Naveen AutomationLabs");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']//span/b[text()=' youtube']")).click();

		
		
		
}

}
