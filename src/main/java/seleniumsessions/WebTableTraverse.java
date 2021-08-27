package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTableTraverse {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://www.w3schools.com/html/html_tables.asp");

		getTableColumn(3);
	}
	
	//Generic method to print the table col: by pasing column number - col no 1,2,3 
	public static void getTableColumn(int columnNo) {
		 ElementUtil elUtil = new ElementUtil(driver);

		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td["+ columnNo +"]";
		
		By row = By.xpath("//table[@id='customers']/tbody/tr");
		int rowCount = elUtil.getElements(row).size();

		for(int i = 2; i <= rowCount; i++) {
			String tableXpath = beforeXpath + i + afterXpath;
			String compName = elUtil.doGetText(By.xpath(tableXpath));
			System.out.println(compName);
		}
	}
}
