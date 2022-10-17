package com.cybermart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

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
