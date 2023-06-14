package com.NewSeleniumLearning.Utilities;

import org.openqa.selenium.WebDriver;

import com.NewSeleniumLearning.PageObjects.HomePage;
import com.NewSeleniumLearning.PageObjects.LoginPage;



public class PageManager {

	public WebDriver driver;
	public LoginPage lp;
	public HomePage hp;

	public PageManager(WebDriver driver) {

		this.driver = driver;
		

	}

	public LoginPage getloginPage() {

		return (lp == null) ? lp = new LoginPage(driver) : lp;

	}

	public HomePage getHomePage() {
		return (hp == null) ? hp = new HomePage(driver) : hp;

	}

}
