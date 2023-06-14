package com.NewSeleniumLearning.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NewSeleniumLearning.Base.BaseTest;
import com.NewSeleniumLearning.PageObjects.AddToCartPage;
import com.NewSeleniumLearning.PageObjects.HomePage;
import com.NewSeleniumLearning.PageObjects.LoginPage;
import com.NewSeleniumLearning.Utilities.Logs;

public class HomePageTest extends BaseTest {
	HomePage hp;
	AddToCartPage acp;
	LoginPage lp;

	@Test(groups = "Sanity")
	public void price_Validation_Test() {
		Logs.startTestCase("price_Validation_Test");
		lp = pm.getloginPage();
		lp.enter_UserName(prop.getProperty("username"));
		lp.enter_Password(prop.getProperty("password"));
		lp.clk_Login();
		// hp = new HomePage(driver);
		hp = pm.getHomePage();
		Assert.assertEquals(hp.get_PriceOfProduct("Sauce Labs Onesie"), "$7.99");
		Logs.endTestCase("price_Validation_Test");

	}

	@Test(groups = "Sanity")
	public void description_Validation_Test() {
		Logs.startTestCase("description_Validation_Test");
		lp = pm.getloginPage();
		lp.enter_UserName(prop.getProperty("username"));
		lp.enter_Password(prop.getProperty("password"));
		lp.clk_Login();
		// hp = new HomePage(driver);
		hp = pm.getHomePage();
		Assert.assertEquals(hp.get_DescOfProduct("Sauce Labs Onesie"),
				"Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
		Logs.endTestCase("description_Validation_Test");
	}

	@Test(groups = "Sanity")
	public void success_Add_To_Cart_Validation_Test() {
		Logs.startTestCase("success_Add_To_Cart_Validation_Test");
		lp = pm.getloginPage();
		String prodName = "Sauce Labs Onesie";
		lp.enter_UserName(prop.getProperty("username"));
		lp.enter_Password(prop.getProperty("password"));
		lp.clk_Login();
		// hp = new HomePage(driver);
		hp = pm.getHomePage();
		hp.clk_ADDTOCart(prodName);
		acp = hp.navigate_To_CartPage();
		Assert.assertEquals(acp.get_Name_Of_Item_Added(), prodName);
		Logs.endTestCase("success_Add_To_Cart_Validation_Test");
	}

	
}
