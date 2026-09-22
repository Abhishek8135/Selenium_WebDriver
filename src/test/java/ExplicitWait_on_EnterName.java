import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait_on_EnterName {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/welcome.html?");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("message"))
            );
            if (message.getText().equals("Welcome!!")) {
                System.out.println("Pass: Message is displayed correctly");
            } else {
                System.out.println("Fail: Message is not displayed correctly. Got: " + message.getText());
            }

            WebElement enterNameBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("enterNameBtn"))
            );
            enterNameBtn.click();


            WebElement nameField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("nameField"))
            );
            nameField.sendKeys("Deependra Singh");

            System.out.println("Pass: Name entered successfully");

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}