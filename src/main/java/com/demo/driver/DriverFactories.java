package com.demo.driver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.demo.utilities.ReadPropertyFile;

import Enums.PropertyFileAttributes;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactories {

	DriverFactories() {
	}

	public static WebDriver getDriver(String browser, String version) throws Exception {

		WebDriver driver = null;

		String runMode = ReadPropertyFile.get(PropertyFileAttributes.RUNMODE);

		if (browser.equalsIgnoreCase("chrome")) {
			if (runMode.equalsIgnoreCase("Remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName(BrowserType.CHROME);
				capabilities.setVersion(version);
				driver = new RemoteWebDriver(new URL(ReadPropertyFile.get(PropertyFileAttributes.URL)), capabilities);
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			if (runMode.equalsIgnoreCase("Remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName(BrowserType.FIREFOX);
				capabilities.setVersion(version);
				driver = new RemoteWebDriver(new URL(ReadPropertyFile.get(PropertyFileAttributes.URL)), capabilities);
			}

			else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
}
