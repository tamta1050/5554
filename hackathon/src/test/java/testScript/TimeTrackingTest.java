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
    	
    	 
    	 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        page = new loginPage(driver);
        page.UserName("Admin");
        page.PassWord("admin123");
        page.ButtonLogin();

        track = new TimeTrackingPage(driver);
    }

    @Test(priority = 1)
    public void PunchInTime() {    
        track.clickTimeOption();
        track.clickAttendance();
        track.clickPunchButton();
        
        
      
        track.clickPunchInButton();

        // Wait for the VerifyPunchIn WebElement to be visible
       

        // Get the text from the element and verify Punch In Time
        String actualPunchInTime = track.getVerifyPunchIn().getText();
        
        String desiredPunchInTime = track.getVerifyPunchIn().getText();
        
        // Assert that the Punch In time contains the desired time
        Assert.assertTrue(actualPunchInTime.contains(desiredPunchInTime), 
                          "Punch In time does not match the entered time!");
    }

    @Test(priority = 2)
    public void PunchOutTime() {
        

      
        track.clickPunchOutButton();
    

       
    }

    
    @AfterTest
    public void logout() {
        // Log out after tests
    	
        page.ClickprofileDropDown();
        
		page.ClickLogoutButton();
        driver.quit();  // Properly close the browser
    }
}
