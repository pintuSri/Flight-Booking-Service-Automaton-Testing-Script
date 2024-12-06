package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Functions.SearchAndSelectFlightPage;
import Utility.AppUtils;

public class SelectFlightRouteTest extends AppUtils{
	
	@Parameters({"Month","Year","Date","From","To","AirlineName"})
	@Test
	public void FlightRoute(String Month, String Year, String Date, String From, String To, String AirlineName) throws Throwable {
		SearchAndSelectFlightPage srch = PageFactory.initElements(driver, SearchAndSelectFlightPage.class);
		srch.searchFlights(Month, Year, Date, From, To, AirlineName);
	}
	
}
