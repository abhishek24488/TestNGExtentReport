package com.tests.pages;

import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	
	@BeforeSuite //1
	public void setUp() {
		System.out.println("setup the Property for chrome");
	}
	
	@BeforeTest //2
	public void launchBrowser() {		
		System.out.println("Browser will launch");		
	}
	
	@BeforeClass //3
	public void login() {
		System.out.println("Login Method");
	}
	
	@BeforeMethod //4
	public void enterURL() {
		System.out.println("Enter URL");
	}
		
	@Test
	public void googleTitleTest() {
		System.out.println("Google Title Test");		
	}
	
	@Test
	public void gmailTitleTest() {
		System.out.println("Gmail Title Test");
	}
	
	@AfterMethod //5
	public void logOut() {
		System.out.println("logout from app");
	}
	
	@AfterClass //6
	public void closeBrowser() {
		System.out.println("closeBrowser");
	}
	
	@AfterTest //7
	public void deleteAllCookies() {
		System.out.println("deleteAllCookies");
	}
	
	@AfterSuite //8
	public void generateReport() {
		System.out.println("generateReport");
	}

}
