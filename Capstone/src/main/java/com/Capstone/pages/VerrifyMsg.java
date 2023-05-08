package com.Capstone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerrifyMsg {

	@FindBy(xpath = "//div[contains(@Class,'complete-text')]")
	private WebElement VerrifyMsg;

	@FindBy(xpath = "//div[contains(@class,'header_secondary_container')]//child::span")
	private WebElement Title;
	
	@FindBy (xpath = "//div[contains(@class,'error-message-container error')]//child::h3")
	private WebElement SuccMsg;
	
	@FindBy (xpath = "//div[contains(@class,'checkout_complete_container')]//child::h2")
	private WebElement SuccOrder;
	
	@FindBy(id = "continue-shopping")
	private WebElement ContShoping;

	public VerrifyMsg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String Msg() {
		String message = VerrifyMsg.getText();
		return message;

	}

	public String SuccMsg() {
		String Message = SuccMsg.getText();
		return Message;
	}

	public String Title() {
		String message = Title.getText();
		return message;
	}

	public void ContBttn() {
		ContShoping.click();
	}
	public String SuccOrder() {
	String Message =	SuccOrder.getText();
		return Message;
		

	}
	
		
	}

