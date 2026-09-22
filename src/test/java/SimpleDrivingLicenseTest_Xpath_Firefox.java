import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SimpleDrivingLicenseTest_Xpath_Firefox {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("file:///c:/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");
            Thread.sleep(1000);



            WebElement nameBox = driver.findElement(By.xpath("//input[@id='fullname']"));
            nameBox.sendKeys("Deependra Singh");


            WebElement addressBox = driver.findElement(By.xpath("//input[@id='address']"));
            addressBox.sendKeys("Bhopal, Madhya Pradesh");


            WebElement ageBox = driver.findElement(By.xpath("//input[@id='age']"));
            ageBox.sendKeys("30");


            WebElement pob = driver.findElement(By.xpath("//input[@id='placeofbirth']"));
            pob.sendKeys("Mumbai");


            WebElement radioMale = driver.findElement(By.xpath("//input[@id='Male']"));
            radioMale.click();


            WebElement colorNo = driver.findElement(By.xpath("//input[@name='color_no']"));
            if (!colorNo.isSelected()) {
                colorNo.click();
            }


            WebElement licenseType = driver.findElement(By.id("licenseType"));
            Select licenseTypeDropdown = new Select(licenseType);
            licenseTypeDropdown.selectByVisibleText("Permanent");


            WebElement languageSelect = driver.findElement(By.id("languages"));
            Select languageDropdown = new Select(languageSelect);
            languageDropdown.selectByVisibleText("English");
            languageDropdown.selectByVisibleText("Hindi");


            WebElement submitBtn = driver.findElement(By.xpath("//form[@id='myForm']//button[@type='submit']"));
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