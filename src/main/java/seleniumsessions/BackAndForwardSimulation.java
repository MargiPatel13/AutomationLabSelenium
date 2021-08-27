package seleniumsessions;

import org.openqa.selenium.WebDriver;

public class BackAndForwardSimulation {

static WebDriver driver;
	
	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		
		driver.navigate().to("https://www.w3schools.com/java/default.asp");
		
		driver.navigate().back();
		driver.navigate().forward();
	}

}
