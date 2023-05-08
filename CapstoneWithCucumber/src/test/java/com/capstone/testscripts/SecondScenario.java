package com.capstone.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.Capstone.pages.LandingPage;
import com.Capstone.pages.VerrifyMsg;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SecondScenario {

	WebDriver driver;
	LandingPage landingpage;
	VerrifyMsg verrifyMsg;

	@Given("The user should navigate to the website https:\\/\\/www.saucedemo.com")
	public void the_user_should_navigate_to_the_website_https_www_saucedemo_com() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "resource//chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@When("A user enter the username locked_out_user in the username")
	public void a_user_enter_the_username_locked_out_user_in_the_username() {
		landingpage = new LandingPage(driver);
		landingpage.entertext("locked_out_user");
	}

	@When("A user enter the required password secret_sauce")
	public void a_user_enter_the_required_password_secret_sauce() {
		landingpage.enterPassword("secret_sauce");
	}

	@When("A user click on the login button")
	public void a_user_click_on_the_login_button() {
		landingpage.ClickLogin();
	}

	@When("A user verrify the message Epic sadface: Sorry, this user has been locked out.")
	public void a_user_verrify_the_message_epic_sadface_sorry_this_user_has_been_locked_out() {
		String expectedErrMsg = "Epic sadface: Sorry, this user has been locked out.";
		String actualErrMsg = landingpage.getErrMsg();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}

	@Then("close the application")
	public void close_the_application() {
		driver.quit();
	}

}
