package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownWithoutSelect {
	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		br.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");

		ElementUtil elUtil = new ElementUtil(driver);
		
		By industry = By.xpath("//select[@id='Form_submitForm_Industry']/option");
		
//		List<WebElement> industList = elUtil.getElements(industry);
//		System.out.println(industList.size());
//
//		for (WebElement e : industList) {
//			String text = e.getText();
//			if (text.equals("Education")) {
//				e.click();
//				break;
//			}
//		}
		clickDropDownValue(industry, "Education");
		
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void clickDropDownValue(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);
		System.out.println(optionsList.size());
		for(WebElement e: optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
