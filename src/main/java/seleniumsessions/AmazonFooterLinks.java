package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonFooterLinks {
	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://www.amazon.ca/");

		ElementUtil elUtil = new ElementUtil(driver);
		
		By firstfooterLinks = By.xpath("//div[@class='navFooterVerticalRow navAccessibility']//a");
//		List<WebElement> footerList= elUtil.getElements(firstfooterLinks);
//		System.out.println(footerList.size());
//		
//		for(WebElement e : footerList) {
//			System.out.println(e.getText());
//		}
		List<String> footerTextList= getLinksTextList(firstfooterLinks);
		//validation points:
		if(footerTextList.size() == 22) {
			System.out.println("footer list count is correct");
		}
		
		if(footerTextList.contains("About Us")) {
			System.out.println("AboutUs is present");
		}else {
			System.out.println("AboutUs is not present");
		}
		
		if(footerTextList.contains("Careers")) {
			System.out.println("Careers is present");
		}
		
		//Assignment : print last two footer link
		//1
		By secfooterLinks = By.xpath("//table[@class = 'navFooterMoreOnAmazon']//a");
		List<String> secFooterList= getLinksTextList(secfooterLinks);
		//validation
		if(secFooterList.size() == 14) {
			System.out.println("Second footer list count is true");
		}
		
		//2
		By lastfooterLinks = By.xpath("//div[@class = 'navFooterLine navFooterLinkLine navFooterPadItemLine navFooterCopyright']//a");
		List<String> lastFooterList= getLinksTextList(lastfooterLinks);
		//validation
		if(lastFooterList.size() == 3) {
			System.out.println("Last footer list count is true");
		}
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static List<String> getLinksTextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();

		List<WebElement> elementlist = getElements(locator);
		System.out.println("Element count: " + elementlist.size());

		for (WebElement e : elementlist) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}
}
