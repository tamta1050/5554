package testScript;

import java.time.Duration;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.TimeTrackingPage;
import pageObject.loginPage;

public class TimeTrackingTest {

    public String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public WebDriver driver;
    public loginPage page;
    public TimeTrackingPage track;

    @BeforeTest
    public void setup() {
        // Initialize ChromeDriver
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Apply implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the login URL
        driver.get(URL);

        // Initialize page objects
        page = new loginPage(driver);

        // Perform login
        page.UserName("Admin");
        page.PassWord("admin123");
        page.ButtonLogin();

        // Initialize TimeTrackingPage object
        track = new TimeTrackingPage(driver);
    }

    @Test
    public void PunchInTime() {
        // Navigate to Time Tracking
        track.ClickTimeOption();
        track.ClickAttendance();
        track.ClickPunchButton();

        // Enter Punch In Time
        track.ClickPunchInTime("10:15 AM");
        track.ClickPunchInButton();

        // Verify Punch In Time
        String expectedPunchTime = "2025-01-19 - 10:15 AM"; // Corrected date format
        String actual = track.VerifyPunchInTime();

        Assert.assertEquals(actual, expectedPunchTime, "Punch In time does not match!");
    }

    @Test
    public void PunchOutTime() {
        // Perform Punch Out
        track.ClickPunchOutButton();
       // String punchOutTime = track.VerifyPunchOutTime();

        // Add appropriate assertions if needed
        // Assert.assertNotNull(punchOutTime, "Punch Out time is not recorded!");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
