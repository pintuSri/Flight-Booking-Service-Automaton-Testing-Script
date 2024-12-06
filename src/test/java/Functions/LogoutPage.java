package Functions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import Utility.AppUtils;

public class LogoutPage extends AppUtils{
	
//	Define Object Repository
	
	@FindBy(xpath="//*[@id=\"contact-info\"]/div/div[1]/h2")
	WebElement objUserDashBoard;
	
	@FindBy(xpath="//*[@id=\"header\"]/nav/div/div[3]/ul/li[2]/div/a/i")
	WebElement objUserSettings;
	
	@FindBy(linkText="Logout")
	WebElement objUserLogout;
	
//	Define Methods
	public void logoutFeature() throws Throwable {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(objUserSettings);
			act.build().perform();
			Thread.sleep(2000);
			objUserLogout.click();	
		} catch (Exception e) {
			Reporter.log("Error Message: "+e.getMessage(), true);
		}
	}
}
