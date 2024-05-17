package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductHighlightsPage {
    private WebDriver driver;

    private By highlightsSection = By.cssSelector("div._2418kt ul li");

    public ProductHighlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getHighlights() {
        return driver.findElements(highlightsSection);
    }
}
