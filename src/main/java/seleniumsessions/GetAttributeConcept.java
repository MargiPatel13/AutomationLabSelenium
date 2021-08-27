package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//WebElement + get Attribute ("attr name") --> String

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By login = By.linkText("Login");
//		String herfVal = driver.findElement(login).getAttribute("href");
//		System.out.println(herfVal);
		if(doGetAttribute(login, "href").contains("/login")) {
			System.out.println("login link is having correct attr value");
		}
		
		By search = By.name("search");
		String phvalue = doGetAttribute(search, "placeholder");
		System.out.println(phvalue);
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String doGetAttribute(By locator, String attrName){
		return getElement(locator).getAttribute(attrName);
	}
}
