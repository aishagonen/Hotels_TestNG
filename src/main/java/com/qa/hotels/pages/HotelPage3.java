package com.qa.hotels.pages;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.utils.Constants;
import com.qa.hotels.utils.ElementUtil;
import com.qa.hotels.utils.JavaScriptUtil;

public class HotelPage3 extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	WebElement element;
	HotelPage hotelPage;
	HotelPage2 hotelPage2;
	
	By star4 = By.id("f-star-rating-4");
	By distance = By.xpath("//a[contains(text(),'Distance')]");
	By cityCenter = By.xpath("//a[contains(text(),'City center')]");
	By star4hotels = By.xpath("//a[@class='property-name-link']");
	By allMiles	= By.xpath("//ul[@class='property-landmarks']//li[contains(text(),'to City center')]");
	
	public HotelPage3(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	public void selectStar4() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		elementUtil.clickOn(star4);	
		elementUtil.clickOn(distance);
		elementUtil.clickOn(cityCenter);
		
		javaScriptUtil.scrollDownBy();
		elementUtil.getHotelsRadius(star4hotels, allMiles);	
		
	}	
	
}
