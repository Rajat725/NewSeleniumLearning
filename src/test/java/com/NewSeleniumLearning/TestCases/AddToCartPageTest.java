package com.NewSeleniumLearning.TestCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.NewSeleniumLearning.Base.BaseTest;
import com.NewSeleniumLearning.PageObjects.AddToCartPage;
import com.NewSeleniumLearning.PageObjects.CheckOutPage;
import com.NewSeleniumLearning.PageObjects.HomePage;
import com.NewSeleniumLearning.Utilities.Logs;

public class AddToCartPageTest extends BaseTest {

	HomePage hp;
	AddToCartPage acp;
	CheckOutPage cop;
	
	
	@Test
	public void validate_To_CheckoutPage_Test()
	{
		Logs.startTestCase("validate_To_CheckoutPage_Test");
		String prodName="Sauce Labs Onesie";
		lp.enter_UserName(prop.getProperty("username"));
		lp.enter_Password(prop.getProperty("password"));
		lp.clk_Login();
		hp = new HomePage(driver);
		hp.clk_ADDTOCart(prodName);
		acp=hp.navigate_To_CartPage();
		Assert.assertEquals(acp.get_Name_Of_Item_Added(),prodName);
		cop=acp.clk_Checkout();
		Assert.assertEquals(cop.getURL(),"https://www.saucedemo.com/checkout-step-one.html");
		Logs.endTestCase("validate_To_CheckoutPage_Test");
		
	}
}
