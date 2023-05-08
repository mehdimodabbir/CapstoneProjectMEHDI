package com.Capstone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishBttn {
	@FindBy (id = "finish")
	private WebElement finishBttn;
	
	public FinishBttn( WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void ClickFinish() {
		finishBttn.click();
	}

}
