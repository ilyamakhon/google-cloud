import bean.EstimationFormModel;
import bean.ValidationFormModel;
import dp.DP;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.Steps;

public class GoogleCloudTest {
    private Steps steps;

    @BeforeClass
    public void setUp() {
        steps = new Steps();
        steps.start();
    }

    @AfterClass
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
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = DP.class, dependsOnMethods = "testProductEstimation")
    public void testEstimationFormValidation(ValidationFormModel validationFormModel) {
        Assert.assertTrue(steps.validateEstimation(validationFormModel));
        Assert.assertTrue(steps.getTotalEstimatedCost(validationFormModel));
    }
}
