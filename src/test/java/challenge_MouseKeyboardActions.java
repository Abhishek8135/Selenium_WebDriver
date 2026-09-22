import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class challenge_MouseKeyboardActions {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("file:///C:/Users/CCST/Downloads/challenge_MouseKeyboardActions.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions action = new Actions(driver);

            WebElement documentsMenu = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("documentsMenu"))
            );
            action.moveToElement(documentsMenu).perform();
            Thread.sleep(2000);

            WebElement uploadDocLink = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("uploadDocLink"))
            );
            uploadDocLink.click();
            Thread.sleep(2000);

            WebElement uploadSection = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("uploadSection"))
            );

            if (uploadSection.isDisplayed()) {
                System.out.println("Pass: Upload section is displayed and scrolled into view.");
            } else {
                System.out.println("Fail: Upload section is not displayed.");
            }
            Thread.sleep(2000);

            WebElement fileInput = driver.findElement(By.id("fileInput"));
            fileInput.sendKeys("C:\\Users\\CCST\\Downloads\\New folder (2)\\SeleniumMaterial\\actionClass_Menu.html");
            Thread.sleep(2000);

            WebElement fileName = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("fileName"))
            );
            String selectedFileNameText = fileName.getText().trim();
            System.out.println("File Name Displayed Text: " + selectedFileNameText);

            if (selectedFileNameText.contains("Selected file:")) {
                System.out.println("Pass: File upload text verified successfully.");
            } else {
                System.out.println("Fail: File upload text mismatch.");
            }
            Thread.sleep(2000);

            WebElement uploadBtn = driver.findElement(By.id("uploadBtn"));
            uploadBtn.click();
            Thread.sleep(2000);

            WebElement result = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("result"))
            );
            String resultText = result.getText().trim();
            System.out.println("Result Message Displayed: " + resultText);

            if (resultText.equals("You greedy fellow !!")) {
                System.out.println("Pass: Upload confirmation message verified.");
            } else {
                System.out.println("Fail: Expected confirmation message not found.");
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