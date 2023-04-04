import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class AmazonTest {

    WebDriver driver;
    String urlPage = "https://www.amazon.fr";
    String keyword = "iPhone 13";

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlPage);
    }

    @Test
    public void amazonTest() {

        HomePage homePage = new HomePage(driver);

        homePage.closeCookiePopup();
        homePage.search(keyword);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}