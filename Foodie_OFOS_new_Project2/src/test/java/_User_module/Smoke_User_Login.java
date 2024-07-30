package _User_module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Smoke_User_Login {
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
	      
	      Thread.sleep(2000);
	      driver.close();
	      
	      
	      
	}

}
