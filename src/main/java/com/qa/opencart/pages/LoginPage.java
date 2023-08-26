package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utility.Utility;

public class LoginPage {

	private WebDriver driver;
	private Utility util;
	private AccountLoginPage accountloginpage;
	private By myAccount = By.linkText("My Account");
	private By login = By.linkText("Login");
	private By register = By.linkText("Register");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new Utility(driver);
		accountloginpage= new AccountLoginPage(driver);
	}

	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("page title is ::- " + title);
		return title;
	}
	
	public String getCurrentPageURL() {
		String url= driver.getCurrentUrl();
		System.out.println("The current url is :- "+ url);
		return url;
	}

	private void clickOnMyAccount() {
		WebElement myAccountOptn = util.getElement(myAccount);
		myAccountOptn.click();
	}

	public AccountLoginPage selectLogin() {
		clickOnMyAccount();
		util.getElementByAction(login);
		return new AccountLoginPage(driver);
	}

	public RegistrationPage navigateToRegistrationPage() {
		util.doClick(register);
		return new RegistrationPage(driver);
	}
}
