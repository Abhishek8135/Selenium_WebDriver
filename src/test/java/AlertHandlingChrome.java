import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertHandlingChrome {

    // Method to handle alert
    public static void handleAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void main(String[] args) {
        WebDriver driver = null;
        ChromeOptions options = new ChromeOptions();
        options.setCapability("unhandledPromptBehavior", "accept");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        try {
            driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/javascriptAlerts.html");

            driver.findElement(By.id("alertBtn")).click();
            Thread.sleep(2000);
            handleAlert(driver);
            System.out.println("Alert handled successfully.");

            driver.findElement(By.id("confirmBtn")).click();
            Thread.sleep(2000);
            handleAlert(driver);
            System.out.println("Confirm alert handled successfully.");

            driver.findElement(By.id("promptBtn")).click();
            Thread.sleep(2000);
            handleAlert(driver);

            // Print page title after the alert is dismissed
            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Prompt alert handled successfully.");

            System.out.println("Alert accepted successfully.");
            System.out.println("Confirm accepted successfully.");
            System.out.println("Prompt accepted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}