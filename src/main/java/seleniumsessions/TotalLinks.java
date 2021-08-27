package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.ca/");
		// get the count of all the links -- <a> 
		// print the text of each link(ignore blank Space)

		//List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		
		By links = By.tagName("a");
		List<WebElement> listOfLinks = getElements(links);
		
		System.out.println("total links: " + listOfLinks.size());

//		for (int i = 0; i < listOfLinks.size(); i++) {
//			String text = listOfLinks.get(i).getText();
//
//			if (!text.isEmpty()) {
//				System.out.println(i + ", " + text);
//			}
//		}
		//Assignment : print index for foreach. count = 0;
		int count = 0;
		for( WebElement e : listOfLinks ) {
			String linksText = e.getText();
			if (!linksText.isEmpty()) {
				System.out.println(count + ", " + linksText);
			}
			count++;
		}
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
