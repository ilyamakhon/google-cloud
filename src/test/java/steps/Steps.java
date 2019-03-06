package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.PricingPage;
import pages.ProductsPage;
import pages.StartPage;

import java.util.concurrent.TimeUnit;

public class Steps {

    private static final String WEB_DRIVER_URL = "D:\\work\\webdriver\\chromedriver.exe";
    private static final String WEB_DRIVER = "webdriver.chrome.driver";
    private static final String BASE_URL = "https://cloud.google.com/";

    private WebDriver driver = null;

    public void start() {
        System.setProperty(WEB_DRIVER, WEB_DRIVER_URL);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    public void stop() {
        driver.quit();
    }

    public void moveToProductsPage() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        startPage.exploreProducts();
    }

    public void moveToPricingPage() {
        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.seePricing();
    }

    public void moveToEstimationFormPage() {
        PricingPage pricingPage = PageFactory.initElements(driver, PricingPage.class);
        pricingPage.calculate();
    }
}
