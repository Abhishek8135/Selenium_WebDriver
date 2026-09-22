import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentOne_SiteTitles {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        String[] urls = {
            "https://www.saucedemo.com",
            "https://www.google.com"
        };

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
}
