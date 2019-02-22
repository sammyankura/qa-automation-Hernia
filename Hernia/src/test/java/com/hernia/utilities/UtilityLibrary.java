package com.hernia.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.google.common.base.Function;


public class UtilityLibrary {
	private WebDriver driver;
	public boolean isDemoMode;
	public JavascriptExecutor js;

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// Constructor
	public UtilityLibrary(WebDriver _driver) {
		driver = _driver;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method starts Firefox browser
	 * 
	 * @return driver
	 */
	private WebDriver startFirefoxBrowser() {
		try {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return driver;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method starts Gecko browser
	 * 
	 * @return driver
	 */
	private WebDriver startGeckoBrowser() {
		try {
			System.setProperty("webdriver.gecko.driver", "/Users/user/Desktop/DesktopFolder/geckodriver");			
			
			FirefoxOptions options = new FirefoxOptions().setLogLevel(Level.INFO);
			DesiredCapabilities capabilities = options.addTo(DesiredCapabilities.firefox());
// 			capabilities.setCapability("marionette", true);
			capabilities = options.addTo(capabilities);
			
			
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile("default");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return driver;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method starts IE browser
	 * 
	 * @return driver
	 */
	private WebDriver startIEBrowser() {
		try {
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities().internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return driver;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method starts Chrome browser
	 * 
	 * @return driver
	 */
	private WebDriver startChromeBrowser() {
		try {
			ChromeOptions options =new ChromeOptions();
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.popups", 0);
			options.addArguments("disable-extensions");
			prefs.put("credentials_enable_service", false);
			prefs.put("password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("chrome.switches","--disable-extensions");
			options.addArguments("--test-type");
			options.addArguments("start-maximized");
//			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			driver = new ChromeDriver(cap);	
			options.addArguments("disable-infobars");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			options.addArguments("start-fullscreen");
//			driver.manage().window().maximize();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return driver;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method starts a Headless Chrome browser
	 * 
	 * @return driver
	 */
	private WebDriver startHeadlessChromeBrowser() throws IOException{

        try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

			// Add options to Google Chrome. The window-size is important for responsive sites
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");

			driver = new ChromeDriver(options);
			return driver;
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return driver;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method starts user defined browser
	 * 
	 * @param browserName
	 * @return driver
	 */
	public WebDriver startLocalBrowser(String browserName) {
		try {
			if (browserName.equals("IE")) {
				driver = startIEBrowser();
			} else if (browserName.equals("Chrome")) {
				driver = startChromeBrowser();
			} /*else if (browserName.equals("Firefox")) {
				driver = startGeckoBrowser();
			}*/ else if (browserName.equals("HeadlessChrome")) {
				driver = startHeadlessChromeBrowser();
			} else {
				throw new Exception("You chose '" + browserName + "', Currently "
						+ "supporing browsers are 'IE, Firefox & Chrome' !");
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return driver;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method handles browser check-box element
	 * 
	 * @param checkBoxLocator
	 * @param isChecked
	 */
	public void handleCheckBox(By checkBoxLocator, boolean isChecked) {
		try {
			WebElement CheckBoxElem = driver.findElement(checkBoxLocator);
			highlightElement(CheckBoxElem);
			boolean userCheckboxState = CheckBoxElem.isSelected();
			if (isChecked == true)// user wants to select
			{
				if (userCheckboxState == true)// default selected
				{
					// do nothing
				} else // default Not selected
				{
					CheckBoxElem.click();
				}
			} else // user do Not want to select
			{
				if (userCheckboxState == true) // default selected
				{
					CheckBoxElem.click();
				} else {
					// do nothing
				}
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method waits for user given seconds
	 * 
	 * @param inSeconds
	 */
	public void customWait(int inSeconds) {
		try {
			Thread.sleep(inSeconds * 1000);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method enters user defined text to text field web-element
	 * 
	 * @param by
	 * @param textValue
	 */
	public void enterTextField(By by, String textValue) {
		try {
			WebElement textFieldElem = driver.findElement(by);
			highlightElement(textFieldElem);
			textFieldElem.clear();
			textFieldElem.sendKeys(textValue);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method clicks any user given element
	 * 
	 * @param by
	 */
	public void clickElement(By By) {
		try {
			WebElement element = driver.findElement(By);
			highlightElement(element);
			element.click();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void clickEnter(By by){
		try {
			WebElement element = driver.findElement(by);
			highlightElement(element);
			element.sendKeys(Keys.ENTER);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void clickTab(By by){
		try {
			WebElement element = driver.findElement(by);
			highlightElement(element);
			element.sendKeys(Keys.TAB);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void softAssert(boolean condition) {
		try {
			SoftAssert softAssertion = new SoftAssert();
			softAssertion.assertTrue(condition);
			softAssertion.assertAll();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public String captureScreenshot(String screenshotFileName, String filePathToSave) {
		String finalImage = null;
		try {
			String screenshotFileNamePath = filePathToSave + screenshotFileName + getCurrentTime() + ".png";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File(screenshotFileNamePath));
			finalImage = screenshotFileNamePath;
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		System.out.println("Screenshot captured: '" + finalImage + "'");
		return finalImage;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method calculates current time and returns the value
	 * 
	 * @return String current time-stamp
	 */
	public String getCurrentTime() {
		String finalTimeStamp = null;
		try {
			Date date = new Date();
			String tempTime = (new Timestamp(date.getTime())).toString();
			finalTimeStamp = tempTime.replace(":", "").replace(".", "").replace(" ", "");
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return finalTimeStamp;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * This method is used for dynamic element search
	 * 
	 * @param by
	 * @return
	 */
	public WebElement fluentWait(final By by) {
		WebElement targetElem = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
					.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			targetElem = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					highlightElement(by);
					return driver.findElement(by);
				}
			});
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
			// throw new Exception("fluent wait method failed.");
		}
		return targetElem;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/***
	 * This method waits until an element is visible
	 *  
	 */
	public void waitUntilElementVisible(By by){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));

		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	protected void highlightElement(By by) {
		try {
			if (isDemoMode == true) {
				for (int i = 0; i < 3; i++) {
					WrapsDriver wrappedElement = (WrapsDriver) driver.findElement(by);
					JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
					customWait(1);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", driver.findElement(by),
							"color: red; border: 2px solid yellow;");
					customWait(1);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", driver.findElement(by), "");
				}
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method waits until all Angular elements have loaded
	 */
	public void untilAngularFinishHttpCalls() {
		final String javaScriptToLoadAngular = "var injector = window.angular.element('body').injector();"
				+ "var $http = injector.get('$http');" + "return ($http.pendingRequests.length === 0)";

		ExpectedCondition<Boolean> pendingHttpCallsCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(javaScriptToLoadAngular).equals(true);
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 20); // timeout = 20 secs
		wait.until(pendingHttpCallsCondition);
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/***
	 * This method highlights the element that an action will be performed on
	 * 
	 * @param element
	 */
	public void highlightElement(WebElement element) {
		try {
			if (isDemoMode == true) {
				for (int i = 0; i < 1; i++) {
					WrapsDriver wrappedElement = (WrapsDriver) element;
					JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
					customWait(1);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
							"color: red; border: 2px solid yellow;");
					customWait(1);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
				}
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/***
	 * This method double clicks an element
	 * 
	 * @param by
	 */
	public void doubleClickElement(WebElement by){
		try {
			Actions action = new Actions(driver);
			action.moveToElement(by).doubleClick().build().perform();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/***
	 * This method selects items from a Drop Down Menu by looking at the visible
	 * text that a user specifies
	 * 
	 * @param by
	 * @param enterValue
	 */
	public void selectDropDownMenuVisibleText (By by,String enterValue){
		try {
			waitUntilElementVisible(by);
			WebElement element = driver.findElement(by);
			Select selectElement = new Select(element);
			highlightElement(element);
			selectElement.selectByVisibleText(enterValue);
			customWait(1);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}		
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/***
	 * This method selects items from a Drop Down Menu by looking at the Value
	 * that a user specifies
	 * 
	 * @param by
	 * @param enterValue
	 */
	public void selectDropDownMenuValue (By by,String enterValue){
		try {
			WebElement element = driver.findElement(by);
			Select selectElement = new Select(element);
			highlightElement(element);
			selectElement.selectByValue(enterValue);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}		
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/***
	 * This method selects items from a Drop Down Menu by looking at the index
	 * that a user specifies
	 * 
	 * @param by
	 * @param enterValue
	 */
	public void selectDropDownMenuByIndex (By by,int enterIndex){
		try {
			WebElement element = driver.findElement(by);
			Select selectElement = new Select(element);
			highlightElement(element);
			selectElement.selectByIndex(enterIndex);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}		
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/***
	 * This method Refreshes the page
	 * 
	 */
	public void refreshPage(){
		driver.navigate().to(driver.getCurrentUrl());
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/***
	 * This method selects items from a Drop Down Menu by looking at the visible
	 * text that a user specifies
	 * 
	 * @param by
	 * @param enterText
	 */
	public void bootStrapDropDown(By by, String enterText) {
		try {
//			customWait(1);
			List<WebElement> dropDownMenu = driver.findElements(by);
			for (int i = 0; i < dropDownMenu.size(); i++) {
				WebElement option = dropDownMenu.get(i);
//			System.out.println(element.getText());		
				String innerHtml = option.getAttribute("innerHTML");			
				if (option.getText().contains(enterText)) {
					option.click();
					break;
				}
			}
			customWait(1);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/***
	 * This method scrolls Element into View
	 */

	public void scrollElementIntoView(By by) {
		try {
			WebElement element = driver.findElement(by);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/***
	 * This method scrolls either Up or Down
	 * to scroll UP, the value needs to be positive. Example: 1900
 	 * to scroll DOWN, the value needs to be negative. Example: -1900
	 */

	public void scrollUpOrDown(By by,int enterHorizontalValue, int enterVerticalValue) {
		try {
			WebElement element = driver.findElement(by);
			js.executeScript("window.scrollBy(" + enterHorizontalValue +"," + enterVerticalValue+");");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void elementNotVisible(By by){
		
		WebElement element = driver.findElement(by);
		
		if(!element.isDisplayed()) {
			softAssert(true);
			System.out.println(element.getText());
		}else {
			softAssert(false);
			System.out.println(element.getText());
		}	
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public boolean isElementPresent(By by) {
	    try {
	        driver.findElement(by);
	        return true;
	    } catch 
	    (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void hoverOverElement(By by){
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(by);
		action.moveToElement(we).build().perform();	
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
