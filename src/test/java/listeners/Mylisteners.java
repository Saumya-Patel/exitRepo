package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.FlipkartTestCase;

public class Mylisteners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = FlipkartTestCase.driver;
        String testName = result.getName();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = testName + "_" + timeStamp + ".jpg";

        System.out.println(testName + " failed");

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("C:\\Users\\saumyapatel\\eclipse-workspace\\ExitTest\\reports\\screenshots" + screenshotName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " skipped");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " passed");
    }
}
