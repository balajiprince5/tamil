package com.basefiles;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

	//while copying base class to other project change the path in browserLaunch and capture

	public class BaseClass{
		public static WebDriver driver;
		
	public static  WebDriver browserLaunch(String browserType) {						// Browser Launch
		switch (browserType.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox" : 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge" : 
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:System.out.println("not compatable with this browser -> "+ browserType);
			break;
		}
		
		return driver;
	}
	
	public static void launchUrl(String url) {											// URL Launch
		driver.get(url);
	}
	
	public static void maximize() {													// Maximize Screen
		driver.manage().window().maximize();
	}
	
	public static void implicitlyWait(int waitTime) {									// Implicitly Wait
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}
	
	public static String getTitle() {													// Print Title
		return driver.getTitle();
	}
	public static String getCurrentUrl() {												// Print URL
		return driver.getCurrentUrl();
	}
	
	public static String windowHandle() {												// Get Single Window Handle
		return driver.getWindowHandle();
	}
	
	public static Set<String> windowHandles() {											// Get Multiple Window Handles
		return driver.getWindowHandles();
	}
	
	public static void navigateTO(String URL) {											// Navigate TO
		driver.navigate().to(URL);
	}
	
	public static void navigateOthers(String option) {									// Navigate Back / Forward / Refresh
		switch (option.toLowerCase()) {
		case "back":driver.navigate().back(); 
		break;
		case "forward":driver.navigate().forward();
		break;
		case "refresh":driver.navigate().refresh();
		break;
		default:System.out.println("Invalid Input - only back/ forward/ refresh");
			break;
		}
	}
	
	public static void deleteCookies() {												// Delete All Cookies
		driver.manage().deleteAllCookies();
	}
	
	public static void close() {														// Driver Close
		driver.close();
	}
	
	public static void quit() {															// Driver Quit
		driver.quit();
	}
	
	public static void clickOnElement(WebElement element) {								// Click Web-Element
		element.click();
	}

	public static void userInput(WebElement element, String value) {					// Send Keys
		element.sendKeys(value);
	}
	
	public static void clearElement(WebElement element) {								// Clear Input Region
		element.clear();
	}

	public static boolean isElementSelected(WebElement element) {						// Element is Selected or Not
		return element.isSelected();
	}

	public static boolean isElementDisplayed(WebElement element) {						// Element is Displayed or Not
		return element.isDisplayed();
	}

	public static boolean isElementEnabled(WebElement element) {						// Element is Enabled or Not
		return element.isEnabled();
	}

	public static String getText(WebElement element) {									// Print Text or Get Text
		return element.getText();
	}
	
	public static String getAttribute(WebElement element, String attributeName) {		// Get Attribute Value
		return element.getAttribute(attributeName);
	}
	
	public static void sleep(int milliSeconds) throws InterruptedException {			// Sleep
		Thread.sleep(milliSeconds);
	}
	
	public static void clickOnElementJS(WebElement element) {							// JS -Click
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void scrollByJS(int pixelRange) {										// JS - Scroll UP/DOWN By Pixels 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, "+pixelRange+");");
	}
	
	public static void scrollFullJS() {													// JS - Scroll Down to Page Bottom 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}
	
	public static void scrollToView(WebElement element) {								// JS - Scroll Until Visibility of Element
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollIntoView();", element);
	}
	
	public static void capture(String fileName) throws IOException {					// Takes Screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\WELCOME\\eclipse-workspace\\IPT_Project_Amazon\\ScreenShot-capture\\"+fileName+".png");
		FileUtils.copyFile(source, destination);
	}
	
	public static void frameSwitch(int index) {											// Frame Switch Based on Index
		driver.switchTo().frame(index);
	}
	
	public static void frameSwitch(WebElement element) {								// Frame Switch Based on WebElement
		driver.switchTo().frame(element);
	}
	
	public static void frameSwitch(String nameID) {										// Frame Switch Based on element name/ID
		driver.switchTo().frame(nameID);
	}
	
	public static void frameParent() {													// Switch to Parent Frame
		driver.switchTo().parentFrame();
	}
	
	public static void frameDefaultContent() {											// Switching to Default Content
		driver.switchTo().defaultContent();
	}
	
	public static void alertButton(String okOrCancel) {									// Alert(PopUp) Accept and Dismiss
		switch (okOrCancel.toLowerCase()) {
		case "ok":driver.switchTo().alert().accept();
			break;
		case "cancel":driver.switchTo().alert().dismiss();
			break;
		default: System.out.println("only Ok or Cancel is accepted");
			break;
		}
	}
	
	public static void alertSendKey(String value) {										// Alert(PopUp) Send Keys
		driver.switchTo().alert().sendKeys(value);
	}
	
	public static String alertPrintText() {												// Alert(PopUp) Get Text
		return driver.switchTo().alert().getText();
	}
	
	public static void dropDownSelect(WebElement element, String option, String value) {// Select By Value/Index/Text
		Select s = new Select(element);
		if (option.equalsIgnoreCase("value")) {s.selectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}else if (option.equalsIgnoreCase("index")) {
			int n = Integer.parseInt(value);
			s.selectByIndex(n);
		}
	}
	
	public static void dropDownDeselect(WebElement element, String option, String value) {// De-select By All/Value/Index/Text
		Select s = new Select(element);
		if (option.equalsIgnoreCase("value")) {s.deselectByValue(value);;
		} else if (option.equalsIgnoreCase("text")) {
			s.deselectByVisibleText(value);
		}else if (option.equalsIgnoreCase("all")) {
			s.deselectAll();
		}else if (option.equalsIgnoreCase("index")) {
			int n = Integer.parseInt(value);
			s.deselectByIndex(n);
		}
	}
	
	public static List<WebElement> dropDownGetOptions(WebElement element, String allORselected) {// Drop Down Get Multiple or All Options
		Select s = new Select(element);
		List<WebElement> options = null;
	switch (allORselected.toLowerCase()) {
	case "all":options = s.getOptions();
		break;
	case "selected":options = s.getAllSelectedOptions();
		break;
	}
	return options;
	}
	
	public static WebElement dropDownFirstSelected(WebElement element) {				// Dropdown get First selected option
		Select s = new Select (element);
		return s.getFirstSelectedOption();
	}
	
	public static boolean dropDownIsMultiple(WebElement element) {						// Drop Down Multiple or not
		Select s =  new Select(element);
		return s.isMultiple();
	}
	
	public static void actionClicks(WebElement element, String value) {					// Actions click, Double click, Right click
		Actions act = new Actions(driver);
		switch (value.toLowerCase()) {
		case "click":act.click(element).build().perform();
			break;
		case "double":act.doubleClick(element).build().perform();
			break;
		case "right":act.contextClick(element).build().perform();
			break;
		default:System.out.println("The acceptable inputs are click, right, double");
			break;
		}
	}
	
	public static void actionsMoveToElement(WebElement element) {						// Actions Move to Element
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public static void userInputActions(WebElement element, String value) {				// Actions Send Keys
		Actions act = new Actions(driver);
		act.sendKeys(element, value).build().perform();
	}
	
	public static void actionsDragAndDrop(WebElement drag, WebElement drop) {			// Actions Drag and Drop
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop);
	}
	
	public static void actionHold(WebElement element) {									// Actions Click and Hold
		Actions act = new Actions(driver);
		act.clickAndHold(element).build().perform();
	}
	
	public static void actionRelease(WebElement element) {								// Actions Release
		Actions act = new Actions(driver);
		act.release(element).build().perform();
	}
	
}
