package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
    private WebDriver driver;

    private By mobileNumberField = By.xpath("//input[@class='r4vIwl BV+Dqf']");
    private By continueButton = By.cssSelector("button[type='submit'][class='QqFHMw twnTnD _7Pd1Fp']");
//    private By otpField = By.cssSelector("input[type='text'][class='_2IX_2- _3mctLh VJZDxU']");
//    private By signupButton = By.cssSelector("button[type='submit'][class='_2KpZ6l _2HKlqd _3AWRsL']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

//    public void enterOTP(String otp) {
//        driver.findElement(otpField).sendKeys(otp);
//    }
//
//    public void clickSignupButton() {
//        driver.findElement(signupButton).click();
//    }
}
