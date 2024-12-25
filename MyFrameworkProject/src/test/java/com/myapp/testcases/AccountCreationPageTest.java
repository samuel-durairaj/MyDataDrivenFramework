package com.myapp.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myapp.base.BaseClass;
import com.myapp.dataprovider.DataProviders;
import com.myapp.pageobjects.AccountCreationPage;
import com.myapp.pageobjects.IndexPage;
import com.myapp.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	@BeforeMethod
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test (dataProvider="accountCreation", dataProviderClass=DataProviders.class)
	public void verifyCreateAccountPageTest(String name, String emailID) throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		//accountCreationPage = loginPage.signUp("samuel", "samuel86@mail.com");
		accountCreationPage = loginPage.signUp(name,emailID);
		boolean result = accountCreationPage.accountCreationHeaderTitle();
		Assert.assertTrue(result);
	}
}
