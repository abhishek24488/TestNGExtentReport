package com.pom.tests;

import java.util.concurrent.TimeUnit;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.tests.pages.Guru99HomePage;
import com.tests.pages.Guru99Login;
import com.utils.listener.Retry;

public class Test99GuruLogin {
	public WebDriver driver;
	Guru99Login objLogin;

	Guru99HomePage objHomePage;
	
	public WebDriver getDriver() {
        return driver;
    }
	
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/abhishekk/eclipse-workspace/Lib/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.guru99.com/V4/");

	}

	/**
	 * 
	 * This test case will login in http://demo.guru99.com/V4/
	 * 
	 * Verify login page title as guru99 bank
	 * 
	 * Login to application
	 * 
	 * Verify the home page using Dashboard message
	 * 
	 */

	@Test(priority = 1 , retryAnalyzer = Retry.class)
	public void test_Home_Page_Appear_Correct(Method method) {

		// Create Login Page object
		
		objLogin = new Guru99Login(driver);

		// Verify login page title

		String loginPageTitle = objLogin.getLoginTitle();

		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

		// login to application

		objLogin.loginToGuru99("mgr1234", "mgr!23");

		// go the next page

		objHomePage = new Guru99HomePage(driver);

		// Verify home page

		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	}
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}
	
}
