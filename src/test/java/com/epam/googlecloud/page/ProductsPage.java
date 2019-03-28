package com.epam.googlecloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends AbstractPage{

    private final String BASE_URL = "https://cloud.google.com/products/";

    @FindBy(linkText = "SEE PRICING")
    private WebElement seePricingLink;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public PricingPage seePricing() {
        seePricingLink.click();
        return PageFactory.initElements(driver, PricingPage.class);
    }

}
