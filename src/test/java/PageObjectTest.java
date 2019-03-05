import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageObjectTest {

    private static final String WEB_DRIVER_URL = "D:\\work\\webdriver\\chromedriver.exe";
//    private static final String WEB_DRIVER_URL = "C:\\work\\webdriver\\chromedriver.exe";
    private static final String WEB_DRIVER = "webdriver.chrome.driver";
    private static final String BASE_URL = "https://cloud.google.com/";

    private WebDriver driver = null;

    @BeforeClass
    public void setUp() {
        System.setProperty(WEB_DRIVER, WEB_DRIVER_URL);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

    @Test
    public void testProductEstimation() {
        String operatingSystemAndSoftware = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
        String VMClass = "Regular";
        String instanceType = "n1-standard-8    (vCPUs: 8, RAM: 30 GB)";
        String GPUType = "NVIDIA Tesla V100";
        String localSSD = "2x375 GB";
        String dataCenterLocation = "Frankfurt (europe-west3)";
        String commitmentTerm = "1 Year";

        PageObjectSample page = PageFactory.initElements(driver, PageObjectSample.class);

        page.exploreProducts()
            .seePricing()
            .calculate()
            .computeEngine()
            .setNumberOfInstances("4");

        Assert.assertNotNull(page.checkWhatAreInstancesForEmptiness(), "'What are instances for' input is not empty!");

        page.setOperatingSystemAndSoftwareOption(operatingSystemAndSoftware);

//        Assert.assertEquals(page.getOperatingSystemAndSoftware(), operatingSystemAndSoftware, "Operating system and software does not match requested -> " + operatingSystemAndSoftware);

        page.setVMClassOption(VMClass);

//        Assert.assertEquals(page.getVMClass(), VMClass, "VM Class does not match requested -> " + VMClass);
//
        page.setInstanceTypeOption(instanceType);
//
        page.addGPUs();
//
        page.setNumberOfGPUsOption("1");
//
        page.setGPUTypeOption(GPUType);

        page.setLocalSSDOption(localSSD);

        page.setDataCenterLocationOption(dataCenterLocation);

        page.setCommitmentTermOption(commitmentTerm);

    }
}
