import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_MultipleWindows {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1, groups = "smoke")
    public void testNavigateAndGetTitles() throws InterruptedException {
        // First navigation
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);
        System.out.println("Page: https://www.saucedemo.com");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("------------------------------");
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "SauceDemo title mismatch!");

        // Second navigation
        driver.get("https://www.google.com");
        Thread.sleep(1000);
        System.out.println("Page: https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("------------------------------");
        Assert.assertEquals(driver.getTitle(), "Google", "Google title mismatch!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
