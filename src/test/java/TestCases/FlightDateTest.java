package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Functions.BookFlightPage;
import Utility.AppUtils;

public class FlightDateTest extends AppUtils{
	@Parameters({"Month","Year","Date"})
	@Test
	public void enterFlightDate(String Month, String Year, String Date) throws Throwable {
		BookFlightPage objFlightDate = PageFactory.initElements(driver, BookFlightPage.class);
		objFlightDate.selectFlightDate(Month, Year, Date);
	}

}
