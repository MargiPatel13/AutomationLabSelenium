package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RightClickContextClickHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		ElementUtil elUtil = new ElementUtil(driver);
		
		By rightclick = By.xpath("//span[text()='right click me']");
		By menu = By.xpath("//li[contains(@class, 'context-menu-item context-menu-icon')]/span");

//		WebElement rightClickElement = elUtil.getElement(rightclick);
//		
//		Actions actions = new Actions(driver);
//		actions.contextClick(rightClickElement).perform();
//		
//		List<WebElement> menuList = elUtil.getElements(menu);
//		
//		System.out.println(menuList.size());
//		
//		for(WebElement e: menuList) {
//			String text = e.getText();
//			System.out.println(text);
//			
//			if(text.equals("Copy")) {
//				e.click();
//				break;
//			}
//		}
		
		//Assignment : create Utility
//		doContextClick(rightclick);
//		getContextMenuList(menu, "Copy");
	
//		doContextClickMenu(rightclick, menu, "Edit");
	
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public static void doContextClick(By locator) {
		Actions actions = new Actions(driver);
		actions.contextClick(getElement(locator)).perform();
	}
	
	public static void getContextMenuList(By locator, String value) {
		List<WebElement> menuList = getElements(locator);
		System.out.println(menuList.size());
		
		for(WebElement e: menuList) {
			String text = e.getText();
			System.out.println(text);
			
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public static void doContextClickGetMenu(By clickLocator, By listLocator,String value) {
		Actions actions = new Actions(driver);
		actions.contextClick(getElement(clickLocator)).perform();
		
		List<WebElement> menuList = getElements(listLocator);
		System.out.println(menuList.size());
		
		for(WebElement e: menuList) {
			String text = e.getText();
			System.out.println(text);
			
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
}
