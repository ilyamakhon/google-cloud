import bean.WebElementOptionModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageObjectSample {

    private final WebDriver driver;
    private WebDriverWait wait;
    private WebElementOptionModel webElementOptionModel;

    private String XPath;

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

    public PageObjectSample(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public PageObjectSample exploreProducts() {
        exploreProductsLink.click();
        return this;
    }

    public PageObjectSample seePricing() {
        seePricingLink.click();
        return this;
    }

    public PageObjectSample calculate() {
        calculatorsLink.click();
        return this;
    }

    public PageObjectSample computeEngine() {
        driver.switchTo().frame("idIframe");
        computeEngine.click();
        return this;
    }

    public void setNumberOfInstances(String quantity) {
        numberOfInstances.sendKeys(quantity);
    }

    public PageObjectSample checkWhatAreInstancesForEmptiness() {
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
        XPath = "//div[@id='select_container_59']/md-select-menu/md-content/md-option/div[@class='md-text']";

        webElementOptionModel = new WebElementOptionModel();
        webElementOptionModel.setOptionToBeSelected(OSAndSoftwareToBeSelected);
        webElementOptionModel.setXPath(XPath);
        webElementOptionModel.setActionElement(selectedOperatingSystemAndSoftware);
        webElementOptionModel.setElementWaitingToBeVisible(selectOSAndSoftwareContainer);

        //        selectedOperatingSystemAndSoftware.click();
//        wait.until(ExpectedConditions.visibilityOf(selectOSAndSoftwareContainer));

        selectOption(webElementOptionModel);
    }

    public void setVMClassOption(String VMClassToBeSelected) {
        XPath = "//div[@id='select_container_63']/md-select-menu/md-content/md-option/div[@class='md-text']";

        webElementOptionModel = new WebElementOptionModel();
        webElementOptionModel.setOptionToBeSelected(VMClassToBeSelected);
        webElementOptionModel.setActionElement(selectedVMClass);
        webElementOptionModel.setElementWaitingToBeVisible(selectVMClassContainer);
        webElementOptionModel.setXPath(XPath);

//        selectedVMClass.click();
//        wait.until(ExpectedConditions.visibilityOf(selectVMClassContainer));

        selectOption(webElementOptionModel);
    }

    public void setInstanceTypeOption(String instanceToBeSelected) {
        XPath = "//div[@id='select_container_94']/md-select-menu/md-content/md-optgroup/md-option/div[@class='md-text']";

        webElementOptionModel = new WebElementOptionModel();
        webElementOptionModel.setOptionToBeSelected(instanceToBeSelected);
        webElementOptionModel.setActionElement(selectedInstanceType);
        webElementOptionModel.setElementWaitingToBeVisible(selectInstanceTypeContainer);
        webElementOptionModel.setXPath(XPath);


//        selectedInstanceType.click();
//        wait.until(ExpectedConditions.visibilityOf(selectInstanceTypeContainer));

        selectOption(webElementOptionModel);
    }

    public void setNumberOfGPUsOption(String numberOfGPUsToBeSelected) {
        XPath = "//div[@id='select_container_330']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        webElementOptionModel = new WebElementOptionModel();
        webElementOptionModel.setActionElement(selectedNumberOfGPUs);
        webElementOptionModel.setElementWaitingToBeVisible(selectNumberOfGPUsContainer);
        webElementOptionModel.setXPath(XPath);
//        selectedNumberOfGPUs.click();
//        wait.until(ExpectedConditions.visibilityOf(selectNumberOfGPUsContainer));

        selectOption(webElementOptionModel);
    }

    public void setGPUTypeOption(String GPUTypeToBeSelected){
        XPath = "//div[@id='select_container_332']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        webElementOptionModel = new WebElementOptionModel();
        webElementOptionModel.setActionElement(selectedGPUType);
        webElementOptionModel.setElementWaitingToBeVisible(selectGPUTypeContainer);
        webElementOptionModel.setXPath(XPath);
//        selectedGPUType.click();
//        wait.until(ExpectedConditions.visibilityOf(selectGPUTypeContainer));

        selectOption(webElementOptionModel);
    }

    public void setLocalSSDOption(String localSSDToBeSelected) {
        XPath = "//div[@id='select_container_96']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        webElementOptionModel = new WebElementOptionModel();
        webElementOptionModel.setActionElement(selectedLocalSSD);
        webElementOptionModel.setElementWaitingToBeVisible(selectLocalSSDContainer);
        webElementOptionModel.setXPath(XPath);
//        selectedLocalSSD.click();
//        wait.until(ExpectedConditions.visibilityOf(selectLocalSSDContainer));

        selectOption(webElementOptionModel);
    }

    public void setDataCenterLocationOption(String dataCenterLocationToBeSelected) {
        XPath = "//div[@id='select_container_98']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        webElementOptionModel = new WebElementOptionModel();
        webElementOptionModel.setActionElement(selectedDataCenterLocation);
        webElementOptionModel.setElementWaitingToBeVisible(selectDataCenterLocationContainer);
        webElementOptionModel.setXPath(XPath);
        //selectedDataCenterLocation.click();
        //wait.until(ExpectedConditions.visibilityOf(selectDataCenterLocationContainer));

        selectOption(webElementOptionModel);
    }

    public void setCommitmentTermOption(String commitmentTermToBeSelected) {
        XPath = "//div[@id='select_container_103']/md-select-menu/md-content/md-option/div[@class='md-text']";

        webElementOptionModel = new WebElementOptionModel();
        webElementOptionModel.setElementWaitingForClick(selectedCommitmentTerm);
        webElementOptionModel.setElementWaitingToBeVisible(selectCommitmentTermContainer);
        webElementOptionModel.setXPath(XPath);
//        wait.until(ExpectedConditions.elementToBeClickable(selectedCommitmentTerm)).click();
//        wait.until(ExpectedConditions.visibilityOf(selectCommitmentTermContainer));

        selectOption(webElementOptionModel);
    }

//    public String getOperatingSystemAndSoftware() {
//        return selectedOperatingSystemAndSoftware.getText();
//    }
//
//    public String getVMClass() {
//        return selectedVMClass.getText();
//    }
//
//    public String getDataCenterLocation() {
//        return selectedDataCenterLocation.getText();
//    }
//
//    public String getInstanceType() {
//        return selectedInstanceType.getText();
//    }
//
//    public String getLocalSSD() {
//        return selectedLocalSSD.getText();
//    }
//
//    public String getCommitmentTerm() {
//        return selectedCommitmentTerm.getText();
//    }

//    private void selectOption(String XPath, String optionToBeSelected) {
//        List<WebElement> listOfSelectOptions = driver.findElements(By.xpath(XPath));
//
//        for (WebElement webElement : listOfSelectOptions) {
//            System.out.println(webElement.getText());
//            if (webElement.getText().equals(optionToBeSelected)) {
//                webElement.click();
//            }
//        }
//    }

    private void selectOption(WebElementOptionModel webElementOptionModel) {
        if (webElementOptionModel.getActionElement() != null) {
            webElementOptionModel.getActionElement().click();
        }

        if (webElementOptionModel.getElementWaitingForClick() != null) {
            wait.until(ExpectedConditions.elementToBeClickable(webElementOptionModel.getElementWaitingForClick()));
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
}
