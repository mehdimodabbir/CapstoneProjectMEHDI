package com.capstone.testscripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Capstone.pages.AddToCard;
import com.Capstone.pages.CheckOut;
import com.Capstone.pages.FinishBttn;
import com.Capstone.pages.Info;
import com.Capstone.pages.LandingPage;
import com.Capstone.pages.VerrifyMsg;

public class ScenarioFourTest extends BaseTest {
	@Test
	public void SortProduct() {
		// Enter the username – ‘standard_user
		LandingPage landingpage = new LandingPage(driver);
		landingpage.entertext("standard_user");
		// password ‘secret_sauce’
		landingpage.enterPassword("secret_sauce");
		// then click on Login button
		landingpage.ClickLogin();
		// Sort the items based on Price from low to high.
		Select DropDwn = new Select(
				driver.findElement(By.xpath("//select[contains(@class,'product_sort_container')]")));
		DropDwn.selectByVisibleText("Price (low to high)");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//select[contains(@class,'product_sort_container')]")));
		// Add the first item to cart.
		AddToCard addToCardLow = new AddToCard(driver);
		addToCardLow.LowPriceBtn();

		// Verify the same item which you selected on the previous page has been added
		// to cart.
		WebElement confirmationMsg = driver.findElement(By.id("item_2_title_link"));
		String confirmationTxt = confirmationMsg.getText();

		if (confirmationTxt.contains("Sauce Labs Onesie")) {
			System.out.println("Correct");
		} else
			System.out.println("wrong selection");
		// Click on ‘Checkout’ button.
		addToCardLow.ClickCardBttn();
		CheckOut checkout = new CheckOut(driver);
		checkout.clickcheckout();
		// Enter your first name in ‘First Name’ textbox.
		Info info = new Info(driver);
		info.FistName("Mehdi");
		// Enter your last name in ‘Last Name’ textbox.
		info.LastName("Modabbir");

		// Enter Postal Code in ‘Postal Code’ textbox.
		info.PostalCode("1234");

		// Click on ‘Continue’ button.
		info.Continue();

		// Click on ‘Finish’ button on the next page.
		FinishBttn finishBttn = new FinishBttn(driver);
		finishBttn.ClickFinish();

		// Verify the success message – ‘Thank you for your order!’ is displayed to the
		// user.
		VerrifyMsg verrifyMsg = new VerrifyMsg(driver);
		String expectedMsg = "Thank you for your order!";
		String actualMsg = verrifyMsg.SuccOrder();
		Assert.assertEquals(actualMsg, expectedMsg);
	}
}
