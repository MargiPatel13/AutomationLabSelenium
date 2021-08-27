package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableHandleCricInfo {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://www.espncricinfo.com/series/india-tour-of-sri-lanka-2021-1262739/sri-lanka-vs-india-3rd-odi-1262757/full-scorecard");
		ElementUtil elUtil = new ElementUtil(driver);
		
		System.out.println(getWicketTakerName("Prithvi Shaw"));
		System.out.println(getScoreList("Prithvi Shaw"));		
		List<String> scoreList = getScoreList("Manish Pandey");
		System.out.println(scoreList);
		
		//Assignment 2: Bowling Score list for bhuvneshwar Kumar- single function and return a list<> - getBowlingScoreDetails - cricInfo.com
		System.out.println(getBowlingScoreDetails("Akila Dananjaya"));
	}
	public static List<String> getScoreList(String playerName) {
		By scoreXpath = By.xpath("//a[text()='"+playerName+"']//parent::td//following-sibling::td");
		List<WebElement> scoreList = driver.findElements(scoreXpath);
		
		List<String> scoreBoardList = new ArrayList<String>();
		
		for(int i=1; i<scoreList.size(); i++) {
			String text = scoreList.get(i).getText();
			scoreBoardList.add(text);
		}
		return scoreBoardList;
	}
	
	public static List<String> getBowlingScoreDetails(String playerName) {
		By scoreXpath = By.xpath("//a[text()='"+playerName+"']//parent::td[@class='text-nowrap']//following-sibling::td");
		List<WebElement> scoreList = driver.findElements(scoreXpath);
		
		List<String> scoreBoardList = new ArrayList<String>();
		
		for(int i=1; i<scoreList.size(); i++) {
			String text = scoreList.get(i).getText();
			scoreBoardList.add(text);
		}
		return scoreBoardList;
	}
	
	public static String getWicketTakerName(String playerName) {
		By wicketTakerXpath = By.xpath("//a[text()='"+playerName+"']//parent::td//following-sibling::td/span");	
		return driver.findElement(wicketTakerXpath).getText();
	}
}
