import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class AmazonTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAmazon() {
        driver.get("https://www.amazon.fr");
    }

    @Test
    public void testGoogle() {
        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}