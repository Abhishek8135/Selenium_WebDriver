import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(10));

        driver.get("http://localhost/litecart/en/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("alertBtn")).click();

        Alert obj_simpleAlert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = obj_simpleAlert.getText();
        System.out.println("Alert text: " + alertText);

        obj_simpleAlert.accept();

        String alertResult = driver.findElement(By.id("alertResult")).getText();
        if (alertResult.equals("Alert was shown and accepted")) {
            System.out.println("Pass: Simple alert handled correctly.");
        } else {
            System.out.println("Fail: Alert result mismatch");
        }

    }
}
