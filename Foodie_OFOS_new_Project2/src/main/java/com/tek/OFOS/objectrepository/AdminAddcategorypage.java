package com.tek.OFOS.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminAddcategorypage {
	@FindBy(xpath = "//input[@name='c_name']")
	private WebElement categoryedit;
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement savebutton;
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement Cancelbutton;

}
