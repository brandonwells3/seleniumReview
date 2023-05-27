package day10_FrameworkDesign;

import org.openqa.selenium.By;

import pages.FacebookPage;
import utils.DataReader;
import utils.Driver;

public class ReusableObjects {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/brandonwells3/Desktop/PrimeTechWork/SeleniumTools/ChromeDriver/chromedriver_mac_arm/chromedriver");
		ReusableObjects run = new ReusableObjects();
		run.testcase1();
	}
	
	FacebookPage fbPage;
		
	public void testcase1() {
		fbPage = new FacebookPage();
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		
		fbPage.facebookEmailField.sendKeys(DataReader.getProperty("facebookUsername"));
		fbPage.facebookPassField.sendKeys(DataReader.getProperty("facebookPassword"));
		fbPage.facebookLoginBtn.click();
		
		Driver.quitDriver();
	}
	
	public void testcase2() throws InterruptedException {	
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		Driver.getDriver().findElement(By.linkText("Create new account")).click();
		Thread.sleep(2000);
		
		Driver.getDriver().findElement(By.name("firstname")).sendKeys("Automation");
		Driver.getDriver().findElement(By.name("lastname")).sendKeys("Automation");
		Driver.getDriver().findElement(By.name("reg_email__")).sendKeys("Automation");
		Driver.getDriver().findElement(By.name("reg_passwd__")).sendKeys("Automation");
		
		Driver.getDriver().findElement(By.name("websubmit")).click();
		
		Driver.quitDriver();
	}
	
	public void getTextPractice() {
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		
		String loginText = Driver.getDriver().findElement(By.name("login")).getText();
		System.out.println("Text: " + loginText);
		if(loginText.equals("Log In")) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL!!!");
		}
		
		Driver.quitDriver();
	}
}
