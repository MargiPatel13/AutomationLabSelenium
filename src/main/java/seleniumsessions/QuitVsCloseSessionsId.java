package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsCloseSessionsId {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\SeleniumJars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");

		String title = driver.getTitle();
		System.out.println("page title is: " + title);

		System.out.println(driver.getCurrentUrl());

		//driver.quit();
		driver.close(); //close browser 
		
		System.out.println(driver.getTitle()); //quit() > Exception in thread "main" org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
												//close()> Exception in thread "main" org.openqa.selenium.NoSuchSessionException: invalid session id
		//re-open the browser:
//		driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		System.out.println(driver.getTitle());

	}
}
