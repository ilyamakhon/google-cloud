package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "SEE PRICING")
    private WebElement seePricingLink;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);

    }

    public ProductsPage seePricing() {
        seePricingLink.click();
        return this;
    }

}
