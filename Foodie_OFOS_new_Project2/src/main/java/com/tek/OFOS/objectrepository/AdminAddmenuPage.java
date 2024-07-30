package com.tek.OFOS.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddmenuPage {
@FindBy(name = "d_name")
private WebElement dishname;
@FindBy(name = "about")
private WebElement description;
@FindBy(name = "price")
private WebElement pricenameedit;
@FindBy(name = "file")
private WebElement uploadimage;
@FindBy(xpath = "//select[@class='form-control custom-select']")
private WebElement selectrestaurantdropdown;
@FindBy(xpath = "//input[@value='Save']")
private WebElement savebutton;
@FindBy(xpath = "//a[text()='Cancel']")
private WebElement cancelbutton;

public WebElement getDishname() {
	return dishname;
}

public WebElement getDescription() {
	return description;
}

public WebElement getPricenameedit() {
	return pricenameedit;
}

public WebElement getUploadimage() {
	return uploadimage;
}

public WebElement getSelectrestaurantdropdown() {
	return selectrestaurantdropdown;
}

public WebElement getSavebutton() {
	return savebutton;
}

public WebElement getCancelbutton() {
	return cancelbutton;
}

public AdminAddmenuPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}
