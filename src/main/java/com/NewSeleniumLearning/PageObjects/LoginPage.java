package com.NewSeleniumLearning.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NewSeleniumLearning.AbstractClasses.AbstractMethod;
import com.NewSeleniumLearning.Utilities.Logs;

public class LoginPage extends AbstractMethod {

	public WebDriver driver;
	public Footer foter;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.foter=new Footer(driver);

	}

	@FindBy(id = "user-name")
	WebElement txt_UserName;

	@FindBy(id = "password")
	WebElement txt_Password;

	@FindBy(id = "login-button")
	WebElement btn_Login;

	@FindBy(css = "h3[data-test='error']")
	WebElement lbl_ErrorMessage;

	
	public String getPasswords()
	{
		
		String a=foter.getPassword();
		return a;
	}
	
	public void enter_UserName(String name) {
		txt_UserName.sendKeys(name);
		Logs.info("Username --"+name+"--entered successfully");
	}

	public void enter_Password(String pass) {
		txt_Password.sendKeys(pass);
		Logs.info("Password --"+pass+"--entered successfully");
	}

	public void clk_Login() {
		try{btn_Login.click();
		Logs.info("Click on Login happened successfully");}
		catch(Exception e)
		{
			Logs.error("Unable to click on login button");
			throw e;
		}
	
		}

	public String get_ErrorMessage() {
		waitUntill_VisibilityOf_Element(lbl_ErrorMessage, 7);
		Logs.info("Error Message is grabbed successfully");
		return lbl_ErrorMessage.getText();
		//Logs.info("Error Message is grabbed successfully");
	}

}
