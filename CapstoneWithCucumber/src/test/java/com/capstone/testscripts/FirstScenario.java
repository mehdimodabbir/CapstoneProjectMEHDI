package com.capstone.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.Capstone.pages.AddToCard;
import com.Capstone.pages.CheckOut;
import com.Capstone.pages.FinishBttn;
import com.Capstone.pages.Info;
import com.Capstone.pages.LandingPage;
import com.Capstone.pages.VerrifyMsg;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstScenario {
	WebDriver driver;
	LandingPage landingpage;
	AddToCard addtocard;
	Info info;

	@Given("A user is on the landing page of saucedemo")
	public void a_user_is_on_the_landing_page_of_saucedemo() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "resource//chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@When("Enter the username standard_user")
	public void enter_the_username_standard_user() {
		landingpage = new LandingPage(driver);
		landingpage.entertext("standard_user");
	}

	@When("password secret_sauce")
	public void password_secret_sauce() {
		landingpage.enterPassword("secret_sauce");
	}

	@When("click on Login button")
	public void click_on_login_button() {
		landingpage.ClickLogin();
	}

	@When("Add the first two products to the cart from list")
	public void add_the_first_two_products_to_the_cart_from_list() {
		addtocard = new AddToCard(driver);
		addtocard.BackPack();
		addtocard.ClicCard2();
	}

	@When("click on the cart icon at top right corner")
	public void click_on_the_cart_icon_at_top_right_corner() {
		addtocard.ClickCardBttn();
	}

	@When("Click on Checkout button")
	public void click_on_checkout_button() {
		CheckOut checkout = new CheckOut(driver);
		checkout.clickcheckout();
	}

	@When("Enter your first name in First Name textbox")
	public void enter_your_first_name_in_first_name_textbox() {
		info = new Info(driver);
		info.FistName("Mehdi");
	}

	@When("nter your last name in Last Name textbox")
	public void nter_your_last_name_in_last_name_textbox() {
		info.LastName("Modabbir");
	}

	@When("Enter Postal Code in Postal Code textbox")
	public void enter_postal_code_in_postal_code_textbox() {
		info.PostalCode("1243");
	}

	@When("Click on Continue button")
	public void click_on_continue_button() {
		info.Continue();
	}

	@When("Click on Finish button on the next page")
	public void click_on_finish_button_on_the_next_page() {
		FinishBttn finishBttn = new FinishBttn(driver);
		finishBttn.ClickFinish();
	}

	@When("Verify the success message Your order has been dispatched and will arrive just as fast as the pony can get there!")
	public void verify_the_success_message_your_order_has_been_dispatched_and_will_arrive_just_as_fast_as_the_pony_can_get_there() {
		VerrifyMsg verrifyMsg = new VerrifyMsg(driver);
		String expectedMsg = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actualMsg = verrifyMsg.Msg();
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@Then("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}

}
