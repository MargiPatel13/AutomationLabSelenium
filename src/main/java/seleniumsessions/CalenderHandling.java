package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalenderHandling {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		ElementUtil elUtil = new ElementUtil(driver);

		By date = By.id("datepicker");
		elUtil.doClick(date);
		
		By calendar = By.id("ui-datepicker-div");
		elUtil.waitForElementPresence(calendar, 10);
		
		//1 
//		By selectDate = By.xpath("//a[text()='22']");
//		elUtil.doClick(selectDate);
		
		//2
//		By calenderTable = By.cssSelector("table.ui-datepicker-calendar a");
//		List<WebElement> daysList = elUtil.getElements(calenderTable);
//		
//		for(WebElement e : daysList) {
//			if(e.getText().equals("20")) {
//				e.click();
//				break;
//			}
//		}
		
		//3
		//selectFutureDate("July 2022", "1");
		
		selectPastDate("April 2019", "13");
	}
	/***
	 *for current month's date and future date
	 * @param expactedMonthAndYear : pass the exact month year as given in the calendar. i.e. August 2021
	 * @param day : day in form of number
	 * */
	public static void selectFutureDate(String expactedMonthAndYear, String day) {  
		
		if(Integer.parseInt(day)>31) {
			System.out.println("wrong date.. please pass the correct date...");
			return;
		}

		String actualMonthAndYear = doGetText(By.cssSelector("div.ui-datepicker-title"));
		System.out.println(actualMonthAndYear);
		
		while(!actualMonthAndYear.equalsIgnoreCase(expactedMonthAndYear)) {
			//click on next if the condition is true
			doClick(By.xpath("//span[text()='Next']"));
			actualMonthAndYear = doGetText(By.cssSelector("div.ui-datepicker-title"));
		}
		doClick(By.xpath("//a[text()='"+ day +"']"));
	}
	/***
	 *for current month's date and past date
	 * @param expactedMonthAndYear : pass the exact month year as given in the calendar. i.e. August 2021
	 * @param day : day in form of number
	 * */
	public static void selectPastDate(String expactedMonthAndYear, String day) {  

		if(Integer.parseInt(day)>31) {
			System.out.println("wrong date.. please pass the correct date...");
			return;
		}

		String actualMonthAndYear = doGetText(By.cssSelector("div.ui-datepicker-title"));
		System.out.println(actualMonthAndYear);
		
		while(!actualMonthAndYear.equalsIgnoreCase(expactedMonthAndYear)) {
			//click on previous if the condition is true
			doClick(By.xpath("//span[text()='Prev']"));
			actualMonthAndYear = doGetText(By.cssSelector("div.ui-datepicker-title"));
		}
		doClick(By.xpath("//a[text()='"+ day +"']"));
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
