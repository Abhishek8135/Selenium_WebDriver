import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HiddenElementsJavaScript {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/hiddenElementJavascriptExecutor.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Assignment 1:
        String title = (String) js.executeScript("return document.title;");
        System.out.println("Page Title: " + title);

        String url = (String) js.executeScript("return document.URL;");
        System.out.println("Page URL: " + url);

        Thread.sleep(2000);

        // Assignment 2:
        WebElement scrollTargetBtn = driver.findElement(By.id("scrollTargetBtn"));
        js.executeScript("arguments[0].scrollIntoView(true);", scrollTargetBtn);
        Thread.sleep(2000);

        if (scrollTargetBtn.isDisplayed()) {
            System.out.println("Pass: scrollTargetBtn is visible after scroll.");
        } else {
            System.out.println("Fail: scrollTargetBtn is not visible.");
        }

        scrollTargetBtn.click();
        Thread.sleep(2000);

        String msgAfterScrollClick = driver.findElement(By.id("result")).getText();
        System.out.println("Extracted Message after Click: " + msgAfterScrollClick);

        Thread.sleep(2000);

        // Existing Hidden Button Logic
        WebElement hiddenBtn = driver.findElement(By.id("hiddenBtn"));
        Thread.sleep(2000);

        try {
            hiddenBtn.click();
            System.out.println("Click Succeeded");
        } catch (Exception e) {
            System.out.println("Click Failed" + e.getClass().getSimpleName());
            Thread.sleep(1000);
            js.executeScript("arguments[0].click();", hiddenBtn);
            String hiddenText = (String) js.executeScript("return arguments[0].textContent;", hiddenBtn);
            System.out.println("Hidden Button Text: " + hiddenText);
            Thread.sleep(2000);

            String result2 = driver.findElement(By.id("result")).getText();
            if (result2.equals(hiddenText)) {
                System.out.println("Pass: " + result2);
            } else {
                System.out.println("Fail: " + result2);
            }
            Thread.sleep(2000);
            driver.quit();
        }
    }
}