
package com.ipt.octbatch.IPT_Oct_Batch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.basefiles.BaseClass;

public class Amazon_WithBase extends BaseClass{

	public static void main(String[] args) throws InterruptedException, Exception {
		browserLaunch("chrome");
		maximize();
		implicitlyWait(10);
		launchUrl("https://www.amazon.in/");

		String dropInput = XLSXReader.singleData("AMAZON", 11, 0);
		String searchInput = XLSXReader.singleData("AMAZON", 11, 1);
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		
		List<WebElement> options = dropDownGetOptions(dropDown, "all");
		for (int i = 0; i < options.size(); i++) {
			String text = getText(options.get(i));
			if (dropInput.equalsIgnoreCase(text)) {
				dropDownSelect(dropDown, "text", text);
			}
		}

		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		userInput(search, searchInput);
		sleep(2000);

		List<WebElement> allElements = driver.findElements(
				By.xpath("//div[@class='autocomplete-results-container']/child::div/child::div/child::div"));

		for (int i = 1; i <= allElements.size(); i++) {
			WebElement eachElement = driver.findElement(By.xpath(
					"//div[@class='autocomplete-results-container']/child::div[" + i + "]/child::div/child::div"));
			String text = getText(eachElement);
			if (searchInput.equalsIgnoreCase(text)) {
				clickOnElement(eachElement);
				break;
			} else {
				continue;
			}
		}
		deleteCookies();
		quit();
	}

}
