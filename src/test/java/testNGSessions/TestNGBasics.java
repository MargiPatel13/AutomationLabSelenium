package testNGSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	//pre conditions
	//testcase --> test steps + assertion (actual vs expected)
	//post conditions
	
	
//	BeforeSuite - - DBconnection
//	BeforeTest - - createUser
//	BeforeClass - - launchBrowser
	
//	BeforeMethod - - login
//	test -- add To Cart Test
//	AfterMethod -- logout
	
//	BeforeMethod - - login
//	test -- home page test
//	AfterMethod -- logout
	
//	BeforeMethod - - login
//	test -- payment Page Test
//	AfterMethod -- logout
	
//	AfterClass -- closeBrowser
//	AfterTest -- deleteUser
//	AfterSuite -- disconnetDB

	@BeforeSuite
	public void DBconnection() {
		System.out.println("BeforeSuite - - DBconnection");
	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("BeforeTest - - createUser");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BeforeClass - - launchBrowser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("BeforeMethod - - login");
	}
	
	@Test
	public void homePageTest() {
		System.out.println("test -- home page test");
	}
	
	@Test
	public void addToCartTest() {
		System.out.println("test -- add To Cart Test");
	}
	
	@Test
	public void paymentPageTest() {
		System.out.println("test -- payment Page Test");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("AfterMethod -- logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AfterClass -- closeBrowser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AfterTest -- deleteUser");
	}
	
	@AfterSuite
	public void disconnetDB() {
		System.out.println("AfterSuite -- disconnetDB");
	}
}
