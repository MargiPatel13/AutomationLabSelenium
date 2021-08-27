package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignDynamicTableMethod {
	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://www.w3schools.com/html/html_tables.asp");

		//getTableColumn(3);
		
		printDynamicTable();
		
	}

	// Generic method to print the table col: by pasing column number - col no 1,2,3
	public static void getTableColumn(int columnNo) {
		ElementUtil elUtil = new ElementUtil(driver);

		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[" + columnNo + "]";

		By row = By.xpath("//table[@id='customers']/tbody/tr");
		int rowCount = elUtil.getElements(row).size();

		for (int i = 2; i <= rowCount; i++) {
			String tableXpath = beforeXpath + i + afterXpath;
			String compName = elUtil.doGetText(By.xpath(tableXpath));
			System.out.println(compName);
		}
	}
	
	public static void printDynamicTable() {
		ElementUtil elUtil = new ElementUtil(driver);

		By rows = By.xpath("//table[@id='customers']/tbody/tr");
		int rowCount = elUtil.getElements(rows).size();
		By cols = By.xpath("//table[@id='customers']/tbody/tr[2]/td");
		int colCount = elUtil.getElements(cols).size();
		
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String midXpath = "]/td[";
		String afterXpath= "]";
		
		for(int i = 2; i <= rowCount; i++) {
			for(int j = 1; j <= colCount; j++) {
				String tableXpath = beforeXpath + i + midXpath + j + afterXpath;

				String customerTable = elUtil.doGetText(By.xpath(tableXpath));
				System.out.print(customerTable);
				System.out.print("  |  ");
			}
			System.out.println();
		}
		
	}

}
