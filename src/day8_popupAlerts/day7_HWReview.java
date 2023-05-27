package day8_popupAlerts;

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

public class day7_HWReview {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		//amazonSelect();
		//alertTest();
		//amazonDropdown();
		//test1();
		//test2();
		test4();
	}
	
	public static void amazonSelect() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
		
		Select select = new Select(dropdown);
				
		String ACtitle = driver.getTitle();
		String EXtitle = "Amazon.com. Spend less. Smile more.";
		String ACfirstOption = select.getFirstSelectedOption().getText();
		String EXfirstOption = "All Departments";
		
		if(ACtitle.equals(EXtitle)) {
			System.out.println("Title - PASS");
		} else {
			System.out.println("Title - FAIL");
		}
		if(ACfirstOption.equals(EXfirstOption)) {
			System.out.println("All - PASS");
		} else {
			System.out.println("All - FAIL");
		}
		
		select.selectByVisibleText("Home & Kitchen");
		search.sendKeys("coffee mug");
		searchBtn.click();
		
		WebElement dropdown2 = driver.findElement(By.id("searchDropdownBox"));
		Select select2 = new Select(dropdown2);
		
		String ACcoffeeTitle = driver.getTitle();
		String EXcoffeeTitle = "Amazon.com : coffee mug";
		String AChomeOption = select2.getFirstSelectedOption().getText();
		String EXhomeOption = "Home & Kitchen";
		
		if(ACcoffeeTitle.equals(EXcoffeeTitle)) {
			System.out.println("Coffee Title - PASS");
		} else {
			System.out.println("Coffee Title - FAIL");
		}
		if(AChomeOption.equals(EXhomeOption)) {
			System.out.println("Home - PASS");
		} else {
			System.out.println("Home - FAIL");
		}
		
		driver.quit();
	}
	
	public static void alertTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		WebElement promptAlert = driver.findElement(By.id("prompt"));
		String promptAlertText = "PrimeTech";
		
		promptAlert.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(promptAlertText);
		alert.accept();
		
		String ACgreeting = driver.findElement(By.id("demo")).getText();
		String EXgreeting = "Hello "+promptAlertText+"! How are you today?";
		if(ACgreeting.equals(EXgreeting)) {
			System.out.println("Greeting - PASS");
		} else {
			System.out.println("Greeting - FAIL");
		}
		
		driver.quit();
	}
	
	public static void amazonDropdown() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select select = new Select(dropdown);
		List<WebElement> dropdownOptions = select.getOptions();
		String EXlistSize = "58";
		
		int size = dropdownOptions.size();
		String AClistSize = Integer.toString(size);
		
		if(AClistSize.equals(EXlistSize)) {
			System.out.println("58 - PASS");
		} else {
			System.out.println("58 - FAIL");
		}
				
		for (WebElement option : dropdownOptions) {
			System.out.println(option.getText());
		}
		
		driver.quit();
	}
	
	public static void test1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		WebElement alertBtn = driver.findElement(By.id("alert"));
		
		alertBtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.quit();
	}
	
	public static void test2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		WebElement confirmBtn = driver.findElement(By.id("confirm"));
		String EXalertText = "Do you wish to continue or cancel?";
		
		confirmBtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String ACalertText = alert.getText();
		
		if(ACalertText.equals(EXalertText)) {
			System.out.println("ACCEPTED");
			alert.accept();
		} else {
			System.out.println("CANCELED");
			alert.dismiss();
		}
		
		driver.quit();
	}
	
	public static void test4() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		
		WebElement promptAlertBtn = driver.findElement(By.id("prompt"));
		String promptText = "PrimeTech";
		String EXresponse = "User cancelled the prompt.";
		
		promptAlertBtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(promptText);
		alert.dismiss();
		
		String ACresponse = driver.findElement(By.id("demo")).getText();
		if(ACresponse.equals(EXresponse)) {
			System.out.println("Response - PASS");
		} else {
			System.out.println("Response - FAIL");
		}
		
		driver.quit();
	}
}
