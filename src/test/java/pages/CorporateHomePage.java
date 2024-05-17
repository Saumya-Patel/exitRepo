package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CorporateHomePage {

    private WebDriver driver;

    // Constructor
    public CorporateHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the corporate home page
    public void goToCorporateHomePage() {
        driver.get("https://corporate.flipkart.net/corporate-home");
    }

    // Method to select the Sustainability link
    public void selectSustainability() {
        driver.findElement(By.cssSelector("a[href='/sustainability']")).click();
    }
    

}
