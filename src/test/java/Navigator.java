import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigator {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            Thread.sleep(1000);
            driver.manage().window().maximize();

            driver.get("https://www.google.com");
            System.out.println("Step 1 - Loaded Google: " + driver.getTitle());
            System.out.println("Handle: " + driver.getWindowHandle());
            Thread.sleep(1000);

            //navigate to another site
            driver.navigate().to("https://www.selenium.dev");
            System.out.println("Step 2 - Loaded Selenium: " + driver.getTitle());
            System.out.println("Handle: " + driver.getWindowHandle());
            Thread.sleep(1000);

            //navigate to 3rd site
            driver.navigate().to("https://www.wikipedia.org");
            System.out.println("Step 3 - Loaded Wikipedia: " + driver.getTitle());
            System.out.println("Handle: " + driver.getWindowHandle());
            Thread.sleep(1000);

            //navigate back to selenium
            driver.navigate().back();
            System.out.println("Step 4 - Back to Selenium: " + driver.getTitle());
            System.out.println("Handle: " + driver.getWindowHandle());
            Thread.sleep(1000);

            //navigate back to google
            driver.navigate().back();
            System.out.println("Step 5 - Back to Google: " + driver.getTitle());
            System.out.println("Handle: " + driver.getWindowHandle());
            Thread.sleep(1000);

            //navigate forward to selenium
            driver.navigate().forward();
            System.out.println("Step 6 - Forward to Selenium: " + driver.getTitle());
            System.out.println("Handle: " + driver.getWindowHandle());
            Thread.sleep(1000);

            /// navigate to refresh selenium
            driver.navigate().refresh();
            System.out.println("Step 7 - Refreshed Selenium: " + driver.getTitle());
            System.out.println("Handle: " + driver.getWindowHandle());
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
