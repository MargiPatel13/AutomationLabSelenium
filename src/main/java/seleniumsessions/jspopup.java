package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class jspopup {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		//brUtil.launchUrl("https://mail.rediff.com/cgi-bin/login.cgi");
		brUtil.launchUrl("https://www.selenium.dev/documentation/en/webdriver/js_alerts_prompts_and_confirmations/");
		
		
		ElementUtil elUtil = new ElementUtil(driver);
		
//		By alertExample = By.linkText("See an example alert");
//		WebElement alertElement = elUtil.getElement(alertExample);
//		alertElement.click();
		
		By confirmExample = By.linkText("See a sample confirm");
		WebElement confirmElement = elUtil.getElement(confirmExample);
		confirmElement.click();
		
		By promptExample = By.linkText("See a sample prompt");
		WebElement promptElement = elUtil.getElement(promptExample);
//		promptElement.click();
		
		Alert alert = driver.switchTo().alert();

		String text = alert.getText(); 	//get the text from the alert - to validate the text
		System.out.println(text);
		
	//	alert.sendKeys("Selenium"); //pass the text
		alert.accept();	//accept the alert
		//alert.dismiss(); //cancel/close the alert
		
		Thread.sleep(4000);

		driver.switchTo().defaultContent();
	}

}
