package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GiftCardRedemptionPage {
    private WebDriver driver;

    public GiftCardRedemptionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void redeemGiftCard(String recipientEmail, String recipientName, String senderName) {
    	driver.findElement(By.cssSelector("img[src='https://rukminim2.flixcart.com/fk-p-flap/100/100/image/93881a4d42932961.jpg?q=50']")).click();
        driver.findElement(By.cssSelector("input.v2VFa-.z2D4XG[name='recipient-email[]']")).sendKeys(recipientEmail);
        driver.findElement(By.cssSelector("input.v2VFa-.z2D4XG[name='recipient-name[]']")).sendKeys(recipientName);
        driver.findElement(By.cssSelector("input.v2VFa-.z2D4XG[name='sender-name[]']")).sendKeys(senderName);
    }
}

