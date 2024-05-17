package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HighToLowFilterPage {
    private WebDriver driver;

    public HighToLowFilterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyHighToLowFilter() {
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='zg-M3Z'][3]")));
        WebElement highToLowFilter = driver.findElement(By.xpath("//div[@class='zg-M3Z'][3]"));
        highToLowFilter.click();
    }
}

