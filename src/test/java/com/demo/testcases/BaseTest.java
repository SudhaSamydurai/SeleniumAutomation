package com.demo.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demo.driver.Driver;

public class BaseTest {

	@BeforeMethod

	protected void setUp() throws Exception {
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
