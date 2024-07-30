package com.tek.OFOS.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginpage {
	@FindBy(name = "username")
	private WebElement useredit;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement Loginbtn;
	public UserLoginpage(WebDriver driver)
	{
	  PageFactory.initElements(driver, this);	
	}
	public WebElement getUseredit() {
		return useredit;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginbtn() {
		return Loginbtn;
	}
	public void Userlogin(String username,String Password)
	{
		useredit.sendKeys(username);
		password.sendKeys(Password);
		Loginbtn.click();
	}
}

