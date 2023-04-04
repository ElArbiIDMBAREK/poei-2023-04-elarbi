package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    By cookieLocator = By.id("sp-cc-accept");
    By allMenuLocator = By.id("nav-hamburger-menu");
    By gamesAndConsolesLocator = By.cssSelector("[data-menu-id='12']");
    By allGamesLocator = By.cssSelector("ul.hmenu-visible a[class='hmenu-item']"); //"ul.hmenu.hmenu-visible.hmenu-translateX a[class='hmenu-item']"
    By searchBarLocator = By.cssSelector("#twotabsearchtextbox");
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToGamesAndConsolesPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));

        WebElement allMenuButton = wait.until(ExpectedConditions.elementToBeClickable(allMenuLocator));
        allMenuButton.click();
        WebElement gamesAndConsolesButton = wait.until(ExpectedConditions.elementToBeClickable(gamesAndConsolesLocator));
        gamesAndConsolesButton.click();
        WebElement allGamesButton = wait.until(ExpectedConditions.elementToBeClickable(allGamesLocator));
        allGamesButton.click();
    }

    public void search(String keyword) {
        driver.findElement(searchBarLocator).sendKeys(keyword + Keys.ENTER);
    }

    public void closeCookiePopup() {
        driver.findElement(cookieLocator).click();
    }
}
