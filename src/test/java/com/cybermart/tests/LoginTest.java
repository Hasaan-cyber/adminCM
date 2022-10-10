package com.cybermart.tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.cybermart.pages.HeaderPage;
import com.cybermart.pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage loginPage;
	HeaderPage headerPage;

	public static final String loginPageTitle = "CyberMart Admin Login";
	public static final String loginPageURL = "https://admin.cybermart.com/auth/login";
	public static final String emailPlaceholder = "Enter your email";
	public static final String passwordPlaceholder = "Enter your password";
	public static final String errorEmailRequired = "Please enter the email.";
	public static final String errorPasswordRequired = "Please enter the password.";
	public static final String errorInvalidEmailOrPassword = "You have entered an invalid email or password.";
	public static final String errorAccountNotRegistered = "The entered email address is not connected to an account.";

	public static final String errorMalformedEmail = "Email is invalid";
	public static final String errorAccountLocked = "Your account has been locked due to invalid login attempts. Please try again after 30 minutes.";
	public static final String errorAccountLockedTime = "Your account has been locked due to invalid login attempts. Please try again after 29 minutes.";
	public static final String registrationPageURL = "https://next.cybermart.com/register";

	@Test(priority = 1, enabled = true)
	public void verifyLoginPageLoaded() {

		headerPage = new HeaderPage();
		loginPage = new LoginPage();

		Assert.assertTrue(jsPageLoadingStatus());

	}

	@Test(priority = 2, enabled = false)
	public void verifyLoginPageURL() {

		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(loginPageURL));

	}

	@Test(priority = 3, enabled = false)
	public void verifyLoginPageTitle() {

		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.titleIs(loginPageTitle));

	}

	@Test(priority = 4, enabled = false)
	public void verifyLoginHeadingDisplayed() {

		boolean status = isWebElementDisplayed(loginPage.getLabelLogin());

		Assert.assertTrue(status);

	}

	@Test(priority = 5, enabled = false)
	public void verifyEmailLabel() {

		String actualLabel;

		actualLabel = loginPage.getLabelEmailField();
		Assert.assertEquals(actualLabel, "Email");

	}

	@Test(priority = 6, enabled = false)
	public void verifyPasswordLabel() {

		String actualLabel;

		actualLabel = loginPage.getLabelPasswordField();
		Assert.assertEquals(actualLabel, "Password");

	}

	@Test(priority = 7, enabled = false)
	public void verifyEmailPlaceholder() {

		String actualPlaceholder;

		actualPlaceholder = loginPage.getLabelEmailField();
		Assert.assertEquals(actualPlaceholder, emailPlaceholder);

	}

	@Test(priority = 8, enabled = false)
	public void verifyPasswordPlaceholder() {

		String actualPlaceholder;

		actualPlaceholder = loginPage.getLabelPasswordField();
		Assert.assertEquals(actualPlaceholder, passwordPlaceholder);

	}

	@Test(priority = 9, enabled = false)
	public void verifyEmailRequiredErrorMessage() {

		loginPage.clickEmailField();
		loginPage.getInputFieldEmail().sendKeys(Keys.TAB);

		String currentError = loginPage.getEmailError();

		Assert.assertEquals(currentError, errorEmailRequired);

	}

	@Test(priority = 10, enabled = false)
	public void verifyPasswordRequiredErrorMessage() {

		loginPage.clickPasswordField();
		loginPage.getInputFieldPassword().sendKeys(Keys.TAB);

		String currentError = loginPage.getPasswordError();

		Assert.assertEquals(currentError, errorPasswordRequired);

	}

	@Test(priority = 11, enabled = false)
	public void verifyBlankEmailLoginFails() {

		loginPage.setPassword("Rizwan@123");
		loginPage.clickLoginButton();

		String currentError = loginPage.getEmailError();
		clearFieldData(loginPage.getInputFieldPassword());

		Assert.assertEquals(currentError, errorEmailRequired);

	}

	@Test(priority = 12, enabled = false)
	public void verifyBlankPasswordLoginFails() {

		loginPage.setEmail("rizwan@convextech.com");
		loginPage.clickLoginButton();

		String currentError = loginPage.getPasswordError();
		clearFieldData(loginPage.getInputFieldEmail());

		Assert.assertEquals(currentError, errorPasswordRequired);

	}

	@Test(priority = 13, enabled = false)
	public void verifyBlankEmailAndPasswordLoginFails() {

		String currentError;
		loginPage.clickLoginButton();

		currentError = loginPage.getEmailError();
		Assert.assertEquals(currentError, errorEmailRequired);

		currentError = loginPage.getPasswordError();
		Assert.assertEquals(currentError, errorPasswordRequired);

	}

	@Test(priority = 14, enabled = false)
	public void verifyInvalidPasswordLoginFails() {

		loginPage.setEmail("airas.mangotech@gmail.com");
		loginPage.setPassword(randomStringGenerator());
		loginPage.clickLoginButton();

		String currentErrorMessage = loginPage.getPasswordError();
		Assert.assertEquals(currentErrorMessage, errorInvalidEmailOrPassword);

	}

	@Test(priority = 15, enabled = false)
	public void verifyUnregisteredEmailLoginFails() {

		loginPage.setEmail("airas.mangtech@gmail.com");
		loginPage.setPassword("123456");
		loginPage.clickLoginButton();

		String currentErrorMessage = loginPage.getPasswordError();
		Assert.assertEquals(currentErrorMessage, errorAccountNotRegistered);

	}

	@Test(priority = 16, enabled = true)
	public void verifyInvalidEmailAndPasswordLoginFails() {

		loginPage.setEmail(randomStringGenerator() + "@gmail.com");
		loginPage.setPassword(randomNumberGenerator());
		loginPage.clickLoginButton();

		String currentErrorMessage = loginPage.getPasswordError();
		Assert.assertEquals(currentErrorMessage, errorAccountNotRegistered);

	}

	@Test(priority = 17, enabled = false)
	public void verifyMalformedEmailErrorMessage() {

		String currentError;

		loginPage.setEmail("rizwan123");
		loginPage.setPassword("Rizwan123");
		loginPage.clickLoginButton();
		currentError = loginPage.getEmailError();
		AssertJUnit.assertEquals(currentError, errorMalformedEmail);

		loginPage.setEmail("123@1123.1123");
		loginPage.clickLoginButton();
		currentError = loginPage.getEmailError();
		AssertJUnit.assertEquals(currentError, errorMalformedEmail);

		loginPage.setEmail("a@a.a");
		loginPage.clickLoginButton();
		currentError = loginPage.getEmailError();
		AssertJUnit.assertEquals(currentError, errorMalformedEmail);

		loginPage.setEmail("rizwan@convextech,com");
		loginPage.clickLoginButton();
		currentError = loginPage.getEmailError();
		AssertJUnit.assertEquals(currentError, errorMalformedEmail);

		loginPage.setEmail("rizwan sakhi@convextech.com");
		loginPage.clickLoginButton();
		currentError = loginPage.getEmailError();
		AssertJUnit.assertEquals(currentError, errorMalformedEmail);

		loginPage.clearFieldData(loginPage.getInputFieldEmail());
		loginPage.clearFieldData(loginPage.getInputFieldPassword());

		softAssert.assertAll();

	}

	@Test(priority = 2, enabled = false)
	public void verifyPageElementsDisplayed() {

		// isPageElementsDisplayed(loginPage.getLoginPageElementsList());

	}

	/*
	 * This test case is disabled for now as used library is slow and sometimes does
	 * not return good results.
	 */
	@Test(priority = 3, enabled = false)
	public void verifyPageLayout() {

		int bugsCount = findPageLayoutBugs();
		AssertJUnit.assertEquals(bugsCount, 0);

	}

	@Test(priority = 4, enabled = false)
	public void verifyCursorPosition() {

		WebElement activeElement = driver.switchTo().activeElement();

		AssertJUnit.assertTrue(loginPage.getInputFieldEmail().equals(activeElement));

	}

	@Test(priority = 5, enabled = false)
	public void verifyMinMaxCharLength() {

		int[] charLength;
		int minCharLength, maxCharLength;

		charLength = getMinMaxCharacterLength(loginPage.getInputFieldEmail());
		minCharLength = charLength[0];
		AssertJUnit.assertEquals(minCharLength, 6);
		maxCharLength = charLength[1];
		AssertJUnit.assertEquals(maxCharLength, 60);
		softAssert.assertAll();

	}

	@Test(priority = 13, enabled = false)
	public void verifyCopyMaskedPassword() {

		loginPage.setPassword("TestPassword");
		String copiedText = copyFiedData(loginPage.getInputFieldPassword());

		Assert.assertNotEquals(copiedText, "TestPassword");

	}

	@Test(priority = 14, enabled = false)
	public void verifyCopyRevealedPassword() {

		loginPage.setPassword("TestPassword");

		// Changed the password field status to visible
		loginPage.clickTogglePasswordButton();
		String copiedText = copyFiedData(loginPage.getInputFieldPassword());

		// Reset the password field state by refreshing the page
		driver.navigate().refresh();

		AssertJUnit.assertEquals(copiedText, "TestPassword");

	}

	@Test(priority = 15, enabled = false)
	public void verifyPasswordIsVisible() {

		loginPage.setPassword("Rizwan123");
		loginPage.clickTogglePasswordButton();

		String currentToggleState = loginPage.getPasswordVisibilityStatus();

		AssertJUnit.assertEquals(currentToggleState, "text");

	}

	@Test(priority = 16, enabled = false)
	public void verifyPasswordIsHidden() {

		loginPage.setPassword("Rizwan123");
		loginPage.clickTogglePasswordButton();

		String currentToggleState = loginPage.getPasswordVisibilityStatus();

		AssertJUnit.assertEquals(currentToggleState, "password");

	}

	@Test(priority = 17, enabled = false)
	public void verifyUnRegisteredEmailErrorMessage() {

		loginPage.setEmail("rizwan100@convextech.com");
		loginPage.setPassword("Rizwan123");
		loginPage.clickLoginButton();

		String currentErrorMessage = loginPage.getInvalidEmailOrPasswordError();
		AssertJUnit.assertEquals(currentErrorMessage, errorAccountNotRegistered);

	}

	@Test(priority = 19, enabled = false)
	public void verifyAccountLocked() {

		loginPage.setEmail("rizwan@convextech.com");
		for (int i = 1; i < 5; i++) {
			loginPage.setPassword("Rizwan12345");
			loginPage.clickLoginButton();
		}

		String currentErrorMessage = loginPage.getInvalidEmailOrPasswordError();
		AssertJUnit.assertEquals(currentErrorMessage, errorAccountLocked);

	}

	/*
	 * This test case is disabled, due to unknown time set for locked Account. Once
	 * we know the actual time set until which the account will remain locked we
	 * will set the actual time and enable the test case.
	 */
	@Test(priority = 20, enabled = false)
	public void verifyAccountLockedTime() throws InterruptedException {

		Thread.sleep(60000);
		loginPage.setEmail("rizwan@convextech.com");
		loginPage.setPassword("Rizwan123");
		loginPage.clickLoginButton();

		String currentErrorMessage = loginPage.getInvalidEmailOrPasswordError();
		AssertJUnit.assertEquals(currentErrorMessage, errorAccountLockedTime);

	}

	@Test(priority = 21, enabled = false)
	public void verifyLoginWhileAccountLocked() {

		loginPage.setEmail("rizwan@convextech.com");
		loginPage.setPassword("Rizwan123");
		loginPage.clickLoginButton();

		String currentErrorMessage = loginPage.getInvalidEmailOrPasswordError();
		AssertJUnit.assertEquals(currentErrorMessage, errorAccountLocked);

	}

	/*
	 * This test case is disabled, due to unknown time set for locked Account. Once
	 * we know the actual time set until which the account will remain locked we
	 * will set the actual time and enable the test case.
	 */
	@Test(priority = 22, enabled = false)
	public void verifyLoginAccountUnlocked() {

		loginPage.setEmail("rizwan@convextech.com");
		loginPage.setPassword("Rizwan123");
		loginPage.clickLoginButton();

		boolean loginSuccess = headerPage.isLoggedIn();
		Assert.assertTrue(loginSuccess, "Failed to login!");

	}

	@Test(priority = 23, enabled = false)
	public void verifyIsLoginSuccessfull() {

		loginPage.setEmail("rizwan@convextech.com");
		loginPage.setPassword("Rizwan@123");
		loginPage.clickLoginButton();

		boolean loginStatus = headerPage.isLoggedIn();
		Assert.assertTrue(loginStatus, "Failed to login!");

		verifyLogoutSuccessfull();

	}

	@Test(priority = 24, enabled = false)
	public void verifySubmitLogin() {

		headerPage.clickLogin();

		loginPage.setEmail("rizwan@convextech.com");
		loginPage.setPassword("Rizwan@123");
		loginPage.submitPassword();

		boolean loginSuccess = headerPage.isLoggedIn();
		Assert.assertTrue(loginSuccess, "Failed to login!");

		verifyLogoutSuccessfull();

	}

	@Test(priority = 25, enabled = false)
	public void verifyRedirectionToHomePage() {

		headerPage.clickLogin();

		loginPage.setEmail("rizwan@convextech.com");
		loginPage.setPassword("Rizwan@123");
		loginPage.submitPassword();

		AssertJUnit.assertTrue(headerPage.isLoggedIn());

		String currentURL = driver.getCurrentUrl();
		AssertJUnit.assertEquals(currentURL, baseURL);

	}

	@Test(priority = 26, enabled = false)
	public void verifyLogoutSuccessfull() {

		headerPage.clickProfile();
		headerPage.clickProfileMenuOption("Logout");

		boolean loginStatus = headerPage.isLoggedOut();
		Assert.assertTrue(loginStatus, "Failed to log out!");

	}

	@Test(priority = 27, enabled = false)
	public void verifyRedirectionToRegistration() {

		headerPage.clickLogin();
		loginPage.clickRegisterLink();

		String currentURL = driver.getCurrentUrl();
		AssertJUnit.assertEquals(currentURL, registrationPageURL);

	}

	@Test(priority = 28, enabled = false)
	public void verifyUserRemainsLoginfterClickingBack() {

		headerPage.clickLogin();

		loginPage.setEmail("rizwan@convextech.com");
		loginPage.setPassword("Rizwan@123");
		loginPage.submitPassword();

		driver.navigate().back();
		driver.get(baseURL);

		boolean loginStatus = headerPage.isLoggedIn();
		Assert.assertTrue(loginStatus, "User logged out!");

		verifyLogoutSuccessfull();

	}

	@Test(priority = 29, enabled = false)
	public void verifyUserRemainsLoginAfterClosingBrowser() {

		headerPage.clickLogin();

		loginPage.setEmail("rizwan@convextech.com");
		loginPage.setPassword("Rizwan@123");
		loginPage.submitPassword();

		AssertJUnit.assertTrue(headerPage.isLoggedIn());

		driver.close();
		setup();

		headerPage = new HeaderPage();
		loginPage = new LoginPage();

		boolean loginStatus = headerPage.isLoggedOut();
		Assert.assertTrue(loginStatus, "User is logged In!");

	}

	@Test(priority = 30, enabled = false)
	public void verifyLoginWithGoogle() {

		headerPage.clickLogin();

		// Store the current window handle
		String parentWindow = driver.getWindowHandle();

		// Perform the click operation that opens new window
		loginPage.clickGoogleLoginButton();

		// Switch to new window opened
		Set<String> handles = driver.getWindowHandles();

		for (String windowHandle : handles) {

			if (!windowHandle.equals(parentWindow)) {

				driver.switchTo().window(windowHandle);

				// Perform the actions on new window
				loginPage.setGoogleEmail("rizwan@convextech.com");
				loginPage.clickNextGoogleEmail();
				loginPage.setGooglePassword("CyberMart2022");
				loginPage.clickNextGooglePassword();

				// Close the new window, if that window no more required
				// driver.close();

			}

		}

		// Switch back to original browser (first window)
		// driver.switchTo().defaultContent();
		driver.switchTo().window(parentWindow);

		// Continue with original browser (first window)

		boolean loginStatus = headerPage.isLoggedIn();
		Assert.assertTrue(loginStatus, "User is logged In!");

		verifyLogoutSuccessfull();

	}

	@Test(priority = 31, enabled = false)
	public void verifyLoginWithFacebook() {

		headerPage.clickLogin();

		// Store the current window handle
		String parentWindow = driver.getWindowHandle();

		// Perform the click operation that opens new window
		loginPage.clickFacebookLoginButton();

		// Switch to new window opened
		Set<String> handles = driver.getWindowHandles();

		for (String windowHandle : handles) {

			if (!windowHandle.equals(parentWindow)) {

				driver.switchTo().window(windowHandle);

				// Perform the actions on new window
				loginPage.setFacebookEmail("rizwan@convextech.com");
				loginPage.setFacebookPassword("Rizwan@123");
				loginPage.clickLoginFacebook();

				// Close the new window, if that window no more required
				// driver.close();

			}

		}

		// Switch back to original browser (first window)
		// driver.switchTo().defaultContent();
		driver.switchTo().window(parentWindow);

		// Continue with original browser (first window)

		boolean loginStatus = headerPage.isLoggedIn();
		Assert.assertTrue(loginStatus, "User is logged In!");

	}

	@Test(priority = 32, enabled = false)
	public void verifyIsLoginRegisterLinksDisplaying() {

		// boolean result;

		// result = isWebElementDisplayed(headerPage.getLinkLogin());
		// AssertJUnit.assertFalse(result);

		// result = isWebElementDisplayed(headerPage.getLinkRegister());
		// AssertJUnit.assertFalse(result);

		softAssert.assertAll();

	}

}