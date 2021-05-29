package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightsListPage extends BasePage {

	@FindBy(xpath = "//h3[contains(text(), 'Flights from')]")
	public WebElement headerLabel;

	@FindBy(xpath = "//td[normalize-space(text())='Lufthansa']/preceding-sibling::td/input")
	public WebElement chooseThisFlightButton;

	@FindBy(xpath = "//td[normalize-space(text())='Lufthansa']/parent::tr/td[2]")
	public WebElement flightNumberLabel;

	@FindBy(xpath = "//td[normalize-space(text())='Lufthansa']/following-sibling::td[3]")
	public WebElement priceLabel;

	public FlightsListPage open() {
		return (FlightsListPage) openPage(FlightsListPage.class);
	}

	public ReservationPaymentPAge chooseFlights() {

		chooseThisFlightButton.click();
		return (ReservationPaymentPAge) openPage(ReservationPaymentPAge.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(headerLabel);

	}

}
