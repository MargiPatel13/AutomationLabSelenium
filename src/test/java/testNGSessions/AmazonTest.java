package testNGSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Errors;

public class AmazonTest extends BaseTest {

	@Test(priority = 1)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("page title is : " + title);
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", Errors.TITLE_MISMATCHED_MESSG);
	}

	@Test(priority = 2)
	public void appPageUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("page url: " + url);
		Assert.assertTrue(url.contains("amazon"), Errors.URL_MISMATCHED_MESSG);
	}

	@Test(priority = 3, enabled = true)
	public void seachBoxTest() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed());
	}

	
}

