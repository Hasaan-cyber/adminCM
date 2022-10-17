package com.cybermart.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cybermart.pages.LoginPage;
import com.cybermart.pages.MarketPlacePage;
import com.cybermart.pages.SideNavigationMenu;

public class MarketPlaceTest extends BaseClass {

	MarketPlacePage marketplacePage;
	LoginPage loginPage;
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

		loginPage.loginUserBySubmit(validRegisteredEmail, validPassword);

		dropdownOptionSelector(sideNavigationMenu.getListOfMainModules(), "Market Place");

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

		dropdownOptionSelector(marketplacePage.getListOfModules(), "General Settings");

	}

}
