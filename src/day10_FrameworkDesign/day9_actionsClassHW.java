package day10_FrameworkDesign;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class day9_actionsClassHW {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		
		dragdrop();
	}
	
	public static void dragdrop() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		
		Actions action = new Actions(driver);
		
		WebElement dragDrop = driver.findElement(By.xpath("//h3[text()='Drag And Drop']"));
		WebElement dropZone = driver.findElement(By.id("dropzone"));
		WebElement text = driver.findElement(By.id("text"));
		WebElement textArea = driver.findElement(By.id("textarea"));
		WebElement number = driver.findElement(By.id("Number"));
		
		if(dragDrop.isDisplayed()) {
			System.out.println("Drag & Drop - PASS");
		} else {
			System.out.println("Drag & Drop - FAIL");
		}
		
		action.dragAndDrop(text, dropZone).build().perform();
		action.dragAndDrop(textArea, dropZone).build().perform();
		action.dragAndDrop(number, dropZone).build().perform();
		
		List<WebElement> trash = driver.findElements(By.className("bi-trash"));
		for (WebElement button : trash) {
			button.click();
		}
		Thread.sleep(2000);
		
		driver.quit();
	}
}
