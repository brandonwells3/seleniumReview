package day9_ActionsClass;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class day8_HWReview {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		//guru99();
		iframeHW();
	}
	
	public static void guru99() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/popup.php");
		
		WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
		String mainTitle = driver.getTitle();
		String email = "test@gmail.com";
		
		clickHere.click();
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> iterator = windowIDs.iterator();
		String mainWindowID = iterator.next();
		String secondWindowID = iterator.next();
		driver.switchTo().window(secondWindowID);
		
		WebElement emailField = driver.findElement(By.name("emailid"));
		WebElement submitBtn = driver.findElement(By.name("btnLogin"));
		
		emailField.sendKeys(email);
		submitBtn.click();
		
		String userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		String password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		System.out.println(userID);
		System.out.println(password);
		
		String ACaccessText = driver.findElement(By.xpath("//h3[text()='This access is valid only for 20 days.']")).getText();
		String EXaccessText = "This access is valid only for 20 days.";
		if(ACaccessText.equals(EXaccessText)) {
			System.out.println("Access Text - PASS");
		} else {
			System.out.println("Access Text - FAIL");
		}
		
		driver.close();
		driver.switchTo().window(mainWindowID);
		if(driver.getTitle().equals(mainTitle)) {
			System.out.println("Title - PASS");
		} else {
			System.out.println("Title - FAIL");
		}
		
		driver.quit();
	}
	
	public static void iframeHW() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/frames");
		
		WebElement iframe = driver.findElement(By.id("iframe1"));
		
		String ACheaderText = driver.findElement(By.xpath("//h3[text()='Frames']")).getText();
		String EXheaderText = "Frames";
		if(ACheaderText.equals(EXheaderText)) {
			System.out.println("Header - PASS");
		} else {
			System.out.println("Header - FAIL");
		}
		
		driver.switchTo().frame(iframe);
		
		WebElement firstNameField = driver.findElement(By.id("firstName"));
		WebElement lastNameField = driver.findElement(By.id("lastName"));
		WebElement addressField = driver.findElement(By.id("address"));
		WebElement cityField = driver.findElement(By.id("city"));
		WebElement stateField = driver.findElement(By.id("state"));
		WebElement zipField = driver.findElement(By.id("zipCode"));
		WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
		
		Select select = new Select(stateField);
		
		String firstName = "Test";
		String lastName = "Name";
		String address = "12345 Test Street";
		String city = "Testville";
		String state = "Virginia";
		String zip = "54321";
		
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		addressField.sendKeys(address);
		cityField.sendKeys(city);
		select.selectByVisibleText(state);
		zipField.sendKeys(zip);
		submitBtn.click();
		
		String ACsubmitHeader = driver.findElement(By.xpath("//h3[text()='You have submited below information:']")).getText();
		String EXsubmitHeader = "You have submitted below information:";
		if(ACsubmitHeader.equals(EXsubmitHeader)) {
			System.out.println("Submit Header - PASS");
		} else {
			System.out.println("Submit Header - FAIL");
		}
		
		driver.switchTo().parentFrame();
		if(ACheaderText.equals(EXheaderText)) {
			System.out.println("Header - PASS");
		} else {
			System.out.println("Header - FAIL");
		}
		
		driver.quit();
	}
}
