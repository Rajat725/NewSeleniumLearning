package com.NewSeleniumLearning.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NewSeleniumLearning.AbstractClasses.AbstractMethod;
import com.NewSeleniumLearning.Base.BaseTest;
import com.NewSeleniumLearning.PageObjects.AddToCartPage;
import com.NewSeleniumLearning.PageObjects.CheckOutPage;
import com.NewSeleniumLearning.PageObjects.CheckOutPage2;
import com.NewSeleniumLearning.PageObjects.HomePage;
import com.NewSeleniumLearning.PageObjects.LoginPage;
import com.NewSeleniumLearning.Utilities.Logs;

public class CheckOutPageTest extends BaseTest {

	HomePage hp;
	AddToCartPage acp;
	CheckOutPage cop;
	CheckOutPage2 cop2;
	LoginPage lp;

	@Test
	public void validate_To_CheckoutPage2_Test() {
		Logs.startTestCase("validate_To_CheckoutPage2_Test");
		lp = pm.getloginPage();
		String prodName = "Sauce Labs Onesie";
		lp.enter_UserName(prop.getProperty("username"));
		lp.enter_Password(prop.getProperty("password"));
		lp.clk_Login();
		hp = pm.getHomePage();
		hp.clk_ADDTOCart(prodName);
		acp = hp.navigate_To_CartPage();
		Assert.assertEquals(acp.get_Name_Of_Item_Added(), prodName);
		cop = acp.clk_Checkout();
		cop.enter_FirstName(AbstractMethod.fakeUsername());
		cop.enter_LastName(AbstractMethod.fakeUsername());
		cop.enter_PostalCode(AbstractMethod.fakePassword());
		cop2 = cop.clk_Continue();
		Assert.assertEquals(cop2.getURL(), "https://www.saucedemo.com/checkout-step-two.html");
		Logs.endTestCase("validate_To_CheckoutPage2_Test");

	}

	@Test
	public void validate_ErrorMessage_CheckoutPage_Test() {
		Logs.startTestCase("validate_ErrorMessage_CheckoutPage_Test");
		lp = pm.getloginPage();
		String prodName = "Sauce Labs Onesie";
		lp.enter_UserName(prop.getProperty("username"));
		lp.enter_Password(prop.getProperty("password"));
		lp.clk_Login();
		hp = pm.getHomePage();
		hp.clk_ADDTOCart(prodName);
		acp = hp.navigate_To_CartPage();
		Assert.assertEquals(acp.get_Name_Of_Item_Added(), prodName);
		cop = acp.clk_Checkout();
		cop.enter_FirstName(AbstractMethod.fakeUsername());
		cop.enter_LastName(AbstractMethod.fakeUsername());
		// cop.enter_PostalCode("");
		cop.clk_Continue();
		Assert.assertEquals(cop.get_Error_Message(), "Error: Postal Code is required");
		Logs.endTestCase("validate_ErrorMessage_CheckoutPage_Test");

	}

}
