package seleniumsessions;

import java.util.List;

import javax.crypto.spec.ChaCha20ParameterSpec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLaungageList {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		ElementUtil elutil = new ElementUtil(driver);

		By languageLink = By.xpath("//div[@id='SIvCob']/a");
		ClickOnElement(languageLink, "Français");
		
//		List<WebElement> languageList = elutil.getElements(languageLink);
//		System.out.println(languageList.size());
//
//		for (WebElement e : languageList) {
//			String text = e.getText();
//
//			if (text.equals("Français")) {
//				System.out.println(text);
//				e.click();
//				break;
//			}
//		}
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void ClickOnElement(By locator, String value) {
		List<WebElement> elementList = getElements(locator);
		System.out.println(elementList.size());

		for (WebElement e : elementList) {
			if (e.getText().equals(value)) {
				System.out.println(e.getText());
				e.click();
				break;
			}
		}
	}
}
