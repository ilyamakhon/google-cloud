import dp.DP;
import bean.EstimationFormModel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

public class GoogleCloudTest {

    private static final String WEB_DRIVER_URL = "D:\\work\\webdriver\\chromedriver.exe";
    private static final String WEB_DRIVER = "webdriver.chrome.driver";
    private static final String BASE_URL = "https://cloud.google.com/";

    private Steps steps;

    @BeforeMethod
    public void setUp() {
        steps = new Steps();
        steps.start();
    }

    @AfterMethod
    public void afterClass() {
        steps.stop();
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DP.class)
    public void testProductEstimation(EstimationFormModel estimationFormModel) {
        steps.moveToProductsPage();
        steps.moveToPricingPage();
        steps.moveToEstimationFormPage();
        steps.fillForm(estimationFormModel);
        steps.addToEstimate();

        Assert.assertEquals(steps.getTotalEstimatedCost(), estimationFormModel.getTotalEstimationCost());
    }
}
