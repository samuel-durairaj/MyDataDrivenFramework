package com.myapp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapp.actiondriver.Action;
import com.myapp.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//a[text()=' Logout']")
	WebElement LogoutButton;
	
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	WebElement ProductsLink;
	
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/text()")
	WebElement LoggedAsUserLabel;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickLogoutButton() throws Throwable {
		Action.click(driver, LogoutButton);
		return new LoginPage();
	}
	   
    public SearchResultPage ClickProductsLink() throws Throwable{
    	Action.click(driver, ProductsLink);
    	return new SearchResultPage();
    }
    
    public boolean loggedInAsUserLabel() throws Throwable {
    	return Action.isDisplayed(driver, LoggedAsUserLabel);
    }
    
    public String getCurrURL() {
    	String currentURL = driver.getCurrentUrl();
    	return currentURL;
    }
}
