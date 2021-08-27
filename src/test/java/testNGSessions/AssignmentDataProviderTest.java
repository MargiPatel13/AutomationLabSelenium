package testNGSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentDataProviderTest {

	WebDriver driver; 
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
	}
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
				{ "Margi", "patel", "margi@gmail.com", "6876874959", "margi"},
				{ "mayu", "patel", "mayur@gmail.com", "9879448464", "margi"},
				{ "anu", "patel", "anu@gmail.com", "324324324", "margi"},
				{ "reen", "patel", "reenu@gmail.com", "2342335434", "margi"},
				{ "shiv", "patel", "shivu@gmail.com", "5645640234", "margi"}, 
		};
	}
	
	@Test(dataProvider = "getData")
	public void registrationTest(String fName, String lName, String email, String phone, String pass) {
		Assert.assertTrue(doRegistration(fName, lName, email, phone, pass));
	}
	
	public boolean doRegistration(String fName, String lName, String email, String phone, String pass) {
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(fName);
		
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lName);
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(email);
		
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(phone);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(pass);
		
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(pass);
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	 
		return driver.findElement(By.xpath("//div[@id='content']/h1")).isDisplayed();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
