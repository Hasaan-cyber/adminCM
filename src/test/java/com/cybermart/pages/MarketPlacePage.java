package com.cybermart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cybermart.tests.BaseClass;

public class MarketPlacePage extends BaseClass {

	public MarketPlacePage() {

		elementsInitializer();

	}

	// @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div[2]/div/div[2]/div")
	@FindBy(xpath = "//div[contains(@class, 'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 MuiGrid-grid-md-4 MuiGrid-grid-lg-4 MuiGrid-grid-xl-3 muiltr-1rs68s8')]")
	private List<WebElement> listOfModules;

	public List<WebElement> getListOfModules() {

		return listOfModules;

	}

}
