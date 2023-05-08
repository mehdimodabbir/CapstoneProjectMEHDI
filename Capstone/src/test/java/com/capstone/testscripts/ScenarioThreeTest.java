package com.capstone.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Capstone.pages.AddToCard;
import com.Capstone.pages.CheckOut;
import com.Capstone.pages.Info;
import com.Capstone.pages.LandingPage;

public class ScenarioThreeTest extends BaseTest {
	@Test
	public void VerryMsgDisp() {

		LandingPage landingpage = new LandingPage(driver);
		// Enter the username – ‘problem_user’
		landingpage.entertext("problem_user");
		// password ‘secret_sauce’ and then click on Login button
		landingpage.enterPassword("secret_sauce");
		// click on the login-button
		landingpage.ClickLogin();

		// You will see a list of products. Add the 1st product to the cart
		AddToCard addtocard = new AddToCard(driver);
		addtocard.BackPack();
		// Click on the cart icon at top right corner.
		addtocard.ClickCardBttn();
		// Click on ‘Checkout’ button.
		CheckOut checkout = new CheckOut(driver);
		checkout.clickcheckout();
		Info info = new Info(driver);
		// Enter your first name in ‘First Name’ textbox.
		info.FistName("Mehdi");
		// Enter your last name in ‘Last Name’ textbox.
		info.LastName("Modabbir");
		// Enter Postal Code in ‘Postal Code’ textbox.
		info.PostalCode("3233");
		// Click on ‘Continue’ button.
		info.Continue();

		// You will see the ‘Last Name’ text-box gets emptied automatically and an error
		// message is displayed. Verify the error message – ‘Error: Last Name is
		// required’ is displayed to the user.
		LandingPage landingpageErr = new LandingPage(driver);
		String expectedErrMsg = "Error: Last Name is required";
		String actualErrMsg = landingpageErr.getErrMsg();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}
}
