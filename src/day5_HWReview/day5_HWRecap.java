package day5_HWReview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day5_HWRecap {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		//textBoxTest();
		webTableTest();
	}
	
	public static void textBoxTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://practice.primetech-apps.com/practice/text-box");
		
		String firstName = "Test";
		String lastName = "Name";
		String email = "test@email.com";
		String password = "password";
		String address = "12345 Fake Street";
		
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(), 'Enable')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("address")).sendKeys(address);
		
		driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
		Thread.sleep(1000);
		
		String displayFirstName = driver.findElement(By.cssSelector(".firstName")).getText();
		String displayLastName = driver.findElement(By.cssSelector(".lastName")).getText();
		String displayEmail = driver.findElement(By.cssSelector(".email")).getText();
		String displayPassword = driver.findElement(By.cssSelector(".password")).getText();
		String displayAddress = driver.findElement(By.cssSelector(".address")).getText();
		
		System.out.println(displayFirstName);
		System.out.println(displayLastName);
		System.out.println(displayEmail);
		System.out.println(displayPassword);
		System.out.println(displayAddress);
		
		if(displayFirstName.equals(firstName)) {
			System.out.println("First Name PASS");
		} else {
			System.out.println("First Name FAIL");
		}
		if(displayLastName.equals(lastName)) {
			System.out.println("Last Name PASS");
		} else {
			System.out.println("Last Name FAIL");
		}
		if(displayEmail.equals(email)) {
			System.out.println("Email PASS");
		} else {
			System.out.println("Email FAIL");
		}
		if(displayPassword.equals(password)) {
			System.out.println("Password PASS");
		} else {
			System.out.println("Password FAIL");
		}
		if(displayAddress.equals(address)) {
			System.out.println("Address PASS");
		} else {
			System.out.println("Address FAIL");
		}
		
		driver.quit();
	}
	
	public static void webTableTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://practice.primetech-apps.com/practice/web-tables");
		
		String headerText = "Web Tables";
		String actualHeaderText = driver.findElement(By.xpath("//h3[text()='Web Tables']")).getText();
		if(actualHeaderText.equals(headerText)) {
			System.out.println("On Correct Page");
		} else {
			System.out.println("On INCORRECT Page");
		}
		
		String ID = "1";
		String firstName = "Test";
		String lastName = "Name";
		String salary = "120000";
		
		driver.findElement(By.cssSelector("#Id")).sendKeys(ID);
		driver.findElement(By.xpath("//input[@id='First Name']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='Last Name']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='Salary']")).sendKeys(salary);
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		Thread.sleep(1000);
		
		String actualID = driver.findElement(By.xpath("//td[text()='"+ID+"']")).getText();
		System.out.println(actualID);
		String actualFirstName = driver.findElement(By.xpath("//td[text()='"+firstName+"']")).getText();
		System.out.println(actualFirstName);
		String actualLastName = driver.findElement(By.xpath("//td[text()='"+lastName+"']")).getText();
		System.out.println(actualLastName);
		String actualSalary = driver.findElement(By.xpath("//td[text()='"+salary+"']")).getText();
		System.out.println(actualSalary);
		
		if(actualID.equals(ID)) {
			System.out.println("ID - PASS");
		} else {
			System.out.println("ID - FAIL");
		}
		if(actualFirstName.equals(firstName)) {
			System.out.println("First Name - PASS");
		} else {
			System.out.println("First Name - FAIL");
		}
		if(actualLastName.equals(lastName)) {
			System.out.println("Last Name - PASS");
		} else {
			System.out.println("Last Name - FAIL");
		}
		if(actualSalary.equals(salary)) {
			System.out.println("Salary - PASS");
		} else {
			System.out.println("Salary - FAIL");
		}
		
		driver.quit();
	}
}
