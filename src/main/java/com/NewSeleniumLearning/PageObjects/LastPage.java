package com.NewSeleniumLearning.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NewSeleniumLearning.AbstractClasses.AbstractMethod;
import com.NewSeleniumLearning.Utilities.Logs;

public class LastPage extends AbstractMethod {
	public WebDriver driver;

	public LastPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(css=".complete-header")
	WebElement lbl_SuccessMssg;
	
	//Thank you for your order!
	

	public String get_SuccessMessage()
	{
		
		if(lbl_SuccessMssg.getText().isEmpty())
		{
			Logs.error("Succees Message can't be grabbed");
		}
		else {
			Logs.info("Success Message is grabbed Successfully");
		}
		return lbl_SuccessMssg.getText();
		
		
	}
	
}