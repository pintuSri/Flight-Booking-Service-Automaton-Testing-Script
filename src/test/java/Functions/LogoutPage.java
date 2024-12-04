package Functions;

import java.io.File;
import java.io.FileWriter;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(objUserSettings));
		String userDashBoard=objUserDashBoard.getText();
		File fi = new File("Output/LoginVerification.txt");
		fi.createNewFile();
		FileWriter fw = new FileWriter(fi);
		fw.write(userDashBoard);
		fw.close();
		Actions act = new Actions(driver);
		act.moveToElement(objUserSettings);
		act.build().perform();
		Thread.sleep(2000);
		objUserLogout.click();
		
	}

}
