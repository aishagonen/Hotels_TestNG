package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.NeedsLocalLogs;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.pages.HotelPage;
import com.qa.hotels.pages.HotelPage2;

public class HotelPage2Test {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	HotelPage hotelPage;
	HotelPage2 hotelPage2;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver); 
		hotelPage = homePage.sendInformation();
		hotelPage2 = new HotelPage2(driver);
	}
	
	@Test(priority=1)
	public void selectStar5Test() {
		hotelPage2.selectStar5();
	}
	
	@AfterTest
	public void tearDown() {
		basePage.quitBrowser();
	}	

}
