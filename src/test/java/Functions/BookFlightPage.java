package Functions;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Utility.AppUtils;

public class BookFlightPage extends AppUtils{
	
//	Define Object Library
	
	@FindBy(id="search-date")
	WebElement objFlightDate;
	
	@FindBy(className = "ui-datepicker-month")
	WebElement objMonth;
	
	@FindBy(className="ui-datepicker-year")
	WebElement objYear;
	
	@FindBy(xpath="//span[contains(@class,'ui-icon-circle-triangle-e')]")
	WebElement objClickNext;
	
	@FindBy(className="ui-datepicker-calendar")
	WebElement objCalenderDate;
	
	@FindBy(xpath="//select[contains(@class,'sf2')]")
	WebElement objFlightFrom;
	
	@FindBy(xpath="//select[contains(@class,'sf3')]")
	WebElement objFlightTo;
	
	@FindBy(id="name")
	WebElement objPassengerName;
	
	@FindBy(xpath="//input[@type='radio' and @value='First Class']")
	WebElement objObjFirstClass;
	
	@FindBy(xpath="//input[@type='radio' and @value='Business']")
	WebElement objBusinessClass;
	
	@FindBy(xpath="//input[@type='radio' and @value='Economy']")
	WebElement objEconomyClass;
	
	@FindBy(id="tickets")
	WebElement objNumberOfTickets;
	
	@FindBy(xpath="//button[contains(@class,'insert-order') and contains(@class,'active')]")
	WebElement objInsertOrder;
	
//	Define Methods
	
	public void selectFlightDate(String month, String year, String date) throws Throwable {
		objFlightDate.click();
		Thread.sleep(2000);
		String mnth=objMonth.getText();
		String yr = objYear.getText();
		while(!yr.equals(year)) {
			objClickNext.click();
			yr = objYear.getText();
		}
		while(!mnth.equals(month)) {
			objClickNext.click();
			mnth=objMonth.getText();
		}
		
		WebElement tableBody=objCalenderDate.findElement(By.tagName("tbody"));
		List<WebElement> trows=tableBody.findElements(By.tagName("tr"));
		for(int i=0; i<trows.size(); i++) {
			List<WebElement> tcols=trows.get(i).findElements(By.tagName("td"));
			for(int j=0; j<tcols.size(); j++) {
				String dt=tcols.get(j).getText();
				if(dt.equalsIgnoreCase(date)) {
					tcols.get(j).click();
					break;
				}
			}
		}
		Thread.sleep(2000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("Output/FlightMonthYear.png");
		FileUtils.copyFile(src, trg);
	}
	
	
	public void selectFrom(String from) {
		Select fr = new Select(objFlightFrom);
		fr.selectByVisibleText(from);
	}
	
	public void selectTo(String To) {
		Select to = new Select(objFlightTo);
		to.selectByVisibleText(To);
	}
	
	public void passengerName(String PassengerName) {
		objPassengerName.sendKeys(PassengerName);
	}
	
	public void flightClass(String FlightClass) {
		if(FlightClass.equalsIgnoreCase("First Class")) {
			objObjFirstClass.click();
		}
		if(FlightClass.equalsIgnoreCase("Business")) {
			objBusinessClass.click();
		}
		if(FlightClass.equalsIgnoreCase("Economy")) {
			objEconomyClass.click();
		}
	}
	
	public void tickets(String Tickets) {
		objNumberOfTickets.clear();
		objNumberOfTickets.sendKeys(Tickets);
	}
	
	public void insertOrder() {
		try {
			objInsertOrder.click();
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
	}

}
