import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDrivingLicenseTest_CSS {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("file:///c:/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");
            Thread.sleep(1000);


            WebElement nameBox = driver.findElement(By.cssSelector("#fullname"));
            nameBox.sendKeys("Deependra Singh");


            WebElement addressBox = driver.findElement(By.cssSelector("#address"));
            addressBox.sendKeys("Bhopal, Madhya Pradesh");


            WebElement ageBox = driver.findElement(By.cssSelector("#age"));
            ageBox.sendKeys("30");


            WebElement pob = driver.findElement(By.cssSelector("#placeofbirth"));
            pob.sendKeys("Mumbai");


            WebElement radioMale = driver.findElement(By.cssSelector("#Male"));
            radioMale.click();


            WebElement colorNo = driver.findElement(By.cssSelector("[name='color_no']"));
            if (!colorNo.isSelected()) {
                colorNo.click();
            }


            WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
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
