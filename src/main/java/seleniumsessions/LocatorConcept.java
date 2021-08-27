package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	static WebDriver driver;
	
	public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	//driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
	driver.get("https://www.orangehrm.com");

//1. id
	//1. basic
	//driver.findElement(By.id("Form_submitForm_FirstName")).sendKeys("Margi");
	//driver.findElement(By.id("Form_submitForm_LastName")).sendKeys("patel");
	
	//2. WebElement
//	WebElement fname= driver.findElement(By.id("Form_submitForm_FirstName"));
//	WebElement lname= driver.findElement(By.id("Form_submitForm_LastName"));
//
//	fname.sendKeys("margi");
	
	//3. By & Webelement
//	By ftname = By.id("Form_submitForm_FirstName");
//	By ltname = By.id("Form_submitForm_LastName");
//
//	WebElement fname= driver.findElement(ftname);
//	WebElement lname= driver.findElement(ltname);
//	fname.sendKeys("himal");
	
	//4. generic method for locator
//	By ftname = By.id("Form_submitForm_FirstName");
//	By ltname = By.id("Form_submitForm_LastName");
//	getElement(ftname).sendKeys("margi");
//	getElement(ltname).sendKeys("mollot");
	
	//5. using generic method for locator & actions
//	By ftname = By.id("Form_submitForm_FirstName");
//	By ltname = By.id("Form_submitForm_LastName");
//	doSendKeys(ftname, "Margi");
//	doSendKeys(ltname, "Mollot");
	
	//6. create new ElementUtill class with generic functions
//	By ftname = By.id("Form_submitForm_FirstName");
//	By ltname = By.id("Form_submitForm_LastName");
//	
	ElementUtil elementUtil = new ElementUtil(driver);
//	elementUtil.doSendKeys(ftname, "Margi");
//	elementUtil.doSendKeys(ltname, "Pat");

//2. name: can be duplicate
//		By fname = By.name("FirstName");
//		elementUtil.doSendKeys(fname, "margi");
	
//3. classname : Can be duplicate
//		By jobTitle = By.className("text");
//		elementUtil.doSendKeys(jobTitle, "QA");
	
//4. Link Text : only for links (a tag)
	//By policylink = By.linkText("Privacy Policy");
	//driver.findElement(policylink).click();
	//doClick(policylink);
	//elementUtil.doClick(policylink);
	
	//Form_submitForm_SetDummyData
	//By checkbox = By.id("Form_submitForm_SetDummyData");
	//elementUtil.doClick(checkbox);

//5. Partial link text : only for links (a tag)
//	By policyPartiallink = By.partialLinkText("Privacy");
//	elementUtil.doClick(policyPartiallink);
	
//6. XPath : address of the Element in DOM. Its not an attribute
//	By emailxpath = By.xpath("//*[@id=\"Form_submitForm_Email\"]"); 
//	elementUtil.doSendKeys(emailxpath, "QA@qa.com");

//7. CSS Selector : 
	By emailSelector = By.cssSelector("#Form_submitForm_Email"); 
	elementUtil.doSendKeys(emailSelector, "QA@qa.com");
	
//8. TagName: 
//	By header = By.tagName("h3");
////	String text = driver.findElement(header).getText();
//	String text = doGetText(header);
//	System.out.println(text);
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
	
	
}
