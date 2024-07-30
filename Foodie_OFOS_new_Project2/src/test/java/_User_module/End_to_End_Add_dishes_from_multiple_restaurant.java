package _User_module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class End_to_End_Add_dishes_from_multiple_restaurant {
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		// read common data from the property file
		FileInputStream fis=new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\Foodie_credentials\\User.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		// fetch the testdata from the excel
		FileInputStream file=new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\Foodie_credentials\\Usermodule.xlsx");
        Workbook wb = WorkbookFactory.create(file);
       Sheet sh = wb.getSheet("Usermodule");
      Row rw = sh.getRow(7);
      String resturantname = rw.getCell(3).toString();
      String Dishname = rw.getCell(4).toString();
      Row rw2 = sh.getRow(10);
      String resturantname1 = rw2.getCell(3).toString();
		
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
	      driver.findElement(By.xpath("//a[text()='Login']")).click();
	      driver.findElement(By.name("username")).sendKeys(USERNAME);
	      driver.findElement(By.name("password")).sendKeys(PASSWORD);
	      driver.findElement(By.xpath("//input[@value='Login']")).click();
	      driver.findElement(By.xpath("//a[text()='Restaurants ']")).click();
	      driver.findElement(By.xpath("//a[text()='"+resturantname+"']")).click();
	     // driver.findElement(By.xpath("//a[text()='Chicken Madeira']")).click();
	      driver.findElement(By.xpath("//a[text()='"+Dishname+"']/ancestor::div/descendant::input[@value='Add To Cart']")).click();
	Thread.sleep(9000);
	      driver.navigate().back();
	  driver.findElement(By.xpath("//a[text()='Restaurants ']")).click();
	      driver.findElement(By.xpath("//a[text()='"+resturantname1+"']")).click();
	      driver.findElement(By.xpath("//input[@value='Add To Cart']")).click();	      
	      
	      Thread.sleep(2000);
	}

}
