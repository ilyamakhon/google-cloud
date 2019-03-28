package com.epam.googlecloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends AbstractPage{

    private final String BASE_URL = "https://cloud.google.com/";

    @FindBy(linkText = "EXPLORE ALL PRODUCTS")
    private WebElement exploreProductsLink;

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public ProductsPage exploreProducts() {
        exploreProductsLink.click();
        return PageFactory.initElements(driver, ProductsPage.class);
    }
}
