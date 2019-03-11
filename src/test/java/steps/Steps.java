package steps;

import bean.EstimationFormModel;
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

    public void fillForm(EstimationFormModel estimationFormModel) {
        EstimationFormPage estimationFormPage = new EstimationFormPage(driver);
        estimationFormPage.openPage();

        estimationFormPage.computeEngine();
        estimationFormPage.setNumberOfInstances(estimationFormModel.getNumberOfInstances());
        estimationFormPage.checkWhatAreInstancesForEmptiness();
        estimationFormPage.setOperatingSystemAndSoftwareOption(estimationFormModel.getOperatingSystemAndSoftware());
        estimationFormPage.setVMClassOption(estimationFormModel.getVMClass());
        estimationFormPage.setInstanceTypeOption(estimationFormModel.getInstanceType());
        estimationFormPage.addGPUs(estimationFormModel.getAddGPU());
        estimationFormPage.setNumberOfGPUsOption(estimationFormModel.getNumberOfGPUs());
        estimationFormPage.setGPUTypeOption(estimationFormModel.getGPUType());
        estimationFormPage.setLocalSSDOption(estimationFormModel.getLocalSSD());
        estimationFormPage.setDataCenterLocationOption(estimationFormModel.getDataCenterLocation());
        estimationFormPage.setCommitmentTermOption(estimationFormModel.getCommitmentTerm());

    }

    public void addToEstimate() {
        EstimationFormPage estimationFormPage = new EstimationFormPage(driver);
        estimationFormPage.addToEstimate();
    }

    public void validateEstimation(EstimationFormModel estimationFormModel) {
        EstimationFormPage estimationFormPage = new EstimationFormPage(driver);
        estimationFormPage.validateEstimationFields(estimationFormModel);
    }

    public String getTotalEstimatedCost() {
        EstimationFormPage estimationFormPage = new EstimationFormPage(driver);
        return estimationFormPage.getTotalEstimatedCost();
    }
}
