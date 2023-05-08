package com.capstone.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Capstone.pages.AddToCard;
import com.Capstone.pages.CheckOut;
import com.Capstone.pages.FinishBttn;
import com.Capstone.pages.Info;
import com.Capstone.pages.LandingPage;
import com.Capstone.pages.VerrifyMsg;

public class ScenarioOneTest extends BaseTest {
	@Test
	public void buyBackPack() {
		// 4)Enter the username – ‘standard_user’
		LandingPage landingpage = new LandingPage(driver);
		landingpage.entertext("standard_user");
		landingpage.enterPassword("secret_sauce");
		landingpage.ClickLogin();

		// 7)You will see a list of products. Add the first 2 products to the cart.
		AddToCard addproduct = new AddToCard(driver);
		addproduct.ClicCard2();
		addproduct.BackPack();
		// Click on the cart icon at top right corner.
		addproduct.ClickCardBttn();
		// 9)Click on ‘Checkout’ button.
		CheckOut checkout = new CheckOut(driver);
		checkout.clickcheckout();
		// 10)Enter your first name in ‘First Name’ textbox.
		Info info = new Info(driver);
		info.FistName("Mehdi");
		// 11)Enter your last name in ‘Last Name’ textbox.
		info.LastName("Modabbir");
		// 12)Enter Postal Code in ‘Postal Code’ textbox.
		info.PostalCode("2342");
		// 13)Click on ‘Continue’ button.
		info.Continue();
		// 14)Click on ‘Finish’ button on the next page.
		FinishBttn finishBttn = new FinishBttn(driver);
		finishBttn.ClickFinish();
		// 15)Verify the success message – ‘Your order has been dispatched, and will

		VerrifyMsg verrifyMsg = new VerrifyMsg(driver);

		String exepctedSuccessMsg = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actualSuccessMsg = verrifyMsg.Msg();
		Assert.assertEquals(actualSuccessMsg, exepctedSuccessMsg);
	}
}
