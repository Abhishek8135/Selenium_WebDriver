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

public class TestNG_LoginSauceDemo {
    WebDriver driver;
    WebDriverWait wait;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.xpath("//h3[@data-test='error']");

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test(priority = 1, groups = "smoke")
    public void testPositiveLoginSauceDemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        WebElement obj_username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );
        WebElement obj_password = driver.findElement(passwordField);
        WebElement obj_loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        );

        obj_username.sendKeys("standard_user");
        obj_password.sendKeys("secret_sauce");
        obj_loginButton.click();

        boolean isLoginSuccess = wait.until(
                ExpectedConditions.urlContains("inventory.html")
        );
        WebElement productsTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("title"))
        );
        String actualTitle = productsTitle.getText();

        if (isLoginSuccess && actualTitle.equalsIgnoreCase("Products")) {
            System.out.println("LOGIN SUCCESSFUL!");
        } else {
            System.out.println("Login Failed");
        }

        Assert.assertTrue(isLoginSuccess, "URL does not contain 'inventory.html'");
        Assert.assertEquals(actualTitle, "Products", "Page title does not match!");
    }

    @Test(priority = 2)
    public void testNegativeLoginSauceDemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        WebElement obj_username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );
        WebElement obj_password = driver.findElement(passwordField);
        WebElement obj_loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        );

        obj_username.sendKeys("locked_out_user");
        obj_password.sendKeys("wrong_password");
        obj_loginButton.click();

        WebElement obj_errorBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        );
        String actualErrorText = obj_errorBox.getText();
        boolean isErrorDisplayed = obj_errorBox.isDisplayed();

        if (isErrorDisplayed && !actualErrorText.isEmpty()) {
            System.out.println("NEGATIVE TEST PASSED: Error message displayed correctly!");
            System.out.println("Error Text: " + actualErrorText);
        } else {
            System.out.println("Negative Test Failed");
        }

        Assert.assertTrue(isErrorDisplayed, "Error box is not displayed!");
        Assert.assertTrue(actualErrorText.contains("Epic sadface:"), "Error message text is unexpected!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
