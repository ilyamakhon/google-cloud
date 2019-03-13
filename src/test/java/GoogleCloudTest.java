import bean.EstimationFormCase;
import bean.ValidationFormCase;
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
    public void testProductEstimation(EstimationFormCase estimationFormCase, ValidationFormCase validationFormCase) {
        steps.moveToProductsPage();
        steps.moveToPricingPage();
        steps.moveToEstimationFormPage();
        steps.fillForm(estimationFormCase);
        steps.addToEstimate();

        Assert.assertTrue(steps.validateEstimation(validationFormCase));
        Assert.assertTrue(steps.getTotalEstimatedCost(validationFormCase));
    }

//    @Test(dataProvider = "dataProvider", dataProviderClass = DP.class, dependsOnMethods = "testProductEstimation")
//    public void testEstimationFormValidation(ValidationFormCase validationFormCase) {
//        Assert.assertTrue(steps.validateEstimation(validationFormCase));
//        Assert.assertTrue(steps.getTotalEstimatedCost(validationFormCase));
//    }
}
