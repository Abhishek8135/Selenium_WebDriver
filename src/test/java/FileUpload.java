import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUpload {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/fileUpload.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement fileInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("fileInput"))
        );

        String filePath = "C:\\Users\\CCST\\Downloads\\New folder (2)\\SeleniumMaterial\\actionClass_Menu.html";
        fileInput.sendKeys(filePath);
        Thread.sleep(2000);
        System.out.println("File path sent to input field");

        WebElement fileNameLabel = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("fileName"))
        );
        if (fileNameLabel.getText().contains("actionClass_Menu.html")) {
            System.out.println("Pass: File Selected and Displayed correctly. Text: " + fileNameLabel.getText());

        } else {
            System.out.println("Fail: File name not Displayed" + fileNameLabel.getText());
        }

        WebElement uploadBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("uploadBtn"))
        );
        uploadBtn.click();
        Thread.sleep(2000);

        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("result"))
        );

        String expectedMessage = "File 'actionClass_Menu.html' uploaded successfully!";
        if (result.getText().contains(expectedMessage)) {
            System.out.println("Pass" + result.getText());
        } else {
            System.out.println("Fail: " + result.getText());
        }

        driver.quit();
    }
}
