package com.qa.opencart.test;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;
import com.qa.opencart.constant.AppConstant;

public class LoginPageTest extends BaseTest {

	@Test(priority=1)
	public void getLoginPageTitleTest() {
		String Acttitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(Acttitle, AppConstant.LOGIN_PAGE_TITLE_VALUE);
	}
	
//	@Test(priority=2)
//	public void clickOnMyAccountTest() {
//		loginpage.clickOnMyAccount();
//	}
	
	@Test(priority=2)
	public void selectLoginTest() {
		loginpage.selectLogin();
	}
	
	
	@Test(priority=3)
	public void getCurrentPageURLTest() {
		String Acturl= loginpage.getCurrentPageURL();
		Assert.assertTrue(Acturl.contains(AppConstant.LOGIN_PAGE_URL_VALUE));
	}

}
