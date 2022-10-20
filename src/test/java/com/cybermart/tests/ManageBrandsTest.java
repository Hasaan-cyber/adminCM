package com.cybermart.tests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cybermart.pages.ForgotPasswordPage;
import com.cybermart.pages.HeaderPage;
import com.cybermart.pages.LoginPage;
import com.cybermart.pages.ManageBrandsPage;
import com.cybermart.pages.SideNavigationMenu;
import com.cybermart.pages.TableActions;

public class ManageBrandsTest extends BaseClass {

	LoginPage loginPage;
	HeaderPage headerPage;
	SideNavigationMenu sideNavigationMenu;
	ManageBrandsPage manageBrandsPage;
	TableActions tableActions;
	SoftAssert softAssert = new SoftAssert();

	public static final String manageBrandsPageURL = "https://admin.cybermart.com/market-place/manage-brands/all-brands";
	public static final String addNewBrandPageURL = "https://admin.cybermart.com/market-place/manage-brands/all-brands/add-brand";
	String actualBreadcrumbs;
	public static final String expectedBreadcrumbsAllBrandsPage = "Market Place > Manage Brands > All Brands";
	public static final String expectedActiveMainTabColor = "rgb(255, 139, 0)";
	public static final String expectedActiveSubTabColor = "rgba(39, 222, 191, 1)";
	public static final String expectedSearchFieldPlaceholder = "Search...";
	public static final String expectedHeadingAddNewBrandPage = "Add New Brand";

	public static final String expectedEmailRequiredError = "Please enter the email.";
	public static final String expectedMalformedEmailError = "Email is invalid.";
	public static final String expectedErrorAccountNotRegistered = "No user registered against this email";
	public static final String expectedEmailPlaceholder = "Email";
	public static String actualErrorAccountNotRegistered;
	public static final String validRegisteredEmail = "airas.mangotech@gmail.com";
	public static final String validPassword = "123456";

	@Test(priority = 1, enabled = true)
	public void verifyIsLoginSuccessfull() {

		loginPage = new LoginPage();
		headerPage = new HeaderPage();
		sideNavigationMenu = new SideNavigationMenu();
		manageBrandsPage = new ManageBrandsPage();
		tableActions = new TableActions();
		
		loginPage.loginUserBySubmit(validRegisteredEmail, validPassword);

		Assert.assertTrue(headerPage.isLoggedIn(), "ERROR! Login Failed.");

	}
	
	@Test(priority = 2, enabled = true)
	public void verifyManageBrandsPageLoaded() {

		sideNavigationMenu.clickAtMarketplaceModule();
		
		sideNavigationMenu.clickAtManageBrandsSubModule();

		Assert.assertTrue(jsPageLoadingStatus(), "ERROR! All Brands Page Did Not Load Successfully.");

	}
	
	@Test(priority = 3, enabled = true)
	public void verifyManageBrandsPageURL() {

		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(manageBrandsPageURL));

	}
	
	@Test(priority = 4, enabled = true)
	public void verifyManageBrandsPageTabsDisplayed() {

		Assert.assertEquals(headerPage.getPageMainTabAtTop(0).getText(), "All Brands", "ERROR! Manage Brands Page First (All Brands) Tab Title Wrong/Changed.");
		Assert.assertEquals(headerPage.getPageMainTabAtTop(1).getText(), "Store Brands", "ERROR! Manage Brands Page Second (Store Brands) Tab Title Wrong/Changed.");

	}
	
	@Test(priority = 5, enabled = true)
	public void verifyManageBrandsPageBreadcrumbs() {

		actualBreadcrumbs = headerPage.copyBreadcrumbsText();
		Assert.assertEquals(actualBreadcrumbs, expectedBreadcrumbsAllBrandsPage, "ERROR! All Brands Page Breadcrumbs Are Not Matched.");

	}
	
	@Test(priority = 6, enabled = true)
	public void verifyIsActiveMainTabHighlighted() {

		String actualActiveMainTabColor = headerPage.getPageMainTabAtTop(0).getCssValue("border-color");
		Assert.assertEquals(actualActiveMainTabColor, expectedActiveMainTabColor, "ERROR! Manage Brands Page Active Tab Not Highlighted/Opened.");

	}
	
	@Test(priority = 7, enabled = true)
	public void verifySearchPlaceholder() {

		String actualSearchFieldPlaceholder = tableActions.getSearchFieldPlaceholderText();
		Assert.assertEquals(actualSearchFieldPlaceholder, expectedSearchFieldPlaceholder, "ERROR! All Brands Page Search Field Placeholder Text Not Matched.");

	}
	
	@Test(priority = 8, enabled = true)
	public void verifySearchFunctionality() throws InterruptedException {
		
		if(tableActions.verifyPageIsNotBlank() == true) {
			Thread.sleep(5000);

			tableActions.enterRandomKeywordIntoSearchField(7);
			
			tableActions.verifyIsCorrectSearchResultsShow(0, 6);
			
		}

	}
	
	@Test(priority = 9, enabled = true)
	public void verifyAllRecordsLoadedAfterClearingSearch() throws InterruptedException {
			
		tableActions.clearSearchField();

	}
	
	@Test(priority = 10, enabled = true)
	public void verifyAddNewBrandPageLoaded() {
		
		tableActions.clickAtAddNewButton();
		
		Assert.assertTrue(jsPageLoadingStatus(), "ERROR! Add New Brand Page Did Not Load Successfully.");
		
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(addNewBrandPageURL));
		
	}
	
	@Test(priority = 11, enabled = true)
	public void verifyAddNewBrandPageURL() {
		
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(addNewBrandPageURL));
		
	}
	
	@Test(priority = 12, enabled = true)
	public void verifyAddNewBrandPageBreadcrumbs() {

		actualBreadcrumbs = headerPage.copyBreadcrumbsText();
		Assert.assertEquals(actualBreadcrumbs, expectedBreadcrumbsAllBrandsPage, "ERROR! All Brands Page Breadcrumbs Are Not Matched At Add New Brand Page.");

	}
	
	@Test(priority = 13, enabled = true)
	public void verifyAddNewBrandPageHeadingDisplayed() {

		String actualHeadingAddNewBrandPage = headerPage.getPageHeadingText();
		Assert.assertEquals(actualHeadingAddNewBrandPage, expectedHeadingAddNewBrandPage);

	}
	
	@Test(priority = 14, enabled = true)
	public void verifyAddNewBrandPageTabsDisplayed() {

		Assert.assertEquals(headerPage.getPageSubTabAtTop(0).getText(), "Brand Information", "ERROR! Add New Brand Page First (Brand Information) Tab Title Wrong/Changed.");
		Assert.assertEquals(headerPage.getPageSubTabAtTop(1).getText(), "SEO", "ERROR! Add New Brand Page Second (SEO) Tab Title Wrong/Changed.");

	}
	
	@Test(priority = 15, enabled = true)
	public void verifyIsActiveSubTabHighlighted() {

		String actualActiveSubTabColor = headerPage.getPageSubTabAtTop(0).getCssValue("background-color");
		Assert.assertEquals(actualActiveSubTabColor, expectedActiveSubTabColor, "ERROR! Add New Brand Page Active Tab Not Highlighted/Opened.");

	}
	
}