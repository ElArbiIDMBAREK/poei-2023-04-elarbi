package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class HomePage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    WebDriver driver;

    @FindBy (css = "#sp-cc-accept")
    private WebElement cookieLocator;
    //By cookieLocator = By.cssSelector("#sp-cc-accept");
    By allMenuLocator = By.cssSelector("#nav-hamburger-menu");
    By gamesAndConsolesLocator = By.cssSelector("[data-menu-id='12']");
    By allGamesLocator = By.cssSelector("ul.hmenu-visible a[class='hmenu-item']"); //"ul.hmenu.hmenu-visible.hmenu-translateX a[class='hmenu-item']"
    By searchBarLocator = By.cssSelector("#twotabsearchtextbox");
    By listAndAccountButtonLocator = By.cssSelector("#nav-link-accountList");
    By creatNewAccountLocator = By.cssSelector(".nav-action-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GamesAndConsolesPage goToGamesAndConsolesPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));

        WebElement allMenuButton = wait.until(ExpectedConditions.elementToBeClickable(allMenuLocator));
        allMenuButton.click();
        WebElement gamesAndConsolesButton = wait.until(ExpectedConditions.elementToBeClickable(gamesAndConsolesLocator));
        gamesAndConsolesButton.click();
        setSleep(500);
        WebElement allGamesButton = wait.until(ExpectedConditions.elementToBeClickable(allGamesLocator));
        allGamesButton.click();

        return new GamesAndConsolesPage(driver);
    }

    public SearchResultPage search(String keyword) {
        driver.findElement(searchBarLocator).sendKeys(keyword + Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public HomePage closeCookiePopup() {
        //driver.findElement(cookieLocator).click();
        cookieLocator.click();
        return this;
    }

    public void createNewAccount() {
        Actions actions = new Actions(driver);

        WebElement buttonAccount = driver.findElement(listAndAccountButtonLocator);
        actions.moveToElement(buttonAccount);
        actions.perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.elementToBeClickable(creatNewAccountLocator)).click();
    }

    public void setSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
