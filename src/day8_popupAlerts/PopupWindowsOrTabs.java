package day8_popupAlerts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupWindowsOrTabs {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		//newTabDemo();
		inClassTask();
	}
	
	public static void newTabDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		
		WebElement newTab = driver.findElement(By.id("newTab"));
		String mainID = driver.getWindowHandle();
		
		newTab.click();
		Set<String> windowIDs = driver.getWindowHandles();
		for (String ID : windowIDs) {
			System.out.println(ID);
		}
		
		Iterator<String> ids = windowIDs.iterator();
		String firstID = ids.next();
		String secondID = ids.next();
		
		driver.switchTo().window(secondID);
		String secondWindowText = driver.findElement(By.xpath("//h1[text()='New Tab']")).getText();
		System.out.println(secondWindowText);
		driver.close();
		driver.switchTo().window(firstID);
		String mainWindowText = driver.findElement(By.xpath("//h3[text()='Browser Windows']")).getText();
		System.out.println(mainWindowText);
		
		if(driver.getWindowHandle().equals(mainID)) {
			System.out.println("ID - PASS");
		} else {
			System.out.println("ID - FAIL");
		}
		
		driver.quit();
	}
	
	public static void inClassTask() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		
		WebElement newTabBtn = driver.findElement(By.id("newTab"));
		String mainWindowID = driver.getWindowHandle();
		
		newTabBtn.click();
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> ids = windowIDs.iterator();
		String firstWindowID = ids.next();
		String secondWindowID = ids.next();
		
		if(firstWindowID.equals(mainWindowID)) {
			System.out.println("Main ID - PASS");
		} else {
			System.out.println("Main ID - FAIL");
		}
		
		driver.switchTo().window(secondWindowID);
		WebElement secondNewTabBtn = driver.findElement(By.id("newTab"));
		if(secondNewTabBtn.isDisplayed()) {
			System.out.println("2nd New Tab Button - PASS");
		} else {
			System.out.println("2nd New Tab Button - FAIL");
		}
		
		driver.close();
		driver.switchTo().window(firstWindowID);
		if(driver.getWindowHandle().equals(mainWindowID)) {
			System.out.println("On Main - PASS");
		} else {
			System.out.println("On Main - FAIL");
		}
		
		driver.quit();
	}
}
