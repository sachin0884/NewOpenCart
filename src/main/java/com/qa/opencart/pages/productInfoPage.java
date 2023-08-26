package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utility.Utility;
import com.qa.opencart.constant.AppConstant;

public class productInfoPage {
	
	private WebDriver driver;
	private Utility util;
	private By productlocator = By.cssSelector("div .product-layout"); 

	public productInfoPage(WebDriver driver) {
	 this.driver= driver;
	 util = new Utility(driver);
	}
	
	public int productSearchResutlCount() {
     int productcount= util.waitVisibilityofElements(productlocator, AppConstant.DEFAULT_TIME_OUT).size();
		System.out.println("Product count is :- "+productcount);
		return productcount; 
	}
	
	public ProductDetailsPage selectProduct(String productName) {
	By productlocator= By.linkText(productName);
		util.waitVisibilityOfElement(productlocator, AppConstant.DEFAULT_TIME_OUT).click();
		return new ProductDetailsPage(driver);
	}
    
	
}
