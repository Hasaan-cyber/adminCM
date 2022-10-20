package com.cybermart.tests;

//import static com.cybermart.tests.BaseClass.baseURL;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cybermart.pages.HeaderPage;
import com.cybermart.pages.LoginPage;

public class LoginTest extends BaseClass {

	// Declaring the global objects of LoginPage and HeaderPage, so to make the
	// access throughout the class.
	LoginPage loginPage;
	HeaderPage headerPage;

	@Test(priority = 1, enabled = true)
	public void verifyLoginPageLoaded() {

		// initializing the HeaderPage and LoginPage classes objects.
		headerPage = new HeaderPage();
		loginPage = new LoginPage();

		/*
		 * Using the jsPageLoadingStatus method of BaseClass validates if the page is
		 * loaded successfully or not.
		 */
		Assert.assertTrue(jsPageLoadingStatus());

	}

	@Test(priority = 2, enabled = true)
	public void verifyLoginPageURL() {

		/*
		 * Validates the current URL, myWait method of BaseClass is used to add some
		 * wait as sometimes driver picks the URL before it's loaded.
		 */
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(strings.getString("urlLoginPage")));

	}

	@Test(priority = 3, enabled = true)
	public void verifyLoginPageTitle() {

		/*
		 * Validates the current page Title, myWait method of BaseClass is used to add
		 * some wait as sometimes driver picks the title of the page before it's loaded.
		 */
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.titleIs(strings.getString("titleLoginPage")));

	}

	@Test(priority = 4, enabled = true)
	public void verifyPageElementsDisplayed() {

		/*
		 * Validates the presence of page elements using BaseClass method
		 * isPageElementsDisplayed, which Takes list of WebElements as it's parameter.
		 * getLoginPageElementsList is a method in LoginPage class which returns the
		 * list of WebElements.
		 */
		isPageElementsDisplayed(loginPage.getLoginPageElementsList());

	}

	/*
	 * This test case is disabled for now as used library is slow and sometimes does
	 * not return good results.
	 */
	@Test(priority = 5, enabled = false)
	public void verifyPageLayout() {

		/*
		 * Calling findPageLayoutBugs method of BaseClass, which actually uses a google
		 * api to perform this job.
		 */
		int bugsCount = findPageLayoutBugs();

		// Validates if the bug count is 0 or not.
		Assert.assertEquals(bugsCount, 0);

	}

	@Test(priority = 6, enabled = true)
	public void verifyCursorPosition() {

		// Assigned Email field to Expected result.
		WebElement expectedResult = loginPage.getInputFieldEmail();

		// Returns the current active (focused) element on page.
		WebElement actualResult = driver.switchTo().activeElement();

		// Validates if the actual result is same as the expected result or not.
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 7, enabled = true)
	public void verifyLoginFormHeading() {

		// Expected heading of the login form
		String expectedResult = "Login";

		// Using getLoginFormHeading method of LoginPage class get's the login form
		// heading.
		String actualResult = loginPage.getLoginFormHeading();

		// Validates the actual and expected results are same or not.
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 8, enabled = true)
	public void verifyEmailLabel() {

		// Created local variable for expected result.
		String expectedLabel = "Email";

		// Get the actual label of email field.
		String actualLabel = loginPage.getLabelEmailField();

		// Compares the actual and expected results.
		Assert.assertEquals(actualLabel, expectedLabel);

	}

	@Test(priority = 9, enabled = true)
	public void verifyPasswordLabel() {

		// Created local variable for expected result.
		String expectedLabel = "Password";

		// Get the actual label of password field.
		String actualLabel = loginPage.getLabelPasswordField();

		// Compares the actual and expected results.
		Assert.assertEquals(actualLabel, expectedLabel);

	}

	@Test(priority = 10, enabled = true)
	public void verifyEmailPlaceholder() {

		// Created local variable for expected result.
		String expectedPlaceholder = strings.getString("placeholderEmail");

		// Get the actual placeholder of email field.
		String actualPlaceholder = loginPage.getEmailFieldPlaceholder();

		// Compares the actual and expected results.
		Assert.assertEquals(actualPlaceholder, expectedPlaceholder);

	}

	@Test(priority = 11, enabled = true)
	public void verifyPasswordPlaceholder() {

		// Created local variable for expected result.
		String expectedPlaceholder = strings.getString("placeholderPassword");

		// Get the actual placeholder of email field.
		String actualPlaceholder = loginPage.getPasswordFieldPlaceholder();

		// Compares the actual and expected results.
		Assert.assertEquals(actualPlaceholder, expectedPlaceholder);

	}

	@Test(priority = 12, enabled = true)
	public void verifyEmailRequiredErrorMessage() {

		// Created local variable to store expected result.
		String expectedError = strings.getString("errorEmailRequired");

		// Clicks the email field.
		loginPage.clickEmailField();

		// Focus out the email field.
		loginPage.getInputFieldEmail().sendKeys(Keys.TAB);

		// Get the actual error message displayed.
		String actualError = loginPage.getEmailError();

		// Compares the actual and expected Error messages.
		Assert.assertEquals(actualError, expectedError);

	}

	@Test(priority = 13, enabled = true)
	public void verifyPasswordRequiredErrorMessage() {

		// Created local variable to store expected result.
		String expectedError = strings.getString("errorPasswordRequired");

		// Clicks the password field.
		loginPage.clickPasswordField();

		// Focus out the password field.
		loginPage.getInputFieldPassword().sendKeys(Keys.TAB);

		// Get the actual error message displayed.
		String actualError = loginPage.getPasswordError();

		// Compares the actual and expected Error messages.
		Assert.assertEquals(actualError, expectedError);

	}

	@Test(priority = 14, enabled = true)
	public void verifyBlankEmailLoginFails() {

		// Created local variable to store expected result.
		String expectedError = strings.getString("errorEmailRequired");

		// Set the value in password field.
		loginPage.setPassword("Rizwan@123");

		// Clicks the login button.
		loginPage.clickLoginButton();

		// Get the actual error message if displayed.
		String actualError = loginPage.getEmailError();

		// Cleared the password field.
		clearFieldData(loginPage.getInputFieldPassword());

		// Compared the actual and expected results.
		Assert.assertEquals(actualError, expectedError);

	}

	@Test(priority = 15, enabled = true)
	public void verifyBlankPasswordLoginFails() {

		// Created local variable to store expected result.
		String expectedError = strings.getString("errorPasswordRequired");

		// Set the value in email field.
		loginPage.setEmail("rizwan@convextech.com");

		// Clicks the login button.
		loginPage.clickLoginButton();

		// Get the actual error message if displayed.
		String actualError = loginPage.getPasswordError();

		// Cleared the email field.
		clearFieldData(loginPage.getInputFieldEmail());

		// Compared the actual and expected results.
		Assert.assertEquals(actualError, expectedError);

	}

	@Test(priority = 16, enabled = false)
	public void verifyBlankEmailAndPasswordLoginFails() {

		// Created local variable to store email required error message.
		String expectedErrorEmail = strings.getString("errorEmailRequired");

		// Created local variable to store password required error message.
		String expectedErrorPassword = strings.getString("errorPasswordRequired");

		// local variable for actual error.
		String actualError;

		// Clicks the login button.
		loginPage.clickLoginButton();

		// Get the email error.
		actualError = loginPage.getEmailError();

		// Compares the actual and expected results.
		softAssert.assertEquals(actualError, expectedErrorEmail);

		// Get the password error.
		actualError = loginPage.getPasswordError();

		// Compares the actual and expected results.
		softAssert.assertEquals(actualError, expectedErrorPassword);

		// Validates the both asserts.
		softAssert.assertAll();

	}

	@Test(priority = 17, enabled = true)
	public void verifyInvalidPasswordLoginFails() {

		// Created local variable to store expected error
		String expectedError = strings.getString("errorInvalidEmailOrPassword");

		// Calls the login method to login user by clicking login button.
		loginPage.loginUserByButtonClick(strings.getString("validRegisteredEmail"), randomStringGenerator());

		// Get the error returned from server.
		String actualError = loginPage.getPasswordError();

		// Compares the actual and expected results.
		Assert.assertEquals(actualError, expectedError);

	}

	@Test(priority = 18, enabled = true)
	public void verifyUnregisteredEmailLoginFails() {

		// Created local variable to store expected error
		String expectedError = strings.getString("errorAccountNotRegistered");

		// Calls the login method to login user by clicking login button.
		loginPage.loginUserByButtonClick(randomStringGenerator() + "@gmail.com",
				strings.getString("validPassword"));

		// Get the error returned from server.
		String actualError = loginPage.getPasswordError();

		// Compares the actual and expected results.
		Assert.assertEquals(actualError, expectedError);

	}

	@Test(priority = 19, enabled = true)
	public void verifyInvalidEmailAndPasswordLoginFails() {

		// Created local variable to store expected error
		String expectedError = strings.getString("errorAccountNotRegistered");

		// Calls the login method to login user by clicking login button.
		loginPage.loginUserByButtonClick(randomStringGenerator() + "@gmail.com", randomNumberGenerator());

		// Get the error returned from server.
		String actualError = loginPage.getPasswordError();

		// Compares the actual and expected results.
		Assert.assertEquals(actualError, expectedError);

	}

	@Test(priority = 20, enabled = true)
	public void verifyMalformedEmailErrorMessage() {

		// Validates the list of invalid email formats.
		staticInvalidEmailChecker(loginPage.getInputFieldEmail(), loginPage.getbuttonLogin(), loginPage.getEmailError(),
				strings.getString("errorMalformedEmail"));

	}

	@Test(priority = 21, enabled = true)
	public void verifyEmailErrorIconDisplayed() {

		// Set some invalid format of email.
		loginPage.setEmail("rizwan123");

		// Clicks the login button.
		loginPage.clickLoginButton();

		// Focus out email field.
		// loginPage.getInputFieldEmail().sendKeys(Keys.TAB);

		// Get the result if error icon displayed or not.
		boolean result = isWebElementDisplayed(loginPage.getIconEmailError());

		// Validate the result.
		Assert.assertTrue(result);

	}

	@Test(priority = 22, enabled = true)
	public void verifyPasswordIsHiddenByDefault() {

		// Created local variable to store expected result.
		String expectedResult = "password";

		// Set the value in password field.
		loginPage.setPassword("TestPassword");

		// Get the visibility of entered text in password field.
		String actualResult = loginPage.getPasswordVisibilityStatus();

		// Validate the actual and expected results.
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 23, enabled = true)
	public void verifyPasswordIsVisible() {

		// Created local variable to store expected result.
		String expectedResult = "text";

		// Set the value in password field.
		loginPage.setPassword("Rizwan123");

		// Click the eye icon on password field.
		loginPage.clickTogglePasswordButton();

		// Get the visibility of entered text in password field.
		String actualResult = loginPage.getPasswordVisibilityStatus();

		// Validate the actual and expected results.
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 24, enabled = true)
	public void verifyPasswordIsHidden() {

		// Created local variable to store expected result.
		String expectedResult = "password";

		// Set the value in password field.
		loginPage.setPassword("Rizwan123");

		// Click the eye icon on password field.
		loginPage.clickTogglePasswordButton();

		// Get the visibility of entered text in password field.
		String actualResult = loginPage.getPasswordVisibilityStatus();

		// Validate the actual and expected results.
		Assert.assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 25, enabled = true)
	public void verifyCopyMaskedPassword() {

		// Created local variable to store expected result.
		String expectedResult = "TestPassword";

		// Created local variable to store actual result.
		String actualResult;

		// Set the value in password field.
		loginPage.setPassword(expectedResult);

		// Checks the visibility of text entered in the password field.
		if (loginPage.getPasswordVisibilityStatus().equals("password")) {

			// Copy the text entered in the password field.
			actualResult = copyFiedData(loginPage.getInputFieldPassword());

		} else {

			// Click the eye icon on password field.
			loginPage.clickTogglePasswordButton();

			// Copy the text entered in the password field.
			actualResult = copyFiedData(loginPage.getInputFieldPassword());

		}

		// Validate the actual and expected results.
		Assert.assertNotEquals(actualResult, expectedResult);

	}

	@Test(priority = 26, enabled = true)
	public void verifyCopyRevealedPassword() {

		// Created local variable to store expected result.
		String expectedResult = "TestPassword";

		// Created local variable to store actual result.
		String actualResult;

		// Set the value in password field.
		loginPage.setPassword(expectedResult);

		// Checks the visibility of text entered in the password field.
		if (loginPage.getPasswordVisibilityStatus().equals("text")) {

			// Copy the text entered in the password field.
			actualResult = copyFiedData(loginPage.getInputFieldPassword());

		} else {

			// Click the eye icon on password field.
			loginPage.clickTogglePasswordButton();

			// Copy the text entered in the password field.
			actualResult = copyFiedData(loginPage.getInputFieldPassword());

		}

		// Validate the actual and expected results.
		Assert.assertNotEquals(actualResult, expectedResult);

	}

	@Test(priority = 27, enabled = true)
	public void verifyMinMaxCharLength() {

		/*
		 * Created local variable to store list of actual minimum and maximum character
		 * length.
		 */
		int[] charLength;

		/*
		 * Created local variables to separate out and store actual minimum and maximum
		 * character lengths.
		 */
		int minCharLength, maxCharLength;

		// Get the actual minimum and maximum character length of email field.
		charLength = getMinMaxCharacterLength(loginPage.getInputFieldEmail());

		// Assign the minimum character length.
		minCharLength = charLength[0];

		// Validates the actual and expected results.
		softAssert.assertEquals(minCharLength, 6);

		// Assign the maximum character length.
		maxCharLength = charLength[1];

		// Validates the actual and expected results.
		softAssert.assertEquals(maxCharLength, 60);

		// Consolidate the results from both assertions.
		softAssert.assertAll();

	}

	@Test(priority = 28, enabled = false)
	public void verifyAccountLocked() {

		// Created local variable to store the expected error.
		String expectedError = strings.getString("errorAccountLocked");

		// Set the valid registered email in email field.
		loginPage.setEmail(strings.getString("validRegisteredEmail"));

		// Performs 5 attempt to login.
		for (int i = 1; i < 5; i++) {

			// Set the invalid password in password field.
			loginPage.setPassword(randomNumberGenerator());

			// Clicks the login button.
			loginPage.clickLoginButton();

		}

		// Get actual error message returned from server.
		String actualError = loginPage.getPasswordError();

		// Compares the actual and expected error.
		Assert.assertEquals(actualError, expectedError);

	}

	/*
	 * This test case is disabled, due to unknown time set for locked Account. Once
	 * we know the actual time set until which the account will remain locked we
	 * will set the actual time and enable the test case.
	 */
	@Test(priority = 29, enabled = false)
	public void verifyAccountLockedTime() throws InterruptedException {

		// Created local variable to store expected error message.
		String expectedError = strings.getString("errorAccountLockedTime");

		// Added wait for 1 minutes.
		Thread.sleep(60000);

		// Calls the login method to login user by clicking login button.
		loginPage.loginUserByButtonClick(strings.getString("validRegisteredEmail"),
				strings.getString("validPassword"));

		// Get actual error message returned from server.
		String actualError = loginPage.getPasswordError();

		// Compares the actual and expected results.
		Assert.assertEquals(actualError, expectedError);

	}

	@Test(priority = 30, enabled = false)
	public void verifyLoginWhileAccountLocked() {

		// Created the local variable to store the expected error.
		String expectedError = strings.getString("errorAccountLocked");

		// Calls the login method to login user by clicking login button.
		loginPage.loginUserByButtonClick(strings.getString("validRegisteredEmail"),
				strings.getString("validPassword"));

		// Get the actual error message.
		String actualError = loginPage.getPasswordError();

		// Compares the actual and expected results.
		Assert.assertEquals(actualError, expectedError);

	}

	/*
	 * This test case is disabled, due to unknown time set for locked Account. Once
	 * we know the actual time set until which the account will remain locked we
	 * will set the actual time and enable the test case.
	 */
	@Test(priority = 31, enabled = false)
	public void verifyLoginAccountUnlocked() {

		// Created local variable to store expected message.
		String expectedMessage = strings.getString("messageLoginSuccess");

		// Calls the login method to login user by clicking login button.
		loginPage.loginUserByButtonClick(strings.getString("validRegisteredEmail"),
				strings.getString("validPassword"));

		// Get the actual message on successful login.
		String actualMessage = loginPage.getToastMessageText();

		// Compares the actual and expected message.
		Assert.assertEquals(actualMessage, expectedMessage);

	}

	@Test(priority = 32, enabled = true)
	public void verifyIsLoginSuccessfull() {

		// Created local variable to store expected message.
		String expectedMessage = strings.getString("messageLoginSuccess");

		// Checks if the user is login already.
		if (headerPage.isLoggedIn()) {

			// Logout user from system.
			verifyLogoutSuccessfull();

			// Calls the login method to login user by clicking login button.
			loginPage.loginUserByButtonClick(strings.getString("validRegisteredEmail"),
					strings.getString("validPassword"));

		} else {

			// Calls the login method to login user by clicking login button.
			loginPage.loginUserByButtonClick(strings.getString("validRegisteredEmail"),
					strings.getString("validPassword"));

		}

		// Added wait for the visibility of toast message.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(loginPage.getToast()));

		// Get the actual message on successful login.
		String actualMessage = loginPage.getToastMessageText();

		// Added wait for the invisibility of toast message.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOf(loginPage.getToast()));

		// Compares the actual and expected message.
		Assert.assertEquals(actualMessage, expectedMessage);

	}

	@Test(priority = 33, enabled = true)
	public void verifySubmitLogin() {

		// Created local variable to store expected message.
		String expectedMessage = strings.getString("messageLoginSuccess");

		// Checks if the user is login already.
		if (headerPage.isLoggedIn()) {

			// Logout user from system.
			verifyLogoutSuccessfull();

			// Calls the login method to login user by clicking Enter key.
			loginPage.loginUserBySubmit(strings.getString("validRegisteredEmail"),
					strings.getString("validPassword"));

		} else {

			// Calls the login method to login user by clicking Enter key.
			loginPage.loginUserBySubmit(strings.getString("validRegisteredEmail"),
					strings.getString("validPassword"));

		}

		// Added wait for the visibility of toast message.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(loginPage.getToast()));

		// Get the actual message on successful login.
		String actualMessage = loginPage.getToastMessageText();

		// Added wait for the invisibility of toast message.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOf(loginPage.getToast()));

		// Compares the actual and expected message.
		Assert.assertEquals(actualMessage, expectedMessage);

	}

	@Test(priority = 34, enabled = true)
	public void verifyRedirectionToHomePage() {

		// Created local variable to store expected URL.
		String expectedURL = strings.getString("urlDashboardPage");
		// baseURL + "/dashboard";

		// Checks if the user is login already.
		if (headerPage.isLoggedIn()) {

			// Logout user from system.
			verifyLogoutSuccessfull();

			// Calls the login method to login user by clicking Enter key.
			loginPage.loginUserBySubmit(strings.getString("validRegisteredEmail"),
					strings.getString("validPassword"));

		} else {

			// Calls the login method to login user by clicking Enter key.
			loginPage.loginUserBySubmit(strings.getString("validRegisteredEmail"),
					strings.getString("validPassword"));

		}

		// Checks the profile icon displayed and if the user is login successfully.
		Assert.assertTrue(headerPage.isLoggedIn());

		// Get the current page URL.
		String actualURL = driver.getCurrentUrl();

		// Compares the actual and expected URl.
		Assert.assertEquals(actualURL, expectedURL);

	}

	@Test(priority = 35, enabled = true)
	public void verifyUserRemainsLoginfterClickingBack() {

		// Checks if the user is login already.
		if (headerPage.isLoggedIn()) {

			// Logout user from system.
			verifyLogoutSuccessfull();

			// Calls the login method to login user by clicking Enter key.
			loginPage.loginUserBySubmit(strings.getString("validRegisteredEmail"),
					strings.getString("validPassword"));

		} else {

			// Calls the login method to login user by clicking Enter key.
			loginPage.loginUserBySubmit(strings.getString("validRegisteredEmail"),
					strings.getString("validPassword"));

		}

		// Clicks the browser back button.
		driver.navigate().back();

		// Open the URL in the current window of the browser.
		driver.get(strings.getString("baseURL"));

		// Get the current login status.
		boolean loginStatus = headerPage.isLoggedIn();

		// Validates if the user is still login or logged out.
		Assert.assertTrue(loginStatus, "User logged out!");

	}

	@Test(priority = 36, enabled = true)
	public void verifyLogoutSuccessfull() {

		// Created local variable to store the expected message.
		String expectedMessage = strings.getString("messageLogoutSuccess");

		// Checks if the user is login already.
		if (headerPage.isLoggedIn()) {

			// Logout user from the system.
			headerPage.logoutUser();

		} else {

			// Calls the login method to login user by clicking Enter key.
			loginPage.loginUserBySubmit(strings.getString("validRegisteredEmail"),
					strings.getString("validPassword"));

			// Logout user from the system.
			headerPage.logoutUser();

		}

		// Added wait for the visibility of toast message.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(loginPage.getToast()));

		// Get the actual message on successful login.
		String actualMessage = loginPage.getToastMessageText();

		// Added wait for the invisibility of toast message.
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOf(loginPage.getToast()));

		// Compares the actual and expected message.
		Assert.assertEquals(actualMessage, expectedMessage);

	}

	@Test(priority = 37, enabled = true)
	private void verifyAccountAccessByClickingBackAfterLogout() {

		// Created local variable assigned expected URL.
		String expectedURL = strings.getString("urlLoginPage");

		// Created local variable to store actual URL.
		String actualURL;

		// Checks if the user is login already.
		if (headerPage.isLoggedIn()) {

			// logout user from the system.
			verifyLogoutSuccessfull();

			// Clicks the browser back key.
			driver.navigate().back();

			// Get the current page URL.
			actualURL = driver.getCurrentUrl();

			// Compares actual and expected URL's.
			softAssert.assertEquals(actualURL, expectedURL);

			// Opens the dashboard URL in the browser.
			driver.get(strings.getString("urlDashboardPage"));

			// Get the current page URL.
			actualURL = driver.getCurrentUrl();

			// Compares actual and expected URL's.
			softAssert.assertEquals(actualURL, expectedURL);

		} else {

			// login user into the system.
			verifyIsLoginSuccessfull();

			// logout user from the system.
			verifyLogoutSuccessfull();

			// Clicks the browser back key.
			driver.navigate().back();

			// Get the current page URL.
			actualURL = driver.getCurrentUrl();

			// Compares actual and expected URL's.
			softAssert.assertEquals(actualURL, expectedURL);

			// Opens the dashboard URL in the browser.
			driver.get(strings.getString("urlDashboardPage"));

			// Get the current page URL.
			actualURL = driver.getCurrentUrl();

			// Compares actual and expected URL's.
			softAssert.assertEquals(actualURL, expectedURL);

		}

		// Validates both assert statements.
		softAssert.assertAll();

	}

	@Test(priority = 38, enabled = true)
	public void verifyLoginWithDifferentCredentialsAtSameBrowser() {

		// Created local variable for actual result.
		boolean result = false;

		if (headerPage.isLoggedIn()) {
			// Store the current window handle
			String parentWindow = driver.getWindowHandle();

			// Opens new tab.
			jsOpenNewTab();

			Set<String> windowHandles = driver.getWindowHandles();

			for (String window : windowHandles) {

				if (!window.equals(parentWindow)) {

					driver.switchTo().window(window);

					// Perform the actions on new window
					driver.get(strings.getString("urlLoginPage"));

					result = myWait(Duration.ofSeconds(5))
							.until(ExpectedConditions.urlToBe(strings.getString("urlDashboardPage")));

				}
			}

			// Close the new window, if that window no more required
			driver.close();

			// Switch back to original browser (first window)
			// driver.switchTo().defaultContent();
			driver.switchTo().window(parentWindow);

		} else {

			// Login user to the system.
			verifyIsLoginSuccessfull();

			// Store the current window handle
			String parentWindow = driver.getWindowHandle();

			// Opens new tab.
			jsOpenNewTab();

			Set<String> windowHandles = driver.getWindowHandles();

			for (String window : windowHandles) {

				if (!window.equals(parentWindow)) {

					driver.switchTo().window(window);

					// Perform the actions on new window
					driver.get(strings.getString("urlLoginPage"));

					result = myWait(Duration.ofSeconds(5))
							.until(ExpectedConditions.urlToBe(strings.getString("urlDashboardPage")));

				}
			}

			// Close the new window, if that window no more required
			driver.close();

			// Switch back to original browser (first window)
			// driver.switchTo().defaultContent();
			driver.switchTo().window(parentWindow);
		}

		// Validate the final result.
		Assert.assertTrue(result);

	}

	@Test(priority = 39, enabled = false)
	public void verifySignInWithGoogleWhenAccountNotLoggedInBrowser() {

		// Checks if the user is login to the system.
		if (headerPage.isLoggedIn()) {

			// Logout user from the system.
			verifyLogoutSuccessfull();

			// Login user with gmail account.
			loginPage.loginWithGoogle();

		} else {

			// Login user with gmail account.
			loginPage.loginWithGoogle();

		}

	}

	@Test(priority = 40, enabled = false)
	public void verifySignInWithFacebookWhenAccountNotLoggedInBrowser() {

		if (headerPage.isLoggedIn()) {

			// Logout user from the system.
			verifyLogoutSuccessfull();

			// Login user with facebook.
			loginPage.loginWithFacebook();

		} else {

			// Login user with facebook.
			loginPage.loginWithFacebook();

		}

	}

	@Test(priority = 41, enabled = true)
	public void verifyUserRemainsLoginAfterClosingBrowser() {

		if (headerPage.isLoggedIn()) {

			driver.close();
			setup();

			headerPage = new HeaderPage();
			loginPage = new LoginPage();

			String currentURL = driver.getCurrentUrl();
			Assert.assertEquals(currentURL, strings.getString("urlDashboardPage"));

		} else {

			verifyIsLoginSuccessfull();

			driver.close();
			setup();

			headerPage = new HeaderPage();
			loginPage = new LoginPage();

			String currentURL = driver.getCurrentUrl();
			Assert.assertEquals(currentURL, strings.getString("urlDashboardPage"));

		}

	}

}