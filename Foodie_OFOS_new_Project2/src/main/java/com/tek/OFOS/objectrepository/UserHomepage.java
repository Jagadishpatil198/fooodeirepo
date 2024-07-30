package com.tek.OFOS.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomepage {
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement LoginLink;
	@FindBy(xpath = "//a[text()='Home ']")
	private WebElement Homelink;
	@FindBy(xpath = "//a[text()='Restaurants ']")
	private WebElement Restaurantslink;
	@FindBy(xpath = "//a[text()='My Orders']")
	private WebElement MyordersLink;
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement Logoutlink;
	public WebElement getLoginLink() {
		return LoginLink;
	}
	public WebElement getHomelink() {
		return Homelink;
	}
	public WebElement getRestaurantslink() {
		return Restaurantslink;
	}
	public WebElement getMyordersLink() {
		return MyordersLink;
	}
	public WebElement getLogoutlink() {
		return Logoutlink;
	}
	public UserHomepage(WebDriver driver)
	{
	  PageFactory.initElements(driver, this);	
	}
}
