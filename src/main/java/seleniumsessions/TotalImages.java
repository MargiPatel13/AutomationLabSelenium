package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.ca/");
		
		By images = By.tagName("img");
		List<WebElement> imgList = getElements(images);
		
		System.out.println(imgList.size());
		
		for (int i = 0; i<imgList.size(); i++) {
			String alt = imgList.get(i).getAttribute("alt");
			String src = imgList.get(i).getAttribute("src");
			System.out.println(alt + " --> " + src);
		}
		
		for(WebElement e: imgList ) {
			String alt = e.getAttribute("alt");
			String src = e.getAttribute("src");
			System.out.println(alt + " --> " + src);
		}
		
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}
