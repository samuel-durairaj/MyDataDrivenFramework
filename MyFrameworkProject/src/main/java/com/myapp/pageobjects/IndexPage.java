package com.myapp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapp.actiondriver.Action;
import com.myapp.base.BaseClass;

//Page Objects in Page Class

public class IndexPage extends BaseClass{

	@FindBy(xpath="//img[@src='/static/images/home/logo.png']")
    WebElement HomePageLogo;
	
	@FindBy(xpath="//*[text()=\" Signup / Login\"]")
	WebElement LoginOrSignUpButton;
    
    //Using Constructor to initialise the webelements
    public IndexPage() {
    	PageFactory.initElements(driver, this);
    }
    
    public boolean validateLogo() throws Throwable{
    	return Action.isDisplayed(driver, HomePageLogo);
    }
    
    public String getHomePageTitle() {
    	String homePageTitle = driver.getTitle();
    	return homePageTitle;
    }
    
    public LoginPage clickOnSignIn() throws Throwable{
    	Action.click(driver, LoginOrSignUpButton);
    	return new LoginPage();
    }
}
