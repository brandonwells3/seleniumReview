package day7_ElementStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day6_HWReview {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		//radioButtonHW();
		//checkBoxHW();
		//amazonHW();
		ebayTest();
	}
	
	public static void radioButtonHW() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/radio-button");
		
		List<WebElement> radioButtons = driver.findElements(By.cssSelector(".form-check-input"));
		
		for (WebElement singleRadio : radioButtons) {
			if(singleRadio.isDisplayed() && singleRadio.isEnabled()) {
				if(singleRadio.isSelected()) {
					System.out.println("Button - SELECTED");
				} else {
					singleRadio.click();
					System.out.println("Button - NOW SELECTED");
				}
			} else {
				System.out.println("Button - FAIL");
			}
			System.out.println("Button Selected?: "+singleRadio.isSelected());
			Thread.sleep(1000);
		}
		
		driver.quit();
	}
	
	public static void checkBoxHW() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/check-box");
		
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".form-check-input"));
		
		for (WebElement singleBox : checkBoxes) {
			if(singleBox.isDisplayed()) {
				if(singleBox.isEnabled()) {
					if(singleBox.isSelected()) {
						System.out.println("Check Box - SELECTED");
					} else {
						singleBox.click();
						if(singleBox.isSelected()) {
							System.out.println("Check Box - JUST SELECTED");
						} else {
							System.out.println("Check Box - FAIL");
						}
					}
				} else {
					System.out.println("Check Box - NOT ENABLED");
				}
			} else {
				System.out.println("Check Box - NOT DISPLAYED");
			}
		}
		
		driver.quit();
	}
	
	public static void amazonHW() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
		WebElement verifySignIn = driver.findElement(By.xpath("//h1[contains(text(),'Sign in')]"));
		WebElement createAccount = driver.findElement(By.id("createAccountSubmit"));
		WebElement verifyCreateAccount = driver.findElement(By.xpath("//h1[contains(text(),'Create account')]"));
		WebElement continueBtn = driver.findElement(By.id("continue"));
		WebElement nameError = driver.findElement(By.xpath("//div[contains(text(),'Enter your name')]"));
		WebElement emailError = driver.findElement(By.xpath("//div[contains(text(),'Enter your email')]"));
		WebElement passwordError = driver.findElement(By.xpath("//div[contains(text(),'Minimum 6 characters required')]"));
		
		
		signIn.click();
		
		if(verifySignIn.isDisplayed()) {
			System.out.println("On Sign in Page 1 - PASS");
		} else {
			System.out.println("On Sign in Page 1 - FAIL");
		}
		
		driver.navigate().back();
		driver.navigate().forward();
		
		if(verifySignIn.isDisplayed()) {
			System.out.println("On Sign in Page 2 - PASS");
		} else {
			System.out.println("On Sign in Page 2 - FAIL");
		}
		
		createAccount.click();
		
		if(verifyCreateAccount.isDisplayed()) {
			System.out.println("On Create account Page 1 - PASS");
		} else {
			System.out.println("On Create account Page 1 - FAIL");
		}
		
		driver.navigate().back();
		
		if(verifySignIn.isDisplayed()) {
			System.out.println("On Sign in Page 3 - PASS");
		} else {
			System.out.println("On Sign in Page 3 - FAIL");
		}
		
		driver.navigate().forward();
		
		if(verifyCreateAccount.isDisplayed()) {
			System.out.println("On Create account Page 2 - PASS");
		} else {
			System.out.println("On Create account Page 2 - FAIL");
		}
		
		continueBtn.click();
		
		if(nameError.isDisplayed()) {
			if(nameError.getText().equals("Enter your name")) {
				System.out.println("Name - PASS");
			} else {
				System.out.println("Name - INCORRECT TEXT");
			}
		} else {
			System.out.println("Name - FAIL");
		}
		
		if(emailError.isDisplayed()) {
			if(emailError.getText().equals("Enter your email or mobile phone number")) {
				System.out.println("Email - PASS");
			} else {
				System.out.println("Email - INCORRECT TEXT");
			}
		} else {
			System.out.println("Email - FAIL");
		}
		
		if(passwordError.isDisplayed()) {
			if(passwordError.getText().equals("Minimum 6 characters required")) {
				System.out.println("Password - PASS");
			} else {
				System.out.println("Password - INCORRECT TEXT");
			}
		} else {
			System.out.println("Password - FAIL");
		}
		
		driver.quit();
	}
	
	public static void ebayTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ebay.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("coffee mug");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
		List<WebElement> ebayPrices = driver.findElements(By.cssSelector(".s-item__price"));
		ebayPrices.remove(0);
		
		int x = 1;
		for (WebElement ebayItem : ebayPrices) {
			System.out.println("Item "+x+" Price: "+ebayItem.getText());
			x++;
		}
		
		driver.quit();
	}
}
