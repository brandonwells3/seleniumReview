package day3_advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		XpathDemo run = new XpathDemo();
		//run.amazonSearch();
		run.etsySignIn();
	}
	
	public void amazonSearch() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://amazon.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon']")).sendKeys("coffee mug");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		
		driver.quit();
	}
	
	public void etsySignIn() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://etsy.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--secondary wt-btn--small inline-overlay-trigger register-header-action select-register']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Jon");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("automation");
		driver.findElement(By.xpath("//button[@name='submit_attempt']")).click();
		Thread.sleep(10000);
		
		String actualErrorMessage = driver.findElement(By.xpath("//div[@id='aria-join_neu_email_field-error']")).getText();
		String expectedErrorMessage = "Sorry, the email you have entered is already in use.";
		System.out.println(actualErrorMessage);
		System.out.println(expectedErrorMessage);
		if(actualErrorMessage.equals(expectedErrorMessage)) {
			System.out.println("PASS, messages match");
		} else {
			System.out.println("FAIL, message DOESN'T match");
		}
		
		driver.quit();
	}
}
