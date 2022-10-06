package com.cybermart.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cybermart.tests.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {

		elementsInitializer();

	}

//	PAGE ELEMENTS

	@FindBy(xpath = "//form[@class='MuiBox-root muiltr-5xwybr']/h6")
	WebElement labelLogin;

	@FindBy(xpath = "//input[@id='mui-2']")
	WebElement inputFieldEmail;

	@FindBy(xpath = "//input[@id='mui-3']")
	WebElement inputFieldPassword;

	@FindBy(xpath = "//label[@id='mui-2-label']")
	WebElement labelInputFieldEmail;

	@FindBy(xpath = "//label[@id='mui-3-label']")
	WebElement labelInputFieldPassword;

	@FindBy(css = ".MuiTypography-root.MuiTypography-body2.muiltr-1dzy9q8")
	WebElement forgetLink;

	@FindBy(id = "mui-4")
	WebElement buttonLogin;

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/form/div[1]/p")
	WebElement errorEmail;

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/form/div[2]/p")
	WebElement errorPassword;

	@FindBy(id = "loginForm-serverError")
	WebElement errorEmailOrPassword;

	@FindBy(id = "togglePassword")
	WebElement buttonTogglePassword;

	@FindBy(id = "loginForm-forgotPassword")
	WebElement linkForgot;

	@FindBy(id = "loginForm-registerLink")
	WebElement linkRegister;

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

	public WebElement getLabelLogin() {

		return labelLogin;

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

		forgetLink.click();

	}

	public void loginUserSuccessfull() {

		setEmail("airas.mangotech@gmail.com");
		setPassword("123456");
		clickLoginButton();

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

	public void clickRegisterLink() {

		linkRegister.click();

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

	public boolean isLoginLabelVisible() {

		try {
			labelLogin.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isEmailFieldVisible() {

		try {
			inputFieldEmail.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isPasswordFieldVisible() {

		try {
			inputFieldPassword.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isRegisterLinkVisible() {

		try {
			linkRegister.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isLoginButtonVisible() {

		try {
			buttonLogin.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isGoogleButtonVisible() {

		try {
			buttonLoginWithGoogle.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isFacebookButtonVisible() {

		try {
			buttonLoginWithFacebook.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isTogglePasswordButtonVisible() {

		try {
			buttonTogglePassword.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isForgotPasswordLinkVisible() {

		try {
			linkForgot.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

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

}