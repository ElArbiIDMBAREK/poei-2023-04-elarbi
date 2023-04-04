package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class ProductPage {

    static final int TIMEOUT_SIDE_PANEL = 10;

    WebDriver driver;
    By priceLocator = By.cssSelector(".priceToPay");
    By integerPriceLocator = By.cssSelector("span.a-price.aok-align-center span span.a-price-whole");
    By decimalPriceLocator = By.cssSelector("span.a-price.aok-align-center span span.a-price-fraction");
    By availableDateLocator = By.cssSelector("#availabilityInsideBuyBox_feature_div span");
    By addToCartLocator = By.cssSelector("input#add-to-cart-button");
    By noThanksLocator = By.cssSelector("#attachSiNoCoverage");
    By cartLocator = By.cssSelector("#attach-sidesheet-view-cart-button");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPrice() {
        //return driver.findElement(priceLocator).getText();
        return driver.findElement(integerPriceLocator).getText() + "," + driver.findElement(decimalPriceLocator).getText() + "€";
    }

    public String getAvailableDate() {
        return driver.findElement(availableDateLocator).getText();
    }

    public ProductPage addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
        addToCartButton.click();
        return this;
    }

    public ProductPage refuseInsurance() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        WebElement noThanksButton = wait.until(ExpectedConditions.elementToBeClickable(noThanksLocator));
        noThanksButton.click();
        return this;
    }

    public CartPage openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(cartLocator));
        cartButton.click();
        return new CartPage(driver);
    }
}
