package com.tek.OFOS.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutility {
	public void waitforpagetoload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitforElementvisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitforElementclickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void switchnewbrowserTab(WebDriver driver, String partialurl)
	{
		 Set<String> set = driver.getWindowHandles();
 		 Iterator<String> iter = set.iterator();
 		 while(iter.hasNext())
 		 {
 			String windowid = iter.next();
 			driver.switchTo().window(windowid);
 			String actualurl = driver.getCurrentUrl();
 			if(actualurl.contains(partialurl))
 			{
 				break;
 			}
 				
	}
    }
	public void switchnewBrowserTab(WebDriver driver, String partialtitle)
	{
		 Set<String> set = driver.getWindowHandles();
 		 Iterator<String> iter = set.iterator();
 		 while(iter.hasNext())
 		 {
 			String windowid = iter.next();
 			driver.switchTo().window(windowid);
 			String actualurl = driver.getCurrentUrl();
 			if(actualurl.contains(partialtitle))
 			{
 				break;
 			}
 		 }
	}
	public void Switchtoframe(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void Switchtoframe(WebDriver driver, String nameid)
	{
		driver.switchTo().frame(nameid);
	}
	public void Switchtoframe(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void Switchtoframedefaultcontent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public void Switchtoframedparent(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	public void SwitchtoAlertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void SwitchtoAlertcancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void mousehoveronelement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleclick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void draganddrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest).perform();
		}
	public void Scrolltoelement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
		}
	public void Rightclick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		}
	public void sendkeys(WebDriver driver, String value)
	{
		Actions act=new Actions(driver);
		act.sendKeys(value).perform();
		
		}
	public void javascriptexecutorbyid(WebDriver driver, String value,String ID)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById("+ID+").value='"+value+";");
	}
	public void javascriptexecutorbyscrollbywindow(WebDriver driver, int X,int Y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+X+","+Y+"");
	
	}
	public String javascriptexecutorbygettitle(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
	     return title;
	}
	public void javascriptexecutorbyscrolltoelement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].scrollIntoView();",element);
	    
	}
	public void javascriptexecutorbyscrolltoelement(WebDriver driver, int X, int Y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(arguments[0], arguments[1]);", X, Y);
	    
	}
	public void Hidden(WebDriver driver)
	{
		WebElement img = driver.findElement(By.xpath("//img[@src='./images/logo/Acoe.png'"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].display='none'",img);

	}
	
	

}
