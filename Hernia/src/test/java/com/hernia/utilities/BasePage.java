package com.hernia.utilities;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BasePage extends Constants{

	public static WebDriver driver;
	public static UtilityLibrary myLib;
	private static JavaPropertiesManager property;
	private static String browser;
	public static ExcelRead excelRead; 
	public static ExcelWrite excelWrite; 


	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@BeforeClass
	public static void beforeAllTestStart() throws Exception {
		property = new JavaPropertiesManager("src/test/resources/config.properties");
		browser = property.readProperty("browserType");
		myLib = new UtilityLibrary(driver);
		if (property.readProperty("isDemoMode").contains("true")) {
			myLib.isDemoMode = true;
		} else {
			myLib.isDemoMode = false;
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@BeforeMethod
	public void beforeEachTest(Method caller) throws Exception {

		driver = myLib.startLocalBrowser(browser);
		excelRead = new ExcelRead(Constants.ExcelFile);		
		excelWrite = new ExcelWrite(Constants.ExcelFile);
		System.out.println("*** Test Started ***");
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@AfterMethod
	public void afterEachTest(ITestResult testResult) throws Exception {

		if (testResult.getStatus() == ITestResult.FAILURE) {

		 ScreenshotRule.takeScreenshot(driver, testResult.getName());
		}
		myLib.customWait(3);
		System.out.println("*** Test Ended ***");
		driver.close();
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@AfterClass
	public static void afterAllTest() {
		if (driver != null) {
			driver.quit();
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}