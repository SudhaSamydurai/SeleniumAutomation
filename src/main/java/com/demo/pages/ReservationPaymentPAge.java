package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReservationPaymentPAge extends BasePage {

	@FindBy(xpath = "//h2")
	public WebElement reservationPageTitleLabel;

	@FindBy(xpath = "//h2/following-sibling::p[1]")
	public WebElement airlineLabel;

	@FindBy(xpath = "//h2/following-sibling::p[2]")
	public WebElement flightNumberLabel;

	@FindBy(xpath = "//h2/following-sibling::p[3]")
	public WebElement priceLabel;

	@FindBy(xpath = "//input[@value='Purchase Flight']")
	public WebElement purchaseFlightButton;

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(reservationPageTitleLabel);

	}

	public ThankYouPage purchaseFlight() {

		purchaseFlightButton.click();
		return (ThankYouPage) openPage(ThankYouPage.class);
	}

}
