package com.capstone.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Capstone.pages.AddToCard;
import com.Capstone.pages.CheckOut;
import com.Capstone.pages.FinishBttn;
import com.Capstone.pages.Info;
import com.Capstone.pages.LandingPage;
import com.Capstone.pages.VerrifyMsg;

public class ScenarioFiveTest extends BaseTest {
	@Test
	public void SorHighLow() {
		// Enter the username – ‘standard_user
		LandingPage landingpage = new LandingPage(driver);
		landingpage.entertext("standard_user");
		// password ‘secret_sauce’
		landingpage.enterPassword("secret_sauce");
		// and then click on Login button.
		landingpage.ClickLogin();
		// You will see a list of products. Add the first and third products to the
		// cart.
		AddToCard addtocard = new AddToCard(driver);
		addtocard.BackPack();
		addtocard.BuyTwoItem();
		// Now remove the first product from the cart.
		// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		addtocard.Remove();
		// Click on cart icon at top right corner.
		addtocard.ClickCardBttn();
		// Verify the text ‘Your Cart’ is displayed at the top left corner of the page.
		VerrifyMsg verrifyMsg = new VerrifyMsg(driver);
		String expecteTitle = "Your Cart";
		String actualTitle = verrifyMsg.Title();
		Assert.assertEquals(actualTitle, expecteTitle);
		// Click on ‘Continue Shopping’ button.
		verrifyMsg.ContBttn();
		// Sort the prices from high to low.
		Select DropDwn = new Select(
				driver.findElement(By.xpath("//select[contains(@class,'product_sort_container')]")));
		DropDwn.selectByVisibleText("Price (high to low)");

		// Add the most expensive item to the cart.
		addtocard.HighPrice();
		// Click on cart icon.
		addtocard.ClickCardBttn();
		// Now verify that there are 2 items in the cart.
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

		// Click on ‘Checkout’ button.
		CheckOut checkout = new CheckOut(driver);
		checkout.clickcheckout();
		// Enter your first name in ‘First Name’ textbox.
		Info info = new Info(driver);
		info.FistName("Mehdi");
		// Enter your last name in ‘Last Name’ textbox.
		info.LastName("Modabbir");
		// Enter Postal Code in ‘Postal Code’ textbox.
		info.PostalCode("2343");
		// Click on ‘Continue’ button.
		info.Continue();
		// Click on ‘Finish’ button on the next page.
		FinishBttn finish = new FinishBttn(driver);
		finish.ClickFinish();
		// Verify the success message – ‘Thank you for your order!’ is displayed to the
		// user.
		String expectedThank = "Thank you for your order!";
		String actualThank = verrifyMsg.SuccOrder();
		Assert.assertEquals(actualThank, expectedThank);
	}
}
