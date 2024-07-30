
package _Admin_module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.tek.OFOS.generic.fileutility.Excelutility;
import com.tek.OFOS.generic.fileutility.Fileutility;
import com.tek.OFOS.generic.webdriverutility.Javautility;
import com.tek.OFOS.generic.webdriverutility.Webdriverutility;
import com.tek.OFOS.objectrepository.AddrestaurntpageByAdmin;
import com.tek.OFOS.objectrepository.AdminHomepage;
import com.tek.OFOS.objectrepository.AdminLoginpage;

public class End_to_End_Deleteoneresturant_checkinuserrestuarantpage {
	public static void main(String[] args) throws Exception {
		WebDriver driver;
	
		// read common data from the property file
	Fileutility flib=new Fileutility();
		
		String BROWSER = flib.getdataPropertiesfile("browser");
		
		String ADMINURL = flib.getdataPropertiesfile("admin_url");
		String ADMINNAME =flib.getdataPropertiesfile("adminusername");
		String ADMINPASSWORD = flib.getdataPropertiesfile("adminpassword");

		// random number
		Javautility jlib=new Javautility();
		int randomnumber = jlib.getrandomnumber();
	
		// fetch the testdata from the excel
		Excelutility elib=new Excelutility();
		
	    //  String resturantname =elib.getdatafromexcel("AdminModule", 1, 3).toString()+randomnumber;
	     // String Dishname = elib.getdatafromexcel("AdminModule", 7, 4).toString();

	Webdriverutility wlib=new Webdriverutility();
	   
	            String Restaurantname = elib.getdatafromexcel("AdminModule", 1, 3).toString()+randomnumber;
	            String  Email = elib.getdatafromexcel("AdminModule", 1, 4).toString();
	           // long phone = (long) rw.getCell(5).getNumericCellValue()+randomnumber;
	            String phonenumber = "9090909090";
	            String Websiteurl = elib.getdatafromexcel("AdminModule", 1, 6).toString();
	            String Open_hours_dropdown = elib.getdatafromexcel("AdminModule", 1, 7).toString();
	            String Close_hours_dropdown = elib.getdatafromexcel("AdminModule", 1, 8).toString();
	            String Open_days_dropdown = elib.getdatafromexcel("AdminModule", 1, 9).toString();
	            String image =elib.getdatafromexcel("AdminModule", 1, 10).toString();
	            String Select_category_dropdown =elib.getdatafromexcel("AdminModule", 1, 11).toString();
	            String Address =elib.getdatafromexcel("AdminModule", 1, 11).toString()+randomnumber;
	           String expectedresturant =elib.getdatafromexcel("AdminModule", 1, 13).toString();
	        
	          String edit_Restaurantname = elib.getdatafromexcel("AdminModule", 10, 3).toString().trim();
	            System.out.println(edit_Restaurantname);
	            
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
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   driver.get(ADMINURL);
	  //login to Admin module
	   AdminLoginpage ALP=new AdminLoginpage(driver);
	   ALP.AdminLogin(ADMINNAME, ADMINPASSWORD);
	   
	   // navigate to restaurant module
	   AdminHomepage AHP=new AdminHomepage(driver);
	   AHP.Allrestaurantlink();
  // driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
	   Thread.sleep(2000);
	
	   //driver.findElement(By.xpath("//a[@href='all_restaurant.php' and text()='All Restaurants']")).click();
	   
	   
	   
	//  WebElement edit = driver.findElement(By.xpath("//td[text()='Chill_bung-207906453']/parent::tr[*]/descendant::a[*]/i[@class='fa fa-edit']"));

	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  
	 Actions act=new Actions(driver);
	   WebElement footer = driver.findElement(By.xpath("//footer[text()=' © 2022 - Online Food Ordering System ']"));
	
	 WebElement editrestaurant = driver.findElement(By.xpath("//td[text()='Highlands Bar & Grill']/parent::tr[*]/descendant::a[*]/i[@class='fa fa-edit']"));
	 Actions a = new Actions(driver);
	 a.moveByOffset(10, 0).perform();
	 editrestaurant.click();
	act.scrollToElement(footer).perform();
	  
	  //	  driver.findElement(By.xpath("//a[contains(text(),'All')]")).click();
	  
	 
	  //	  int X = editrestaurant.getLocation().getX();
//	int  Y= editrestaurant.getLocation().getY();
//	  wlib.javascriptexecutorbyscrolltoelement(driver, X, Y);
	   //wlib.javascriptexecutorbyscrolltoelement(driver, editrestaurant);
	   //wlib.waitforElementclickable(driver, editrestaurant);
//	   editrestaurant.click();
	   AddrestaurntpageByAdmin ARPA=new AddrestaurntpageByAdmin(driver);
	   ARPA.getRestaurantnameedit().sendKeys(Restaurantname);
	//   driver.findElement(By.name("res_name")).sendKeys(Restaurantname);
	   ARPA.getEmailedit().sendKeys(Email);
	   
	 //  driver.findElement(By.name("email")).sendKeys(Email);
	   ARPA.getPhoneedit().sendKeys(phonenumber);
	   
	   //driver.findElement(By.name("phone")).sendKeys(phonenumber);
	   ARPA.getUrledit().sendKeys(Websiteurl);
	//   driver.findElement(By.name("url")).sendKeys(Websiteurl);
	   //handle the openhours dropdown
	  WebElement openhoursdd = ARPA.getOpenhoursdropdown();
	  wlib.select(openhoursdd, Open_hours_dropdown);
		     //  Select openhoursele=new Select(openhoursdd);
		      // openhoursele.selectByVisibleText(Open_hours_dropdown);
		       //handle the close hours drop down
		       WebElement closehoursdd = ARPA.getClosehoursdropdown();
		       wlib.select(closehoursdd, Close_hours_dropdown);
	//	Select closehoursele=new Select(closehoursdd);
		//closehoursele.selectByVisibleText(Close_hours_dropdown);
		//handle the open days drop down
		       
//		WebElement opendaysdd =ARPA.getOpendaysdropdown();
//		wlib.select(opendaysdd, Open_days_dropdown);
//		//Select opendaysele=new Select(opendaysdd);
//		//opendaysele.selectByVisibleText(Open_days_dropdown);
//	            ARPA.getUploadimagepng().sendKeys(image);
//		//upload.sendKeys(image);
//		WebElement categorydd = driver.findElement(By.xpath("//select[@name='c_name']"));
//		Select categoryele=new Select(categorydd);
//		categoryele.selectByVisibleText(Select_category_dropdown);
//		driver.findElement(By.name("address")).sendKeys(Address);
//		driver.findElement(By.xpath("//input[@value='Save']")).click();
//		String updatedverify = driver.findElement(By.xpath("//strong[text()='Record Updated!']")).getText();
//		if(updatedverify.equals("Record Updated!.."));
//		{
//		System.out.println("verification is done");
//		}
//		
	}
}
