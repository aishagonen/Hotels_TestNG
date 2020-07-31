package com.qa.hotels.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.utils.ElementUtil;
import com.qa.hotels.utils.JavaScriptUtil;

public class HotelPage2 extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	WebElement element;
	HotelPage hotelPage;
	HotelPage2 hotelPage2;
	
	
	By star5 = By.id("f-star-rating-5");
	By distance = By.xpath("//a[contains(text(),'Distance')]");
	By cityCenter = By.xpath("//a[contains(text(),'City center')]");
	By star5hotels = By.xpath("//*[@class='hotel-wrap']//a[@class='property-name-link']");
	By allMiles	= By.xpath("//ul[@class='property-landmarks']//li[contains(text(),'to City center')]");
	
	
	public HotelPage2(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	public void selectStar5() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		elementUtil.clickOn(star5);	
		elementUtil.clickOn(distance);
		elementUtil.clickOn(cityCenter);
		
		javaScriptUtil.scrollDownBy();
		elementUtil.getHotelsRadius(star5hotels, allMiles);		
	}	
						
}
