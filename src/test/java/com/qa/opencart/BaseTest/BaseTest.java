package com.qa.opencart.BaseTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.Driverfactory;
import com.qa.opencart.pages.AccountLoginPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductDetailsPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.productInfoPage;

public class BaseTest {

	WebDriver driver;
	Driverfactory df;
	protected LoginPage loginpage;
	protected AccountLoginPage accountloginpage;
	protected productInfoPage productinfopage;
	protected ProductDetailsPage productdetailspage;
	protected RegistrationPage registrationpage;
	protected Properties prop;

	@BeforeTest
	public void setUp() {
		df = new Driverfactory(driver);
		prop= df.initProp();
		driver = df.initDriver(prop);
		loginpage = new LoginPage(driver);
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
