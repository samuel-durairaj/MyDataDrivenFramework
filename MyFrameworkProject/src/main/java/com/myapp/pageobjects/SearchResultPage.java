package com.myapp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myapp.actiondriver.Action;
import com.myapp.base.BaseClass;

public class SearchResultPage extends BaseClass {

	@FindBy(xpath="//*[@id='search_product']")
	WebElement SearchWatermarkText;
	
	@FindBy(xpath="//*[@id='submit_search']")
	WebElement SubmitSearch;
	
	@FindBy(xpath="/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]/div/p")
	WebElement MenTShirtProduct;
	
	@FindBy(xpath="//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
	WebElement ViewCartModal;
	
	@FindBy(xpath="//*[text()='Your product has been added to cart.']")
	WebElement AddToCartConfirmationMessage;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
    
	public boolean searchWaterMarkLabel() {
		return Action.isDisplayed(driver, SearchWatermarkText);
	}
	
	public void enterSearchText(String enterText) {
		Action.type(SearchWatermarkText, enterText);
	}
	
	public void clickSubmitSearch() {
		Action.click(driver, SubmitSearch);
	}
	
	public AddToCartPage clickViewCartModal() throws Throwable {
		Action.click(driver, ViewCartModal);
		return new AddToCartPage();
	}
	
	public boolean isProductAvailable(WebElement MenTShirtProduct) throws Throwable{
		return Action.isDisplayed(driver, MenTShirtProduct);
	}
	
	public void clickOnProduct() throws Throwable{
		Action.click(driver, MenTShirtProduct);
	}
	
	public boolean addToCartConfirmationMessage() {
		return Action.isDisplayed(driver, AddToCartConfirmationMessage);
	}
}
