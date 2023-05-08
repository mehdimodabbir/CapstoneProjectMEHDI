package com.Capstone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Info {
	
	@FindBy (id = "first-name")
	private WebElement FistName;
	
	@FindBy (id = "last-name")
	private WebElement LastName;
	
	@FindBy (id = "postal-code")
	private WebElement PostalCode;
	
	@FindBy (id = "continue")
	private WebElement Continue;
	
	public Info(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void FistName(String Fist) {
		FistName.sendKeys(Fist);
	}
	
	public void LastName(String Last) {
		LastName.sendKeys(Last);
	}
	public void PostalCode(String code) {
		PostalCode.sendKeys(code);
	}
	public void Continue () {
		Continue.click();
	}

}
