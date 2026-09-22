import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightHeading {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");

            String title = (String) js.executeScript("return document.title;");
            System.out.println("Page Title: " + title);


            String url = (String) js.executeScript("return document.URL;");
            System.out.println("Page URL: " + url);


            WebElement obj_heading = driver.findElement(By.xpath("//div[@class='form-container']/h2"));

            js.executeScript("arguments[0].style.border='3px solid red';", obj_heading);

            Thread.sleep(2000);

        } finally {
            driver.quit();
        }
    }
}