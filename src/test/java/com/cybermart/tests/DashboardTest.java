package com.cybermart.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cybermart.pages.DashboardPage;
import com.cybermart.pages.HeaderPage;
import com.cybermart.pages.LoginPage;

public class DashboardTest extends BaseClass {

	HeaderPage headerPage;
	LoginPage loginPage;
	DashboardPage dashboardPage;

	public static final String dashboardPageURL = "https://admin.cybermart.com/dashboard";
	public static final String validRegisteredEmail = "airas.mangotech@gmail.com";
	public static final String validPassword = "123456";
	public static final String dashboardPageTitle = "Dashboard";

	@Test(priority = 1, enabled = true)
	public void verifyDashboardPageLoaded() {

		// initializing the HeaderPage, LoginPage and DashboardPage classes objects.
		headerPage = new HeaderPage();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();

		// Calls the loginUser method to login user by clicking login button.
		loginPage.loginUserByButtonClick(validRegisteredEmail, validPassword);

		// Waits until 5 seconds to check if user is logged in and dashboard page
		// opened.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(dashboardPageURL));

		/*
		 * Using the jsPageLoadingStatus method of BaseClass validates if the page is
		 * loaded successfully or not.
		 */
		Assert.assertTrue(jsPageLoadingStatus());

	}

	@Test(priority = 2, enabled = true)
	public void verifyDashboardPageURL() {

		/*
		 * Validates the current URL, myWait method of BaseClass is used to add some
		 * wait as sometimes driver picks the URL before it's loaded.
		 */
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(dashboardPageURL));

	}

	@Test(priority = 3, enabled = true)
	public void verifyDashboardPageTitle() {

		/*
		 * Validates the current page Title, myWait method of BaseClass is used to add
		 * some wait as sometimes driver picks the title of the page before it's loaded.
		 */
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.titleIs(dashboardPageTitle));

	}

	@Test(priority = 4, enabled = true)
	public void verifyPageElementsDisplayed() {

		/*
		 * Validates the presence of page elements using BaseClass method
		 * isPageElementsDisplayed, which Takes list of WebElements as it's parameter.
		 * getLoginPageElementsList is a method in LoginPage class which returns the
		 * list of WebElements.
		 */
		isWebElementDisplayed(dashboardPage.getCyberMartLogo());

		// isPageElementsDisplayed(loginPage.getLoginPageElementsList());

	}

}
