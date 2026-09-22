import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeyBoardsShortcut {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/keyboardShortcuts.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions action = new Actions(driver);

            WebElement sourceText = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("sourceText"))
            );
            WebElement targetText = driver.findElement(By.id("targetText"));

            sourceText.click();
            System.out.println("Clicked source field to set focus");
            Thread.sleep(2000);

            action.keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .perform();
            System.out.println("Action: Selected all text (Ctrl + A)");
            Thread.sleep(2000);

            action.keyDown(Keys.CONTROL)
                    .sendKeys("c")
                    .keyUp(Keys.CONTROL)
                    .perform();
            System.out.println("Action: Copied text to clipboard (Ctrl + C)");
            Thread.sleep(2000);

            targetText.click();
            System.out.println("Clicked target field to set focus");
            Thread.sleep(2000);

            action.keyDown(Keys.CONTROL)
                    .sendKeys("v")
                    .keyUp(Keys.CONTROL)
                    .perform();
            System.out.println("Action: Pasted text into target (Ctrl + V)");
            Thread.sleep(2000);

            WebElement resultMsg = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("result"))
            );

            wait.until(ExpectedConditions.textToBePresentInElement(resultMsg, "Text copied successfully to Target !"));
            System.out.println("Result Message displayed: " + resultMsg.getText().trim());

            if (resultMsg.getText().trim().equals("Text copied successfully to Target !")) {
                System.out.println("Pass: Initial copy verified.");
            } else {
                System.out.println("Fail: Initial copy verification failed.");
            }
            Thread.sleep(2000);

            targetText.click();
            action.keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .sendKeys(Keys.BACK_SPACE)
                    .perform();
            System.out.println("Action: Selected all and cleared target box");
            Thread.sleep(2000);

            wait.until(ExpectedConditions.textToBePresentInElement(resultMsg, "Text in Target does not match Source yet."));

            String clearedActualMessage = resultMsg.getText().trim();
            String clearedExpectedMessage = "Text in Target does not match Source yet.";

            System.out.println("Result Message after clear: " + clearedActualMessage);

            if (clearedActualMessage.equals(clearedExpectedMessage)) {
                System.out.println("Pass: Clear validation successful.");
            } else {
                System.out.println("Fail: Expected '" + clearedExpectedMessage + "', but found '" + clearedActualMessage + "'");
            }
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}