package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MixingWait {
	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		
		//e1 e2 ....en --> 20 secs (implicitlyWait)
		//for e2 element -- custom wait --> WebDriverWait (Exp wait) --> 10 secs
	
	}

}
