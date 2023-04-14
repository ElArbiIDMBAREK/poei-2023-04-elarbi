import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void iFrameTest() {

        By textSelector = By.cssSelector("[rel-title=iFrame] strong");
        String expectedText = "Below is an iFrame. If you want to perform any operation in this window, you will need to enter in this iframe.";

        Assert.assertEquals(driver.findElement(textSelector).getText(), expectedText, "The text is not similar");

        WebElement iFrame = driver.findElement(By.cssSelector("[name=globalSqa]"));

        // solution 1
        driver.switchTo().frame(iFrame);

        // solution 2
        // driver.switchTo().frame("globalSqa");

        // solution 3
        // driver.switchTo().frame(1);

        driver.findElement(By.cssSelector("#portfolio_items > div")).click();

        // This assert doesn't work because selenium it's inside the frame and the selector is outside the frame
        //Assert.assertEquals(driver.findElement(textSelector).getText(), expectedText, "The text is not similar");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // get out of the iFrame
        driver.switchTo().defaultContent();

        // the assertion works because selenium is outside of the iFrame again
        Assert.assertEquals(driver.findElement(textSelector).getText(), expectedText, "The text is not similar");

    }




}
