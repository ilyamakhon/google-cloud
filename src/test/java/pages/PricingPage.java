package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingPage {

    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Calculators")
    private WebElement calculatorsLink;

    public PricingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);
    }

    public PricingPage calculate() {
        calculatorsLink.click();
        return this;
    }
}
