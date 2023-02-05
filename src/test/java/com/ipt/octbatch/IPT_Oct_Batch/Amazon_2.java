
package com.ipt.octbatch.IPT_Oct_Batch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_2 {

	public static void main(String[] args) throws InterruptedException, Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\WELCOME\\eclipse-workspace\\MiniProject\\Driver\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String dropInput = XLSXReader.singleData("AMAZON", 11, 0);
		String searchInput = XLSXReader.singleData("AMAZON", 11, 1);
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		Select s = new Select(dropDown);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();
			if (dropInput.equalsIgnoreCase(text)) {
				s.selectByVisibleText(text);
			}
		}

		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys(searchInput);
		Thread.sleep(2000);

		List<WebElement> allElements = driver.findElements(
				By.xpath("//div[@class='autocomplete-results-container']/child::div/child::div/child::div"));

		for (int i = 1; i <= allElements.size(); i++) {
			WebElement eachElement = driver.findElement(By.xpath(
					"//div[@class='autocomplete-results-container']/child::div[" + i + "]/child::div/child::div"));
			String text = eachElement.getText();
			if (searchInput.equalsIgnoreCase(text)) {
				eachElement.click();
				break;
			} else {
				continue;
			}
		}
	}

}
