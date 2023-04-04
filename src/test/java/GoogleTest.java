import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleTest {

    WebDriver driver;
    String urlPage = "https://www.google.com";

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlPage);
    }

    @Test
    public void googleTest() {
        List<WebElement> buttons = driver.findElements(By.cssSelector("button [role=none]"));
        buttons.get(3).click();
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("POEI Testeur" + Keys.ENTER);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
