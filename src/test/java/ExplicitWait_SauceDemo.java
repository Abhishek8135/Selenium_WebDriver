import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait_SauceDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.saucedemo.com");

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            WebDriverWait obj_wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement message = obj_wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("title"))
            );

            if (message.getText().equals("Products")) {
                System.out.println("Pass: Message is displayed correctly");
            } else {
                System.out.println("Fail: Message is not displayed correctly. Got: " + message.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}