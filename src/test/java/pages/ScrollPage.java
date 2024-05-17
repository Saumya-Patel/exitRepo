package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollPage {

    private WebDriver driver;

    public ScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToBottom() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({\r\n"
        		+ "    top: 5000,\r\n"
        		+ "    behavior: 'smooth'\r\n"
        		+ "})");
    }
}

