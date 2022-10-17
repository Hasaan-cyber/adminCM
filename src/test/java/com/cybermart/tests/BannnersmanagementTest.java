package com.cybermart.tests;
import static org.testng.Assert.assertEquals;

import java.util.Locale;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cybermart.pages.BannerManagementPage;
import com.cybermart.pages.HeaderPage;
import com.cybermart.pages.LoginPage;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BannnersmanagementTest extends BaseClass{

	LoginPage loginPage;
	HeaderPage headerPage;
	SoftAssert softAssert = new SoftAssert();
	BannerManagementPage objbanner;
	Faker faker = new Faker(new Locale("en"));

	public static final String expectedEmailRequiredError = "Please enter the email.";
	public static final String expectedMalformedEmailError = "Email is invalid.";
	public static final String expectedErrorAccountNotRegistered = "No user registered against this email";
	public static final String expectedEmailPlaceholder = "Email";
	public static final String forgotPasswordPageURL = "https://admin.cybermart.com/auth/forget-password";
	public static final String loginPageURL = "https://admin.cybermart.com/auth/login";
	public static final String forgotPasswordPageTitle = "Cyber Mart";
	public static String actualErrorAccountNotRegistered;
	public static final String validRegisteredEmail = "airas.mangotech@gmail.com";
	public static final String validPassword = "123456";

	@Test(priority = 1, enabled = true)
	public void verifyIsLoginSuccessfull() {

		loginPage = new LoginPage();
		headerPage = new HeaderPage();
		objbanner = new BannerManagementPage();

		loginPage.loginUserBySubmit(validRegisteredEmail, validPassword);

		Assert.assertTrue(headerPage.isLoggedIn());

	}
	

	@Test(priority = 2, enabled = true)
	public void verifyUserTypesPageLoaded() {

		headerPage = new HeaderPage();
		objbanner = new BannerManagementPage();

		headerPage.clickAtSystemTab();
		objbanner.bannerTypeclick();

		//Assert.assertTrue(jsPageLoadingStatus());

	}

//	@Test (priority = 3, enabled = false)
//	public void verifyURL() {
//		String currentURL = driver.getCurrentUrl();
//		assertEquals(currentURL, BannerTypePageURL);
//	}
//	
	
	@Test(priority = 3, enabled = true)
	public void checksSelected() {
		objbanner.checkAllSelected();
		Assert.assertFalse(objbanner.checkAllSelected(), "are selected");
	}

	@Test(priority = 4, enabled = true)
	public void addingBanner() {

		objbanner.addBanner();
	}

	@Test(priority = 5, enabled = true)
	public void addBannerError() {
		String currentError;
		objbanner.clickSavBtn();
		currentError = objbanner.getTypeError();
		assertEquals(currentError, "Please enter type.");

		currentError = objbanner.getNameError();
		assertEquals(currentError, "Please enter the name.");

	}

	@Test(priority = 6, enabled = true)

	public void settingfileds() {
		String currentMessage;
		objbanner.setFieldsForm(faker.name().firstName(), faker.number().digits(4), faker.number().digits(4),
				faker.number().digits(4), faker.number().digits(4));
		currentMessage = objbanner.getToastMsg();
		assertEquals(currentMessage, "Banner Type inserted successfully");


			objbanner.setFieldsForm(faker.name().firstName(), faker.name().title(), faker.number().digits(4),
					faker.number().digits(4), faker.number().digits(4));
			currentMessage = objbanner.getToastMsg();
			assertEquals(currentMessage, "Banner Type inserted successfully");

	

	}

	@Test(priority = 7, enabled = true)
	public void clickingBckBtn() {
		driver.navigate().refresh();
		objbanner.clickBckBtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test(priority = 8, enabled = true)
	public void MultipleCheckBoxes() {
		objbanner.selectingAllChecks();
	}
	
	@Test(priority = 9, enabled = true)
	public void pagination() {
		objbanner.checkPagination();
		objbanner.putDelay();
	}

	@AfterTest
	public void closeDriver() {
		objbanner.putDelay();
		driver.quit();
	}

}



