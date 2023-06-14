package com.NewSeleniumLearning.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NewSeleniumLearning.AbstractClasses.AbstractMethod;

public class Footer extends AbstractMethod {

	public WebDriver driver;

	public Footer(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	By psswerText=By.cssSelector("div[class='login_password'] h4");

	
	@FindBy(css=".login_credentials_wrap-inner")
	WebElement foot;
	
	public String getPassword()
	{
		
		return foot.findElement(psswerText).getText();
	}

}
