package seleniumsessions;

import org.openqa.selenium.WebDriver;

public class NavigationConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		
		brUtil.launchUrl("https://www.google.com/");			// driver.get()
		
		//driver.navigate().to("https://about.google/?fg=1&utm_source=google-CA&utm_medium=referral&utm_campaign=hp-header");
		
		brUtil.launchUrl("https://amazon.ca");			 //driver.get()

		driver.navigate().back();
		driver.navigate().forward(); 
	}

}
