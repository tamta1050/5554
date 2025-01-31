package testScript;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
    
    @Test (priority = 1)
    	public void ApplyLeave() {
    		
    	leavePage.ClickLeaveBtn();
    	leavePage.ClickApply();
    	
    	
    	if (leavePage.OptionButtonIsClickable()) {
            leavePage.ClickLeaveOption();
            leavePage.ChooseOption("CAN - Bereavement");
        } else {
            System.out.println("Apply button is not clickable, No Leave Balance Available.");
        }
    }
}

    
    	
    	
    

   
    
    

