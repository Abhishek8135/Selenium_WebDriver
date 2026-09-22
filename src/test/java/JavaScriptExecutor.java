import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptExecutor {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            double zoomLevelBefore = (double) js.executeScript("return window.devicePixelRatio * 1.0;");
            System.out.println("Current Zoom ratio: " + zoomLevelBefore);

            Actions action = new Actions(driver);
            action.keyDown(Keys.CONTROL).sendKeys(Keys.ADD).keyUp(Keys.CONTROL).perform();

            Thread.sleep(1000);

            double zoomLevelAfter = (double) js.executeScript("return window.devicePixelRatio * 1.0;");
            System.out.println("Current zoom ratio: " + zoomLevelAfter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}