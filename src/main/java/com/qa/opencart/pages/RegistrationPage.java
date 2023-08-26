package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utility.Utility;
import com.qa.opencart.constant.AppConstant;

public class RegistrationPage {

	private static final CharSequence USER_REGS_SUCESMSG = null;
	private WebDriver driver;
	private Utility util;

	private By firstName = By.xpath("//div[@class='col-sm-10']//input[@id='input-firstname']");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribe = By.xpath("//div[@class='form-group']/label[@class='col-sm-2 control-label']");
	private By subscribeYes = By.xpath("//label[normalize-space()='Yes']/input[@type='radio']");
	private By subscribeNo = By.xpath("//label[normalize-space()='No']/input[@type='radio']");
	private By privacyPlicyCheckBox = By.xpath("//div[@class='pull-right']//input[@type='checkbox']");
	private By continueBtn = By.xpath("//div[@class='pull-right']//input[@type='submit']");
	private By successMsg = By.xpath("//div[@id='content']/h1");
	private By logOut = By.xpath("//div[@class='list-group']/a[contains(text(),'Logout')]");
	private By registerLink = By.xpath("//div[@class='list-group']/a[contains(text(),'Register')]"); 

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		util = new Utility(driver);
	}

	public boolean registerUser(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {
		util.waitVisibilityOfElement(this.firstName, AppConstant.DEFAULT_TIME_OUT).sendKeys(firstName);
		util.doSendkey(this.lastName, lastName);
		util.doSendkey(this.email, email);
		util.doSendkey(this.telephone, telephone);
		util.doSendkey(this.password, password);
		util.doSendkey(confirmPassword, password);

		if (subscribe.equalsIgnoreCase("yes")) {
			util.doClick(subscribeYes);
		} else util.doClick(subscribeNo);
		{
		}
		util.doClick(privacyPlicyCheckBox);
		util.doClick(continueBtn);
		String sucesMsg= util.waitVisibilityOfElement(logOut, AppConstant.DEFAULT_TIME_OUT).getText();
		System.out.println("Success message is:- "+ sucesMsg);
		
		//Your Account Has Been Created
		if(sucesMsg.contains(AppConstant.USER_REGS_SUCESMSG)) {
			util.doClick(logOut);
			util.doClick(registerLink);
			return true;
		}return false;
	}
}
