package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    WebDriver driver;
    By productTitleLocator = By.cssSelector("span.a-truncate-cut");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));

        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(productTitleLocator));
        List<WebElement> Products = driver.findElements(productTitleLocator);
        return Products.get(index).getText();
    }

}
