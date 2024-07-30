package com.tek.OFOS.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AdminLoginpage {
	@FindBy(name = "username")
	private WebElement AdminName;
	@FindBy(name = "password")
	private WebElement AdminPassword;
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement Loginbtn;
	public AdminLoginpage(WebDriver driver)
	{
	  PageFactory.initElements(driver, this);	
	}
	public WebElement getAdminName() {
		return AdminName;
	}
	public WebElement getAdminPassword() {
		return AdminPassword;
	}
	public WebElement getLoginbtn() {
		return Loginbtn;
	}
    public void AdminLogin(String Adminname,String Adminpassword)
    {
    	AdminName.sendKeys(Adminname);
    	AdminPassword.sendKeys(Adminpassword);
    	Loginbtn.click();
    }
}
