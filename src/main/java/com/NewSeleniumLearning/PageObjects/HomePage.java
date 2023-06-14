package com.NewSeleniumLearning.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NewSeleniumLearning.AbstractClasses.AbstractMethod;
import com.NewSeleniumLearning.Utilities.Logs;

public class HomePage extends AbstractMethod {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".inventory_item")
	List<WebElement> lst_ItemCards;

	By invName = By.cssSelector(".inventory_item_name");
	By addToCart = By.cssSelector("button[id*='add-to-cart']");
	By itemPrice = By.cssSelector(".inventory_item_price");
	By itemDesc = By.cssSelector(".inventory_item_desc");

	@FindBy(css = ".shopping_cart_link")
	WebElement icn_CartPage;

	public AddToCartPage navigate_To_CartPage() {
		icn_CartPage.click();
		Logs.info("Navigated to Cart Page");
		return new AddToCartPage(driver);
	}

	public WebElement choose_Product(String name) {

		WebElement card = lst_ItemCards.stream().filter(s -> s.findElement(invName).getText().equalsIgnoreCase(name))
				.findFirst().orElse(null);
		Logs.info("Product "+name+" is selected");
		return card;

	}

	public void clk_ADDTOCart(String name) {
		choose_Product(name).findElement(addToCart).click();
		Logs.info("Add to cart"+name+ "clicked successfully");

	}

	public String get_PriceOfProduct(String name) {
		String price = choose_Product(name).findElement(itemPrice).getText();
		Logs.info("Grabbed price of "+name+" Product");
		return price;
	}

	public String get_DescOfProduct(String name) {
		Logs.info("Grabbed Description of "+name+" Product");
		return choose_Product(name).findElement(itemDesc).getText();
	}
}
