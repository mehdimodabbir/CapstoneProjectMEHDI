package com.capstone.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	WebDriver driver;

	@BeforeClass
	public void LunchApplication() {
		driver = new ChromeDriver();
		// Go to https://www.saucedemo.com/
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}
