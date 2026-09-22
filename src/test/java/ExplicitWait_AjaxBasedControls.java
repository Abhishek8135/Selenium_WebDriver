import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait_AjaxBasedControls {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/challenge_AjaxPage.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            boolean isSpinnerGone = wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(By.id("spinner"))
            );
            if (isSpinnerGone) {
                System.out.println("Pass: Spinner disappeared.");
            }

            boolean fetchingQuote = wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(By.id("quoteLoading"))
            );
            if (fetchingQuote) {
                System.out.println("Pass: Quote Fetching Completed ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}



