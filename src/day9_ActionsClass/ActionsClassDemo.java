package day9_ActionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		//actionsDemo();
		dragAndDropDemo();
	}
	
	public static void actionsDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("https://etsy.com");
		
		Actions action = new Actions(driver);
		
		WebElement jewelryAccessories = driver.findElement(By.id("catnav-primary-link-10855"));
		action.moveToElement(jewelryAccessories).build().perform();
		
		WebElement bagsPurses = driver.findElement(By.id("side-nav-category-link-10865"));
		wait.until(ExpectedConditions.elementToBeClickable(bagsPurses));
		action.moveToElement(bagsPurses).build().perform();
		
		WebElement shoulderBags = driver.findElement(By.id("catnav-l4-10869"));
		wait.until(ExpectedConditions.elementToBeClickable(shoulderBags));
		action.moveToElement(shoulderBags).build().perform();
		shoulderBags.click();
		
		WebElement shoulderHeader = driver.findElement(By.xpath("//h1[text()='Shoulder Bags']"));
		if(shoulderHeader.isDisplayed()) {
			System.out.println("Shoulder Bag Header - PASS");
		} else {
			System.out.println("Shoulder Bag Header - FAIL");
		}
		
		driver.quit();
	}
	
	public static void dragAndDropDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		
		Actions action = new Actions(driver);
		
		WebElement dropzone = driver.findElement(By.id("dropzone"));
		WebElement text = driver.findElement(By.id("text"));
		
		action.dragAndDrop(text, dropzone).build().perform();
		
		driver.quit();
	}
}
