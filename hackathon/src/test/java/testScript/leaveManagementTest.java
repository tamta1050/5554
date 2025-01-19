package testScript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.leaveManagementPage;
import pageObject.loginPage;

public class leaveManagementTest {

    public String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public WebDriver driver;
    public loginPage loginPage;
    public leaveManagementPage leavePage;

    @BeforeTest
    public void setup() {
        // Initialize WebDriver
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Apply implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the login URL
        driver.get(URL);

        // Initialize Page Objects
        loginPage = new loginPage(driver);
        leavePage = new leaveManagementPage(driver);

        // Perform Login
        loginPage.UserName("Admin");
        loginPage.PassWord("admin123");
        loginPage.ButtonLogin();
    }

    @Test
    public void ApplyingLeave() {
        // Navigate to Apply Leave Section
        leavePage.ClickApplyLeave();
        leavePage.ClickLeaveOption();

        // Verify if Leave Types are available
        String actualMessage = leavePage.IsLeavetypesAvailable();
        String expectedMessage = "No Leave Types with Leave Balance";

        Assert.assertEquals(actualMessage, expectedMessage, "Leave types availability message does not match!");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
