package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utility.Utility;
import com.qa.opencart.constant.AppConstant;

public class AccountLoginPage {

	private WebDriver driver;
	private Utility util;
	private By userName = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@class='btn btn-primary']");
	private By forgetPwd = By.linkText("Forgotten Password");
	private By headers = By.xpath("//div[@id='content']/h2");
	private By search= By.name("search");
	private By searchBtn = By.cssSelector("#search .btn.btn-default");
	
	// private By forgetPwd =
	// By.xpath("/div[@class='form-group']//a[contains(text(),'Forgotten
	// Password')]");

	public AccountLoginPage(WebDriver driver) {
		this.driver = driver;
		util = new Utility(driver);
	}

	public boolean forgotPassword() {
		boolean flag = util.getElement(forgetPwd).isDisplayed();
		String forgottext = util.getElement(forgetPwd).getText();
		System.out.println("forgot password text is :- " + forgottext);
		return flag;
	}

	public String getCurrentURLBefore() {
		String accountpageURL = driver.getCurrentUrl();
		System.out.println("Account page url is (before):- " + accountpageURL);
		return accountpageURL;
	}

	public void loginIntoAccount(String name, String pwd) {
		util.waitVisibleofElementClick(userName, AppConstant.DEFAULT_TIME_OUT);
		util.doSendkey(userName, name);
		util.doClick(password);
		util.doSendkey(password, pwd);
		util.doClick(loginBtn);
		// return new MyAccountPage(driver);
	}

	public String getCurrentURLAfter() {
		String accountpageURL = driver.getCurrentUrl();
		System.out.println("Account page url is (after) :- " + accountpageURL);
		return accountpageURL;
	}

	public ArrayList<String> headerListValue() {
		List<WebElement> headerslist = util.getElements(headers);
		ArrayList<String> headerValue = new ArrayList<String>();
		for (WebElement e : headerslist) {
			String text = e.getText();
			System.out.println("headers value is ::- " + text);
			headerValue.add(text);
		}
		return headerValue;
	}

	public int getHeaderCount() {
		int count = util.getElements(headers).size();
		System.out.println("count of the header is ::-"+ count);
	return count;
	}
	
	public productInfoPage searchProduct(String searchKey) {
		//util.getElement(search);
		util.doSendkey(search, searchKey);
		util.getElement(searchBtn).click();
		return new productInfoPage(driver);
	}
	
	
}
