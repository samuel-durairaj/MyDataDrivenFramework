package com.myapp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapp.actiondriver.Action;
import com.myapp.base.BaseClass;

public class CheckoutPage extends BaseClass {

	@FindBy (xpath = "//*[text()='Place Order']")
	WebElement PlaceOrderButton;
	
	public CheckoutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickPlaceOrderButton() {
		Action.click(getDriver(), PlaceOrderButton);
	}
}
