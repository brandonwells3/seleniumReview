package day2_seleniumFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookActivities {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		FacebookActivities run = new FacebookActivities();
		
		run.getTextPractice();
	}
	
	public void testcase1() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://facebook.com");
		
		driver.findElement(By.name("email")).sendKeys("Automation");
		driver.findElement(By.name("pass")).sendKeys("Automation");
		driver.findElement(By.name("login")).click();
		
		driver.quit();
	}
	
	public void testcase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://facebook.com");
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("firstname")).sendKeys("Automation");
		driver.findElement(By.name("lastname")).sendKeys("Automation");
		driver.findElement(By.name("reg_email__")).sendKeys("Automation");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Automation");
		
		driver.findElement(By.name("websubmit")).click();
		
		driver.quit();
	}
	
	public void getTextPractice() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://facebook.com");
		
		String loginText = driver.findElement(By.name("login")).getText();
		System.out.println("Text: " + loginText);
		if(loginText.equals("Log In")) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL!!!");
		}
		
		driver.quit();
	}
}
