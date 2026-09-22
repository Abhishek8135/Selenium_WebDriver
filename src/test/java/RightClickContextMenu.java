import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RightClickContextMenu {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/rightClickContextMenuInteraction.html");
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions action = new Actions(driver);

            WebElement targetBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("targetBox"))
            );

            action.contextClick(targetBox).perform();

            WebElement contextMenu = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("contextMenu"))
            );

            if (contextMenu.isDisplayed()) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }

            WebElement deleteOption = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("deleteOption"))
            );
            deleteOption.click();

            String result = driver.findElement(By.id("result")).getText();
            if (result.equals("You selected: Delete")) {
                System.out.println("Pass: " + result);
            } else {
                System.out.println("Fail: " + result);
            }

            driver.findElement(By.tagName("body")).click();

            boolean isCleared = wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(By.id("contextMenu"))
            );

            if (isCleared) {
                System.out.println("Pass: Menu cleared when clicked elsewhere");
            } else {
                System.out.println("Fail: Menu is still visible");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}