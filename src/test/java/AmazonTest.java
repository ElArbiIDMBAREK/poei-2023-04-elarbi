import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class AmazonTest {

    WebDriver driver;
    String urlPage = "https://www.amazon.fr";
    String keyword = "Apple iPhone 13 (128 Go) - Vert";
    String expectedPrice = "54,99€";
    String expectedAvailableDate = "Cet article paraîtra le 12 mai 2023.";

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlPage);
    }

    @Test
    public void firstAmazonTest() {
        HomePage homePage = new HomePage(driver);
        GamesAndConsolesPage gamesAndConsolesPage = new GamesAndConsolesPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        homePage.closeCookiePopup();
        homePage.search(keyword);
        searchResultPage.openSearchResult(0);
        productPage.addToCart();
        productPage.refuseInsurance();
        productPage.openCart();
        Assert.assertEquals(cartPage.getProductTitle(0), keyword, "The title doesn't contain " + keyword);
    }

    @Test
    public void secondAmazonTest() {
        HomePage homePage = new HomePage(driver);
        GamesAndConsolesPage gamesAndConsolesPage = new GamesAndConsolesPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        homePage.closeCookiePopup();
        homePage.goToGamesAndConsolesPage();
        gamesAndConsolesPage.OpenBestSeller(0);
        Assert.assertEquals(productPage.getPrice(),expectedPrice, "The price is not " + expectedPrice);
        Assert.assertEquals(productPage.getAvailableDate(), expectedAvailableDate, "The dates are not the same " + "(" + expectedAvailableDate + ")");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}