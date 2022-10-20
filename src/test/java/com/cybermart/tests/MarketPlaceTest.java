package com.cybermart.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cybermart.pages.HeaderPage;
import com.cybermart.pages.LoginPage;
import com.cybermart.pages.MarketPlacePage;
import com.cybermart.pages.SideNavigationMenu;

public class MarketPlaceTest extends BaseClass {

	MarketPlacePage marketplacePage;
	LoginPage loginPage;
	HeaderPage headerPage;
	SideNavigationMenu sideNavigationMenu;

	@Test(priority = 1, enabled = true)
	public void verifyMarketPlacePageLoaded() {

		marketplacePage = new MarketPlacePage();
		sideNavigationMenu = new SideNavigationMenu();
		loginPage = new LoginPage();
		headerPage = new HeaderPage();

		// Login user to the system.
		loginPage.loginUserBySubmit(properties.getProperty("validRegisteredEmail"),
				properties.getProperty("validPassword"));

		// Validates the user is logged in.
		Assert.assertTrue(headerPage.isLoggedIn());

		// Selects the Market Place option from side menu.
		listItemSelector(sideNavigationMenu.getListOfMainModules(), "Market Place");

		// Validates the page URL updated.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(properties.getProperty("urlMarketPlace")));

		/*
		 * Using the jsPageLoadingStatus method of BaseClass validates if the page is
		 * loaded successfully or not.
		 */
		Assert.assertTrue(jsPageLoadingStatus());

	}

	@Test(priority = 2, enabled = true)
	public void verifyMarketplacePageURL() {

		/*
		 * Validates the current URL, myWait method of BaseClass is used to add some
		 * wait as sometimes driver picks the URL before it's loaded.
		 */
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(properties.getProperty("urlMarketPlace")));

	}

	@Test(priority = 3, enabled = true)
	public void verifyMarketplacePageTitle() {

		/*
		 * Validates the current page Title, myWait method of BaseClass is used to add
		 * some wait as sometimes driver picks the title of the page before it's loaded.
		 */
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.titleIs(properties.getProperty("titleMarketplace")));

	}

	@Test(priority = 4, enabled = true)
	public void verifyPageElementsDisplayed() {

		/*
		 * Validates the presence of page elements using BaseClass method
		 * isPageElementsDisplayed, which Takes list of WebElements as it's parameter.
		 * getLoginPageElementsList is a method in LoginPage class which returns the
		 * list of WebElements.
		 */
		isPageElementsDisplayed(marketplacePage.getListOfModules());

	}

	@Test(priority = 5, enabled = true)
	public void verifyRedirectionToGeneralSettings() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "General Settings");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5))
				.until(ExpectedConditions.urlToBe(properties.getProperty("urlGeneralSettings_MarketPlace")));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 6, enabled = true)
	public void verifyRedirectionToTodayDeals() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Today Deals");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5))
				.until(ExpectedConditions.urlToBe(properties.getProperty("urlTodayDeals_MarketPlace")));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 7, enabled = true)
	public void verifyRedirectionToTopSelling() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Top Selling");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5))
				.until(ExpectedConditions.urlToBe(properties.getProperty("urlTopSelling_MarketPlace")));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 8, enabled = true)
	public void verifyRedirectionToFAQ() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "FAQs");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(properties.getProperty("urlFAQs_MarketPlace")));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 9, enabled = true)
	public void verifyRedirectionToOfficeAddress() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Office Addresses");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5))
				.until(ExpectedConditions.urlToBe(properties.getProperty("urlOfficeAddresses_marketPlace")));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 10, enabled = true)
	public void verifyRedirectionToManageBanners() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Manage Banners");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5))
				.until(ExpectedConditions.urlToBe(properties.getProperty("urlManageBanners_MarketPlace")));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 11, enabled = true)
	public void verifyRedirectionToManageBrands() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Manage Brands");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5))
				.until(ExpectedConditions.urlToBe(properties.getProperty("urlManageBrands_MarketPlace")));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 12, enabled = true)
	public void verifyRedirectionToCategories() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Manage Categories");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5))
				.until(ExpectedConditions.urlToBe(properties.getProperty("urlManageCategories_MarketPlace")));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 13, enabled = true)
	public void verifyRedirectionToFeaturedProducts() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Featured Products");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5))
				.until(ExpectedConditions.urlToBe(properties.getProperty("urlFeaturedProducts_MarketPlace")));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 14, enabled = true)
	public void verifyRedirectionToOfficeContactInformation() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Office Contact Information");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5))
				.until(ExpectedConditions.urlToBe(properties.getProperty("urlOfficeContactInformation_MarketPlace")));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

}
