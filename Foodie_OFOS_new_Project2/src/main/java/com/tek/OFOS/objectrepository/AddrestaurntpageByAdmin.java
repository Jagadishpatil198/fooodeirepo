package com.tek.OFOS.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddrestaurntpageByAdmin {
	@FindBy(name = "res_name")
	private WebElement restaurantnameedit;
	@FindBy(name = "email")
	private WebElement emailedit;
	@FindBy(name = "phone")
	private WebElement phoneedit;
	@FindBy(name = "url")
	private WebElement urledit;
	@FindBy(xpath = "//option[text()='--Select your Hours--']/preceding::select[@class='form-control custom-select']")
	private WebElement openhoursdropdown;
	@FindBy(xpath = "//select[@name='c_hr']")
	private WebElement closehoursdropdown;
	@FindBy(xpath = "//select[@name='o_days']")
	private WebElement opendaysdropdown;
	@FindBy(name = "file")
	private WebElement uploadimagepng;
	@FindBy(xpath = "//select[@name='c_name']")
	private WebElement categorydropdown;
	@FindBy(name = "address")
	private WebElement addressedit;
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement savebutton;
	public AddrestaurntpageByAdmin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getRestaurantnameedit() {
		return restaurantnameedit;
	}
	public WebElement getEmailedit() {
		return emailedit;
	}
	public WebElement getPhoneedit() {
		return phoneedit;
	}
	public WebElement getUrledit() {
		return urledit;
	}
	public WebElement getOpenhoursdropdown() {
		return openhoursdropdown;
	}
	public WebElement getClosehoursdropdown() {
		return closehoursdropdown;
	}
	public WebElement getOpendaysdropdown() {
		return opendaysdropdown;
	}
	public WebElement getUploadimagepng() {
		return uploadimagepng;
	}
	public WebElement getCategorydropdown() {
		return categorydropdown;
	}
	public WebElement getAddressedit() {
		return addressedit;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
}


