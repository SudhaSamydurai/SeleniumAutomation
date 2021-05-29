package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.constants.GlobalConstants;
import com.demo.driver.DriverManager;

public abstract class BasePage<T> {

	public WebDriver driver;

	public T openPage(Class<T> clazz) {
		T page = null;
		AjaxElementLocatorFactory ajaxLocatorFactory = new AjaxElementLocatorFactory(DriverManager.getDriver(),
				GlobalConstants.getAjaxWaitLoad());
		page = PageFactory.initElements(DriverManager.getDriver(), clazz);
		PageFactory.initElements(ajaxLocatorFactory, page);

		ExpectedCondition pageLoadCondtion = ((BasePage) page).getPageLoadCondition();
		waitForPageLoad(pageLoadCondtion);
		return page;

	}

	public abstract ExpectedCondition getPageLoadCondition();

	public void waitForPageLoad(ExpectedCondition expectedCondition) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), GlobalConstants.getExplicitWait());
		wait.until(expectedCondition);
	}

}
