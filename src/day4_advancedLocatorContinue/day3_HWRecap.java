package day4_advancedLocatorContinue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day3_HWRecap {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		facebookTestCase2();
	}
	
	public static void facebookTestCase1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Automation");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(2000);
		
		driver.quit();
	}
	
	public static void facebookTestCase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Automation");
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		
		driver.quit();
	}
	
	public static void indeedTestCase3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://indeed.com");
		
		String homeURL = driver.getCurrentUrl();
		String homeTitle = driver.getTitle();
		
		String whatSearch = "SDET";
		driver.findElement(By.xpath("//input[@id='text-input-what']")).sendKeys(whatSearch);
		
		WebElement whereField = driver.findElement(By.xpath("//input[@id='text-input-where']"));
		whereField.sendKeys(Keys.COMMAND + "a");
		whereField.sendKeys(Keys.DELETE);
		whereField.sendKeys("Washington, DC");
		
		driver.findElement(By.xpath("//button[@class='yosegi-InlineWhatWhere-primaryButton']")).click();
		Thread.sleep(2000);
		
		String searchURL = driver.getCurrentUrl();
		String searchTitle = driver.getTitle();
		
		driver.quit();
	}
}
