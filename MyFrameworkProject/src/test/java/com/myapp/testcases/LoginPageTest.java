package com.myapp.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myapp.base.BaseClass;
import com.myapp.pageobjects.HomePage;
import com.myapp.pageobjects.IndexPage;
import com.myapp.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void loginTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL = homePage.getCurrURL();
		String expectedURL = "https://www.automationexercise.com/";
		Assert.assertEquals(actualURL, expectedURL);
	}
}
