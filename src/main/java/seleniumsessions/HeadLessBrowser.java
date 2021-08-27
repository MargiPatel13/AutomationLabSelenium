package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {
		
		//headless - no browser
		//testing is hidden
		//its faster - since no browser are getting open
		//can take screeenshot using headless
		
		//we don't know where is driver currently working or any element is visible on DOM
		//move to element, visible elements, frame, alerts any js pop-up we can't perform
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		co.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://facebook.com");
		
//		WebDriverManager.firefoxdriver().setup();
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--headless");
		//co.addArguments("--incognito");
//		WebDriver driver = new FirefoxDriver(fo);
//		driver.get("https://facebook.com");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();
		

		
	}

}
