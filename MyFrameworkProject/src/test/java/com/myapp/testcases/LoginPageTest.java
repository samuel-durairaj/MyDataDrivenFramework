package com.myapp.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myapp.base.BaseClass;
import com.myapp.dataprovider.DataProviders;
import com.myapp.pageobjects.HomePage;
import com.myapp.pageobjects.IndexPage;
import com.myapp.pageobjects.LoginPage;
import com.myapp.utility.Log;

public class LoginPageTest extends BaseClass{

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
	
	@Test(dataProvider="credentials", dataProviderClass=DataProviders.class, groups= {"Smoke","Sanity"})
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("LoginTest");
		indexPage = new IndexPage();
		Log.info("User is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Log.info("Enter username and password");
		//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    homePage=loginPage.login(uname,pswd);
		String actualURL = homePage.getCurrURL();
		String expectedURL = "https://www.automationexercise.com/";
		Log.info("Verifying if user is able to login successfully");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is success");
		Log.endTestCase("LoginTest");
	}
}
