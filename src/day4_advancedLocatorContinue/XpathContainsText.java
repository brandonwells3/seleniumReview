package day4_advancedLocatorContinue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathContainsText {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		etsyXpath();
	}
	
	public static void etsyXpath() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://etsy.com");
		
		driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(), 'Register')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[contains(@id, 'join_neu_email_field')]")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.xpath("//input[contains(@id, 'join_neu_first_name_field')]")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[contains(@id, 'join_neu_password_field')]")).sendKeys("Automation");
		
		driver.findElement(By.xpath("//button[contains(@name, 'submit_attempt')]")).click();
		Thread.sleep(7000);
		
		String errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Sorry, the email you have entered is already in use.')]")).getText();
		if(errorMessage.equals("Sorry, the email you have entered is already in use.")) {
			System.out.println("Test PASS");
		} else {
			System.out.println("Test FAIL!!!");
		}
		
		driver.quit();
	}
	
	public static void etsyCssSelector() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://etsy.com");
		
		driver.findElement(By.cssSelector(".select-signin")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".select-register")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input[name=email]")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.cssSelector("input[name=first_name]")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input[name=password]")).sendKeys("Automation");
		
		driver.findElement(By.cssSelector("button[name=submit_attempt]")).click();
		Thread.sleep(7000);
		
		String errorMessage = driver.findElement(By.cssSelector("div[id=aria-join_neu_email_field-error]")).getText();
		if(errorMessage.equals("Sorry, the email you have entered is already in use.")) {
			System.out.println("Test PASS");
		} else {
			System.out.println("Test FAIL!!!");
		}
		
		driver.quit();
	}
}
