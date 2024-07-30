package com.tek.OFOS.objectrepository;

import javax.accessibility.AccessibleEditableText;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomepage {
	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement Dashboardpagelink;
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement Userpageinfolink;
	@FindBy(xpath = "//span[text()='Restaurant']")
     private WebElement Restaurantdropdown;
	@FindBy(xpath = "//span[text()='Menu']")
    private WebElement Menudropdown;
	@FindBy(xpath = "//span[text()='Orders']")
	private WebElement Orderslink;
	@FindBy(xpath = "//a[contains(text(),'All Restaurant')]")
	private WebElement Allrestaurantlink;
	@FindBy(xpath = "//a[text()='Add Category']")
	private WebElement Addcategorylink;
	@FindBy(xpath = "//a[text()='Add Restaurant']")
	private WebElement Addrestaurantlink;
	@FindBy(xpath = "//a[text()='All Menues']")
	private WebElement Allmenulink;
	@FindBy(xpath = "//a[text()='Add Menu']")
	private WebElement Addmenulink;

	public AdminHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDashboardpagelink() {
		return Dashboardpagelink;
	}

	public WebElement getUserpageinfolink() {
		return Userpageinfolink;
	}

	public WebElement getRestaurantdropdown() {
		return Restaurantdropdown;
	}

	public WebElement getMenudropdown() {
		return Menudropdown;
	}

	public WebElement getOrderslink() {
		return Orderslink;
	}

	public WebElement getAllrestaurantlink() {
		return Allrestaurantlink;
	}

	public WebElement getAddcategorylink() {
		return Addcategorylink;
	}

	public WebElement getAddrestaurantlink() {
		return Addrestaurantlink;
	}

	public WebElement getAllmenulink() {
		return Allmenulink;
	}

	public WebElement getAddmenulink() {
		return Addmenulink;
	}
	public void Allrestaurantlink() {
		Restaurantdropdown.click();
		Allrestaurantlink.click();
	}
	public void Addcategorylink() {
		Restaurantdropdown.click();
		Addcategorylink.click();
	}
	public void Addrestaurantlink() {
		Restaurantdropdown.click();
		Addrestaurantlink.click();
	}
	public void Allmenulink() {
		Menudropdown.click();
		Allmenulink.click();
	}
	public void Addmenulink() {
		Menudropdown.click();
		Addmenulink.click();
	}
	
}
