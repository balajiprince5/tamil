package com.Runner;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.basefiles.BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//com.features//FeatureOne.feature", glue = "com.stepdefintion", monochrome=true, 
plugin={"pretty","html:Reports/htmlreport.html","json:Reports/jsonreport.json","junit:Reports/junitreport.xml"})
public class Runner {
	public static WebDriver driver;
	@BeforeClass
	public static void setUp() {
		driver = BaseClass.browserLaunch("chrome");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("all done");
//		BaseClass.deleteCookies();
//		BaseClass.quit();
	}
}
