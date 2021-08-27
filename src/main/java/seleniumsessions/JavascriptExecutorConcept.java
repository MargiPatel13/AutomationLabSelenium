package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptExecutorConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		//br.launchUrl("https://www.linkedin.com/checkpoint/rm/sign-in-another-account?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
		br.launchUrl("https://www.amazon.ca/");

		ElementUtil elUtil = new ElementUtil(driver);
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		//System.out.println(jsUtil.getTitleByJS());
		
		//jsUtil.refreshBrowserByJS();
		
		//System.out.println(jsUtil.getPageInnerText());
		
//		jsUtil.generateAlert("hey there!");
//		driver.switchTo().alert().dismiss();
				
//		WebElement username = elUtil.getElement(By.id("username"));
//		WebElement pass = elUtil.getElement(By.id("password"));
//		WebElement signIn = elUtil.getElement(By.xpath("//button[text()='Sign in']"));

//		jsUtil.flash(username);
//		elUtil.doSendKeys(username, "margi-mar");
//		jsUtil.drawBorder(username);
//
//		jsUtil.flash(pass);
//		elUtil.doSendKeys(pass, "soefbeucnflrvudnt[qk]");
//		jsUtil.drawBorder(pass);
//
//		jsUtil.flash(signIn);
//		elUtil.doClick(signIn);
//		//jsUtil.clickElementByJS(signIn);
//		jsUtil.drawBorder(signIn);
		
	//	jsUtil.scrollPageDown();
	//	jsUtil.scrollPageUp();
		
	//	jsUtil.scrollPageDown("300");
		
		WebElement amazon = elUtil.getElement(By.className("navFooterBackToTopText"));
		//System.out.println(amazon.getLocation());  //to get the location of element in coordinate (0, 5559)
		//jsUtil.ScrollPageDownByCoordinate("0","5559");
		//jsUtil.drawBorder(amazon);
		//amazon.click();
		
	//	jsUtil.scrollIntoView(amazon);

	}

}
