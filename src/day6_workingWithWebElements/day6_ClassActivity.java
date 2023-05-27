package day6_workingWithWebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day6_ClassActivity {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		//navigateActivity();
		//listElement();
		elementStatus();
	}
	
	public static void navigateActivity() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("coffee mug");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.navigate().back();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("pretty coffee mug");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		driver.quit();
	}
	
	public static void listElement() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://saucedemo.com");
		
		String username = "standard_user";
		String password = "secret_sauce";
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item"));
		int listSize = items.size();
		System.out.println(listSize);
		
		List<WebElement> itemPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
		for (int i = 0; i < itemPrices.size(); i++) {
			System.out.println(itemPrices.get(i).getText());
		}
		
		driver.quit();
	}
	
	public static void elementStatus() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://indeed.com");
		
		WebElement whatField = driver.findElement(By.id("text-input-what"));
		WebElement whereField = driver.findElement(By.id("text-input-where"));
		
		if(whatField.isDisplayed() && whatField.isEnabled()) {
			System.out.println("What Field - PASS");
		} else {
			System.out.println("What Field - FAIL");
		}
		if (whereField.isDisplayed() && whereField.isEnabled()) {
			System.out.println("Where Field - PASS");
		} else {
			System.out.println("Where Field - FAIL");
		}
		
		driver.quit();
	}
}
