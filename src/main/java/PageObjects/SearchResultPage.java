package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    WebDriver driver;
    By searchResultLocator = By.cssSelector("[data-component-type='s-search-result']:not(.AdHolder)");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage openSearchResult(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));

        WebElement searchResultProduct = wait.until(ExpectedConditions.elementToBeClickable(searchResultLocator));
        List<WebElement> searchResultProducts = driver.findElements(searchResultLocator);
        searchResultProducts.get(index).click();

        return new ProductPage(driver);
    }

}
