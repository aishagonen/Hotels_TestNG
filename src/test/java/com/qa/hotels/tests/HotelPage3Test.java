package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.pages.HotelPage;
import com.qa.hotels.pages.HotelPage3;

public class HotelPage3Test {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	HotelPage hotelPage;
	HotelPage3 hotelPage3;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver); 
		hotelPage = homePage.sendInformation();
		hotelPage3 = new HotelPage3(driver);
	}
	
	
	@Test(priority=1)
	public void selectStar4Test() {
		hotelPage3.selectStar4();
	}
	
	
	@AfterTest
	public void tearDown() {
		basePage.quitBrowser();
	}
		
	
}
