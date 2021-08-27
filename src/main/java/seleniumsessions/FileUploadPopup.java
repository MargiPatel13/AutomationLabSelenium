package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPopup {

	static WebDriver driver;

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		ElementUtil elUtil = new ElementUtil(driver);
		
		By uploadFile = By.name("upfile");
		WebElement upFile = elUtil.getElement(uploadFile);
		
		elUtil.doSendKeys(uploadFile, "C:\\Users\\Mayur\\Desktop\\wallpaper.jpg");
	}

}
