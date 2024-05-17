package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By emailField = By.cssSelector("input[type='text'][class='r4vIwl BV+Dqf']");
   	private By submitButton = By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
    	driver.get("https://www.flipkart.com/account/login?ret=/account/login%3Fret%3D%2F");
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }


    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}

