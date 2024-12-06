package TestCases;

import java.io.File;
import java.io.FileWriter;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utility.AppUtils;

public class LoginTest extends AppUtils{
	
	
	
	
//	@Parameters({"userName", "Password"})
//	@Test(priority = 1,enabled = false)
//	public void checkUserLogin(String userName, String Password) throws Throwable {
//		LoginPage objLog = PageFactory.initElements(driver, LoginPage.class);
//		objLog.loginFeature(userName, Password);
//		Thread.sleep(2000);
//		LogoutPage objLogout = PageFactory.initElements(driver, LogoutPage.class);
//		objLogout.logoutFeature();
//	}
	
	
	@Test()
	public void verifyLoginPage() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("objUserDashBoard"))));
		File fi = new File("Output/LoginVerification.txt");
		fi.createNewFile();
		FileWriter fw = new FileWriter(fi);
		fw.write(driver.findElement(By.xpath(p.getProperty("objUserDashBoard"))).getText()+"\n");
		fw.close();
	}
}
