package tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import listeners.Mylisteners;
import pages.CommunicationPreferencesPage;
import pages.ContactUsPage;
import pages.CorporateHomePage;
import pages.FlightSearchPage;
import pages.FlipkartHomePage;
import pages.GiftCardRedemptionPage;
import pages.GroceryPage;
import pages.HighToLowFilterPage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductHighlightsPage;
import pages.ScrollPage;
import pages.SignupPage;
import utils.ReadXLSdata;



@Listeners(Mylisteners.class)
public class FlipkartTestCase {

	public static WebDriver driver;
    private FlipkartHomePage flipkartHomePage;
    private ProductDetailsPage productDetailsPage;
    private GroceryPage groceryPage;
    private CommunicationPreferencesPage communicationPreferencesPage;
    private FlightSearchPage flightSearchPage;
    private CorporateHomePage corporateHomePage;
    private ScrollPage scrollPage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private ProductHighlightsPage productHighlightsPage;
    
    private static final Logger LOGGER = Logger.getLogger(ProductHighlightsPage.class.getName());
    
    
    String projectpath = System.getProperty("user.dir");
	ExtentReports extentReports;
	ExtentSparkReporter sparkReporter ;
	ExtentTest test;
	Properties properties = new Properties();
	
	@Parameters({"browserName","headless"})
	@BeforeClass
	public void setup(String browserName,boolean headless) throws IOException{
		LOGGER.info("Setting up the test environment");
		// Load properties from config.properties
        FileInputStream configFile = new FileInputStream(projectpath + "\\src\\main\\resources\\config.properties");
        properties.load(configFile);

        headless = Boolean.parseBoolean(properties.getProperty("headless"));
        String url = properties.getProperty("url");
        String chromeDriverPath = properties.getProperty("chromeDriverPath");
        String firefoxDriverPath = properties.getProperty("firefoxDriverPath");
        String ieDriverPath = properties.getProperty("ieDriverPath");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", ieDriverPath);
            driver = new InternetExplorerDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser specified in parameters: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
        driver.get(url);
        
        
        
        flipkartHomePage = new FlipkartHomePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        groceryPage = new GroceryPage(driver);
        communicationPreferencesPage = new CommunicationPreferencesPage(driver); 
        flightSearchPage = new FlightSearchPage(driver);
        corporateHomePage = new CorporateHomePage(driver);
        scrollPage = new ScrollPage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        productHighlightsPage = new ProductHighlightsPage(driver);
        
        
        
        File screenshotDir = new File("C:\\Users\\saumyapatel\\eclipse-workspace\\ExitTest\\reports\\screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }
        
        
        sparkReporter = new ExtentSparkReporter("." + File.separator + "reports" + File.separator + "ExitReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);

		
		extentReports.createTest("checking testcases and taking screenshot of failed testcases");
	
		
		extentReports.setSystemInfo("Machine", "Lenovo Thinkpad");
		extentReports.setSystemInfo("OS", "Windows 11");
		extentReports.setSystemInfo("User", "Saumya");
		extentReports.setSystemInfo("Browser", "Chrome");


		sparkReporter.config().setDocumentTitle("Extent Report Demo");
		sparkReporter.config().setReportName("Test Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

    }
	

    
  
	@Test(priority = 1, dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
	public void signupWithMobileNumber(String MobileNo) throws InterruptedException {
		LOGGER.info("Starting test: signupWithMobileNumber");
	    test = extentReports.createTest("Verify Signup");
	    driver.get("https://www.flipkart.com/account/login?signup=true&ret=/");
	    signupPage.enterMobileNumber(MobileNo);
	    signupPage.clickContinueButton();
	    Thread.sleep(3000);
	    Assert.assertEquals(driver.getTitle(), "Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com");
	    LOGGER.info("Completed test: signupWithMobileNumber");
	} 
    
    
    @Test(priority = 2)
    public void loginToFlipkart() throws InterruptedException {
    	LOGGER.info("Starting test: loginToFlipkart");
    	test = extentReports.createTest("Verify login");
        loginPage.clickLoginButton();
        Thread.sleep(2000); 
        loginPage.enterEmail("9335668283"); 
        loginPage.clickSubmitButton();
        Thread.sleep(3000); 
        Assert.assertTrue(true);
        LOGGER.info("Completed test: loginToFlipkart");
    }
    @Test(priority = 3)
    public void searchProduct() {
    	LOGGER.info("Starting test: searchProduct");
    	test = extentReports.createTest("Verify search");
        flipkartHomePage.searchFor("iphone15");
        flipkartHomePage.clickSearchButton();
        Assert.assertTrue(true);
        LOGGER.info("Completed test: searchProduct");
        // Add assertions or further actions here
    }
    @Test(priority = 4)
    public void addToCart ()throws InterruptedException {
    	LOGGER.info("Starting test: addToCart");
    	test = extentReports.createTest("Verify add to cart");
        driver.get("https://www.flipkart.com/apple-iphone-15-black-128-gb/p/itm6ac6485515ae4?pid=MOBGTAGPTB3VS24W&lid=LSTMOBGTAGPTB3VS24WVZNSC6&marketplace=FLIPKART&q=iphone15&store=tyy%2F4io&spotlightTagId=BestsellerId_tyy%2F4io&srno=s_1_1&otracker=search&otracker1=search&fm=Search&iid=e7c5fc65-48db-479e-be1e-3e458a32c2d0.MOBGTAGPTB3VS24W.SEARCH&ppt=sp&ppn=sp&ssid=jrhrbkdguo0000001715625085468&qH=1827ac0d826493c5");
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addToCart();
        Thread.sleep(2000); 
        Assert.assertTrue(true);
        LOGGER.info("Completed test: addToCart");
        // Add assertions or further actions here
    }
    
    
    
    @Test(priority = 5)
    public void getProductHighlights() {
    	LOGGER.info("Starting test: getProductHighlights");
    	test = extentReports.createTest("Verify product highlight");
        driver.get("https://www.flipkart.com/apple-iphone-15-black-128-gb/p/itm6ac6485515ae4?pid=MOBGTAGPTB3VS24W&lid=LSTMOBGTAGPTB3VS24WVZNSC6&marketplace=FLIPKART&q=iphone15&store=tyy%2F4io&spotlightTagId=BestsellerId_tyy%2F4io&srno=s_1_1&otracker=search&otracker1=search&fm=Search&iid=e7c5fc65-48db-479e-be1e-3e458a32c2d0.MOBGTAGPTB3VS24W.SEARCH&ppt=sp&ppn=sp&ssid=jrhrbkdguo0000001715625085468&qH=1827ac0d826493c5");

        LOGGER.info("Page loaded successfully");

        List<WebElement> highlights = productHighlightsPage.getHighlights();

        LOGGER.info("Product Highlights:");
        for (WebElement highlight : highlights) {
            LOGGER.info("- " + highlight.getText());
        }

        
    }
    
    @Test(priority = 6)
    public void goToGroceryPage() {
    	LOGGER.info("Starting test: go To GroceryPage");
    	test = extentReports.createTest("Verify groceryPage");
        driver.get("https://www.flipkart.com/");
        groceryPage.goToGroceryPage();
        Assert.assertTrue(true);
        LOGGER.info("Completed test: go To GroceryPage");
    }
    
    @Test(priority = 7)
    public void enterPinCodeTest() throws InterruptedException 
    {
    	LOGGER.info("Starting test: enter Pin Code Test");
    	test = extentReports.createTest("Verify entering pincode");
        driver.get("https://www.flipkart.com/");
        groceryPage.goToGroceryPage();
        groceryPage.enterPinCode("110001");
        groceryPage.getPinCodeField().sendKeys(Keys.RETURN);
        Assert.assertTrue(true);
        LOGGER.info("Completed test: enter Pin Code Test");
    }

    @Test(priority = 8)
    public void goToGrocerySnacksBeveragesBiscuitsPage()  {
    	LOGGER.info("Starting test: go To Grocery Snacks Beverages Biscuits Page");
    	test = extentReports.createTest("Verify grocry selection");
    	driver.get("https://www.flipkart.com/grocery/snacks-beverages/biscuits/pr?sid=73z,ujs,eb9&otracker=categorytree&marketplace=GROCERY&fm=neo%2Fmerchandising&iid=M_8f364b66-8185-4e29-807a-ab20f995e194_2_5239FF3RSRUN_MC.0B0O6N61TOZP&otracker=clp_rich_navigation_1_2.navigationCard.RICH_NAVIGATION_Snacks%2B%2526%2BBeverages~Biscuits_grocery-supermart-store_0B0O6N61TOZP&otracker1=clp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_1_L1_view-all&cid=0B0O6N61TOZP");
        WebElement element = driver.findElement(By.xpath("//img[@class='DByuf4']"));
        element.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("snacks-beverages/biscuits"), "Not on the biscuits page");
        LOGGER.info("Completed test: go To Grocery Snacks Beverages Biscuits Page");
    }
    
    @Test(priority = 9)
    public void testCommunicationPreferencesPage(){
    	LOGGER.info("Starting test: Communication Preferences Page");
    	test = extentReports.createTest("Verify testCommunicationPreferencesPage ");
        communicationPreferencesPage.navigateToPage();
        communicationPreferencesPage.clickOnElementWithXPath("//a[@class='TSD49J'][1]");
        Assert.assertTrue(true);
        LOGGER.info("Completed test: Communication Preferences Page");
    }

    @Test(priority = 10)
    public void goToCorporateHomeAndSelectSustainability(){
    	LOGGER.info("Starting test: go To CorporateHome And SelectSustainability");
    	test = extentReports.createTest("Verify CorporateHome page");
        corporateHomePage.goToCorporateHomePage();
        corporateHomePage.selectSustainability();
        Assert.assertTrue(driver.getCurrentUrl().contains("sustainability"), "Not on the sustainability page");
        LOGGER.info("Completed test: go To CorporateHome And SelectSustainability");
    }
    
    @Test(priority = 11)
    public void scrollPageToBottom() throws InterruptedException{
    	LOGGER.info("Starting test: scroll Page To Bottom");
    	test = extentReports.createTest("Verify scrollPageToBottom");
    	driver.get("https://corporate.flipkart.net/sustainability");
        scrollPage.scrollToBottom();
        Thread.sleep(2000); 
        Assert.assertTrue(true);
        LOGGER.info("Completed test: scroll Page To Bottom");
    }
    @Test(priority = 12)
    public void gotoGroupCompanies() throws InterruptedException {
    	LOGGER.info("Starting test: go to Group Companies");
        test = extentReports.createTest("Verify Contact Us page");
        driver.get("https://www.flipkart.com/helpcentre");
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.clickOnMyntraLink();
        Thread.sleep(3000);
        LOGGER.info("Completed test: go to Group Companies");
    }
    
    @Test(priority = 13)
    public void verifyGiftCardRedemption() {
    	LOGGER.info("Starting test: verify Gift Card Redemption");
        test = extentReports.createTest("Verify Gift Card Redemption");

        driver.get("https://www.flipkart.com/the-gift-card-store");
        GiftCardRedemptionPage giftCardRedemptionPage = new GiftCardRedemptionPage(driver);
        giftCardRedemptionPage.redeemGiftCard("abc@gmail.com.com", "qwerty", "Saumya Patel");
        LOGGER.info("Completed test: verify Gift Card Redemption");
    }

    @Test(priority = 14)
    public void verifyHighToLow() {
    	LOGGER.info("Starting test: verify High To Low");
        test = extentReports.createTest("Verify high to low filter");
        driver.get("https://www.flipkart.com/search?q=laptop&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
        HighToLowFilterPage highToLowFilterPage = new HighToLowFilterPage(driver);
        highToLowFilterPage.applyHighToLowFilter();
        LOGGER.info("Completed test: verify High To Low");
    }

    @Test(priority = 15)
    public void clickOnShareButton() throws InterruptedException {
    	LOGGER.info("Starting test: click On Share Button");
        test = extentReports.createTest("verify share button");
        driver.get("https://www.flipkart.com/marq-flipkart-2024-range-1-ton-3-star-split-inverter-4-in-1-convertible-turbo-cool-technology-ac-white/p/itm367dd723c240b?pid=ACNGW3NXTUCET6CZ&lid=LSTACNGW3NXTUCET6CZWFT45U&marketplace=FLIPKART&q=ac&store=j9e%2Fabm%2Fc54&srno=s_1_1&otracker=search&otracker1=search&fm=Search&iid=0af3cccc-55b7-46c9-b92a-69c9fce6a9d5.ACNGW3NXTUCET6CZ.SEARCH&ppt=sp&ppn=sp&ssid=h9kj60i4q80000001715871905299&qH=e2075474294983e0");

        // Click on the specified element
        WebElement element = driver.findElement(By.xpath("//span[@class='sm7nRr']"));
        element.click();

        test.pass("Clicked on the specified element on the product page");
        extentReports.flush();
        LOGGER.info("Completed test: click On Share Button");
    }
    
    @Test(priority = 16)
    public void clickOnNotificationPreferences() {
    	LOGGER.info("Starting test: click On Notification Preferences");
    	test = extentReports.createTest("verify NotificationPreferences");
    	String expectedUrl = "https://www.flipkart.com/communication-preferences/push?t=all";
        driver.get(expectedUrl);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The URL did not match the expected URL");
        LOGGER.info("Completed test: click On Notification Preferences");
    }

    
    @AfterMethod
	public void getTestResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Failed", ExtentColor.RED));
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Passed", ExtentColor.GREEN));

		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Skiped", ExtentColor.YELLOW));

		}
	}
    @AfterTest
	public void teardown() throws InterruptedException{
		extentReports.flush();
		Thread.sleep(3000); 
    	driver.quit();
	}
}