import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataproviderLoginSauce {
    WebDriver driver;
    WebDriverWait wait;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.xpath("//h3[@data-test='error']");

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        // Updated to point directly to the CSV file
        String csvFilePath = "C:\\Users\\CCST\\Downloads\\loginData.csv";

        List<Object[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip header
                }
                if (line.trim().isEmpty()) {
                    continue; // Skip blank lines
                }

                String[] values = line.split(",");
                if (values.length >= 2) {
                    records.add(new Object[]{values[0].trim(), values[1].trim()});
                }
            }
        }
        return records.toArray(new Object[0][0]);
    }

    @Test(priority = 1, dataProvider = "loginData")
    public void testPositiveLoginSauceDemo(String username, String password) {
        driver.get("https://www.saucedemo.com/");

        WebElement obj_username = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        WebElement obj_password = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        WebElement obj_loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        obj_username.sendKeys(username);
        obj_password.sendKeys(password);
        obj_loginButton.click();

        boolean isLoginSuccess = wait.until(ExpectedConditions.urlContains("inventory.html"));
        WebElement productsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        String actualTitle = productsTitle.getText();

        Assert.assertTrue(isLoginSuccess, "URL does not contain 'inventory.html'");
        Assert.assertEquals(actualTitle, "Products", "Page title does not match!");
    }

    @Test(priority = 2)
    public void testNegativeLoginSauceDemo() {
        driver.get("https://www.saucedemo.com/");

        WebElement obj_username = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        WebElement obj_password = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        WebElement obj_loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        obj_username.sendKeys("locked_out_user");
        obj_password.sendKeys("wrong_password");
        obj_loginButton.click();

        WebElement obj_errorBox = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        String actualErrorText = obj_errorBox.getText();

        Assert.assertTrue(actualErrorText.contains("Epic sadface:"), "Error message text is unexpected!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}