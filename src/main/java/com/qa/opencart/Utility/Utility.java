package com.qa.opencart.Utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.Driverfactory;

public class Utility {

	private WebDriver driver;

	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement ele = driver.findElement(locator);
		if (Boolean.parseBoolean(Driverfactory.highlight)) {
			flash(ele);
		}
		return ele;
	}

	public void getElementByAction(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).build().perform();
		act.click().build().perform();
	}

	public void doSendkey(By locator, String value) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void waitVisibleofElementClick(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		ele.click();
	}

	public void changeColor(String color, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor= '" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (Exception e) {

		}
	}

	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(255,165,0)", element);
			changeColor(bgcolor, element);
		}
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		for (WebElement e : elements) {
			String text = e.getText();
		}
		return elements;
	}
	
	public List<WebElement> waitForVisibiliyOfAllElements(By locator, int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));	
	return wait.until(ExpectedConditions.visibilityOfAllElements(getElement(locator)));
	}
	
	public List<WebElement> waitVisibilityofElements(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public WebElement waitVisibilityOfElement(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
