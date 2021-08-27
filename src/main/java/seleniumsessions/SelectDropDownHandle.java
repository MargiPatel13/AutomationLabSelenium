package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandle {
	static WebDriver driver;

	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		driver= br.launchBrowser("chrome");
		
		br.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		ElementUtil elUtil = new ElementUtil(driver);
		
		By indust = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		
		WebElement indusEle = elUtil.getElement(indust); 		//driver.findElement(indust);
		WebElement countryEle = elUtil.getElement(country); 	//driver.findElement(country);
		
//		Select selectdrp = new Select(indusEle);
//		//selectdrp.selectByIndex(1);
//		//selectdrp.selectByValue("Aerospace");
//		selectdrp.selectByVisibleText("Aerospace");
//		Select selectCountry = new Select(countryEle);
//		selectCountry.selectByValue("India");
		
//		doSelectByVisibleText(indust, "Aerospace");
//		doSelectByVisibleText(country, "India");
		
//		doSelectByValue(country, "India");
//		doSelectByValue(indust, "Aerospace");
		
//		doSelectByIndex(country, 3);
//		doSelectByIndex(indust, 5);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doSelectByVisibleText(By locator, String text) {
		Select selectCountry = new Select(getElement(locator));
		selectCountry.selectByVisibleText(text);
	}
	
	public static void doSelectByValue(By locator, String text) {
		Select selectCountry = new Select(getElement(locator));
		selectCountry.selectByValue(text);
	}
	
	public static void doSelectByIndex(By locator, int index) {
		Select selectCountry = new Select(getElement(locator));
		selectCountry.selectByIndex(index);
	}
}
