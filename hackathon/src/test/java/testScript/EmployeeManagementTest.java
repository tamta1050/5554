package testScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObject.PIMPage;
import pageObject.loginPage;

import java.time.Duration;

public class EmployeeManagementTest {

    public String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public WebDriver driver;
    loginPage loginPage;
    PIMPage PIMPage;

    @BeforeTest
    public void setup() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize page objects
        loginPage = new loginPage(driver);
        PIMPage = new PIMPage(driver);

        // Log in as Admin before all tests (only once)
        loginPage.UserName("Admin");
        loginPage.PassWord("admin123");
        loginPage.ButtonLogin();
    }

    // Test Case 1: Add Employee Test
    @Test(priority = 1)
    public void addEmployeeTest() throws InterruptedException {

        Thread.sleep(2000); // It's better to use waits instead of Thread.sleep()

        // Add new employee
        PIMPage.ClickEmployeeMenu();
        PIMPage.clickAddEmployeeButton();
        PIMPage.enterEmployeeFirstName("James");
        PIMPage.enterEmployeeLastName("Bond");
        PIMPage.createLoginDetailsBox();
        PIMPage.enterEmployeeUsername("james28190");
        PIMPage.enterEmployeePassword("Password123");
        PIMPage.enterConfirmEmployeePassword("Password123");
        PIMPage.submitEmployeeForm();

        // Wait for employee creation to complete (use more reliable waits)
        Thread.sleep(2000);

        // Verify if employee was added successfully
        Assert.assertTrue(PIMPage.isEmployeeAdded("James Bond"), "Employee was not added successfully");

        // Wait to visually verify
        Thread.sleep(2000); // Preferably replace with a wait condition
    }

    // Test Case 2: Edit Employee Test
    @Test(priority = 2)
    public void editEmployeeTest() throws InterruptedException {
        // Wait for any previous action to complete
        Thread.sleep(2000);

        // Navigate to Employee Management
        PIMPage.ClickEmployeeMenu();
        
        // Locate employee (assuming there's a search method or employee ID)
        PIMPage.EnterEmployeeName("james28190");

        // Edit employee details
        PIMPage.ClickSearchButton();
        PIMPage.enterEmployeeFirstName("James");
        PIMPage.ClickeditButton();
        PIMPage.enterEmployeeLastName("Bond Jr."); // Updated last name
        PIMPage.submitEmployeeForm();
        
        driver.navigate().refresh();

        // Verify if the employee was updated successfully
        Assert.assertTrue(PIMPage.isEmployeeAdded("James Bond Jr."), "Employee was not updated successfully");

        Thread.sleep(2000); // Wait for visual verification
    }

    @AfterTest
    public void logout() {
        // Log out after tests
        loginPage.ClickprofileDropDown();
        loginPage.ClickLogoutButton();
        driver.quit();  // Properly close the browser
    }
}
