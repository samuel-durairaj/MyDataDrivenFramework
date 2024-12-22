package com.myapp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapp.actiondriver.Action;
import com.myapp.base.BaseClass;

public class AccountCreationPage extends BaseClass{

	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/div[1]/h2/b")
	WebElement AccountCreationHeaderTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean accountCreationHeaderTitle() throws Throwable {
		return Action.isDisplayed(driver, AccountCreationHeaderTitle);
	}
}
