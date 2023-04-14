package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GamesAndConsolesPage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    WebDriver driver;

    //@FindBy (css = "[cel_widget_id='handsfree-browse_OctopusBestSellerAsin'] span.a-list-item")
    //private List<WebElement> bestSellerLocator;
    By bestSellerLocator = By.cssSelector("[cel_widget_id='handsfree-browse_OctopusBestSellerAsin'] span.a-list-item");

    public GamesAndConsolesPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage openBestSeller(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.elementToBeClickable(bestSellerLocator));
        List<WebElement> bestSellerProducts = driver.findElements(bestSellerLocator);
        //List<WebElement> bestSellerProducts = bestSellerLocator; // Récupérer une liste d'élément avec FindBy
        bestSellerProducts.get(index).click();
        return new ProductPage(driver);
    }

}
