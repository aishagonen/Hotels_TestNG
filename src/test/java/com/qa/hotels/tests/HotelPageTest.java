package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.pages.HotelPage;

public class HotelPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	HotelPage hotelPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver); 
		hotelPage = homePage.sendInformation();
	}

	@Test(priority=1)
	public void getHiltonTest() {
		hotelPage.selectStar3();
		hotelPage.getHilton();
	}
	
	@AfterTest
	public void tearDown() {
		basePage.quitBrowser();
	}
		
}
