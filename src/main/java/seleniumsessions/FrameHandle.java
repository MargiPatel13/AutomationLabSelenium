package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHandle {

		static WebDriver driver;

		public static void main(String[] args) {
			
			BrowserUtil brUtil = new BrowserUtil();
			driver = brUtil.launchBrowser("chrome");
			brUtil.launchUrl("http://www.londonfreelance.org/courses/frames/index.html");
			
			ElementUtil elUtil = new ElementUtil(driver);
			
			//List<WebElement> frameList = driver.findElements(By.tagName("frame"));
			
			//driver.switchTo().frame(2); 		//frame by index -- should avoid because we don't know how many frames is there
			//driver.switchTo().frame("main");	//frame by name or id  -- should avoid if name or id is not available 
			driver.switchTo().frame(driver.findElement(By.name("main"))); // frame by webElement -- using any locator
			
			By header = By.xpath("/html/body/h2");
			String titleHeader = elUtil.getElement(header).getText();
			System.out.println(titleHeader);
			
			driver.switchTo().defaultContent();
			
			
	}

}
