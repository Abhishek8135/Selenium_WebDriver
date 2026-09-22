import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrameDemo {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/iFrameDemo.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.switchTo().frame(0);

            WebElement frame1Btn = wait.until(ExpectedConditions.elementToBeClickable(By.id("frame1Btn")));
            frame1Btn.click();
            Thread.sleep(1000);

            String frame1Result = driver.findElement(By.id("frame1Result")).getText();
            if (frame1Result.trim().equalsIgnoreCase("Frame 1 button clicked!")) {
                System.out.println("Pass: Frame 1 button click successful");
            } else {
                System.out.println("Frame 1 button click failed (got: '" + frame1Result + "')");
            }

            driver.switchTo().defaultContent();

            driver.switchTo().frame("frameByName");

            WebElement frame2input = wait.until(ExpectedConditions.elementToBeClickable(By.id("frame2Input")));
            frame2input.sendKeys("Selenium Student");

            String enteredValue = frame2input.getAttribute("value");
            if ("Selenium Student".equals(enteredValue)) {
                System.out.println("Pass: Frame 2 input successful");
            } else {
                System.out.println("Fail: Frame 2 input failed");
            }

            driver.switchTo().defaultContent();

            WebElement frame3Element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("frame3")));
            driver.switchTo().frame(frame3Element);

            WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("frame3Dropdown")));

            Select select = new Select(dropdownElement);
            select.selectByVisibleText("Two");

            String selectedValue = select.getFirstSelectedOption().getText();
            if ("Two".equals(selectedValue)) {
                System.out.println("Pass: Frame 3 selection successful");
            } else {
                System.out.println("Fail: Frame 3 selection failed");
            }

            driver.switchTo().defaultContent();

            // FRAME WITHIN FRAME ( FRAME 4 )
            WebElement outerFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("outerFrame")));
            driver.switchTo().frame(outerFrame);

            WebElement innerFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("innerFrame")));
            driver.switchTo().frame(innerFrame);

            WebElement innerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("innerFrameBtn")));
            innerBtn.click();

            String result = driver.findElement(By.id("innerFrameResult")).getText();

            if (result.contains("clicked")) {
                System.out.println("Pass: Inner frame button clicked");
            } else {
                System.out.println("Fail: Button not clicked");
            }
            Thread.sleep(2000);
            driver.switchTo().defaultContent();

            WebElement mainBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainBtn")));
            if (mainBtn.isDisplayed()) {
                System.out.println("Pass: Main button is displayed");
            }

        } finally {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}