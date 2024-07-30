package _Admin_module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Integration_Check_user_details {
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		// read common data from the property file
		FileInputStream fis=new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\Foodie_credentials\\User.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String ADMINURL = pobj.getProperty("admin_url");
		String ADMINNAME = pobj.getProperty("adminusername");
		String ADMINPASSWORD = pobj.getProperty("adminpassword");
		//String USERNAME = pobj.getProperty("username");
		//String PASSWORD = pobj.getProperty("password");
		
		//read the test data from the excel
		FileInputStream file=new FileInputStream("C:\\Users\\Win10\\OneDrive\\Desktop\\Foodie_credentials\\Usermodule.xlsx");
		                Workbook wb = WorkbookFactory.create(file);
		               Sheet sh = wb.getSheet("Usermodule");
		               Random randomint=new Random();
		               int randomnumber = randomint.nextInt(100);

		              Row rw = sh.getRow(1);
		               String username = rw.getCell(3).toString()+randomnumber;
		             String firstname = rw.getCell(4).toString()+randomnumber;
		             String lastname = rw.getCell(5).toString()+randomnumber;
		             String email = rw.getCell(6).toString()+randomnumber;
		             long phone = (long)rw.getCell(7).getNumericCellValue()+randomnumber;
		             String phonenumber = String.valueOf(phone);
		             String password = rw.getCell(8).toString()+randomnumber;
		             String confirmpassword = rw.getCell(9).toString()+randomnumber;
		             String Deliveryaddress = rw.getCell(10).toString()+randomnumber;
                     

		
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
	     // driver.findElement(By.xpath("//a[text()='Logout']")).click();
	     
	      Thread.sleep(2000);
	      
	      // navigate to admin module
	     // navigate to application
	      
	      
	      driver.get(ADMINURL);
	     driver.findElement(By.name("username")).sendKeys(ADMINNAME);
	      driver.findElement(By.name("password")).sendKeys(ADMINPASSWORD);
	      driver.findElement(By.xpath("//input[@value='Login']")).click();
	      //navigate to user link module
	      driver.findElement(By.xpath("//span[text()='Users']")).click();
	      
	      String actualuser = driver.findElement(By.xpath("//td[text()='"+username+"']")).getText();
	      if(actualuser.equals(username))
	      {
	    	  System.out.println(actualuser+"is verified");
	      }else
	      {
	    	  System.out.println(actualuser+"is  not verified");
	      }
//	      List<WebElement> alluser = driver.findElements(By.xpath("//table[@id='myTable']/thead/tr/th"));
//	      for(WebElement user:alluser)
//	      {
//	    	  String actualuser = user.getText();
//	    	  if(actualuser.contains(username))
//	    	  {
//	    		  System.out.println("it is verified");
//	    		  break;
//	    	  }
//	      }
	      
	}

}
