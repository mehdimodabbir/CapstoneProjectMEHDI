package com.capstone.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class FourthScenario {
	WebDriver driver;
	LandingPage landingpage;
	AddToCard addtocard;
	VerrifyMsg verrifyMsg;
	Info info;

	@Given("The user is on the main webpage")
	public void the_user_is_on_the_main_webpage() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "resource//chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@When("The user enter with his\\/her username")
	public void the_user_enter_with_his_her_username() {
		landingpage = new LandingPage(driver);
		landingpage.entertext("standard_user");
	}

	@When("The user enter his\\/her password")
	public void the_user_enter_his_her_password() {
		landingpage.enterPassword("secret_sauce");
	}

	@When("the User click on login button further")
	public void the_user_click_on_login_button_further() {
		landingpage.ClickLogin();
	}

	@When("the User sort the item based on price Low_to_High")
	public void the_user_sort_the_item_based_on_price_low_to_high() {
		addtocard = new AddToCard(driver);
		Select DropDwn = new Select(
				driver.findElement(By.xpath("//select[contains(@class,'product_sort_container')]")));
		DropDwn.selectByVisibleText("Price (low to high)");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//select[contains(@class,'product_sort_container')]")));
	}

	@When("User add the first itme to the cart")
	public void user_add_the_first_itme_to_the_cart() {

		// Add the first item to cart.
		AddToCard addToCardLow = new AddToCard(driver);
		addToCardLow.LowPriceBtn();
	}

	@When("the user verrify the selected product")
	public void the_user_verrify_the_selected_product() {
		WebElement confirmationMsg = driver.findElement(By.id("item_2_title_link"));
		String confirmationTxt = confirmationMsg.getText();

		if (confirmationTxt.contains("Sauce Labs Onesie")) {
			System.out.println("Correct");
		} else
			System.out.println("wrong selection");
	}

	@When("Click on the checkout button")
	public void click_on_the_checkout_button() {
		addtocard.ClickCardBttn();
		CheckOut checkout = new CheckOut(driver);
		checkout.clickcheckout();
	}

	@When("User enter Fist Name")
	public void user_enter_fist_name() {
		info = new Info(driver);
		info.FistName("mehdi");
	}

	@When("User Enter Last Name")
	public void user_enter_last_name() {
		info.LastName("Modabbir");
	}

	@When("User enter the postal code")
	public void user_enter_the_postal_code() {
		info.PostalCode("2343");

	}

	@When("User click on the continue button to the page")
	public void user_click_on_the_continue_button_to_the_page() {
		info.Continue();
	}

	@When("User click on Finish button")
	public void user_click_on_finish_button() {
		FinishBttn finishbutton = new FinishBttn(driver);
		finishbutton.ClickFinish();
	}

	@When("User veriffy the usccess message Thank you for your order!")
	public void user_veriffy_the_usccess_message_thank_you_for_your_order() {
		verrifyMsg = new VerrifyMsg(driver);
		String expectedMsg = "Thank you for your order!";
		String actualMsg = verrifyMsg.SuccOrder();
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@Then("user close the browser")
	public void user_close_the_browser() {
		driver.quit();
	}

}
