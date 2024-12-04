package Utility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class AppUtils {
	
	public static WebDriver driver;
	public static Properties p;
	
//	Launch Application
	@BeforeMethod
	public void luanchApp() throws Throwable{
		p= new Properties();
		p.load(new FileInputStream("PropertyFile/OR.properties"));
		
		if(p.getProperty("Browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}
		else if(p.getProperty("Browser").equalsIgnoreCase("fireFox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
	}
	
//	Close Application
	@AfterMethod
	public void closeApp() {
		driver.quit();
	}
	
}
