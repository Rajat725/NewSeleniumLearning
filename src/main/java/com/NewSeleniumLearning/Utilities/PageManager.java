package com.NewSeleniumLearning.Utilities;

import org.openqa.selenium.WebDriver;

import com.NewSeleniumLearning.PageObjects.AddToCartPage;
import com.NewSeleniumLearning.PageObjects.CheckOutPage;
import com.NewSeleniumLearning.PageObjects.CheckOutPage2;
import com.NewSeleniumLearning.PageObjects.HomePage;
import com.NewSeleniumLearning.PageObjects.LastPage;
import com.NewSeleniumLearning.PageObjects.LoginPage;

public class PageManager {

	public WebDriver driver;
	public LoginPage lp;
	public HomePage hp;
	public AddToCartPage acp;
	public CheckOutPage cop;
	public CheckOutPage2 cop2;
	public LastPage lap;

	public PageManager(WebDriver driver) {

		this.driver = driver;

	}

	public AddToCartPage getAddToCartPage() {

		return (acp == null) ? acp = new AddToCartPage(driver) : acp;

	}

	public CheckOutPage getCheckoutPage() {

		return (cop == null) ? cop = new CheckOutPage(driver) : cop;

	}

	public CheckOutPage2 getCheckoutPage2() {

		return (cop2 == null) ? cop2 = new CheckOutPage2(driver) : cop2;

	}

	public LastPage getLastPage() {

		return (lap == null) ? lap = new LastPage(driver) : lap;

	}

	public LoginPage getloginPage() {

		return (lp == null) ? lp = new LoginPage(driver) : lp;

	}

	public HomePage getHomePage() {
		return (hp == null) ? hp = new HomePage(driver) : hp;

	}

}
