package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomCSSOrangeCRMDropDown {

	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		br.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");

		ElementUtil elUtil = new ElementUtil(driver);
		
		//select#Form_submitForm_Industry option
		
		By industry = By.cssSelector("select#Form_submitForm_Industry");
		
		WebElement industryElement = elUtil.getElement(industry);
		Select selectIndustry = new Select(industryElement);
		
		List<WebElement> industryList = selectIndustry.getOptions();
		System.out.println(industryList.size());
		for(WebElement e : industryList) {
			String text = e.getText();
			if(text.equals("Travel")) {
				e.click();
				break;
			}
		}
	}

}
