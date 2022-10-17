package com.cybermart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.cybermart.tests.BaseClass;

public class SideNavigationMenu extends BaseClass {

	public SideNavigationMenu() {

		elementsInitializer();

	}

	@FindBys(@FindBy(xpath = "/html/body/div[2]/div[3]/div/div[3]"))
	List<WebElement> listOfMainModules;

	public List<WebElement> getListOfMainModules() {

		return listOfMainModules;

	}

}
