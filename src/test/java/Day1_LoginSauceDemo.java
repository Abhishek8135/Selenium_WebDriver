import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day1_LoginSauceDemo {
    public static void main(String[] args) {
        WebDriver obj_driver = new ChromeDriver();
        WebDriverWait obj_wait = new WebDriverWait(obj_driver, Duration.ofSeconds(10));

        try {
            obj_driver.get("https://www.saucedemo.com");

            WebElement obj_username = obj_wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))
            );
            WebElement obj_password = obj_driver.findElement(By.id("password"));
            WebElement obj_loginButton = obj_wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("login-button"))
            );

            obj_username.sendKeys("standard_user");
            obj_password.sendKeys("secret_sauce");
            obj_loginButton.click();

            boolean isLoginSuccess = obj_wait.until(
                    ExpectedConditions.urlContains("inventory.html")
            );

            WebElement productsTitle = obj_wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("title"))
            );

            if (isLoginSuccess && productsTitle.getText().equalsIgnoreCase("Products")) {
                System.out.println("LOGIN SUCCESSFUL!");
            } else {
                System.out.println("Login Failed");
            }

        } catch (Exception e) {
            System.err.println("Automation error: " + e.getMessage());
        } finally {
            obj_driver.quit();
        }
    }
}