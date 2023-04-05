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

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlPage);
    }

    //@Test
    public void firstAmazonTest() {
        String keyword = "Apple iPhone 13 (128 Go) - Vert";

        HomePage homePage = new HomePage(driver);

        String actualProductTitle = homePage.closeCookiePopup()
                .search(keyword)
                .openSearchResult(0)
                .addToCart()
                .refuseInsurance()
                .openCart()
                .getProductTitle(0);
        Assert.assertEquals(actualProductTitle, keyword, "The title is not '" + keyword + "'");
    }

    @Test
    public void secondAmazonTest() {
        String expectedPrice = "54,99€";
        String expectedAvailableDate = "Cet article paraîtra le 12 mai 2023.";

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.closeCookiePopup()
                .goToGamesAndConsolesPage()
                .openBestSeller(0);
        Assert.assertEquals(productPage.getPrice(),expectedPrice, "The price is not " + expectedPrice);
        Assert.assertEquals(productPage.getAvailableDate(), expectedAvailableDate, "The dates are not the same : '" + expectedAvailableDate + "'");
    }

    @Test
    public void thirdAmazonTest() {
        HomePage homePage = new HomePage(driver);

        homePage.closeCookiePopup()
                .createNewAccount();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}