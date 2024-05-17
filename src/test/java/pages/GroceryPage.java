package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GroceryPage {

    private WebDriver driver;

    public GroceryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToGroceryPage() {
        WebElement element = driver.findElement(By.xpath("//a[@class='_1ch8e_'][1]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void enterPinCode(String pinCode) {
        WebElement pinCodeInput = driver.findElement(By.xpath("//input[@class='_1UOrqe']"));
        pinCodeInput.sendKeys(pinCode);
    }
    public WebElement getPinCodeField() {
        return driver.findElement(By.xpath("//input[@class='_1UOrqe']"));
    }
    // Add other methods for interacting with elements on the grocery page
}

