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
    private WebElement selectedCommitedUsage;

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
    private WebElement selectCommitedUsageContainer;

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

        selectedOperatingSystemAndSoftware.click();
        wait.until(ExpectedConditions.visibilityOf(selectOSAndSoftwareContainer));

        selectOption(XPath, OSAndSoftwareToBeSelected);
    }

    public void setVMClassOption(String VMClassToBeSelected) {
        XPath = "//div[@id='select_container_63']/md-select-menu/md-content/md-option/div[@class='md-text']";

        selectedVMClass.click();
        wait.until(ExpectedConditions.visibilityOf(selectVMClassContainer));

        selectOption(XPath, VMClassToBeSelected);
    }

    public void setInstanceTypeOption(String instanceToBeSelected) {
        XPath = "//div[@id='select_container_94']/md-select-menu/md-content/md-optgroup/md-option/div[@class='md-text']";

        selectedInstanceType.click();
        wait.until(ExpectedConditions.visibilityOf(selectInstanceTypeContainer));

        selectOption(XPath, instanceToBeSelected);
    }

    public void setNumberOfGPUsOption(String numberOfGPUsToBeSelected) {
        XPath = "//div[@id='select_container_330']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        selectedNumberOfGPUs.click();
        wait.until(ExpectedConditions.visibilityOf(selectNumberOfGPUsContainer));

        selectOption(XPath, numberOfGPUsToBeSelected);
    }

    public void setGPUTypeOption(String GPUTypeToBeSelected){
        XPath = "//div[@id='select_container_332']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        selectedGPUType.click();
        wait.until(ExpectedConditions.visibilityOf(selectGPUTypeContainer));

        selectOption(XPath, GPUTypeToBeSelected);
    }

    public void setLocalSSDOption(String localSSDToBeSelected) {
        XPath = "//div[@id='select_container_96']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        selectedLocalSSD.click();
        wait.until(ExpectedConditions.visibilityOf(selectLocalSSDContainer));

        selectOption(XPath, localSSDToBeSelected);
    }

    public void setDataCenterLocationOption(String dataCenterLocationToBeSelected) {
        XPath = "//div[@id='select_container_98']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        selectedDataCenterLocation.click();
        wait.until(ExpectedConditions.visibilityOf(selectDataCenterLocationContainer));

        selectOption(XPath, dataCenterLocationToBeSelected);
    }

    public void setCommitedUsageOption(String commitedUsageToBeSelected) {
        XPath = "//div[@id='select_container_103']/md-select-menu/md-content/md-option/div[@class='md-text']";

        wait.until(ExpectedConditions.elementToBeClickable(selectedCommitedUsage)).click();
        wait.until(ExpectedConditions.visibilityOf(selectCommitedUsageContainer));

        selectOption(XPath, commitedUsageToBeSelected);
    }

    public String getSelectedOperatingSystemAndSoftware() {
        return selectedOperatingSystemAndSoftware.getText();
    }

    public String getSelectedVMClass() {
        return selectedVMClass.getText();
    }

    private void selectOption(String XPath, String optionToBeSelected) {
        List<WebElement> listOfSelectOptions = driver.findElements(By.xpath(XPath));

        for (WebElement webElement : listOfSelectOptions) {
            System.out.println(webElement.getText());
            if (webElement.getText().equals(optionToBeSelected)) {
                webElement.click();
            }
        }
    }
}
