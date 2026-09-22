import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/welcome.html?");


            Wait<WebDriver> obj_fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);

            WebElement message = obj_fluentWait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("message"))
            );

            if (message.getText().contains("Welcome")) {
                System.out.println("Pass: " + message.getText());
            } else {
                System.out.println("Fail: " + message.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}