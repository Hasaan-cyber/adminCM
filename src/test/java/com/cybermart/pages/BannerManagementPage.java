package com.cybermart.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cybermart.tests.BaseClass;

public class BannerManagementPage extends BaseClass {

	// constructor 
	//test
	public BannerManagementPage() {
		elementsInitializer();
	}

	// elements
	@FindBy(xpath = "//p[normalize-space()='Banner Types']")
	WebElement bannerTypebtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/table[1]/thead[1]/tr[1]/th[1]/span[1]/input[1]")
	WebElement selectAllCheck;

	@FindBy(xpath = "//button[@title='addNew']")
	WebElement addNewbtn;

	@FindBy(xpath = "//button[@title='save']")
	WebElement addSavBtn;

	@FindBy(xpath = "//p[normalize-space()='Please enter type.']")
	WebElement typeError;

	@FindBy(xpath = "//p[normalize-space()='Please enter the name.']")
	WebElement nameError;

	@FindBy(xpath = "//button[@aria-label = 'back']")
	WebElement bckBtn;

	@FindBy(xpath = "//input[@name = 'type']")
	WebElement TypeInputfield;

	@FindBy(xpath = "//input[@name = 'name']")
	WebElement nameInputField;

	@FindBy(xpath = "//input[@name = 'widthRange']")
	WebElement widthField;

	@FindBy(xpath = "//input[@name = 'heightRange']")
	WebElement heightField;

	@FindBy(xpath = "//input[@name = 'sizeRange']")
	WebElement sizeRange;

	@FindBy(xpath = "//button[@ title= 'save']")
	WebElement savBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Banner Type inserted successfully')]")
	WebElement toastMsg;
	

	// functions
	public void bannerTypeclick() {
		bannerTypebtn.click();
	}

	public boolean checkAllSelected() {
		// selectAllCheck.click();
		return selectAllCheck.isSelected();

	}

	public void addBanner() {
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(addNewbtn));

		addNewbtn.click();

	}

	public void clickSavBtn() {
		addSavBtn.click();
	}

	public String getTypeError() {

		return typeError.getAttribute("innerHTML");

	}

	public String getNameError() {

		return nameError.getAttribute("innerHTML");

	}
	
	public String getToastMsg() 
	{
		return toastMsg.getAttribute("innerHTML");
	}

	public void clickBckBtn() {
		bckBtn.click();
	}

	public void setFieldsForm(String Type, String name, String width, String height, String size) {
		clearFieldData(TypeInputfield);
		TypeInputfield.sendKeys(Type);

		clearFieldData(nameInputField);
		nameInputField.sendKeys(name);

		clearFieldData(widthField);
		widthField.sendKeys(width);

		clearFieldData(heightField);
		heightField.sendKeys(height);

		clearFieldData(sizeRange);
		sizeRange.sendKeys(size);

		savBtn.click();

	}
}
