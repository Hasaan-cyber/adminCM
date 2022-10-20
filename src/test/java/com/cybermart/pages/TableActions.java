package com.cybermart.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.cybermart.tests.BaseClass;
import com.github.javafaker.Faker;

public class TableActions extends BaseClass {
	
	Faker faker = new Faker(new Locale("en"));

	public TableActions() {

		elementsInitializer();

	}

	@FindBy(xpath = "//input[@class='MuiInputBase-input muiltr-mnn31']")
	WebElement searchField;
	
	@FindBy(xpath = "//*[contains(@class,'MuiTableRow-root jss')]")
	List<WebElement> listOfTableTotalRows;
	
	@FindBy(xpath = "//*[contains(@class,'MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium')]")
	List<WebElement> listOfTableTotalCells;	
	
	@FindBy(name = "countPerPage")
	WebElement countPerPage;
	
	@FindBy(xpath = "//*[@data-testid='AddCircleIcon']")
	WebElement buttonAddNew;
	
	public String randomKeywordFromPageRecords;
	
	int numberOfTableTotalRows;
	


	
	public String getSearchFieldPlaceholderText() {

		return searchField.getAttribute("placeholder");
		
	}
	
	public boolean verifyPageIsNotBlank() {
		
		if(listOfTableTotalRows.get(0).getText().contains("No Data Found")) {
			
			System.out.println("ERROR! No Records Found At Page");
			
			return false;
			
	}
		
		else {
			
			return true;

			}

	}

	public void enterRandomKeywordIntoSearchField(int incrementValue) throws InterruptedException {
	
		numberOfTableTotalRows = listOfTableTotalRows.size();
	
		int numberOfTableTotalCells = listOfTableTotalCells.size();
					
		randomKeywordFromPageRecords = listOfTableTotalCells.get(numberOfTableTotalCells - (incrementValue * faker.number().numberBetween(1, numberOfTableTotalRows))).getText();
			
		searchField.sendKeys(randomKeywordFromPageRecords);
			
		Thread.sleep(5000);
		
	}
	
	public void verifyIsCorrectSearchResultsShow(int startingIndex, int incrementValue) {
				
		for(; startingIndex <= listOfTableTotalCells.size(); startingIndex += incrementValue) {
				
				if(listOfTableTotalCells.get(startingIndex).getText().contains(randomKeywordFromPageRecords)) {

					System.out.println("PASSED! Search Result(s) Contains Search Keyword");

				}
					
			}
				
	}

	public void clearSearchField() throws InterruptedException {

		clearFieldData(searchField);

		Thread.sleep(5000);
		
		Assert.assertEquals(listOfTableTotalRows.size(), numberOfTableTotalRows, "ERROR! Correct Records Not Loaded After Clearing Search Field");

	}

	public void clickAtAddNewButton() {
		
		buttonAddNew.click();
		
	}

}