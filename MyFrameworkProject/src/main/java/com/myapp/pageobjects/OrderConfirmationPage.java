package com.myapp.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.myapp.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
}
