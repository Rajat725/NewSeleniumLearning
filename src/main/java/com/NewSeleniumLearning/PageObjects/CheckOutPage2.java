package com.NewSeleniumLearning.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NewSeleniumLearning.AbstractClasses.AbstractMethod;
import com.NewSeleniumLearning.Utilities.Logs;

public class CheckOutPage2 extends AbstractMethod {
	public WebDriver driver;

	public CheckOutPage2(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
//Error: Postal Code is required
	
	@FindBy(id="finish")
	WebElement btn_Finish;
	

	public LastPage clk_Finish()
	{
		btn_Finish.click();
		Logs.info("Clicked on Finish");
		return new LastPage(driver);
	}
	
}