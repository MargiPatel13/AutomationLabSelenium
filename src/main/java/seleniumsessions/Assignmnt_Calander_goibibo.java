package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignmnt_Calander_goibibo {
	
	static WebDriver driver;
	
	public static void selectFutureDate(String expactedMonthAndYear, String day) {  
		
		if(Integer.parseInt(day)>31) {
			System.out.println("wrong date.. please pass the correct date...");
			return;
		}
		String actualMonthAndYear = doGetText(By.cssSelector("div .DayPicker-Caption div"));
		System.out.println(actualMonthAndYear);
		
		while(!actualMonthAndYear.equalsIgnoreCase(expactedMonthAndYear)) {
			//click on next if the condition is true
			doClick(By.cssSelector("span[aria-label='Next Month']"));
			actualMonthAndYear = doGetText(By.cssSelector("div .DayPicker-Caption div"));
		}
		doClick(By.xpath("//div[text()='"+ day +"']"));
	}
	
	public static void selectPastDate(String expactedMonthAndYear, String day) {  

		if(Integer.parseInt(day)>31) {
			System.out.println("wrong date.. please pass the correct date...");
			return;
		}
		String actualMonthAndYear = doGetText(By.cssSelector("div .DayPicker-Caption div"));
		System.out.println(actualMonthAndYear);
		
		while(!actualMonthAndYear.equalsIgnoreCase(expactedMonthAndYear)) {
			//click on previous if the condition is true
			doClick(By.cssSelector("span[aria-label='Previous Month']"));
			actualMonthAndYear = doGetText(By.cssSelector("div .DayPicker-Caption div"));
		}
		doClick(By.xpath("//div[text()='"+ day +"']"));
	}
	
	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://www.goibibo.com/");
		ElementUtil elUtil = new ElementUtil(driver);

		By departure = By.id("departureCalendar");
		elUtil.doClick(departure);
		
		By departureCalendar = By.className("DayPicker");
		elUtil.waitForElementPresence(departureCalendar, 10);
		
		selectFutureDate("April 2022", "15");
			
		elUtil.doClick(departure);
		elUtil.waitForElementPresence(departureCalendar, 10);
		
		By actualMonthAndYear = By.cssSelector("div .DayPicker-Caption div");
		elUtil.waitForElementPresence(actualMonthAndYear, 10);
		
		selectPastDate("August 2021", "9");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
}
