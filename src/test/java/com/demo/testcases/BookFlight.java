package com.demo.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.pages.BlazeDemoWelcomePage;
import com.demo.pages.ThankYouPage;

public class BookFlight extends BaseTest {

	@Test(dataProvider = "excel-data", dataProviderClass = com.demo.utilities.GetExcelData.class)
	public void bookFlight_Success(String fromCity, String toCity, String successMessage) throws InterruptedException {

		ThankYouPage thankyoupage = new BlazeDemoWelcomePage().open().findFlightList(fromCity, toCity).chooseFlights()
				.purchaseFlight().reservationDetails();

		String thankYouMessage = thankyoupage.ThankYouHeaderLabel.getText();
		WebElement reservationDetails = thankyoupage.purchaseDetailTable;
		Assert.assertEquals(thankYouMessage, successMessage);
		Assert.assertTrue(reservationDetails.isDisplayed(), "Reserveration details are not displayed");
		Thread.sleep(5000);

	}
}
