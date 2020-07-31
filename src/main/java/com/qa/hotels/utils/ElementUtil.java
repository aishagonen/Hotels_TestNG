package com.qa.hotels.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ElementUtil {

	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil javaScriptUtil;
	Properties prop;
	Select select;
	WebElement element;
	
	public ElementUtil(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Constants.DEFAULT_TIME);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	public void clickOn(By locator) {
		waitForElementPresent(locator);
		driver.findElement(locator).click();
	}
	
	public void selectDropDownValueByIndex(By locator, int value) {
		WebElement element = driver.findElement(locator);
		select = new Select(element);
		select.selectByIndex(value);	
	}
	
	public void sendKeys(By locator, String value){
		try{
			element = driver.findElement(locator);
			element.clear();
			element.sendKeys(value);
		}
		catch(Exception e){
			System.out.println("Some exception occured while sending to  webelement " + locator);
		}
	}
	
	public boolean waitForElementPresent(By locator){
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return true;
	}
	
	public void printOutList(List<WebElement> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText()); 	
		}
	}
	
	public void getHotelsRadius(By hotelLocator, By mileLocator ) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> hotelList = driver.findElements(hotelLocator);
		List<WebElement> hotelMiles = driver.findElements(mileLocator);
		ArrayList<String> hotelsInRadius = new ArrayList<String>();
		
		for (int i = 0; i < hotelList.size(); i++) {
			String hotelNames = hotelList.get(i).getText(); 
			String milesText = hotelMiles.get(i).getText();
			String milesNumber = milesText.replaceAll("[a-zA-Z ]", "");
			double miles = Double.parseDouble(milesNumber);
			 
			if (miles <= Constants.RADIUS) {
				hotelsInRadius.add(hotelNames + " - " + milesText);
			}
		}	
		
		for (int i = 0; i < hotelsInRadius.size(); i++) {
			System.out.println(hotelsInRadius.get(i));
		}	
	}
	
}
