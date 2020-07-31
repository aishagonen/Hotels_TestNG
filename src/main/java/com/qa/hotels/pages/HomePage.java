package com.qa.hotels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.utils.ElementUtil;
import com.qa.hotels.utils.JavaScriptUtil;

public class HomePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	WebElement element;
	
	By destination = By.name("q-destination");
	By checkin = By.xpath("//input[@id='qf-0q-localised-check-in']");
	By checkout = By.xpath("//input[@id='qf-0q-localised-check-out']");
	By rooms = By.id("qf-0q-rooms"); // value: 0
	By adults = By.id("qf-0q-room-0-adults"); // value: 1
	By children = By.id("qf-0q-room-0-children"); // value: 2
	By age1 = By.id("qf-0q-room-0-child-0-age"); // value: 5
	By age2 = By.id("qf-0q-room-0-child-1-age"); // value: 10
	By searchBtn = By.xpath("//button[@class='cta cta-strong']");
								
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	public HotelPage sendInformation() {
		driver.findElement(destination).sendKeys("Boston, Massachusetts, United States of America");		
		elementUtil.sendKeys(checkin, "08/21/20");
		elementUtil.sendKeys(checkout, "08/27/20");
		elementUtil.selectDropDownValueByIndex(rooms, 0);
		elementUtil.selectDropDownValueByIndex(adults, 1);
		elementUtil.selectDropDownValueByIndex(children, 2);
		elementUtil.selectDropDownValueByIndex(age1, 5);
		elementUtil.selectDropDownValueByIndex(age2, 10);
		element = driver.findElement(searchBtn);
		javaScriptUtil.clickElementByJS(element);
		return new HotelPage(driver);
	}

}
