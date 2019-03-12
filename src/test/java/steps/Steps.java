package steps;

import bean.EstimationFormCase;
import bean.ValidationFormCase;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.EstimationFormPage;
import pages.PricingPage;
import pages.ProductsPage;
import pages.StartPage;

public class Steps {

    private WebDriver driver;

    public void start() {
        driver = DriverSingleton.getDriver();
    }

    public void stop() {
        DriverSingleton.closeDriver();
    }

    public void moveToProductsPage() {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.exploreProducts();
    }

    public void moveToPricingPage() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.openPage();
        productsPage.seePricing();
    }

    public void moveToEstimationFormPage() {
        PricingPage pricingPage = new PricingPage(driver);
        pricingPage.openPage();
        pricingPage.calculate();
    }

    public void fillForm(EstimationFormCase estimationFormCase) {
        EstimationFormPage estimationFormPage = new EstimationFormPage(driver);
        estimationFormPage.openPage();

        estimationFormPage.computeEngine();
        estimationFormPage.setNumberOfInstances(estimationFormCase.getNumberOfInstances());
        estimationFormPage.checkWhatAreInstancesForEmptiness();
        estimationFormPage.setOperatingSystemAndSoftwareOption(estimationFormCase.getOperatingSystemAndSoftware());
        estimationFormPage.setVMClassOption(estimationFormCase.getVMClass());
        estimationFormPage.setInstanceTypeOption(estimationFormCase.getInstanceType());
        estimationFormPage.addGPUs(estimationFormCase.getAddGPU());
        estimationFormPage.setNumberOfGPUsOption(estimationFormCase.getNumberOfGPUs());
        estimationFormPage.setGPUTypeOption(estimationFormCase.getGPUType());
        estimationFormPage.setLocalSSDOption(estimationFormCase.getLocalSSD());
        estimationFormPage.setDataCenterLocationOption(estimationFormCase.getDataCenterLocation());
        estimationFormPage.setCommitmentTermOption(estimationFormCase.getCommitmentTerm());

    }

    public void addToEstimate() {
        EstimationFormPage estimationFormPage = new EstimationFormPage(driver);
        estimationFormPage.addToEstimate();
    }

    public boolean validateEstimation(ValidationFormCase validationFormCase) {
        EstimationFormPage estimationFormPage = new EstimationFormPage(driver);
        return estimationFormPage.validateEstimationFields(validationFormCase);
    }

    public boolean getTotalEstimatedCost(ValidationFormCase validationFormCase) {
        EstimationFormPage estimationFormPage = new EstimationFormPage(driver);
        return estimationFormPage.getTotalEstimatedCost().contains(validationFormCase.getTotalEstimatedCost());
    }
}
