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

public class Smoke_Register_as_User {
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		// read common data from the property file
		FileInputStream fis=new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\Foodie_credentials\\User.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		//String USERNAME = pobj.getProperty("username");
		//String PASSWORD = pobj.getProperty("password");
		
		//read the test data from the excel
		FileInputStream file=new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\Foodie_credentials\\Usermodule.xlsx");
		                Workbook wb = WorkbookFactory.create(file);
		               Sheet sh = wb.getSheet("Usermodule");
		              Row rw = sh.getRow(1);
		               String username = rw.getCell(2).toString();
		             String firstname = rw.getCell(3).toString();
		             String lastname = rw.getCell(4).toString();
		             String email = rw.getCell(5).toString();
		            // long phone = (long)rw.getCell(6).getNumericCellValue();
		             //String phonenumber = String.valueOf(phone);
		             String phonenumber=rw.getCell(6).toString();
		             String password = rw.getCell(7).toString();
		             String confirmpassword = rw.getCell(8).toString();
		             String Deliveryaddress = rw.getCell(9).toString();


		
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
	      driver.findElement(By.xpath("//a[text()='Register']")).click();
	      driver.findElement(By.name("username")).sendKeys(username);
	      driver.findElement(By.name("firstname")).sendKeys(firstname);
	      driver.findElement(By.name("lastname")).sendKeys(lastname);
	      driver.findElement(By.name("email")).sendKeys(email);
	      driver.findElement(By.name("phone")).sendKeys(phonenumber);
	      driver.findElement(By.name("password")).sendKeys(password);
	      driver.findElement(By.name("cpassword")).sendKeys(confirmpassword);
	      driver.findElement(By.name("address")).sendKeys(Deliveryaddress);
	      driver.findElement(By.xpath("//input[@value='Register']")).click();
	      
	      Thread.sleep(2000);

	      

	}

}
