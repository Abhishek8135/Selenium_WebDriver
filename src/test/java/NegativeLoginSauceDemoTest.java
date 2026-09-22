import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeLoginSauceDemoTest {
    public static void main(String[] args) {
        WebDriver obj_driver = new ChromeDriver();

        try {
            obj_driver.get("https://www.saucedemo.com");

            Thread.sleep(1000);

            WebElement obj_username = obj_driver.findElement(By.id("user-name"));
            WebElement obj_password = obj_driver.findElement(By.id("password"));
            WebElement obj_loginButton = obj_driver.findElement(By.id("login-button"));

            obj_username.sendKeys("hello");
            obj_password.sendKeys("deependra");
            obj_loginButton.click();

            Thread.sleep(2000);

            if (obj_driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println("LOGIN SUCCESSFUL!");
            } else {
                System.out.println("Login Failed");
                System.out.println("Test Case Passed: Negative Login Test");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Sleep interrupted: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Automation error: " + e.getMessage());
        } finally {
            obj_driver.quit();
        }
    }
}
