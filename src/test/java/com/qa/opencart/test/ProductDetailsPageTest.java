package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;

public class ProductDetailsPageTest extends BaseTest{
	
	@BeforeClass
	public void ProductDetailsPageSetup() {
		accountloginpage = loginpage.selectLogin();
		accountloginpage.loginIntoAccount(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"macbook","MacBook"},
			{"macbook","MacBook Air"},
			{"macbook","MacBook Pro"},
			{"samsung","Samsung SyncMaster 941BW"},
			{"samsung","Samsung Galaxy Tab 10.1"},
			{"iMac","iMac"},
		};
	}

	@Test(priority = 1, dataProvider ="productData")
	public void searchProductTest(String searchKey, String productName) {
		//accountloginpage.loginIntoAccount(prop.getProperty("username"), prop.getProperty("password"));
		productinfopage = accountloginpage.searchProduct(searchKey);
		if (productinfopage.productSearchResutlCount() > 0) {
			productdetailspage = productinfopage.selectProduct(productName);
			String actprodHead = productdetailspage.productHeader();
			Assert.assertEquals(actprodHead, productName);
		}
	}
	@Test(priority=2, dataProvider ="productData")
	public void getProductImagesCountTest(String searchKey, String productName) {
		productinfopage = accountloginpage.searchProduct(searchKey);
		productdetailspage = productinfopage.selectProduct(productName);
		productdetailspage.getProductImagesCount();
	}
	@Test(priority=3, dataProvider ="productData")
	public void productInfoTest(String searchKey, String productName) {
		productinfopage = accountloginpage.searchProduct(searchKey);
		productdetailspage = productinfopage.selectProduct(productName);
		productdetailspage.productInfo();
	}
}
