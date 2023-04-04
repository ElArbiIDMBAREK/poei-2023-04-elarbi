package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GamesAndConsolesPage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    WebDriver driver;
    By bestSellerLocator = By.cssSelector("[cel_widget_id='handsfree-browse_OctopusBestSellerAsin'] span.a-list-item");

    public GamesAndConsolesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void OpenBestSeller(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));

        WebElement bestSellerProduct = wait.until(ExpectedConditions.elementToBeClickable(bestSellerLocator));
        List<WebElement> bestSellerProducts = driver.findElements(bestSellerLocator);
        bestSellerProducts.get(index).click();
    }

}
