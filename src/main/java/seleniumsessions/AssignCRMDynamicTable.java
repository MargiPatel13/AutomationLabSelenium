package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AssignCRMDynamicTable {     	//print name column value - with pagination to get all the names of each columns
	
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
		while(true) {
			getTableColumn(4, 2);
			// pagination logic
				try {
					pageList.get(i).click();
				} catch (Exception e) {
					break;
				}
				selectPage_element = elUtil.getElement(pageDropDown);
				selectPage = new Select(selectPage_element);
				pageList = selectPage.getOptions();
			i++;	
		}
		
	}
	
	public static void getTableColumn(int dataStartRow, int columnNo) {
		ElementUtil elUtil = new ElementUtil(driver);
	
		String beforeXpath = "//form[@id='vContactsForm']/table[@class='datacard']/tbody/tr[";
		String afterXpath = "]/td["+ columnNo +"]";
		
		By row = By.xpath("//form[@id='vContactsForm']/table[@class='datacard']/tbody/tr");
		int rowCount = elUtil.getElements(row).size();

		for(int i = dataStartRow; i < rowCount; i++) {
			String tableXpath = beforeXpath + i + afterXpath;
			String compName = elUtil.doGetText(By.xpath(tableXpath));
			System.out.println(compName);
		}
	}

}
