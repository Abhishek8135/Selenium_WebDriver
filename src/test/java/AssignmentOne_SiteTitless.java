import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AssignmentOne_SiteTitless {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        String[] urls = {"https://www.saucedemo.com", "https://www.google.com"};

        try {
            for (String url : urls) {
                driver.get(url);
                Thread.sleep(1000);

                System.out.println("Page: " + url);
                System.out.println("Title: " + driver.getTitle());
                System.out.println("------------------------------");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Sleep interrupted: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Automation error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static class SimpleDrivingLicenseTest {
        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            try {

                driver.get("file:///c:/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");


                WebElement nameBox = driver.findElement(By.id("fullname"));
                nameBox.clear();
                nameBox.sendKeys("John Doe");


                WebElement radioMale = driver.findElement(By.id("male"));
                radioMale.click();


                WebElement checkbox = driver.findElement(By.id("agree"));
                if (!checkbox.isSelected()) checkbox.click();


                WebElement submitBtn = driver.findElement(By.id("submit"));
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
}
