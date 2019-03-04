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

    @FindBy(id = "select_container_59")
    private WebElement selectOSAndSoftwareContainer;

    @FindBy(id = "select_container_63")
    private WebElement selectVMClassContainer;


    public PageObjectSample(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,3);
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

    public PageObjectSample setNumberOfInstances(String quantity) {
        numberOfInstances.sendKeys(quantity);
        return this;
    }

    public PageObjectSample checkWhatAreInstancesForEmptiness() {
        if (whatAreInstancesFor.getAttribute("value").equals("")) {
            return this;
        }
        return null;
    }

    public void setOperatingSystemAndSoftware(String OSAndSoftwareToBeSelected) {
        String selectElementXPath = "//div[@id='select_container_59']/md-select-menu/md-content/md-option/div[@class='md-text']";
        List<WebElement> OSAndSoftwareList = driver.findElements(By.xpath(selectElementXPath));

        selectedOperatingSystemAndSoftware.click();

        wait.until(ExpectedConditions.visibilityOf(selectOSAndSoftwareContainer));
        for (WebElement OSAndSoftware : OSAndSoftwareList) {
            if (OSAndSoftware.getText().equals(OSAndSoftwareToBeSelected)) {
                OSAndSoftware.click();
            }
        }
    }

    public void setVMClass(String VMClassToBeSelected) {
        String selectElementXPath = "//div[@id='select_container_63']/md-select-menu/md-content/md-option";
        List<WebElement> VMClassList = driver.findElements(By.xpath(selectElementXPath));

        selectedVMClass.click();

        wait.until(ExpectedConditions.visibilityOf(selectVMClassContainer));
        for (WebElement VMClass : VMClassList) {
            if (VMClass.getText().equals(VMClassToBeSelected)) {
                VMClass.click();
            }
        }
    }

    public String getSelectedOperatingSystemAndSoftware() {
        return selectedOperatingSystemAndSoftware.getText();
    }

    public String getSelectedVMClass() {
        return selectedVMClass.getText();
    }

}
