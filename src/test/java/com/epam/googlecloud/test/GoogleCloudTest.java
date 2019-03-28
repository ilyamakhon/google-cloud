package com.epam.googlecloud.test;

import com.epam.googlecloud.bean.EstimationFormCase;
import com.epam.googlecloud.bean.ValidationFormCase;
import com.epam.googlecloud.dp.DP;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.epam.googlecloud.steps.Steps;

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
        steps.moveToEstimationForm();
        steps.fillForm(estimationFormCase);
        steps.addToEstimate();

        Assert.assertTrue(steps.validateEstimation(validationFormCase));
        Assert.assertTrue(steps.getTotalEstimatedCost(validationFormCase));
    }
}
