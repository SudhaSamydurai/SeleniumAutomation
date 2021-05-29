package com.demo.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager() {
	}

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	static void setDriver(WebDriver driverRef) {
		if (Objects.nonNull(driverRef)) {
			driver.set(driverRef);
		}
	}

	// Much safer than assign null values to thread local variable
	static void unLoad() {
		driver.remove();
	}

}
