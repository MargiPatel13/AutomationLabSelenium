package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropActionsHandle {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			
			BrowserUtil brUtil = new BrowserUtil();
			driver = brUtil.launchBrowser("chrome");
			brUtil.launchUrl("https://jqueryui.com/resources/demos/droppable/default.html");
			
			ElementUtil elUtil = new ElementUtil(driver);
			
			By draggable = By.id("draggable");
			By droppable = By.id("droppable");
			
			WebElement darg = driver.findElement(draggable);
			WebElement drop = driver.findElement(droppable);
			
			Actions action = new Actions(driver);
			//action.clickAndHold(darg).moveToElement(drop).release(drop).build().perform();
			action.dragAndDrop(darg, drop);
	}
		

}
