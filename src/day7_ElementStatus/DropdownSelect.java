package day7_ElementStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownSelect {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		//dropdownDemo();
		//nonSelectDropdown();
		alertDemo();
	}
	
	public static void dropdownDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
				
		WebElement dropdownBox = driver.findElement(By.id("searchDropdownBox"));
		Select select = new Select(dropdownBox);
		
		WebElement firstOption = select.getFirstSelectedOption();
		System.out.println(firstOption.getText());
		
		select.selectByVisibleText("Home & Kitchen");
		Thread.sleep(2000);
		select.selectByIndex(1);
		Thread.sleep(2000);
		select.selectByValue("search-alias=stripbooks");
		
		List<WebElement> allOptions = select.getOptions();
		
		System.out.println(allOptions.size());
		
		for (WebElement option : allOptions) {
			System.out.println(option.getText());
		}
		
		driver.quit();
	}
	
	public static void nonSelectDropdown() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		
		WebElement dropdown = driver.findElement(By.xpath("(//div[@class='ui fluid selection dropdown'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(dropdown));
		dropdown.click();
		
		WebElement mattOption = driver.findElement(By.xpath("//div[@data-value='matt']"));
		wait.until(ExpectedConditions.visibilityOf(mattOption));
		mattOption.click();
		
		driver.quit();
	}
	
	public static void alertDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		WebElement confirmAlert = driver.findElement(By.id("confirm"));
		WebElement promptAlert = driver.findElement(By.id("prompt"));
		
		confirmAlert.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		promptAlert.click();
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.sendKeys("TESTING");
		Thread.sleep(2000);
		alert2.dismiss();
		
		driver.quit();
	}
}
