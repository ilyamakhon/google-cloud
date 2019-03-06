package pages;

import bean.WebElementOptionModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static bean.WebElementOptionModel.SelectType.SELECT_WITHOUT_GROUPS;
import static bean.WebElementOptionModel.SelectType.SELECT_WITH_GROUPS;

public class StartPage {

    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "EXPLORE ALL PRODUCTS")
    private WebElement exploreProductsLink;

    @FindBy(linkText = "SEE PRICING")
    private WebElement seePricingLink;

    @FindBy(linkText = "Calculators")
    private WebElement calculatorsLink;

    @FindBy(xpath = "//div[@title='Compute Engine']")
    private WebElement computeEngine;

    @FindBy(name = "quantity")
    private WebElement numberOfInstances;

    @FindBy(name = "label")
    private WebElement whatAreInstancesFor;

    @FindBy(id = "select_value_label_40")
    private WebElement selectedOperatingSystemAndSoftware;

    @FindBy(id = "select_value_label_41")
    private WebElement selectedVMClass;

    @FindBy(id = "select_value_label_42")
    private WebElement selectedInstanceType;

    @FindBy(id = "select_value_label_327")
    private WebElement selectedNumberOfGPUs;

    @FindBy(id = "select_value_label_328")
    private WebElement selectedGPUType;

    @FindBy(id = "select_value_label_43")
    private WebElement selectedLocalSSD;

    @FindBy(id = "select_value_label_44")
    private WebElement selectedDataCenterLocation;

    @FindBy(id = "select_value_label_45")
    private WebElement selectedCommitmentTerm;

    @FindBy(id = "select_container_59")
    private WebElement selectOSAndSoftwareContainer;

    @FindBy(id = "select_container_63")
    private WebElement selectVMClassContainer;

    @FindBy(id = "select_container_94")
    private WebElement selectInstanceTypeContainer;

    @FindBy(id = "select_container_330")
    private WebElement selectNumberOfGPUsContainer;

    @FindBy(id = "select_container_332")
    private WebElement selectGPUTypeContainer;

    @FindBy(id = "select_container_96")
    private WebElement selectLocalSSDContainer;

    @FindBy(id = "select_container_98")
    private WebElement selectDataCenterLocationContainer;

    @FindBy(id = "select_container_103")
    private WebElement selectCommitmentTermContainer;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUCheckbox;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);
    }

    public StartPage exploreProducts() {
        exploreProductsLink.click();
        return this;
    }

    public StartPage seePricing() {
        seePricingLink.click();
        return this;
    }

    public StartPage calculate() {
        calculatorsLink.click();
        return this;
    }

    public StartPage computeEngine() {
        driver.switchTo().frame("idIframe");
        computeEngine.click();
        return this;
    }

    public void setNumberOfInstances(String quantity) {
        numberOfInstances.sendKeys(quantity);
    }

    public StartPage checkWhatAreInstancesForEmptiness() {
        if (whatAreInstancesFor.getAttribute("value").equals("")) {
            return this;
        }
        return null;
    }

    public void addGPUs() {
        wait.until(ExpectedConditions.elementToBeClickable(addGPUCheckbox));
        addGPUCheckbox.click();
    }

    public void setOperatingSystemAndSoftwareOption(String OSAndSoftwareToBeSelected) {
        selectOption(
                buildSelectOptionModel(
                    buildXPath(SELECT_WITHOUT_GROUPS, "select_container_59")
                    , OSAndSoftwareToBeSelected, selectedOperatingSystemAndSoftware, null, selectOSAndSoftwareContainer
        ));
    }

    public void setVMClassOption(String VMClassToBeSelected) {
        selectOption(
                buildSelectOptionModel(
                    buildXPath(SELECT_WITHOUT_GROUPS, "select_container_63")
                    , VMClassToBeSelected, selectedVMClass,null, selectVMClassContainer
        ));
    }

    public void setInstanceTypeOption(String instanceToBeSelected) {
        selectOption(
                buildSelectOptionModel(
                    buildXPath(SELECT_WITH_GROUPS, "select_container_94")
                    , instanceToBeSelected, selectedInstanceType, null, selectInstanceTypeContainer
        ));
    }

    public void setNumberOfGPUsOption(String numberOfGPUsToBeSelected) {
        selectOption(
                buildSelectOptionModel(
                    buildXPath(SELECT_WITHOUT_GROUPS, "select_container_330")
                    , numberOfGPUsToBeSelected, selectedNumberOfGPUs, null, selectNumberOfGPUsContainer
        ));
    }

    public void setGPUTypeOption(String GPUTypeToBeSelected){
        selectOption(
                buildSelectOptionModel(
                    buildXPath(SELECT_WITHOUT_GROUPS, "select_container_332")
                    , GPUTypeToBeSelected, selectedGPUType, null, selectGPUTypeContainer
        ));
    }

    public void setLocalSSDOption(String localSSDToBeSelected) {
        selectOption(
                buildSelectOptionModel(
                    buildXPath(SELECT_WITHOUT_GROUPS, "select_container_96")
                    , localSSDToBeSelected, selectedLocalSSD, null, selectLocalSSDContainer
        ));
    }

    public void setDataCenterLocationOption(String dataCenterLocationToBeSelected) {
        selectOption(
                buildSelectOptionModel(
                    buildXPath(SELECT_WITHOUT_GROUPS, "select_container_98")
                    , dataCenterLocationToBeSelected, selectedDataCenterLocation, null, selectDataCenterLocationContainer
        ));
    }

    public void setCommitmentTermOption(String commitmentTermToBeSelected) {
        selectOption(
                buildSelectOptionModel(
                    buildXPath(SELECT_WITHOUT_GROUPS, "select_container_103"),
                    commitmentTermToBeSelected, null, selectedCommitmentTerm, selectCommitmentTermContainer
        ));
    }



    private void selectOption(WebElementOptionModel webElementOptionModel) {
        if (webElementOptionModel.getActionElement() != null) {
            webElementOptionModel.getActionElement().click();
        }

        if (webElementOptionModel.getElementWaitingForClick() != null) {
            wait.until(ExpectedConditions.elementToBeClickable(webElementOptionModel.getElementWaitingForClick())).click();
        }

        if (webElementOptionModel.getElementWaitingToBeVisible() != null) {
            wait.until(ExpectedConditions.visibilityOf(webElementOptionModel.getElementWaitingToBeVisible()));
        }

        List<WebElement> listOfSelectOptions = driver.findElements(By.xpath(webElementOptionModel.getXPath()));

        for (WebElement webElement : listOfSelectOptions) {
            System.out.println(webElement.getText());
            if (webElement.getText().equals(webElementOptionModel.getOptionToBeSelected())) {
                webElement.click();
            }
        }
    }

    private String buildXPath(WebElementOptionModel.SelectType selectType, String containerID) {
        switch (selectType) {
            case SELECT_WITH_GROUPS:
                return "//div[@id='"+containerID+"']/md-select-menu/md-content/md-optgroup/md-option";
            case SELECT_WITHOUT_GROUPS:
                return "//div[@id='"+containerID+"']/md-select-menu/md-content/md-option";
        }

        return null;
    }

    private WebElementOptionModel buildSelectOptionModel(String XPath,
                                                         String optionToBeSelected,
                                                         WebElement actionElement,
                                                         WebElement elementWaitingForClick,
                                                         WebElement elementWaitingToBeVisible) {
        return WebElementOptionModel.ModelBuilder
                .create()
                    .withXPath(XPath)
                    .withOptionToBeSelected(optionToBeSelected)
                    .withActionElement(actionElement)
                    .withElementWaitingForClick(elementWaitingForClick)
                    .withElementWaitingToBeVisible(elementWaitingToBeVisible)
                .build();
    }
}
