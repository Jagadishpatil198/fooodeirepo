package _Admin_module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tek.OFOS.generic.fileutility.Excelutility;
import com.tek.OFOS.generic.fileutility.Fileutility;
import com.tek.OFOS.generic.webdriverutility.Webdriverutility;
import com.tek.OFOS.objectrepository.AdminHomepage;
import com.tek.OFOS.objectrepository.AdminLoginpage;
import com.tek.OFOS.objectrepository.UserHomepage;
import com.tek.OFOS.objectrepository.UserLoginpage;

public class End_to_end_Delete_order_by_admin {
	public static void main(String[] args) throws Exception {
		boolean flag = false;
		String DISHNAME1 = " Buffalo Wings";
		WebDriver driver;
		
		// read common data from the property file
		// read common data from the property file
		Fileutility flib=new Fileutility();
		
		String BROWSER = flib.getdataPropertiesfile("browser");
				
		String URL = flib.getdataPropertiesfile("url");
		String USERNAME = flib.getdataPropertiesfile("username");
		String PASSWORD = flib.getdataPropertiesfile("password");
		String ADMINURL = flib.getdataPropertiesfile("admin_url");
		String ADMINNAME =flib.getdataPropertiesfile("adminusername");
		String ADMINPASSWORD = flib.getdataPropertiesfile("adminpassword");

		
		// fetch the testdata from the excel
		Excelutility elib=new Excelutility();
		
      String resturantname =elib.getdatafromexcel("Usermodule", 7, 3).toString();
      String Dishname = elib.getdatafromexcel("Usermodule", 7, 4).toString();
      
      String resturantname1 =elib.getdatafromexcel("Usermodule", 10, 3).toString();
		
		// navigate to application
	      driver=null;
	      if(BROWSER=="chrome")
	      {
	    	  driver=new ChromeDriver();
	      }else if(BROWSER=="firefox")
	      {
	    	  driver=new FirefoxDriver();
	      }else if(BROWSER=="edge")
	      {
	    	  driver= new EdgeDriver();
	      }else
	      {
	    	  driver=new ChromeDriver();
	      }
	      driver.manage().window().maximize();
Webdriverutility wlib=new Webdriverutility();
             wlib.waitforpagetoload(driver);
	      driver.get(URL);
	      
	      UserHomepage UHP=new UserHomepage(driver);
	      UHP.getLoginLink().click();
	    UserLoginpage ULP=new UserLoginpage(driver);
	    ULP.Userlogin(USERNAME, PASSWORD);
	  UHP.getRestaurantslink().click();
	    System.out.println(resturantname);
	    Thread.sleep(2000);
	     driver.findElement(By.xpath("//a[text()='"+resturantname+"']")).click();
  
		WebElement dishadd = driver.findElement(By.xpath("//a[contains(text(),'"+Dishname+"')]/ancestor::div/descendant::input[@value='Add To Cart']"));
	    wlib.javascriptexecutorbyscrolltoelement(driver, dishadd);
	    dishadd.click();
		   WebElement dishadd1 = driver.findElement(By.xpath("//a[contains(text(),'"+DISHNAME1+"')]/ancestor::div/descendant::input[@value='Add To Cart']"));

    wlib.javascriptexecutorbyscrolltoelement(driver,dishadd1 );
    wlib.waitforElementclickable(driver, dishadd1);
	    dishadd1.click();
	       WebElement checkout = driver.findElement(By.xpath("//a[text()='Checkout']"));
	     
	       int Y = checkout.getLocation().getY();
	       wlib.javascriptexecutorbyscrolltoelement(driver, 0, Y);
	       wlib.waitforElementclickable(driver, checkout);
	       //wlib.javascriptexecutorbyscrolltoelement(driver, checkout);
	         checkout.click();
	       
	         driver.findElement(By.xpath("//input[@value='Order Now']")).click();
	         wlib.SwitchtoAlertAccept(driver);
	         Thread.sleep(2000);
	         wlib.SwitchtoAlertAccept(driver);
	      
	       //logout as user
	         UHP.getLogoutlink().click();
	       
	       Thread.sleep(2000);
	       
	       // login as admin
	       driver.get(ADMINURL);

	       AdminLoginpage ALP=new AdminLoginpage(driver);
	       ALP.AdminLogin(ADMINNAME, ADMINPASSWORD);
	        // navigate to order submodule
	       AdminHomepage AHM=new AdminHomepage(driver);
	       AHM.getOrderslink().click();
	     //   driver.findElement(By.xpath("//span[text()='Orders']")).click();
//	        driver.findElement(By.xpath("//table[@id='myTable']/tbody/tr[*]/td[text()='"+USERNAME+"']/parent::tr/descendant::i[@class='fa fa-trash-o']")).click();
//                     Alert al2 = driver.switchTo().alert();
//                     al2.accept();
	        System.out.println(USERNAME);
	        ArrayList<String> arr=new ArrayList<String>();
	            arr.add(0, "liamoore");
	            arr.add(1, "Preetam96");
	            arr.add(2, "1234");
	            
	  List<WebElement> allusersname = driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr[*]/td[1]"));
	                         // System.out.println(allusersname.size());
	                 
	                          for(WebElement alluser:allusersname)
	                   {
	                	  String actualuseraccessname = alluser.getText();
	                	  for(String ar:arr)
	                	  {
	                	  if(actualuseraccessname.equals(ar))
	                		   {
	                		  flag=true;
	                		  System.out.println(actualuseraccessname+ "is verified");
	                		 break;
	                		   }
	                	  }
	                   
	                          if(flag==false)
	                          {
	                        	  System.out.println(actualuseraccessname+ "is ont verified");
	                          }
	                   }     
	}
	
}
