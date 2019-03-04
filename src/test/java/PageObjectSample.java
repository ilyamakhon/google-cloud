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

    private String elementXPath;

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

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUCheckbox;

    public PageObjectSample(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,4);
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

    public void setOperatingSystemAndSoftware(String OSAndSoftwareToBeSelected) {
        elementXPath = "//div[@id='select_container_59']/md-select-menu/md-content/md-option/div[@class='md-text']";

        selectedOperatingSystemAndSoftware.click();
        wait.until(ExpectedConditions.visibilityOf(selectOSAndSoftwareContainer));

        List<WebElement> OSAndSoftwareList = driver.findElements(By.xpath(elementXPath));
        selectElement(OSAndSoftwareList, OSAndSoftwareToBeSelected);
    }

    public void setVMClass(String VMClassToBeSelected) {
        elementXPath = "//div[@id='select_container_63']/md-select-menu/md-content/md-option/div[@class='md-text']";

        selectedVMClass.click();
        wait.until(ExpectedConditions.visibilityOf(selectVMClassContainer));

        List<WebElement> VMClassList = driver.findElements(By.xpath(elementXPath));
        selectElement(VMClassList, VMClassToBeSelected);
    }

    public void setInstanceType(String instanceToBeSelected) {
        elementXPath = "//div[@id='select_container_94']/md-select-menu/md-content/md-optgroup/md-option/div[@class='md-text']";

        wait.until(ExpectedConditions.visibilityOf(selectedInstanceType)).click();
        wait.until(ExpectedConditions.visibilityOf(selectInstanceTypeContainer));

        List<WebElement> listOfInstances = driver.findElements(By.xpath(elementXPath));
        selectElement(listOfInstances, instanceToBeSelected);
    }

    public void setNumberOfGPUs(String numberOfGPUsToBeSelected) {
        elementXPath = "//div[@id='select_container_330']/md-select-menu/md-content/md-option/div[@class='md-text']";

        selectedNumberOfGPUs.click();
        List<WebElement> listOfGPUsNumber = driver.findElements(By.xpath(elementXPath));

        wait.until(ExpectedConditions.visibilityOf(selectNumberOfGPUsContainer));
        selectElement(listOfGPUsNumber, numberOfGPUsToBeSelected);
    }


    public void setGPUType(String GPUType){
        elementXPath = "//div[@id='select_container_332']/md-select-menu/md-content/md-optgroup/md-option/div[@class='md-text']";
        List<WebElement> listOfGPUsNumber = driver.findElements(By.xpath(elementXPath));

        selectedInstanceType.click();
        wait.until(ExpectedConditions.visibilityOf(selectGPUTypeContainer));
        selectElement(listOfGPUsNumber, GPUType);
    }

    public String getSelectedOperatingSystemAndSoftware() {
        return selectedOperatingSystemAndSoftware.getText();
    }

    public String getSelectedVMClass() {
        return selectedVMClass.getText();
    }

    private void selectElement(List<WebElement> listOfSelectElements, String elementToBeSelected) {
        for (WebElement webElement : listOfSelectElements) {
            System.out.println(webElement.getText());
            if (webElement.getText().equals(elementToBeSelected)) {
                webElement.click();
            }
        }
    }
}
