package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utility.Utility;
import com.qa.opencart.constant.AppConstant;

public class ProductDetailsPage {

	private static final boolean WebElement = false;
	private WebDriver driver;
	private Utility util;
	private By productHeading = By.cssSelector("div.col-sm-4 h1");
	private By Images = By.cssSelector("ul.thumbnails li");
	private By metaData = By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[position()=1]/li");
	private By metPrice = By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[position()=2]/li");
	private Map<String, String> productInfo;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		util = new Utility(driver);
	}

	public String productHeader() {
		String prodHeading = util.getElement(productHeading).getText();
		System.out.println("product heading is ::-" + prodHeading);
		return prodHeading;
	}

	public int getProductImagesCount() {
		int imageList = util.waitVisibilityofElements(Images, AppConstant.DEFAULT_TIME_OUT).size();
		System.out.println("product images count is :-" + imageList);
		return imageList;
	}
	
	
	
	public void productInfo() {
		productInfo = new LinkedHashMap<String, String>();
		getHeader();
		getProductData();
		getProductPrice();
	}
	
	private void getHeader() { //header
		productInfo = new LinkedHashMap<String, String>();
		productInfo.put("product info", productHeader());
		}

	private void getProductData() {  // metadata
		productInfo = new LinkedHashMap<String, String>();
		List<WebElement> productData = util.waitForVisibiliyOfAllElements(metaData, AppConstant.DEFAULT_TIME_OUT);
		for (WebElement e : productData) {
			String prdData = e.getText();
			String metaInfo[] = prdData.split(":");
			String key = metaInfo[0].trim();
			String value = metaInfo[1].trim();
			productInfo.put(key, value);
		}
	}

	private void getProductPrice() { //metaprice	
		productInfo = new LinkedHashMap<String, String>();
		List<WebElement> productPrice = util.waitForVisibiliyOfAllElements(metPrice, AppConstant.DEFAULT_TIME_OUT);
		for (WebElement e : productPrice) {
			String prdPrc = e.getText();
		String price = productPrice.get(0).getText();
		String ExTax= productPrice.get(0).getText();
		String tax= prdPrc.split(":")[0].trim();
		productInfo.put("product price", price);
		System.out.println("product price is :-"+ price);
		productInfo.put("ExTax", tax);
		System.out.println("product tax is :-"+ tax);
		}
	}
}
