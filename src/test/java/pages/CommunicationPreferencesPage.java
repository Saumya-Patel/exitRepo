package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommunicationPreferencesPage {
    private WebDriver driver;
    private String url = "https://www.flipkart.com/communication-preferences/push?t=all";

    public CommunicationPreferencesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void clickOnElementWithXPath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }
    
}
