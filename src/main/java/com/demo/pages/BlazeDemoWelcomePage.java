package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemoWelcomePage extends BasePage {

	@FindBy(xpath = "//h1[normalize-space(text())='Welcome to the Simple Travel Agency!']")
	public WebElement welcomelabel;

	@FindBy(xpath = "//select[@name='fromPort']")
	public WebElement fromDropdown;

	@FindBy(xpath = "//select[@name='toPort']")
	public WebElement toDropdown;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement findFlightsButton;

	public BlazeDemoWelcomePage open() {
		return (BlazeDemoWelcomePage) openPage(BlazeDemoWelcomePage.class);
	}

	public FlightsListPage findFlightList(String departureCity, String destinationCity) {

		Select selectDropDown;
		selectDropDown = new Select(fromDropdown);
		selectDropDown.selectByValue(departureCity);
		selectDropDown = new Select(toDropdown);
		selectDropDown.selectByValue(destinationCity);
		findFlightsButton.click();

		return (FlightsListPage) openPage(FlightsListPage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(welcomelabel);
	}

}
