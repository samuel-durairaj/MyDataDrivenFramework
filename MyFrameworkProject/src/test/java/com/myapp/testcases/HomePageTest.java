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

public class HomePageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
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
	public void homePageValidationTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.loggedInAsUserLabel();
		Assert.assertTrue(result);
	}
}
