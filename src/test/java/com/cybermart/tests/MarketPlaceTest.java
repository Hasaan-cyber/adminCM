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

	public static final String marketplaceURL = "https://admin.cybermart.com/market-place";
	public static final String marketplaceTitle = "CyberMart Marketplace";
	public static final String validRegisteredEmail = "airas.mangotech@gmail.com";
	public static final String validPassword = "123456";

	@Test(priority = 1, enabled = true)
	public void verifyMarketPlacePageLoaded() {

		marketplacePage = new MarketPlacePage();
		sideNavigationMenu = new SideNavigationMenu();
		loginPage = new LoginPage();
		headerPage = new HeaderPage();

		// Login user to the system.
		loginPage.loginUserBySubmit(validRegisteredEmail, validPassword);

		// Validates the user is logged in.
		Assert.assertTrue(headerPage.isLoggedIn());

		// Selects the Market Place option from side menu.
		listItemSelector(sideNavigationMenu.getListOfMainModules(), "Market Place");

		// Validates the page URL updated.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL));

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
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL));

	}

	@Test(priority = 3, enabled = true)
	public void verifyMarketplacePageTitle() {

		/*
		 * Validates the current page Title, myWait method of BaseClass is used to add
		 * some wait as sometimes driver picks the title of the page before it's loaded.
		 */
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.titleIs(marketplaceTitle));

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
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL + "/general-settings"));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 6, enabled = true)
	public void verifyRedirectionToTodayDeals() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Today Deals");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL + "/today-deals"));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 7, enabled = true)
	public void verifyRedirectionToTopSelling() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Top Selling");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL + "/top-selling"));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 8, enabled = true)
	public void verifyRedirectionToFAQ() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "FAQs");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL + "/faqs"));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 9, enabled = true)
	public void verifyRedirectionToOfficeAddress() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Office Addresses");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL + "/office-addresses"));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 10, enabled = true)
	public void verifyRedirectionToManageBanners() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Manage Banners");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL + "/manage-banners"));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 11, enabled = true)
	public void verifyRedirectionToManageBrands() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Manage Brands");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL + "/manage-brands"));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 12, enabled = true)
	public void verifyRedirectionToCategories() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Manage Categories");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL + "/manage-categories"));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 13, enabled = true)
	public void verifyRedirectionToFeaturedProducts() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Featured Products");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL + "/featured-products"));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

	@Test(priority = 14, enabled = true)
	public void verifyRedirectionToOfficeContactInformation() {

		// Navigates user to the respective page.
		listItemSelector(marketplacePage.getListOfModules(), "Office Contact Information");

		// Validates the page URL to verify the user is on expected page.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(marketplaceURL + "/office-contact-information"));

		// Redirects back to the Market Place page.
		driver.navigate().back();

	}

}
