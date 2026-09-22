import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_AssertSoft {
    WebDriver driver;
    WebDriverWait wait;

    By messageHeader = By.id("message");
    By enterNameBtn = By.id("enterNameBtn");
    By nameField = By.id("nameField");

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void testWelcomePageBehavior() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/welcome.html");
        Thread.sleep(2000);

        WebElement obj_messageHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(messageHeader)
        );
        WebElement obj_enterNameBtn = driver.findElement(enterNameBtn);
        WebElement obj_nameField = driver.findElement(nameField);

        String actualMessage = obj_messageHeader.getText();
        System.out.println("Actual Message: " + actualMessage);
        softAssert.assertEquals(actualMessage, "Welcome!!", "Message header does not match!");

        boolean isFieldEnabledInitially = obj_nameField.isEnabled();
        System.out.println("Is field enabled initially? " + isFieldEnabledInitially);
        softAssert.assertFalse(isFieldEnabledInitially, "Text field was expected to be disabled initially!");

        obj_enterNameBtn.click();

        boolean isFieldEnabledAfterClick = obj_nameField.isEnabled();
        System.out.println("Is field enabled after button click? " + isFieldEnabledAfterClick);
        softAssert.assertTrue(isFieldEnabledAfterClick, "Text field was expected to be enabled after clicking the button!");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
