package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ThankYouPage extends BasePage {

	@FindBy(xpath = "//h1")
	public WebElement ThankYouHeaderLabel;

	@FindBy(xpath = "//table[@class='table']")
	public WebElement purchaseDetailTable;

	@FindBy(xpath = "//td[normalize-space(text())='Id']/following-sibling::td")
	public WebElement idTableCell;

	public ThankYouPage reservationDetails() {

		ThankYouHeaderLabel.isDisplayed();
		return (ThankYouPage) openPage(ThankYouPage.class);
	}

	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(ThankYouHeaderLabel);
	}

}
