package com.demo.driver;

import java.util.Objects;

import com.demo.utilities.ReadPropertyFile;

import Enums.PropertyFileAttributes;

public final class Driver {

	private Driver() {
	}

	public static void initDriver() throws Exception {

		String browser = ReadPropertyFile.get(PropertyFileAttributes.BROWSER);
		String version = ReadPropertyFile.get(PropertyFileAttributes.VERSION);

		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactories.getDriver(browser, version));
			} catch (Exception e) {
				e.printStackTrace();
			}
			DriverManager.getDriver().get(ReadPropertyFile.get(PropertyFileAttributes.URL));
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unLoad();
		}
	}
}
