package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.pages.HotelPage;
import com.qa.hotels.pages.HotelPage4;

public class HotelPage4Test {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	HotelPage hotelPage;
	HotelPage4 hotelPage4;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver); 
		hotelPage = homePage.sendInformation();
		hotelPage4 = new HotelPage4(driver);
	}
	
	
	@Test(priority=1)
	public void selectStar3Test() {
		hotelPage4.selectStar3();
	}
	
	
	@AfterTest
	public void tearDown() {
		basePage.quitBrowser();
	}
		
	
	
	
}
