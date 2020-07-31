package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.pages.HotelPage;

public class HomePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);								
	}
	
	@Test
	public void sendInformationTest() {
		homePage.sendInformation();
	}
	
	
	@AfterTest
	public void tearDown() {
		basePage.quitBrowser();
	}
		
}
