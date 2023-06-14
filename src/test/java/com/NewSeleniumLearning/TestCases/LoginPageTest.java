package com.NewSeleniumLearning.TestCases;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NewSeleniumLearning.AbstractClasses.AbstractMethod;
import com.NewSeleniumLearning.Base.BaseTest;
import com.NewSeleniumLearning.PageObjects.HomePage;
import com.NewSeleniumLearning.PageObjects.LoginPage;
import com.NewSeleniumLearning.TestData.ExternalData;
import com.NewSeleniumLearning.Utilities.Logs;
import com.NewSeleniumLearning.Utilities.Retry;
import com.github.javafaker.Name;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest extends BaseTest {
	// Base Comment

	public LoginPage lp;

	@Test(groups = "Smoke")
	public void invalid_User_Test() {

		// System.out.println(AbstractMethod.fakeUsername());
		// System.out.println(AbstractMethod.fakePassword());
		Logs.startTestCase("invalid_User_Test");
		lp = pm.getloginPage();
		lp.enter_UserName(AbstractMethod.fakeUsername());
		lp.enter_Password(AbstractMethod.fakePassword());
		lp.clk_Login();
		Assert.assertEquals(lp.get_ErrorMessage(),
				"Epic sadface: Username and password do not match any user in this service");
		Logs.endTestCase("invalid_User_Test");
	}

	@Test(groups = "Smoke")
	public void valid_User_Test() {
		Logs.startTestCase("valid_User_Test");
		lp = pm.getloginPage();
		lp.enter_UserName(prop.getProperty("username"));
		// Logs.info("Username entered successfully");
		lp.enter_Password(prop.getProperty("password"));
		// Logs.info("Password entered successfully");
		lp.clk_Login();
		// Logs.info("Login happened successfully");
		Logs.endTestCase("valid_User_Test");

	}

	@Test(dataProvider = "data1", dataProviderClass = ExternalData.class)
	public void invalid_User_Test_ExternalData(Map<String, String> l) {

		Logs.startTestCase("invalid_User_Test_ExternalData");
		lp = pm.getloginPage();
		// System.out.println(AbstractMethod.fakeUsername());
		// System.out.println(AbstractMethod.fakePassword());
		lp.enter_UserName(l.get("username"));
		lp.enter_Password(l.get("password"));
		lp.clk_Login();
		Assert.assertEquals(lp.get_ErrorMessage(),
				"Epic sadface: Username and password do not match any user in this service");
		Logs.endTestCase("invalid_User_Test_ExternalData");
	}
	


}
