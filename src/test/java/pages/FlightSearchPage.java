package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage {

    private WebDriver driver;

    public FlightSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDepartureAirport(String airport) {
    	driver.get("https://www.flipkart.com/travel/flights?otracker=nmenu_Flights");
        Select selectDeparture = new Select(driver.findElement(By.xpath("//input[@name='0-departcity']")));
        selectDeparture.selectByVisibleText(airport);
    }

    public void selectArrivalAirport(String airport) {
        Select selectArrival = new Select(driver.findElement(By.name("0-arrivalcity")));
        selectArrival.selectByVisibleText(airport);
    }
}


