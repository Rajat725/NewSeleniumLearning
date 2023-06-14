package com.NewSeleniumLearning.AbstractClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class AbstractMethod {
	public WebDriver driver;

	public AbstractMethod(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	public void waitUntill_VisibilityOf_Element(WebElement el,int time)
	{
		WebDriverWait waitz=new WebDriverWait(driver,Duration.ofSeconds(time));
		waitz.until(ExpectedConditions.visibilityOf(el));
	}
	
	public static String fakeUsername()
	{
		Faker fk=new Faker();
		return fk.name().firstName();
		
		
	}
	
	public static String fakePassword()
	{
		Faker fk=new Faker();
		return fk.random().hex(10);
		
		
	}
	
	public String getURL()
	{
		return driver.getCurrentUrl();
	}

}
