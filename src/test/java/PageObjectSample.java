import bean.WebElementOptionModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

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

        webElementOptionModel = buildModel(
                XPath, OSAndSoftwareToBeSelected, selectedOperatingSystemAndSoftware, null, selectOSAndSoftwareContainer
        );

        selectOption(webElementOptionModel);
    }

    public void setVMClassOption(String VMClassToBeSelected) {
        XPath = "//div[@id='select_container_63']/md-select-menu/md-content/md-option/div[@class='md-text']";

        webElementOptionModel = buildModel(
                XPath, VMClassToBeSelected, selectedVMClass,null, selectVMClassContainer
        );

        selectOption(webElementOptionModel);
    }

    public void setInstanceTypeOption(String instanceToBeSelected) {
        XPath = "//div[@id='select_container_94']/md-select-menu/md-content/md-optgroup/md-option/div[@class='md-text']";

        webElementOptionModel = buildModel(
                XPath, instanceToBeSelected, selectedInstanceType, null, selectInstanceTypeContainer
        );

        selectOption(webElementOptionModel);
    }

    public void setNumberOfGPUsOption(String numberOfGPUsToBeSelected) {
        XPath = "//div[@id='select_container_330']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        webElementOptionModel = buildModel(
                XPath, numberOfGPUsToBeSelected, selectedNumberOfGPUs, null, selectNumberOfGPUsContainer
        );

        selectOption(webElementOptionModel);
    }

    public void setGPUTypeOption(String GPUTypeToBeSelected){
        XPath = "//div[@id='select_container_332']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        webElementOptionModel = buildModel(
                XPath, GPUTypeToBeSelected, selectedGPUType, null, selectGPUTypeContainer
        );

        selectOption(webElementOptionModel);
    }

    public void setLocalSSDOption(String localSSDToBeSelected) {
        XPath = "//div[@id='select_container_96']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        webElementOptionModel = buildModel(
                XPath, localSSDToBeSelected, selectedLocalSSD, null, selectLocalSSDContainer
        );

        selectOption(webElementOptionModel);
    }

    public void setDataCenterLocationOption(String dataCenterLocationToBeSelected) {
        XPath = "//div[@id='select_container_98']/md-select-menu/md-content/md-option/div[@class='md-text ng-binding']";

        webElementOptionModel = buildModel(
                XPath, dataCenterLocationToBeSelected, selectedDataCenterLocation, null, selectDataCenterLocationContainer
        );

        selectOption(webElementOptionModel);
    }

    public void setCommitmentTermOption(String commitmentTermToBeSelected) {
        XPath = "//div[@id='select_container_103']/md-select-menu/md-content/md-option/div[@class='md-text']";

        webElementOptionModel = buildModel(
                XPath, commitmentTermToBeSelected, null, selectedCommitmentTerm, selectCommitmentTermContainer
        );

        selectOption(webElementOptionModel);
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





    private WebElementOptionModel buildModel(String XPath,
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
