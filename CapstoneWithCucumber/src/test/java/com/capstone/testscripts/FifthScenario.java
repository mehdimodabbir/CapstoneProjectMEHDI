package com.capstone.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
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

public class FifthScenario {
	WebDriver driver;
	LandingPage landingpage;
	AddToCard addtocard;
	VerrifyMsg verrifyMsg;
	Info info;

	@Given("User should be on the WebPage")
	public void user_should_be_on_the_web_page() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "resource//chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@When("User type hi\\/her login username")
	public void user_type_hi_her_login_username() {
		landingpage = new LandingPage(driver);
		landingpage.entertext("standard_user");
	}

	@When("user type his\\/her password")
	public void user_type_his_her_password() {
		landingpage.enterPassword("secret_sauce");
	}

	@When("User could click on the green login button")
	public void user_could_click_on_the_green_login_button() {
		landingpage.ClickLogin();
	}

	@When("User add the first and third items to the cart")
	public void user_add_the_first_and_third_items_to_the_cart() {
		AddToCard addtocard = new AddToCard(driver);
		addtocard.BackPack();
		addtocard.BuyTwoItem();

	}

	@When("user should remove the first item from the cart")
	public void user_should_remove_the_first_item_from_the_cart() {
		addtocard = new AddToCard(driver);
		addtocard.Remove();
	}

	@When("user click on the right corner cart button")
	public void user_click_on_the_right_corner_cart_button() {
		addtocard = new AddToCard(driver);
		addtocard.ClickCardBttn();
	}

	@When("User verrify the title")
	public void user_verrify_the_title() {
		VerrifyMsg verrifyMsg = new VerrifyMsg(driver);
		String expecteTitle = "Your Cart";
		String actualTitle = verrifyMsg.Title();
		Assert.assertEquals(actualTitle, expecteTitle);
	}

	@When("user should be able click on continue button")
	public void user_should_be_able_click_on_continue_button() {
		verrifyMsg = new VerrifyMsg(driver);
		verrifyMsg.ContBttn();
	}

	@When("User Sort the items from High to Low")
	public void user_sort_the_items_from_high_to_low() {
		Select DropDwn = new Select(
				driver.findElement(By.xpath("//select[contains(@class,'product_sort_container')]")));
		DropDwn.selectByVisibleText("Price (high to low)");
	}

	@When("User add most expensive item to the cart")
	public void user_add_most_expensive_item_to_the_cart() {
		addtocard.HighPrice();
	}

	@When("User click on the cart icon")
	public void user_click_on_the_cart_icon() {
		addtocard.ClickCardBttn();
	}

	@When("Verrify there are two items added to cart")
	public void verrify_there_are_two_items_added_to_cart() {
		WebElement CardVerrify = driver.findElement(By.xpath("//div[contains(@class,'cart_list')]"));
		String ConfirmCard = CardVerrify.getText();

		if (ConfirmCard.contains("Sauce Labs Backpack")) {
			System.out.println("The back pack exist in the card");
		} else {
			System.out.println("BackPack doesn't exist in your card");
		}
		if (ConfirmCard.contains("Sauce Labs Fleece Jacket")) {
			System.out.println("The Fleece Jacket exist in the card");
		} else {
			System.out.println("Jacket dosen't exist in your card");
		}
	}

	@When("checkout button")
	public void checkout_button() {
		CheckOut checkout = new CheckOut(driver);
		checkout.clickcheckout();
	}
	@When("User enter fist_name")
	public void user_enter_fist_name() {
		info = new Info(driver);
		info.FistName("Mehdi");
	}

	@When("user Enter Last Name")
	public void user_enter_last_name() {

		info.LastName("Modabbir");

	}

	@When("user enter postal code")
	public void user_enter_postal_code() {
		info.PostalCode("3432");
	}

	@When("Click on the continue button")
	public void click_on_the_continue_button() {
		info.Continue();
	}

	@When("click on the finish button")
	public void click_on_the_finish_button() {
		FinishBttn finishbutton = new FinishBttn(driver);
		finishbutton.ClickFinish();
	}

	@When("Verrify the success message Thank you for your order!")
	public void verrify_the_success_message_thank_you_for_your_order() {
		verrifyMsg = new VerrifyMsg(driver);
		String expectedThank = "Thank you for your order!";
		String actualThank = verrifyMsg.SuccOrder();
		Assert.assertEquals(actualThank, expectedThank);
	}

	@Then("close the browser of sucedemo")
	public void close_the_browser_of_sucedemo() {
		driver.quit();
	}

}
