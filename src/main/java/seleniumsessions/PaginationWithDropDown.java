package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaginationWithDropDown {

	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://classic.crmpro.com/");
		ElementUtil elUtil = new ElementUtil(driver);

		By uname = By.name("username");
		By pass = By.name("password");
		By login = By.xpath("//input[@value='Login']");
		elUtil.doSendKeys(uname, "groupautomation");
		elUtil.doSendKeys(pass, "Test@12345");
		elUtil.doClick(login);

		elUtil.waitForFrameAndSwitchToIt("mainpanel", 3);

		By contacts = By.linkText("CONTACTS");
		elUtil.doClick(contacts);
		
		By pageDropDown = By.xpath("(//div[@class='pagination'])[1]/select");
		WebElement selectPage_element = elUtil.getElement(pageDropDown);
		Select selectPage = new Select(selectPage_element);
		List<WebElement> pageList = selectPage.getOptions();
		
		int i = 0;
		while (true) {
			String contactName = "Margi Patel";
			if (elUtil.getElements(By.linkText(contactName)).size() > 0) { // if more than one same name is available
																			// still condition will be true.
				selectContact(contactName); // if the same name available more than once, then it will select the first one.
				break;
			} else { // pagination logic
				try {
					pageList.get(i).click();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Sorry, We couldn't find any contact with that name");
					break;
				}
				selectPage_element = elUtil.getElement(pageDropDown);
				selectPage = new Select(selectPage_element);
				pageList = selectPage.getOptions();
			}
			i++;
		}
	}

	public static void selectContact(String name) {
		By checkBox = By.xpath("//a[text()='" + name + "']//parent::td//preceding-sibling::td/input[@type='checkbox']");
		driver.findElement(checkBox).click();
	}

}
