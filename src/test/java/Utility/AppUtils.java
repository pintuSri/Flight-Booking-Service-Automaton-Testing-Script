package Utility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Functions.LoginPage;
import Functions.LogoutPage;


public class AppUtils {
	
	public static WebDriver driver;
	public static Properties p;
	
//	Launch Application
	@BeforeSuite
	public void launchApp() throws Throwable{
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
	
	
	@Parameters({"userName", "Password"})
	@BeforeClass
	public void login(String userName, String Password) throws Throwable {
		LoginPage objLogin = PageFactory.initElements(driver, LoginPage.class);
		objLogin.loginFeature(userName, Password);
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void logout() throws Throwable {
		LogoutPage objLogout = PageFactory.initElements(driver, LogoutPage.class);
		objLogout.logoutFeature();
	}
	
//	Close Application
	@AfterSuite
	public void closeApp() {
		driver.quit();
	}
	
}
