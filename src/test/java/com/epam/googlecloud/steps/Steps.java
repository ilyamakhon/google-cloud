package com.epam.googlecloud.steps;

import com.epam.googlecloud.bean.EstimationFormCase;
import com.epam.googlecloud.bean.ValidationFormCase;
import com.epam.googlecloud.driver.DriverSingleton;
import com.epam.googlecloud.page.EstimationFormPage;
import com.epam.googlecloud.page.StartPage;
import org.openqa.selenium.WebDriver;

public class Steps {

    private WebDriver driver;

    public void start() {
        driver = DriverSingleton.getDriver();
    }

    public void stop() {
        DriverSingleton.closeDriver();
    }

    public void moveToEstimationForm() {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();

        startPage
                .exploreProducts()
                .seePricing()
                .calculate();
    }

    public void fillForm(EstimationFormCase estimationFormCase) {
        EstimationFormPage estimationFormPage = new EstimationFormPage(driver);

        estimationFormPage.computeEngine();
        estimationFormPage.setNumberOfInstances(estimationFormCase.getNumberOfInstances());
        estimationFormPage.checkWhatAreInstancesForEmptiness();
        estimationFormPage.setOperatingSystemAndSoftwareOption(estimationFormCase.getOperatingSystemAndSoftware());
        estimationFormPage.setVMClassOption(estimationFormCase.getVMClass());
        estimationFormPage.setInstanceTypeOption(estimationFormCase.getInstanceType());
        if(estimationFormCase.getAddGPU().equals("Yes")) {
            estimationFormPage.addGPUs();
            estimationFormPage.setNumberOfGPUsOption(estimationFormCase.getNumberOfGPUs());
            estimationFormPage.setGPUTypeOption(estimationFormCase.getGPUType());
            estimationFormPage.setLocalSSDOption(estimationFormCase.getLocalSSD());
            estimationFormPage.setDataCenterLocationOption(estimationFormCase.getDataCenterLocation());
            estimationFormPage.setCommitmentTermOption(estimationFormCase.getCommitmentTerm());
        } else {
            estimationFormPage.setLocalSSDOption(estimationFormCase.getLocalSSD());
            estimationFormPage.setDataCenterLocationOption(estimationFormCase.getDataCenterLocation());
            estimationFormPage.setCommitmentTermOption(estimationFormCase.getCommitmentTerm());
        }
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
