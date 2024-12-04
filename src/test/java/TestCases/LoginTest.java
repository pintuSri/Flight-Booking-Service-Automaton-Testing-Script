package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Functions.LoginPage;
import Functions.LogoutPage;
import Utility.AppUtils;

public class LoginTest extends AppUtils{
	
	@Parameters({"userName", "Password"})
	@Test
	public void checkUserLogin(String userName, String Password) throws Throwable {
		LoginPage objLog = PageFactory.initElements(driver, LoginPage.class);
		objLog.loginFeature(userName, Password);
		Thread.sleep(2000);
		LogoutPage objLogout = PageFactory.initElements(driver, LogoutPage.class);
		objLogout.logoutFeature();
	}

}
