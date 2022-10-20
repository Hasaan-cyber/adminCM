package com.cybermart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cybermart.tests.BaseClass;

public class SideNavigationMenu extends BaseClass {

	public SideNavigationMenu() {

		elementsInitializer();

	}

	@FindBy(xpath = "//div[@class = 'MuiBox-root muiltr-1r9e2co']/div[1]")
	private WebElement buttonDashboard;

	@FindBy(xpath = "//div[@class = 'MuiBox-root muiltr-1r9e2co']/div[2]")
	private WebElement buttonSettings;

	@FindBy(xpath = "//div[@class = 'MuiBox-root muiltr-1r9e2co']/div[3]")
	private WebElement buttonMarketPlace;

	// @FindBy(xpath = "//div[@class = 'MuiBox-root muiltr-1r9e2co']")
	@FindBy(xpath = "//div[contains(@class, 'MuiListItemButton-root MuiListItemButton-gutters')]")
	List<WebElement> listOfMainModules;

	public List<WebElement> getListOfMainModules() {

		return listOfMainModules;

	}

	public WebElement getButtonDashboard() {

		return buttonDashboard;

	}

	public WebElement getButtonSettings() {

		return buttonSettings;

	}

	public WebElement getButtonMarketPlace() {

		return buttonMarketPlace;

	}

}
