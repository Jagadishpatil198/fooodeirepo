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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.tek.OFOS.generic.fileutility.Excelutility;
import com.tek.OFOS.generic.fileutility.Fileutility;

public class Integration_Add_Restuarant {
	public static void main(String[] args) throws Exception {
		
	
	WebDriver driver;
	// read common data from the property file
	Fileutility flib=new Fileutility();
	
	String BROWSER = flib.getdataPropertiesfile("browser");
	String URL = flib.getdataPropertiesfile("admin_url");
	String ADMINNAME =flib.getdataPropertiesfile("adminusername");
	String ADMINPASSWORD = flib.getdataPropertiesfile("adminpassword");
	
	// fetch the testdata from the excel
	Excelutility elib=new Excelutility();
	
            Random randomint=new Random();
           int randomnumber = randomint.nextInt(50);
            String Restaurantname = elib.getdatafromexcel("AdminModule", 1, 3).toString()+randomnumber;

            String  Email = elib.getdatafromexcel("AdminModule", 1, 4).toString();
//            long phone = (long) rw.getCell(5).getNumericCellValue()+randomnumber;
//            String phonenumber = String.valueOf(phone);
            String phonenumber="9090909090";
            String Websiteurl =elib.getdatafromexcel("AdminModule", 1, 6).toString();
            String Open_hours_dropdown = elib.getdatafromexcel("AdminModule", 1, 7).toString();
            String Close_hours_dropdown = elib.getdatafromexcel("AdminModule", 1, 8).toString();
         //   String Open_days_dropdown = rw.getCell(9).toString();
            String Open_days_dropdown = "Mon-Wed";
            String image = elib.getdatafromexcel("AdminModule", 1, 10).toString();
            String Select_category_dropdown = elib.getdatafromexcel("AdminModule", 1, 11).toString();
            String Address = elib.getdatafromexcel("AdminModule", 1, 12).toString()+randomnumber;
           String expectedresturant = elib.getdatafromexcel("AdminModule", 1, 13).toString()+randomnumber;
            
            
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
   driver.get(URL);
  driver.findElement(By.name("username")).sendKeys(ADMINNAME);
   driver.findElement(By.name("password")).sendKeys(ADMINPASSWORD);
   driver.findElement(By.xpath("//input[@value='Login']")).click();
   
   // navigate to restaurant module
   driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
   driver.findElement(By.xpath("//a[text()='Add Restaurant']")).click();
   driver.findElement(By.name("res_name")).sendKeys(Restaurantname);
   driver.findElement(By.name("email")).sendKeys(Email);
   driver.findElement(By.name("phone")).sendKeys(phonenumber);
   driver.findElement(By.name("url")).sendKeys(Websiteurl);
   //handle the openhours dropdown
  WebElement openhoursdd = driver.findElement(By.xpath("//option[text()='--Select your Hours--']/preceding::select[@class='form-control custom-select']"));
	       Select openhoursele=new Select(openhoursdd);
	       openhoursele.selectByVisibleText(Open_hours_dropdown);
	       //handle the close hours drop down
	       WebElement closehoursdd = driver.findElement(By.xpath("//select[@name='c_hr']"));
	Select closehoursele=new Select(closehoursdd);
	closehoursele.selectByVisibleText(Close_hours_dropdown);
	//handle the open days drop down
	WebElement opendaysdd = driver.findElement(By.xpath("//select[@name='o_days']"));
	Select opendaysele=new Select(opendaysdd);
	opendaysele.selectByVisibleText(Open_days_dropdown);
	WebElement upload = driver.findElement(By.name("file"));
	upload.sendKeys(image);
	WebElement categorydd = driver.findElement(By.xpath("//select[@name='c_name']"));
	Select categoryele=new Select(categorydd);
	categoryele.selectByVisibleText(Select_category_dropdown);
	driver.findElement(By.name("address")).sendKeys(Address);
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//input[@value='Save']")).click();
	Actions act=new Actions(driver);
	   WebElement footer = driver.findElement(By.xpath("//footer[text()=' © 2022 - Online Food Ordering System ']"));
	WebElement save = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
	act.scrollToElement(footer).perform();
	  save.click();
	String actualrestuarantname = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
	System.out.println(actualrestuarantname);
	if(actualrestuarantname.equals(expectedresturant))
	{
		System.out.println(actualrestuarantname + "is verified");
	}else
	{
		System.out.println(actualrestuarantname + "is not verified");
	}
	Thread.sleep(2000);
	driver.close();
	}
}
