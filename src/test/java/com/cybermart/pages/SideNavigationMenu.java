package com.cybermart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.cybermart.tests.BaseClass;

public class SideNavigationMenu extends BaseClass {

	public SideNavigationMenu() {

		elementsInitializer();

	}

	@FindBy(xpath = "//*[contains(@class,'MuiListItemButton-root MuiListItemButton-gutters')]")
	List<WebElement> listOfMainModules;
	
	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 MuiGrid-grid-md-4 MuiGrid-grid-lg-4 MuiGrid-grid-xl-3 muiltr-1rs68s8']")
	List<WebElement> listOfMarketplaceModules;

	public void clickAtMarketplaceModule() {

		listOfMainModules.get(2).click();
		
	}
	
	public void clickAtManageBrandsSubModule() {

		listOfMarketplaceModules.get(2).click();
		
	}

}
