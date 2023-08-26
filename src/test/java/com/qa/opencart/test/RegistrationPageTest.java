package com.qa.opencart.test;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;
import com.qa.opencart.Utility.ExcelUtil;
import com.qa.opencart.constant.AppConstant;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void RegistrationPageSetup() {
		loginpage.selectLogin();
		registrationpage = loginpage.navigateToRegistrationPage();
	}

	@DataProvider
	public Object[][] getRegTestData() {
		Object[][] regData = ExcelUtil.getTestData(AppConstant.REGISTER_SHEET_NAME);
		return regData;
	}

	@Test(dataProvider= "getRegTestData")
	public void registerUserTest(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {
		registrationpage.registerUser(firstName, lastName, email, telephone, password,
			subscribe);
	}
}
