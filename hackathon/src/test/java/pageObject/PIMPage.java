package pageObject;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {

    WebDriver driver;

    // Initialize Page Factory elements
    @FindBy(xpath= "//a[@href=\"/web/index.php/pim/viewPimModule\"]")
    WebElement employeeMenu;

    @FindBy(xpath = "//a[normalize-space()='Add Employee']")
    WebElement AddEmployeeButton;

    @FindBy(xpath = "//input[@name=\"firstName\"]")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameField;
    
    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
    WebElement createLoginDetail;

    @FindBy(xpath = "(//input[@autocomplete='off'])[1]")
    WebElement usernameField;

    // Password //
    @FindBy(xpath = "(//input[@autocomplete='off'])[2]")
    WebElement passwordField;
    
    // Confirm Password //
    @FindBy(xpath = "(//input[@autocomplete='off'])[3]")
    WebElement confirmpasswordField;

    // Save Button //
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    // Employee List //
    @FindBy(xpath = "//a[normalize-space()='Employee List']")
    WebElement EmployeeList;
    
    // Employee Name Search //
    @FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
    WebElement EmployeeName;
    
    // Employee Search Button //
    
    @FindBy(xpath="//button[normalize-space()='Search']") 
    WebElement SearchButton;
    
    // Employee Edit Button //
    
    @FindBy(xpath="//div[@class='orangehrm-container']//button[1]")
    WebElement editButton;
    
    
    
    // Profile Dropdown //
    
    @FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
    WebElement ProfileDropdown;
    

    @FindBy(xpath= "//a[@class='edit']")
    WebElement employeeProfileLink;

    @FindBy(xpath = "//input[@id='btnDelete']")
    WebElement deleteEmployeeButton;

    @FindBy(xpath = "//div[@class='message success']")
    WebElement successMessage;

    // Constructor to initialize the Page Factory elements
    public PIMPage(WebDriver drive) {
        driver = drive;
        PageFactory.initElements(drive, this);
    }

    // Check if the Employee menu is visible
    public void ClickEmployeeMenu() {
        employeeMenu.click();
    }

    // Click the "Add Employee" button
    public void clickAddEmployeeButton() {
        AddEmployeeButton.click();
    }

    // Fill employee details in the form
    public void enterEmployeeFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterEmployeeLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }
    
    public void createLoginDetailsBox() {
    	createLoginDetail.click();
    }

    public void enterEmployeeUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterEmployeePassword(String password) {
        passwordField.sendKeys(password);
    }
    public void enterConfirmEmployeePassword(String password) {
        confirmpasswordField.sendKeys(password);
    }

    // Submit the employee form
    public void submitEmployeeForm() {
        saveButton.click();
    }

    // Verify if employee was added successfully
    public boolean isEmployeeAdded(String employeeName) {
        try {
            // Try to find the employee in the employee list using XPath (or a different selector)
            WebElement employee = driver.findElement(By.xpath("//h6[normalize-space()='James Bond']"));
            return employee.isDisplayed(); // Check if the employee is visible
        } catch (NoSuchElementException e) {
            return false; // If the employee is not found, return false
        }
    }
    
   
    
    // Employee Search
    public void ClickEmployeeList() {
    	EmployeeList.click();
    }

    // Search for an employee by name
    public void EnterEmployeeName(String Name) {
    	EmployeeName.sendKeys(Name);
    }
    
    public void ClickSearchButton() {
    	SearchButton.click();
    }
    
    public void ClickeditButton() {
    	editButton.click();
    }

    // Click on the employee profile link
    public void clickEmployeeProfile() {
        employeeProfileLink.click();
    }

    // Update employee details (e.g., last name)
    public void updateEmployeeLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    // Delete employee
    public void clickDeleteEmployeeButton() {
        deleteEmployeeButton.click();
    }

    // Verify if the employee was deleted
    public boolean isEmployeeDeleted(String employeeName) {
        return !driver.getPageSource().contains(employeeName);
    }
}
