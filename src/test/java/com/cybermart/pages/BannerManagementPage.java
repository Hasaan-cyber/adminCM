package com.cybermart.pages;

//start


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	
	@FindBy(xpath = "//div[contains(text(),'No Option Selected')]")
	WebElement emptyDelToast;
	

	@FindBy(xpath = "//input[@class = 'MuiInputBase-input muiltr-mnn31']")
	WebElement SearchBar;

	@FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body1 muiltr-1mbwobu']")
	WebElement delBtn;

	@FindBy(xpath = "(//button[normalize-space()='Yes'])[1]")
	WebElement confrmDelbtn;
	
	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement paginationNext;
	
	
	@FindBy(xpath = "//button[normalize-space()='Prev']")
	WebElement paginationprev;
	
	
			

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
	
	public String getdelToastMsg() 
	{
		return emptyDelToast.getAttribute("innerHTML");
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

	public void Searchunctionality() {

		try {

			SearchBar.sendKeys("a");
			SearchBar.sendKeys(Keys.ENTER);

			for (int seconds = 0;; seconds++) {

				if (seconds >= 60) {
					break;
				}
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
			}
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollTop)");

			Thread.sleep(300);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void selectingmultipleChecks() {
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
		for (int i = 1; i < 3; i++) {
			checkboxes.get(i).click();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// deleting method
		for (WebElement chkbox : checkboxes) {
			if (chkbox.isSelected()) {
				ClickingOnDel();
				break;

			}
	
		}

	}

	public void ClickingOnDel() {
		delBtn.click();
		confrmDelbtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void deleteWithNoSelection() {
		delBtn.click();
	}
	
	public void checkPagination() {
		paginationNext.click();
		paginationprev.click();
	}
	
	public void putDelay() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickOnDelIcon() {
		
	}

	// ending bracket
}
