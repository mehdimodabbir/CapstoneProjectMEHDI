package com.capstone.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Capstone.pages.LandingPage;

public class ScenarioTwoTest extends BaseTest {

	@Test
	public void verifyErrMsg() {

		// Enter the username – ‘locked_out_user’ in the ‘Username’ textbox.
		LandingPage landingpage = new LandingPage(driver);
		landingpage.entertext("locked_out_user");
		// Enter password ‘secret_sauce’ in the ‘Password’ textbox.
		landingpage.enterPassword("secret_sauce");
		// Click on Login button.
		landingpage.ClickLogin();
		// Verify the error message – ‘Epic sadface: Sorry, this user has been locked
		// out.’ is displayed on the web-page
		String expectedErrMsg = "Epic sadface: Sorry, this user has been locked out.";
		String actualErrMsg = landingpage.getErrMsg();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}
}