package day3_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_HWRecap {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		Day2_HWRecap run = new Day2_HWRecap();
		
		//run.etsyHomework();
		run.indeedHomework();
	}
	
	public void etsyHomework() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://etsy.com");
		Thread.sleep(2000);
		
		driver.findElement(By.className("select-signin")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("email")).sendKeys("Automation");
		driver.findElement(By.name("password")).sendKeys("Automation");
		driver.findElement(By.name("submit_attempt")).click();
		
		driver.quit();
	}
	
	public void indeedHomework() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		String searchCriteria = "SDET";
		
		driver.get("https://indeed.com");
		Thread.sleep(2000);
		
		String homeURL = driver.getCurrentUrl();
		String homeTitle = driver.getTitle();
		
		driver.findElement(By.id("text-input-what")).sendKeys(searchCriteria);
		driver.findElement(By.className("yosegi-InlineWhatWhere-primaryButton")).click();
		Thread.sleep(2000);
		
		String searchURL = driver.getCurrentUrl();
		String searchTitle = driver.getTitle().toUpperCase();
		if (!searchURL.equals(homeURL) && searchURL.contains(searchCriteria)) {
			System.out.println("URL's don't match and searchURL contains searchCriteria");
		} else {
			System.out.println("Either the URL's match or searchURL doesn't contain searchCriteria");
		}
		
		if (!searchTitle.equals(homeTitle) && searchTitle.contains(searchCriteria)) {
			System.out.println("Title's don't match and searchTitle contains searchCriteria");
		} else {
			System.out.println("Either the Title's match or searchTitle doesn't contain searchCriteria");
		}
		
		String jobsInLocationText = driver.findElement(By.className("jobsearch-SerpTitle")).getText();
		System.out.println("Jobs in Location Text: " + jobsInLocationText);
		if (jobsInLocationText.contains(searchCriteria)) {
			System.out.println("PASS, Jobs In Location Text Contains the Search Criteria");
		} else {
			System.out.println("FAIL, Jobs In Location Text DOESN'T Contain the Search Criteria");
		}
		
		String searchCriteriaSubText = jobsInLocationText.substring(0, searchCriteria.length());
		System.out.println(searchCriteriaSubText);
		
		driver.quit();
	}
}
