package com.NewSeleniumLearning.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NewSeleniumLearning.AbstractClasses.AbstractMethod;
import com.NewSeleniumLearning.Utilities.Logs;

public class AddToCartPage extends AbstractMethod {
	public WebDriver driver;

	public AddToCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css=".inventory_item_name")
	WebElement lbl_ItemAdded;
	
	@FindBy(id="checkout")
	WebElement btn_Checkout;
	
	
	public String get_Name_Of_Item_Added()
	{
		Logs.info("Grabbed name of item Added");
		return lbl_ItemAdded.getText();
		
	}
	
	public CheckOutPage clk_Checkout()
	{
		btn_Checkout.click();
		Logs.info("CLicked on Checkout button");
		return new CheckOutPage(driver);
		
	}
}
