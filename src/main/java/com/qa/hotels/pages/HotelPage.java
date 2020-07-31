package com.qa.hotels.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.utils.ElementUtil;
import com.qa.hotels.utils.JavaScriptUtil;

public class HotelPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	WebElement element;
	HotelPage hotelPage;
	
	By star3 = By.id("f-star-rating-3");
	By search = By.xpath("/input[@id='f-name']");
	By hiltonList = By.xpath("//*[contains(text(), 'Hilton')]");
	
	public HotelPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	public void selectStar3() {
		elementUtil.clickOn(star3);
	}
	
	public void getHilton() {
		javaScriptUtil.scrollDownBy();
		
		List<WebElement> list = driver.findElements(hiltonList);
		System.out.println(list.size() + " Three stars hotels are available." );
		
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText(); 
			System.out.println(text);
		}	
	}
	
		
	
}	


