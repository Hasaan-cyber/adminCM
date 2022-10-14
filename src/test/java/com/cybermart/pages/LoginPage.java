package com.cybermart.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.cybermart.tests.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {

		elementsInitializer();

	}

//	PAGE ELEMENTS

	@FindBy(xpath = "//form[@class='MuiBox-root muiltr-5xwybr']/h6")
	private WebElement labelLogin;

	@FindBy(xpath = "//input[@id='mui-2']")
	private WebElement inputFieldEmail;

	@FindBy(xpath = "//input[@id='mui-3']")
	private WebElement inputFieldPassword;

	@FindBy(xpath = "//label[@id='mui-2-label']")
	private WebElement labelInputFieldEmail;

	@FindBy(xpath = "//label[@id='mui-3-label']")
	private WebElement labelInputFieldPassword;

	@FindBy(css = ".MuiTypography-root.MuiTypography-body2.muiltr-1dzy9q8")
	private WebElement linkforgotPassword;

	@FindBy(id = "mui-4")
	private WebElement buttonLogin;

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/form/div[1]/p")
	private WebElement errorEmail;

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/form/div[2]/p")
	private WebElement errorPassword;

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/form/div[1]/div/div/div")
	private WebElement iconEmailError;

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/form/div[2]/div/div/div/button")
	private WebElement buttonTogglePassword;

	@FindBy(xpath = "//div[@class='Toastify__toast-body']/div[2]")
	private WebElement toastMessage;

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div/div[2]")
	private WebElement imageLogin;

	@FindBy(id = "loginForm-serverError")
	WebElement errorEmailOrPassword;

	@FindBy(id = "loginForm-googleBtn")
	WebElement buttonLoginWithGoogle;

	@FindBy(id = "loginForm-facebookBtn")
	WebElement buttonLoginWithFacebook;

	@FindBy(id = "identifierId")
	WebElement inputFieldGoogleEmail;

	@FindBy(id = "identifierNext")
	WebElement buttonNextGoogleEmail;

	@FindBy(name = "password")
	WebElement inputFieldGooglePassword;

	@FindBy(id = "passwordNext")
	WebElement buttonNextGooglePassword;

	@FindBy(id = "email")
	WebElement inputFieldFacebookEmail;

	@FindBy(id = "pass")
	WebElement inputFieldFacebookPassword;

	@FindBy(id = "loginbutton")
	WebElement buttonFacebookLogin;

//	PAGE ELEMENTS

	public List<WebElement> getLoginPageElementsList() {

		List<WebElement> list = new ArrayList<WebElement>();

		list.add(labelLogin);
		list.add(inputFieldEmail);
		list.add(inputFieldPassword);
		list.add(buttonTogglePassword);
		list.add(linkforgotPassword);
		list.add(buttonLogin);
		list.add(imageLogin);

		return list;

	}

	public String getLoginFormHeading() {

		return labelLogin.getAttribute("innerHTML");

	}

	public WebElement getImageLogin() {

		return imageLogin;

	}

	public WebElement getToast() {

		return toastMessage;

	}

	public String getToastMessageText() {

		return toastMessage.getAttribute("innerHTML");

	}

	public WebElement getLabelLogin() {

		return labelLogin;

	}

	public WebElement getIconEmailError() {

		System.out.println(iconEmailError.toString());
		return iconEmailError;

	}

	public WebElement getbuttonLogin() {

		return buttonLogin;

	}

	public String getLabelEmailField() {

		return labelInputFieldEmail.getAttribute("innerHTML");

	}

	public String getLabelPasswordField() {

		return labelInputFieldPassword.getAttribute("innerHTML");

	}

	public String getEmailFieldPlaceholder() {

		return inputFieldEmail.getAttribute("placeholder");

	}

	public String getPasswordFieldPlaceholder() {

		return inputFieldPassword.getAttribute("placeholder");

	}

	public String getEmailError() {

		return errorEmail.getAttribute("innerHTML");

	}

	public String getPasswordError() {

		return errorPassword.getAttribute("innerHTML");

	}

	public void clickForgotLink() {

		linkforgotPassword.click();

	}

	public void clickEmailField() {

		inputFieldEmail.click();

	}

	public void clickPasswordField() {

		inputFieldPassword.click();

	}

	public void clickLoginButton() {

		buttonLogin.click();

	}

	public void clickTogglePasswordButton() {

		buttonTogglePassword.click();

	}

	public void setEmail(String email) {

		clearFieldData(inputFieldEmail);
		inputFieldEmail.sendKeys(email);

	}

	public void setPassword(String password) {

		clearFieldData(inputFieldPassword);
		inputFieldPassword.sendKeys(password);

	}

	public WebElement getInputFieldEmail() {

		return inputFieldEmail;

	}

	public WebElement getInputFieldPassword() {

		return inputFieldPassword;

	}

	public void submitPassword() {

		inputFieldPassword.submit();

	}

	public String getInvalidEmailOrPasswordError() {

		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(errorEmailOrPassword));
		return errorEmailOrPassword.getAttribute("innerHTML");

	}

	public String getPasswordVisibilityStatus() {

		return inputFieldPassword.getAttribute("type");

	}

	public void clickGoogleLoginButton() {

		buttonLoginWithGoogle.click();

	}

	public void setGoogleEmail(String email) {

		inputFieldGoogleEmail.sendKeys(email);

	}

	public void clickNextGoogleEmail() {

		buttonNextGoogleEmail.click();

	}

	public void setGooglePassword(String password) {

		inputFieldGooglePassword.sendKeys(password);

	}

	public void clickNextGooglePassword() {

		buttonNextGooglePassword.click();

	}

	public void clickFacebookLoginButton() {

		buttonLoginWithFacebook.click();

	}

	public void setFacebookEmail(String email) {

		inputFieldFacebookEmail.sendKeys(email);

	}

	public void setFacebookPassword(String password) {

		inputFieldFacebookPassword.sendKeys(password);

	}

	public void clickLoginFacebook() {

		buttonFacebookLogin.click();

	}

	public void loginWithGoogle() {

		// Store the current window handle
		String parentWindow = driver.getWindowHandle();

		// Perform the click operation that opens new window
		clickGoogleLoginButton();

		// Switch to new window opened
		Set<String> handles = driver.getWindowHandles();

		for (String windowHandle : handles) {

			if (!windowHandle.equals(parentWindow)) {

				driver.switchTo().window(windowHandle);

				// Perform the actions on new window
				setGoogleEmail("rizwan@convextech.com");
				clickNextGoogleEmail();
				setGooglePassword("CyberMart2022");
				clickNextGooglePassword();

				// Close the new window, if that window no more required
				// driver.close();

			}

		}

		// Switch back to original browser (first window)
		// driver.switchTo().defaultContent();
		driver.switchTo().window(parentWindow);

		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(getToast()));
		String actualMessage = getToastMessageText();
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOf(getToast()));
		Assert.assertEquals(actualMessage, "Logged-In successfully");

	}

	public void loginWithFacebook() {

		// Store the current window handle
		String parentWindow = driver.getWindowHandle();

		// Perform the click operation that opens new window
		clickFacebookLoginButton();

		// Switch to new window opened
		Set<String> windowHandles = driver.getWindowHandles();

		for (String window : windowHandles) {

			if (!window.equals(parentWindow)) {

				driver.switchTo().window(window);

				// Perform the actions on new window
				setFacebookEmail("rizwan@convextech.com");
				setFacebookPassword("Rizwan@123");
				clickLoginFacebook();

				// Close the new window, if that window no more required
				// driver.close();

			}

		}

		// Switch back to original browser (first window)
		// driver.switchTo().defaultContent();
		driver.switchTo().window(parentWindow);

		// Continue with original browser (first window)

		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(getToast()));
		String actualMessage = getToastMessageText();
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOf(getToast()));
		Assert.assertEquals(actualMessage, "Logged-In successfully");

	}

	public void loginUserBySubmit(String email, String password) {

		inputFieldEmail.sendKeys(email);
		inputFieldPassword.sendKeys(password);
		inputFieldPassword.submit();

	}

	public void loginUserByButtonClick(String email, String password) {

		inputFieldEmail.sendKeys(email);
		inputFieldPassword.sendKeys(password);
		buttonLogin.click();

	}

}