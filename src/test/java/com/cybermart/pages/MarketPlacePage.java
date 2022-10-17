package com.cybermart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.cybermart.tests.BaseClass;

public class MarketPlacePage extends BaseClass {

	public MarketPlacePage() {

		elementsInitializer();

	}

	@FindBys(@FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div[2]/div/div[2]/div"))
	private List<WebElement> listOfModules;

	public List<WebElement> getListOfModules() {

		return listOfModules;

	}

}
