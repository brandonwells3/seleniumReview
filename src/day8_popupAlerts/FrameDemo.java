package day8_popupAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
	}
	
	public static void frameDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/frames");
		
		driver.switchTo().frame("iframe1");
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Test");
		driver.switchTo().parentFrame();
		
		driver.quit();
	}
}
