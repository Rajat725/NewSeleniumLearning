package com.NewSeleniumLearning.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NewSeleniumLearning.AbstractClasses.AbstractMethod;
import com.NewSeleniumLearning.Utilities.Logs;

public class CheckOutPage extends AbstractMethod {
	public WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

	
	@FindBy(id="first-name")
	WebElement txt_FirstName;
	

	@FindBy(id="last-name")
	WebElement txt_LastName;
	

	@FindBy(id="postal-code")
	WebElement txt_PostalCode;
	

	@FindBy(id="continue")
	WebElement btn_Continue;
	
	@FindBy(css="h3[data-test='error']")
	WebElement lbl_ErrorMssg;
	
	public void enter_FirstName(String nm)
	{
		txt_FirstName.sendKeys(nm);
		Logs.info("First name "+nm +"entered successfully");
	}
	public void enter_LastName(String nm)
	{txt_LastName.sendKeys(nm);
	Logs.info("Last name "+nm +"entered successfully");
		
	}
	public void enter_PostalCode(String nm)
	{
		txt_PostalCode.sendKeys(nm);
		Logs.info("Postal COde "+nm +"entered successfully");
	}
	
	public CheckOutPage2 clk_Continue()
	{
		btn_Continue.click();
		Logs.info("CLicked on Continue button");
		return new CheckOutPage2(driver);
	}
	
	public String get_Error_Message()
	{Logs.info("Grabbed error message");
		return lbl_ErrorMssg.getText();}
	
	public String giveURL()
	{
		Logs.info("Get URL Of page");
		return getURL();
	}
}
