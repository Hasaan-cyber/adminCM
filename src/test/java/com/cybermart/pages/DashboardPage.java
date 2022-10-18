package com.cybermart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cybermart.tests.BaseClass;

public class DashboardPage extends BaseClass {

	public DashboardPage() {

		elementsInitializer();
	}

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div[1]/div/div/div[1]/svg[1]")
	private WebElement logoCybermart;

	public WebElement getCyberMartLogo() {

		return logoCybermart;

	}

}
