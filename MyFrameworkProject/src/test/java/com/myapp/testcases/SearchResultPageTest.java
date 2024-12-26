package com.myapp.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myapp.base.BaseClass;
import com.myapp.pageobjects.HomePage;
import com.myapp.pageobjects.IndexPage;
import com.myapp.pageobjects.LoginPage;
import com.myapp.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod (groups= {"Smoke","Sanity","Regression"})
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod (groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test (groups={"Regression","Sanity"})
	public void productAvailabilityTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		searchResultPage = homePage.ClickProductsLink();
		boolean searchWaterMarkLabel = searchResultPage.isSearchWaterMarkLabel();
		Assert.assertTrue(searchWaterMarkLabel);
		searchResultPage.enterSearchText("Men Tshirt");
		searchResultPage.clickSubmitSearch();
		searchResultPage.mouseHoverTheProduct();
//		boolean productAvl = searchResultPage.isProductAvailable();
//		Assert.assertTrue(productAvl);
//		searchResultPage.clickOnProduct();
//		boolean addToCartModalConfirmationMsg=searchResultPage.addToCartConfirmationMessage();
//		Assert.assertTrue(addToCartModalConfirmationMsg);
//		searchResultPage.clickViewCartModal();
	}
}
