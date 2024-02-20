package com.eCommerce.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgName.genericUtility.UtilityClass;

public class Home_Page {

	@FindBy (xpath = "//input[@name='product']")
	private WebElement searchOption;
	
	@FindBy (xpath = "//button[@name='search']")
	private WebElement searchOptionButton;
	
	@FindBy (linkText = "My Account")
	private WebElement myAccountLink;
	
	@FindBy (linkText = "Wishlist")
	private WebElement wishlistLink;
	
	@FindBy (linkText = "My Cart")
	private WebElement myCartLink;
	
	@FindBy (linkText = "Login")
	private WebElement loginLink;
	
	@FindBy (xpath = "//span[.='Track Order']")
	private WebElement trackOrderButton;
	
	@FindBy (xpath = "//i[@class='glyphicon glyphicon-shopping-cart']")
	private WebElement cartButton;
	
	@FindBy (xpath = "//a[.=' Books']")
	private WebElement booksLink;
	
	@FindBy (xpath = "//a[.=' Electronics']")
	private WebElement electronicsLink;
	
	@FindBy (xpath = "//a[.=' Furniture']")
	private WebElement furnitureLink;
	
	@FindBy (xpath = "//a[.=' vehicles']")
	private WebElement vehiclesLink;
	
	@FindBy(xpath = "//a[.=' Cloths']")
	private WebElement clothesLink;
	
	@FindBy (xpath = "//a[.='All']")
	private WebElement allFeaturedProducts;
	
	@FindBy (xpath = "//button[.='Add to cart']")
	private WebElement addToCartButton;
	
	
	public Home_Page() {
		PageFactory.initElements(UtilityClass.getDriver(), this);
	}
	
	public void searchTheProduct(String productName) {
		searchOption.sendKeys(productName);
		searchOptionButton.click();
	}
	
	public void addToCart() {
		addToCartButton.click();
		UtilityClass.getDriver().switchTo().alert().accept();
	}
}
