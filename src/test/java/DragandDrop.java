import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragandDrop {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/dragDrop.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action = new Actions(driver);

        WebElement item1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("item1"))
        );
        WebElement targetContainer = driver.findElement(By.id("targetContainer"));

        action.dragAndDrop(item1, targetContainer).perform();

        String result1 = driver.findElement(By.id("result")).getText();
        System.out.println("After Drag" + result1);

        if (result1.contains("Write Manual Testcases and moved to Done")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        Thread.sleep(2000);

        WebElement item2 = driver.findElement(By.id("item2"));

        action.clickAndHold(item2)
                .moveToElement(targetContainer)
                .pause(Duration.ofMillis(300))
                .release()
                .perform();

        String result2 = driver.findElement(By.id("result")).getText();
        System.out.println("After Manual Click" + result2);

        if (result2.contains("Define Entry and Exit Criteria moved to Done")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        Thread.sleep(2000);
        driver.quit();

    }
}