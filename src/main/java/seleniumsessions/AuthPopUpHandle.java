package seleniumsessions;

import org.openqa.selenium.WebDriver;

public class AuthPopUpHandle {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		//auth pop up ---not a JS alert
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
				
				//https://username+password@test.com
				//driver.get("https://admin:admin@"+"the-internet.herokuapp.com/basic_auth");
		
				String username = "admin";
				String password = "admin";
				
				driver.get("https://"+username + ":"+password + "@"+"the-internet.herokuapp.com/basic_auth");
	}

}
