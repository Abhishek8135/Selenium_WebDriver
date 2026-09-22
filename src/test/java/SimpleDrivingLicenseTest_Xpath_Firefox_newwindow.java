import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SimpleDrivingLicenseTest_Xpath_Firefox_newwindow {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();


        try {
            driver.get("file:///c:/Users/CCST/Downloads/New%20folder%20%282%29/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");
            Thread.sleep(1000);

            String originalWindow = driver.getWindowHandle();

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
            java.util.Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }


            Thread.sleep(1000);
            driver.manage().window().maximize();


            String newWindowUrl = driver.getCurrentUrl();
            if (newWindowUrl.contains("welcome.html")) {
                System.out.println("New window URL is correct: " + newWindowUrl);
            } else {
                System.out.println("New window URL is incorrect: " + newWindowUrl);
            }

            System.out.println("Page title after submit: " + driver.getTitle());


            if (driver.getTitle().equals("Welcome")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }


            WebElement nameField = driver.findElement(By.id("nameField"));
            WebElement button = driver.findElement(By.id("enterNameBtn"));

            System.out.println("Button enabled before entering name: " + button.isEnabled());

            nameField.click();
            nameField.sendKeys("Deependra Singh");

            if (button.isEnabled()) {
                System.out.println("Button is enabled: Test Passed");
            } else {
                System.out.println("Button is disabled: Test Failed");
            }

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}