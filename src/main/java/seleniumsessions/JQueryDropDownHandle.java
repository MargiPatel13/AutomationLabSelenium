package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JQueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");

		brUtil.launchUrl("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		ElementUtil elUtil = new ElementUtil(driver);

//		By multiDropDown = By.id("justAnInputBox");
//		WebElement multiDropDownClick = elUtil.getElement(multiDropDown);
//		multiDropDownClick.click();

//		Thread.sleep(2000);
//		By selectOption = By.cssSelector(".comboTreeItemTitle"); 	//dropdown with checkbox selection

		// tc 1 : Single Selection:
		// selectSingleJQueryDropDown(selectOption, "choice 6 1");

		// tc 2: Multi Selection:
		// selectMultiJQueryDropDown(selectOption, "choice 1", "choice 2", "choice 6 1");
		// selectMultiJQueryDropDown(selectOption, "choice 5");

		// tc 3: All Selection:
		//		selectJQueryDropDown(selectOption, "choice 3");									//tc 1
		//		selectJQueryDropDown(selectOption, "choice 1", "choice 2", "choice 6 1");		//tc 2
		//		selectJQueryDropDown(selectOption, "select_all");										//tc 3
		//		selectJQueryDropDown(selectOption, "select_all");	//to De-Select call the method again with same argument
		
		
		//Assignment: 	Multi Selection With Cascade Option Select
//		By multiWithCascadeDropDown = By.id("justAnInputBox1");
//		WebElement multiWithCascadeDropDownClick = elUtil.getElement(multiWithCascadeDropDown);
//		multiWithCascadeDropDownClick.click();
//		Thread.sleep(2000);
//
//		By selectMultiOption = By.cssSelector(".comboTreeItemTitle"); 
//		selectJQueryDropDown(selectMultiOption, "choice 5");
		
		//Assignment: Single Selection
		By singleSelectionDropDown = By.id("justAnotherInputBox");
		WebElement singleSelectionDropDownClick = elUtil.getElement(singleSelectionDropDown);
		singleSelectionDropDownClick.click();
		Thread.sleep(2000);

		By selectSingleOption = By.cssSelector(".comboTreeItemTitle"); 
		selectJQueryDropDown(selectSingleOption, "choice 6 2 3");
		
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	//	public static void selectSingleJQueryDropDown(By locator, String value) {
	//		List<WebElement> dropDownList = getElements(locator);
	//
	//		for (WebElement e : dropDownList) {
	//			String listText = e.getText();
	//			System.out.println(listText);
	//			if (listText.equals(value)) {
	//				e.click();
	//				break;
	//			}
	//		}
	//	}

	//	public static void selectMultiJQueryDropDown(By locator, String... value) {
	//		List<WebElement> dropDownList = getElements(locator);
	//
	//		for (WebElement e : dropDownList) {
	//			String listText = e.getText();
	//			System.out.println(listText);
	//
	//			for (int j = 0; j < value.length; j++) {
	//				if (listText.equals(value[j])) {
	//					e.click();
	//					break;
	//				}
	//			}
	//		}
	//	}
	
	/** 	this method work for single, multi and all the selection. 
	 * note: please pass select_all if want to select all	**/
	public static void selectJQueryDropDown(By locator, String... value) {
		List<WebElement> dropDownList = getElements(locator);

		if(!value[0].equalsIgnoreCase("select_all")) {
			//single - multi selection logic
			for (WebElement e : dropDownList) { 					
				String listText = e.getText();
				
				for (int j = 0; j < value.length; j++) {
					if (listText.equals(value[j])) {
						e.click();
						break;
					}
				}
			}
		} else {
			//all selection logic
			try {
				for(WebElement e: dropDownList) {
					e.click();
				}
			}catch(Exception e) {}
		}
	}
}
