package Functions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
//	Define ObjRepository
	
	@FindBy(name="email")
	WebElement objEmailID;
	
	@FindBy(name="password")
	WebElement objPassword;
	
	@FindBy(xpath="//button[contains(@class,'btn-primary')]")
	WebElement objSigin;
	
	
//	Define Methods
	
	public void loginFeature(String userName, String Password) {
		objEmailID.sendKeys(userName);
		objPassword.sendKeys(Password);
		objSigin.click();
	}

}
