package com.cybermart.pages;


import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.cybermart.tests.BaseClass;
import com.cybermart.tests.MarketPlaceBannersTest;

public class MarketPlaceBannersPage extends BaseClass{
	
	// constructor
	public MarketPlaceBannersPage() {
		elementsInitializer();
	}
	
	
//locators 
	@FindBy(xpath = "//span[normalize-space()='Market Place']")
	WebElement marketPlaceTab;

	@FindBy(xpath = "//p[normalize-space()='Manage Banners']")
	WebElement manageBannersBtn;

	@FindBy(xpath = "(//button[normalize-space()='Add New'])[1]")
	WebElement addNewbtn;

	@FindBy(xpath = "//p[normalize-space()='Please select destination type.']")
	WebElement destinationError;

	@FindBy(xpath = "//p[normalize-space()='Please select banner type.']")
	WebElement bannerTypeError;

	@FindBy(xpath = "//button[@title = 'save']")
	WebElement SavBtn;

	@FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body1 muiltr-1mbwobu']")
	WebElement delBtn;

	@FindBy(xpath = "(//button[normalize-space()='Yes'])[1]")
	WebElement confrmDelbtn;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement paginationNext;

	@FindBy(xpath = "//button[normalize-space()='Prev']")
	WebElement paginationprev;

	@FindBy(xpath = "//div[@id='mui-component-select-bannerType']")
	WebElement drpDown;

	@FindBys(@FindBy(xpath = "//li[@role  =  'option']"))
	List<WebElement> options;

	@FindBys(@FindBy(xpath = "//input[@type='checkbox']"))
	List<WebElement> AllChecks;

	@FindBys(@FindBy(xpath = "//button[@aria-label = 'delete']"))
	List<WebElement> DeleteIcon;
	
	@FindBys(@FindBy(xpath = "//button[@aria-label = 'edit']"))
	List<WebElement> EditIcon;

	@FindBy(xpath = "//input[@type='file']")
	WebElement imgBtn;

	@FindBy(xpath = "//input[@name= 'destinationType']")
	WebElement inputDest;

	@FindBy(xpath = "//div[contains(text(),'Banner(s) deleted successfully')]")
	WebElement toastMsg;

//	@FindBys(@FindBy(xpath = "//div[@class = 'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 MuiGrid-grid-xl-6 muiltr-1bnqk5o']//button"))
//	List<WebElement> paginationBtns ;

	@FindBy(xpath = "//div[@class = 'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 MuiGrid-grid-xl-6 muiltr-1bnqk5o']//button")
	WebElement paginationbtns;

	@FindBy(xpath = "//button[@aria-label = 'edit']")
	WebElement editBtnsSvg;

	@FindBy(xpath = "//button[@aria-label = 'delete']")
	WebElement deleteBtnsSvg;
	

	@FindBy(xpath = "//button[@title = 'cancel']")
	WebElement  CancelBtn ;
	
	
//functions 
	public void clickOnMarketPlace() {

		marketPlaceTab.click();
		manageBannersBtn.click();

	}

	public void putDelay() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addBanner() {
		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(addNewbtn));

		addNewbtn.click();

	}

	public String getdesTError() {

		return destinationError.getAttribute("innerHTML");

	}

	public String getTypeError() {

		return bannerTypeError.getAttribute("innerHTML");

	}

	public void clickSavBtn() {
		SavBtn.click();
	}

	public void selectallChecks() {
		int size = AllChecks.size();
		for (int i = 1; i <= size - 3; i++) {

			AllChecks.get(i).click();
		}

	}

	public void ClickingOnDel() {
		delBtn.click();
		confrmDelbtn.click();
	}

	public void checkPagination() {
		paginationNext.click();
		paginationprev.click();
	}

	public void SelectionDrpDown() {
		String searchText = "Home Main Slider Banners";
		drpDown.click();

		for (WebElement option : options) {
			if (option.getText().equals(searchText)) {
				option.click();
				break;
			}
		}

	}

	public void uploadingImg() {
		imgBtn.sendKeys("C:\\Users\\Ahmad\\Downloads\\larger2mb.jpg");
	}

	public void clickonRandomCheckBox() {

		Random ram = new Random();
		int index = ram.nextInt(1, 7);
		AllChecks.get(index).click();

		// deleting method
		/*
		 * for (WebElement chkbox : AllChecks) { if (chkbox.isSelected()) {
		 * ClickingOnDel(); break;
		 * 
		 * } // break; }
		 */

	}

	public void DeleteRandom() {
		Random ram = new Random();
		int index = ram.nextInt(1, 5);
		DeleteIcon.get(index).click();
		confrmDelbtn.click();
		
	}

	
	public void editRandom() {
	
		
		Random ram = new Random();
		int index = ram.nextInt(3, 5);
		EditIcon.get(index).click();
		uploadingImg();
		clickSavBtn();
		myWait(Duration.ofSeconds(20));
		clickOnCancel();
		
		
	}
	
	public void deletionMethod() {
		for (WebElement chkbox : AllChecks) {
			if (chkbox.isSelected()) {
				ClickingOnDel();
				break;

			}

		}

	}

	public String getToastMsg() {
		return toastMsg.getAttribute("innerHTML");
	}

	public void settingDestinationtype(String Type) {
		inputDest.sendKeys(Type);

	}

	public void travesringpagination() {
		while (true) {

			try {
				paginationbtns.click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}

		}

	}

	public boolean editElementDisplayed() {

		return editBtnsSvg.isDisplayed();

	}
	
	public boolean deleteElementDisplayed() {

		return deleteBtnsSvg.isDisplayed();

	}
	
	public void clickOnCancel() {
		CancelBtn.click();
	}



}
