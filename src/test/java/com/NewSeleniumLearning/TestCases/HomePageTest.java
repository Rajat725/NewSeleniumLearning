package com.NewSeleniumLearning.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NewSeleniumLearning.Base.BaseTest;
import com.NewSeleniumLearning.PageObjects.AddToCartPage;
import com.NewSeleniumLearning.PageObjects.HomePage;

public class HomePageTest extends BaseTest {
	HomePage hp;
	AddToCartPage acp;

	@Test(groups = "Sanity")
	public void price_Validation_Test() {
		lp.enter_UserName(prop.getProperty("username"));
		lp.enter_Password(prop.getProperty("password"));
		lp.clk_Login();
		//hp = new HomePage(driver);
		hp=pm.getHomePage();
		Assert.assertEquals(hp.get_PriceOfProduct("Sauce Labs Onesie"), "$7.99");

	}

	@Test(groups = "Sanity")
	public void description_Validation_Test() {
		lp.enter_UserName(prop.getProperty("username"));
		lp.enter_Password(prop.getProperty("password"));
		lp.clk_Login();
		//hp = new HomePage(driver);
		hp=pm.getHomePage();
		Assert.assertEquals(hp.get_DescOfProduct("Sauce Labs Onesie"),
				"Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
	}
	
	@Test(groups = "Sanity")
	public void success_Add_To_Cart_Validation_Test()
	{
		String prodName="Sauce Labs Onesie";
		lp.enter_UserName(prop.getProperty("username"));
		lp.enter_Password(prop.getProperty("password"));
		lp.clk_Login();
		//hp = new HomePage(driver);
		hp=pm.getHomePage();
		hp.clk_ADDTOCart(prodName);
		acp=hp.navigate_To_CartPage();
		Assert.assertEquals(acp.get_Name_Of_Item_Added(),prodName);
	}

}
