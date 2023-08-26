package com.qa.opencart.test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;
import com.qa.opencart.constant.AppConstant;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void AccountPageSetup() {
		accountloginpage = loginpage.selectLogin();

	}

	@Test(priority = 1)
	public void forgotPasswordTest() {
		boolean actuallink = accountloginpage.forgotPassword();
		Assert.assertTrue(actuallink, AppConstant.FORGOTPWD_LINK_VALUE);
	}

	@Test(priority = 2)
	public void getCurrentURLBefore() {
		accountloginpage.getCurrentURLBefore();
		Assert.assertTrue(
				accountloginpage.getCurrentURLBefore().contains(AppConstant.ACCOUNT_CURRENT_URL_BEFORE_VALUE));
	}

	@Test(priority = 3)
	public void loginIntoAccountTest() {
		accountloginpage.loginIntoAccount(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accountloginpage.getCurrentURLAfter().contains(AppConstant.ACCOUNT_CURRENT_URL_AFTER_VALUE));
	}

	@Test(priority = 4)
	public void headerListValueTest() {
		ArrayList<String> actualVal = accountloginpage.headerListValue();
		int length = actualVal.size();
		Assert.assertEquals(length, 4);
	}

	@Test(priority = 5)
	public void getHeaderCountTest() {
		int count2 = accountloginpage.getHeaderCount();
		Assert.assertEquals(count2, 4);
	}
	
	
}
