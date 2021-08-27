package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIsDisplayedIsEnabled {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//WebElement + isDisplayed() --> boolean(true/false)

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
//		boolean flag = driver.findElement(By.name("search")).isDisplayed();
//		System.out.println(flag);
		By searchField = By.name("search");
		By searchButton = By.xpath("//*[@id=\"search\"]/span/button");
		
//		if(doIsDisplayed(searchField)) {
//			doSendKeys(searchField, "macBook");
//			doClick(searchButton);
//		}
		
//		boolean searchIsEnable = driver.findElement(By.name("search")).isEnabled();
//		System.out.println(searchIsEnable);
		System.out.println(doIsEnabled(searchField));
//		if(doIsEnabled(searchField)) {
//			doSendKeys(searchField, "apple");
//			doClick(searchButton);
//		}
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}	
	
	public static void doClick(By locator){
		getElement(locator).click();
	}
	
	public static String doGetText(By locator){
		return getElement(locator).getText();
	}
	
	public static String doGetAttribute(By locator, String attrName){
		return getElement(locator).getAttribute(attrName);
	}
	
	public static boolean doIsDisplayed(By locator){
		return getElement(locator).isDisplayed();
	}
	
	public static boolean doIsEnabled(By locator){
		return getElement(locator).isEnabled();
	}
	
}