package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownOptionwithSelect {
	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		br.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");

		ElementUtil elUtil = new ElementUtil(driver);

		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");

		WebElement industryEle = elUtil.getElement(industry);
		WebElement countryEle = elUtil.getElement(country);

//		Select industrySelect = new Select(industryEle);
//		//to get the all option text from dorpdown 
//		List<WebElement> industList = industrySelect.getOptions();
//		System.out.println(industList.size());
//		
//		for(WebElement e : industList) {
//			String text = e.getText();
//			System.out.println(text);
//		}

		List<String> industryList =	getDropDownOptionsList(industry);
		if(industryList.size() == 21) {
			System.out.println("TC_01: Pass");
		}
		if(industryList.contains("Finance")) {
			System.out.println("TC_02: Pass");
		}
		
		List<String> countryList = getDropDownOptionsList(country);
		if(countryList.size() == 232) {
			System.out.println("TC_03: Pass");
		}
		if(countryList.contains("India")) {
			System.out.println("TC_04: Pass");
		}
		
		getDropDownOptionsList(country);
		
		
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<String> getDropDownOptionsList(By locator) {
		List<String> optionsValList = new ArrayList<String>();
		
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();

		System.out.println(optionsList.size());

		for(WebElement e : optionsList) {
			String text = e.getText();
			optionsValList.add(text);
		}
		return optionsValList;
	}
	
	public static void selectDropDownValue(By locator, String value) {		
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
