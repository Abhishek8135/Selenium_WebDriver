import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;


import java.io.File;

public class CaptureScreenshot {

    static WebDriver driver;
    static String screenshotDir;

    public static void main(String[] args) {

        screenshotDir = "screenshots/";
        new File(screenshotDir).mkdir();

        try {

            driver = new ChromeDriver();

            driver.get("file:///c%3A/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");
            Thread.sleep(1000);

            String actualTitle = driver.getTitle();
            String expectedTitle = "Driving License Application....";

            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Pass: Title verifired. Actual Title: " + actualTitle);
            } else {

                System.out.println("Fail: Title not verifired. Actual Title: " + expectedTitle + ",Actual Title: " + actualTitle);
                captureScreenshot("TitleVerificationFailed");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }

    public static void captureScreenshot(String title) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(screenshotFile, new File(screenshotDir + title + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot captured: ");
    }

    // create a method to capture screenshot
}
