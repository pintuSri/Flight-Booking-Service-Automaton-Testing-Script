package Functions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.AppUtils;

public class SearchAndSelectFlightPage  extends AppUtils{
	
//	Define Object Repository
	
	@FindBy(xpath="//button[contains(@class,'btn-search')]")
	WebElement objSearchFlight;
	
	@FindBy(className ="flights_table")
	WebElement objFLightTable;
	
	@FindBy(xpath ="//button[@type='button' and @class='close']")
	WebElement objFlightSearchTableClose;
	
	public static String airline;
	
	public void searchFlights(String Month, String Year, String Date, String From, String To, String AirlineName) throws Throwable {
		BookFlightPage bf = PageFactory.initElements(driver, BookFlightPage.class);
		bf.selectFlightDate(Month, Year, Date);
		bf.selectFrom(From);
		bf.selectTo(To);
		objSearchFlight.click();
		Thread.sleep(2000);
		
		if(objFLightTable.isDisplayed()==true) {
			List<WebElement> trows=objFLightTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
			for(int i=1; i<trows.size(); i++) {
				List<WebElement> tcols=trows.get(i).findElements(By.tagName("td"));
				airline=tcols.get(0).getText();
				if(airline.equalsIgnoreCase(AirlineName)) {
					tcols.get(8).click();
					break;
				}
			}
		}
		else {
			objFlightSearchTableClose.click();
		}
		
	}
	
}
