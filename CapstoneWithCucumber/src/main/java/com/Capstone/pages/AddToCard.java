package com.Capstone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCard {

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement BackPack;
	@FindBy(id ="add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement BuyTwoItem;

	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement BikeLight;
	
	@FindBy(xpath= "//a[contains(@class, 'shopping_cart_link')]")
	private WebElement CardBttn;
	
	@FindBy (xpath = "//select[contains(@class,'product_sort_container')]") ////select[contains(@class,'product_sort_container')]
	private WebElement SortLowHigh;
	
	@FindBy (id = "add-to-cart-sauce-labs-onesie")
	private WebElement LowPriceBttn;
	
	@FindBy (id = "remove-sauce-labs-bolt-t-shirt")
	private WebElement Removeproduct;
	
	@FindBy (id = "add-to-cart-sauce-labs-fleece-jacket")
	private WebElement HighPrice;

	public AddToCard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void BackPack() {
		BackPack.click();
	}

	public void ClicCard2() {
		BikeLight.click();
	}
	public void ClickCardBttn() {
		CardBttn.click();
	}
	
public void SortBttn() {
	SortLowHigh.click();
}
public void LowPriceBtn() {
	LowPriceBttn.click();
}
public void BuyTwoItem() {
	BuyTwoItem.click();
}
public void Remove() {
	Removeproduct.click();
}

public void HighPrice() {
	HighPrice.click();
}
}
