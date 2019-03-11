package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingPage extends AbstractPage{

    private final String BASE_URL = "https://cloud.google.com/pricing/";

    @FindBy(linkText = "Calculators")
    private WebElement calculatorsLink;

    public PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public PricingPage calculate() {
        calculatorsLink.click();
        return this;
    }
}
