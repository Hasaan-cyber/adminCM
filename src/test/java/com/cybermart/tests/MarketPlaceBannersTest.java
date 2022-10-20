package com.cybermart.tests;


import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.cybermart.pages.HeaderPage;
import com.cybermart.pages.LoginPage;
import com.cybermart.pages.MarketPlaceBannersPage;
import com.github.javafaker.Faker;
public class MarketPlaceBannersTest  extends BaseClass{

	
	LoginPage loginPage;
	HeaderPage headerPage;
	MarketPlaceBannersPage marketBannerObj;
	Faker faker = new Faker(new Locale("en"));

	public static final String validRegisteredEmail = "airas.mangotech@gmail.com";
	public static final String validPassword = "123456";
	public static final String BannerURL = "https://admin.cybermart.com/market-place/manage-banners";
	public static final String PageTitle = "Market Place Banner page";
	public String currentMessage;

	// Tests

	@Test(priority = 1, enabled = true)
	public void verifyIsLoginSuccessfull() {

		loginPage = new LoginPage();
		headerPage = new HeaderPage();
		marketBannerObj = new MarketPlaceBannersPage();

		loginPage.loginUserBySubmit(validRegisteredEmail, validPassword);

		Assert.assertTrue(headerPage.isLoggedIn());

	}

	@Test(priority = 2, enabled = true)
	public void verifyPageLoaded() {

		marketBannerObj.clickOnMarketPlace();

		Assert.assertTrue(jsPageLoadingStatus());
	}

	@Test(priority = 3, enabled = true)
	public void checksSelected() {
		marketBannerObj.selectallChecks();

		driver.navigate().refresh();
//	  Assert.assertFalse(marketBannerObj.), "are selected");
//	  marketBannerObj.putDelay();
//	  }
	}

	@Test(priority = 4, enabled = true)
	public void randomChecks() {
		marketBannerObj.clickonRandomCheckBox();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 5, enabled = false)
	public void selectDelete() {

		marketBannerObj.clickonRandomCheckBox();
		marketBannerObj.deletionMethod();

		currentMessage = marketBannerObj.getToastMsg();
		assertEquals(currentMessage, "Banner(s) deleted successfully");
	}

	@Test(priority = 6, enabled = false)
	public void randomDeleting() {
		// deleting with svg delete icon
		marketBannerObj.DeleteRandom();
		currentMessage = marketBannerObj.getToastMsg();
		assertEquals(currentMessage, "Banner(s) deleted successfully");
	}

	@Test(priority = 7, enabled = true)
	public void verifyingEditElement() {
		marketBannerObj.editElementDisplayed();
	}
	

	@Test(priority = 8, enabled = true)
	public void verifyingDeleteElement() {
		marketBannerObj.deleteElementDisplayed();
	}

	@Test(priority = 9, enabled = true)
	public void verifyURL() {
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(BannerURL));
	}

	@Test(priority = 10, enabled = true)
	public void verifyTitle() {
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.titleIs(PageTitle));
	}

	@Test(priority = 11, enabled = true)
	public void pagination() {
		marketBannerObj.checkPagination();
		marketBannerObj.travesringpagination();

	}

	@Test(priority = 12, enabled = true)
	public void addingBanner() {

		marketBannerObj.addBanner();
		marketBannerObj.putDelay();
	}

	@Test(priority = 13, enabled = true)
	public void addBannerError() {
		String currentError;
		marketBannerObj.clickSavBtn();
		currentError = marketBannerObj.getdesTError();
		assertEquals(currentError, "Please select destination type.");

		currentError = marketBannerObj.getTypeError();
		assertEquals(currentError, "Please select banner type.");

	}

	@Test(priority = 14, enabled = true)
	public void addingNewBanner() {
		driver.navigate().refresh();
		marketBannerObj.SelectionDrpDown();
		marketBannerObj.uploadingImg();
		marketBannerObj.settingDestinationtype(faker.name().firstName());
		marketBannerObj.clickSavBtn();
	}

//	@AfterTest
//	public void sleep(){
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		driver.quit();
//	}
//	


}
