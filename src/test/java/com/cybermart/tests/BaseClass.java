package com.cybermart.tests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.googlecode.fightinglayoutbugs.FightingLayoutBugs;
import com.googlecode.fightinglayoutbugs.LayoutBug;
import com.googlecode.fightinglayoutbugs.WebPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected static WebDriver driver;
	String browser = "chrome";
	String baseURL = "https://admin.cybermart.com";

	private static JavascriptExecutor jsExecutor;
	SoftAssert softAssert;

	@BeforeClass
	// @Parameters("browser")
	public void setup() {

		try {

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(baseURL);
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.get(baseURL);
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
				driver.get(baseURL);
				driver.manage().window().maximize();
			}

			jsExecutor = (JavascriptExecutor) driver;
			softAssert = new SoftAssert();

		} catch (Exception e) {

			System.out.println("Cause is: " + e.getCause());
			System.out.println("Message is: " + e.getMessage());
			e.printStackTrace();

		}

	}

	public void elementsInitializer() {

		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);

	}

	public boolean jsPageLoadingStatus() {

		boolean pageStatus = jsExecutor.executeScript("return document.readyState").equals("complete");

		if (!pageStatus) {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
					pageStatus = jsExecutor.executeScript("return document.readyState").equals("complete");
					if (pageStatus) {
						return pageStatus;
					}
				} catch (InterruptedException e) {
					System.out.println("Page has not Loaded!");
				}
			}
		}

		return pageStatus;

	}

	public void jsPageScroller(WebElement element) {

		jsExecutor.executeScript("arguments[0].scrollIntoView()", element);

	}

	public void jsElementClicker(WebElement element) {

		jsExecutor.executeScript("arguments[0].click()", element);

	}

	public void jsClear(WebElement element) {

		jsExecutor.executeScript("arguments[0].value = ''", element);

	}

	public void jsOpenNewTab() {

		jsExecutor.executeScript("window.open('about:blank','_blank');");

	}

	public void clearFieldData(WebElement element) {

		element.sendKeys(Keys.SHIFT, Keys.ARROW_UP);
		element.sendKeys(Keys.DELETE);

	}

	public void clearPhoneFieldData(WebElement element) {

		element.sendKeys(Keys.SHIFT, Keys.ARROW_UP);
		element.sendKeys(Keys.SHIFT, Keys.ARROW_RIGHT);
		element.sendKeys(Keys.SHIFT, Keys.ARROW_RIGHT);
		element.sendKeys(Keys.SHIFT, Keys.ARROW_RIGHT);
		element.sendKeys(Keys.DELETE);

	}

	public int[] getMinMaxCharacterLength(WebElement element) {

		int[] charLength = new int[2];

		String minLength = element.getAttribute("minlength");
		System.out.println("Minimum character length is: " + minLength);
		charLength[0] = Integer.parseInt(minLength);

		String maxLength = element.getAttribute("maxlength");
		System.out.println("Maximum character length is: " + maxLength);
		charLength[1] = Integer.parseInt(maxLength);
		return charLength;

	}

	public String copyFiedData(WebElement element) {

		String copiedText = "";

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();

		StringSelection stringSelection = new StringSelection(copiedText);
		clipboard.setContents(stringSelection, null);

		element.sendKeys(Keys.COMMAND, "a");
		element.sendKeys(Keys.COMMAND, "c");

		try {

			copiedText = (String) clipboard.getData(DataFlavor.stringFlavor);

		} catch (UnsupportedFlavorException | IOException e) {

			e.printStackTrace();

		}

		return copiedText;

	}

	public WebDriverWait myWait(Duration timeoutInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

		return wait;

	}

	public String randomNumberGenerator() {

		// create a string of all digits
		String digits = "1234567890";

		// create random string builder
		StringBuilder stringBuilder = new StringBuilder();

		// create object of the Random class
		Random random = new Random();

		// specify the length of the number
		int length = 10;

		for (int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(digits.length());

			// get digit specified by index from digits string
			char randomDigit = digits.charAt(index);

			// append the digit to string builder
			stringBuilder.append(randomDigit);

		}

		String randomNumber = stringBuilder.toString();
		return randomNumber;

	}

	public String randomStringGenerator() {

		// create a string of all characters
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";

		// create random string builder
		StringBuilder stringBuilder = new StringBuilder();

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = 10;

		for (int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphabet.length());

			// get character specified by index from the string
			char randomChar = alphabet.charAt(index);

			// append the character to string builder
			stringBuilder.append(randomChar);
		}

		String randomString = stringBuilder.toString();
		return randomString;

	}

//	CUSTOM METHOD TO ENTER INVALID STATIC EMAILS INTO EMAIL FIELD AT PAGE
	public void staticInvalidEmailChecker(WebElement emailField, WebElement buttonSubmit, String actualError,
			String expectedError) {

		String[] listOfInvalidEmails = { "plainaddress123", "123@1123.1123", "a@a.a", "email@example,com",
				"@example.com", "Joe Smith <email@example.com>", "email.example.com", "email.@example.com",
				"email..email@example.com", "joe smith@example.com" };

		for (String invalidEmail : listOfInvalidEmails) {

			emailField.clear();
			emailField.sendKeys(invalidEmail);

			// emailField.sendKeys(Keys.TAB);

			buttonSubmit.click();

			softAssert.assertEquals(actualError, expectedError);

		}

		emailField.clear();
		softAssert.assertAll();

	}

//	CUSTOM METHOD TO ENTER VALID STATIC EMAILS INTO EMAIL FIELD AT PAGE
	public void staticValidEmailGenerator(WebElement emailField, WebElement submitButton, WebElement emailErrorElement,
			String expectedEmailErrorText) {

		String[] listOfValidEmails = { "testadmin@gmail.com", "admin.mangotech@hotmail.com", "email@example.com",
				"Testaccount@yahoo.com" };

		for (String validEmail : listOfValidEmails) {

			emailField.clear();
			emailField.sendKeys(validEmail);

			submitButton.click();

			Assert.assertEquals(emailErrorElement.getAttribute("innerHTML"), expectedEmailErrorText);

		}

	}

//	CUSTOM METHOD TO GENERATE RANDOM INVALID EMAIL
	public String invalidRandomEmailGenerator() {

		// use this statement for valid expression
//      String SALTCHARS = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";

		// use this statement for invalid expression
		String SALTCHARS = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public int findPageLayoutBugs() {

		WebPage webPage = new WebPage(driver);
		FightingLayoutBugs flb = new FightingLayoutBugs();
		final Collection<LayoutBug> layoutBugs = flb.findLayoutBugsIn(webPage);
		System.out.println("Found " + layoutBugs.size() + " layout bug(s).");
		for (LayoutBug bug : layoutBugs) {
			System.out.println(bug);
		}
		return layoutBugs.size();

	}

	public void isPageElementsDisplayed(List<WebElement> listOfElements) {

		boolean result = false;

		for (WebElement element : listOfElements) {

			try {

				result = element.isDisplayed();
				Assert.assertTrue(result);

			} catch (NoSuchElementException e) {

				Assert.assertTrue(false);

			}
		}

		softAssert.assertAll();

	}

	public boolean isWebElementDisplayed(WebElement element) {

		try {

			return element.isDisplayed();

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public void dropdownOptionSelector(List<WebElement> listOfWebElements, String option) {

		for (WebElement element : listOfWebElements) {

			String currentOption = element.getText();

			if (currentOption.equals(option)) {

				element.click();
				break;

			}
		}
	}

	@AfterClass
	public void tearDown() {

		//driver.quit();

	}
}