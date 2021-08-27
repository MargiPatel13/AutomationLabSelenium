package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		//ebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		//driver = new ChromeDriver();

		
		String browser = "chrome";
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("please pass the correct browser....");
		}
		

		driver.get("http://www.amazon.com");
		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		driver.quit();		
	}

}
