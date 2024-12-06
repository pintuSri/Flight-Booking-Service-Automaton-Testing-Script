package TestCases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Functions.BookFlightPage;
import Functions.SearchAndSelectFlightPage;
import Utility.AppUtils;

public class BookFlightTest extends AppUtils{
	
	@Parameters({"Month","Year","Date","From","To","AirlineName","PassengerName","FlightClass","Tickets"})
	@Test
	public void insertOrder(String Month, String Year, String Date, String From, String To, String AirlineName,String PassengerName, String FlightClass,
			String Tickets) throws Throwable 
	{
		SearchAndSelectFlightPage flightRoute = PageFactory.initElements(driver, SearchAndSelectFlightPage.class);
		flightRoute.searchFlights(Month, Year, Date, From, To, AirlineName);
		Thread.sleep(2000);
		BookFlightPage obj = PageFactory.initElements(driver, BookFlightPage.class);
		obj.passengerName(PassengerName);
		Thread.sleep(2000);
		obj.flightClass(FlightClass);
		Thread.sleep(2000);
		obj.tickets(Tickets);
		Thread.sleep(2000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("Output/OrderInfo.png");
		FileUtils.copyFile(src, trg);
		obj.insertOrder();
		Thread.sleep(2000);
		TakesScreenshot ts1 = (TakesScreenshot)driver;
		File src1=ts1.getScreenshotAs(OutputType.FILE);
		File trg1 = new File("Output/OrderSuccess.png");
		FileUtils.copyFile(src1, trg1);
	}
}
