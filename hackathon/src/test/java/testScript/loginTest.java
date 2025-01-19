package testScript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.junit.Assert;

import pageObject.dashboardPage;
import pageObject.loginPage;

public class loginTest {

    public String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public WebDriver driver;

    @BeforeTest
    public void setup() {
        // Setup WebDriverManager and ChromeDriver
    	
    	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\tamta\\Downloads\\chromedriver-win64\\chromedriver.exe");

    	driver = new ChromeDriver();

        // Initialize ChromeDriver and maximize window
//        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Apply implicit wait for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the login URL
        driver.get(URL);
    }

    @Test(priority = 1, enabled = true)
    public void invalid_login() {
        loginPage page = new loginPage(driver);

        // Enter invalid username and password
        page.UserName("Admin");
        page.PassWord("invalid123");

        // Click Login Button
        page.ButtonLogin();

        // Verify the invalid credentials message
        String actualMsg = page.InvalidText();
        String expectedMsg = "Invalid credentials";
        Assert.assertEquals("Error message doesn't match", expectedMsg, actualMsg);
    }

    @Test(priority = 2, enabled = true)
    public void loginWithoutDetails() {
        loginPage page = new loginPage(driver);

        // Don't enter any credentials
        page.ButtonLogin();

        // Verify the invalid credentials message
        String actualMsg = page.InvalidText();
        String expectedMsg = "Invalid credentials";
        Assert.assertEquals("Error message doesn't match", expectedMsg, actualMsg);
    }

    @Test(priority = 3, enabled = true)
    public void loginAttemptsExceeds() {
        loginPage page = new loginPage(driver);

        // Try logging in with invalid credentials 5 times
        for (int i = 0; i < 5; i++) {
            page.UserName("Admin");
            page.PassWord("invalid123");
            page.ButtonLogin();
        }

        // Verify the message after exceeding login attempts
        String actualMsg = page.InvalidText();
        String expectedMsg = "Maximum number of login attempts failed";
        Assert.assertEquals("Error message doesn't match", expectedMsg, actualMsg);
    }

    @Test(priority = 4, enabled = true)
    public void valid_login() {
        loginPage page = new loginPage(driver);
        dashboardPage Dpage = new dashboardPage(driver);

        // Enter valid credentials
        page.UserName("Admin");
        page.PassWord("admin123");

        // Click Login Button
        page.ButtonLogin();

        // Verify the page title after successful login
        String expectedTitle = "OrangeHRM";
        String actualTitle = Dpage.GetTitle();
        Assert.assertEquals("Page title doesn't match", expectedTitle, actualTitle);
    }
}
