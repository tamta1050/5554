package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class leaveManagementPage {
    
    WebDriver driver;
    
    // ApplyLeave Button
    @FindBy(xpath="//button[@title='Apply Leave']//*[name()='svg']")
    WebElement ApplyLeave;
    
    // Leave Type Dropdown
    @FindBy(xpath="//div[@class='oxd-select-text-input']")
    WebElement LeaveOption;
    
    // Choose option
    
    @FindBy(xpath = "//div[@role=\"listbox\"]")
    List<WebElement> Options;
    
    // Apply Button
    @FindBy(xpath = "(//a[@class='oxd-topbar-body-nav-tab-item'])[1]")
    WebElement ApplyButton;
    
    // No Leave Message
    @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2']")
    WebElement NoLeaveMessage;

	 
    
    public leaveManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void ClickLeaveBtn() {
        ApplyLeave.click();
    }
    
    public void ClickApply() {
    	ApplyButton.click();
    }
    
    public void ClickLeaveOption() {
    	LeaveOption.click();
    }
    
    public void ChooseOption(String optionText) {
        for (WebElement option : Options) {
            if (option.getText().trim().equalsIgnoreCase(optionText)) {
                option.click();
                break;
            }
        }   	
    }
    public boolean OptionButtonIsClickable() {
        try {
            return LeaveOption.isDisplayed() && LeaveOption.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
    
   