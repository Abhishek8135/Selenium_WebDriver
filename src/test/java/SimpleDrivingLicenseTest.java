import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleDrivingLicenseTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("file:///c:/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");

            WebElement nameBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
            nameBox.sendKeys("Deependra Singh");

            WebElement addressBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address")));
            addressBox.sendKeys("Bhopal, Madhya Pradesh");

            WebElement ageBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age")));
            ageBox.sendKeys("30");

            WebElement pob = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("placeofbirth")));
            pob.sendKeys("Mumbai");


            WebElement radioMale = wait.until(ExpectedConditions.elementToBeClickable(By.id("Male")));
            radioMale.click();


            WebElement colorNo = wait.until(ExpectedConditions.elementToBeClickable(By.name("color_no")));
            if (!colorNo.isSelected()) {
                colorNo.click();
            }


            By submitLocator = By.xpath("//form[@id='myForm']//button[@type='submit']");
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitLocator));
            submitBtn.click();

            Thread.sleep(1000);
            System.out.println("Page title after submit: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
