package com.stepdefintion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Runner.Runner;
import com.basefiles.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass{

	public static WebDriver driver = Runner.driver;
	static String searchIn;
//	static String dropInput;

	
	@Given("user Launch Browser")
	public void user_launch_browser() {
		launchUrl("https://www.amazon.in/");
		maximize();
		implicitlyWait(10);
	}
	@When("select {string} from Dropdown")
	public void select_from_dropdown(String dropInput) throws Exception {
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		List<WebElement> options =dropDownGetOptions(dropDown, "all");
		for (int i = 0; i < options.size(); i++) {
			String text = getText(options.get(i));
			if (dropInput.equalsIgnoreCase(text)) {
				dropDownSelect(dropDown, "text", text);
			}
		}
	}
	@Then("Send The Value {string}")
	public void send_the_value(String searchInput) throws Exception {
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		searchIn = searchInput;
		userInput(search, searchInput);
		sleep(2000);
	}
	@And("find The Exact Searchvalue In The Suggestion Click")
	public void find_the_exact_searchvalue_in_the_suggestion_click() {
		List<WebElement> allElements = driver.findElements(
				By.xpath("//div[@class='autocomplete-results-container']/child::div/child::div/child::div"));

		for (int i = 1; i <= allElements.size(); i++) {
			WebElement eachElement = driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/child::div[" + i + "]/child::div/child::div"));
			String text = getText(eachElement);
			if (searchIn.equalsIgnoreCase(text)) {
				clickOnElementJS(eachElement);
				break;
			}else continue;
		}
//			for (WebElement eachElement : allElements) {
//				String text = getText(eachElement);
//				if (searchIn.equalsIgnoreCase(text)) {
//					clickOnElement(eachElement);
//					break;
//			}
//		}
	}
}
