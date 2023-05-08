package com.Capstone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	// private WebElement BackPackTshirt = driver.findElement(By.id(user-name));

	@FindBy(id = "user-name")

	private WebElement username;

	@FindBy(id = "password")
	private WebElement Pass;

	@FindBy(id = "login-button")
	private WebElement Login;

	@FindBy(xpath = "//h3[contains(@data-test,'error')]")
	private WebElement ErrMsg;

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void entertext(String user) {
		username.sendKeys(user);
	}
	public void enterPassword(String Passid) {
		Pass.sendKeys(Passid);
	}

	public void ClickLogin() {
		Login.click();}
		
	public String getErrMsg() {
		String message = ErrMsg.getText();
		return message;
	}
		
	}
