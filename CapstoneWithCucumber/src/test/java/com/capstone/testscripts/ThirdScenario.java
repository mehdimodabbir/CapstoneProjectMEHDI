package com.capstone.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.Capstone.pages.AddToCard;
import com.Capstone.pages.CheckOut;
import com.Capstone.pages.Info;
import com.Capstone.pages.LandingPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ThirdScenario {
	WebDriver driver;
	LandingPage landingpage;
	AddToCard addtocard;
	Info info;

	@Given("the user is on the https:\\/\\/www.saucedemo.com\\/ webpage")
	public void the_user_is_on_the_https_www_saucedemo_com_webpage() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "resource//chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@When("A user enter the username problem_user")
	public void a_user_enter_the_username_problem_user() {
		landingpage = new LandingPage(driver);
		landingpage.entertext("problem_user");
	}

	@When("A user enter the password secret_sauce in the webpage")
	public void a_user_enter_the_password_secret_sauce_in_the_webpage() {
		landingpage.enterPassword("secret_sauce");
	}

	@When("A user click on the login button of page")
	public void a_user_click_on_the_login_button_of_page() {
		landingpage.ClickLogin();
	}

	@When("User add the 1st product to the cart")
	public void user_add_the_1st_product_to_the_cart() {
		addtocard = new AddToCard(driver);
		addtocard.BackPack();
	}

	@When("The user click further on the cart icon top right corner")
	public void the_user_click_further_on_the_cart_icon_top_right_corner() {
		addtocard.ClickCardBttn();
	}
	@When("The user click on checkout button")
	public void the_user_click_on_checkout_button() {
		CheckOut checkout = new CheckOut(driver);
		checkout.clickcheckout();
	}

	@When("User enter the First Name")
	public void user_enter_the_first_name() {
		info = new Info(driver);
		info.FistName("Mehdi");
	}

	@When("User enter the Last Name")
	public void user_enter_the_last_name() {
		info.LastName("Modabbir");
	}

	@When("user enter the Postal code")
	public void user_enter_the_postal_code() {
		info.PostalCode("2353");
	}

	@When("User click on the continue button")
	public void user_click_on_the_continue_button() {
		info.Continue();
	}

	@When("Error messeged occured Error: Last Name is required")
	public void error_messeged_occured_error_last_name_is_required() {
		landingpage.getErrMsg();
	}

	@Then("close the webpage")
	public void close_the_webpage() {
		driver.quit();
	}

}
