package day10_FrameworkDesign;

import pages.IndeedPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class BrowserUtilsDemo {
	public static void main(String[] args) {
		indeedTest();
	}
	
	static IndeedPage indeedpage;
	static BrowserUtils utils = new BrowserUtils();
	
	public static void indeedTest() {
		indeedpage = new IndeedPage();
		Driver.getDriver().get(DataReader.getProperty("indeedUrl"));
		utils.waitForElementVisible(indeedpage.whereField);
		utils.clearText(indeedpage.whereField);
		Driver.quitDriver();
	}
}
