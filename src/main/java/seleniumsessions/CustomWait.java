package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomWait {
	
	//using only sleep();
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/login");	
		
		By email_id = By.id("input-demail");
		retryingElement(email_id, 20).sendKeys("hello@g.com");
	}
	
	public static WebElement retryingElement(By locator, int maxAttempts) {
		WebElement element = null;
		int attempts = 0;
		
		while(attempts < maxAttempts) {
			try {
				element = driver.findElement(locator);
				break;
			} 
			catch(Exception e) {
				try {
					Thread.sleep(1000);
				} 
				catch(InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("element is not found in attempt : " + (attempts+1));
			}
			attempts++;
		}
		return element;
	}

}
