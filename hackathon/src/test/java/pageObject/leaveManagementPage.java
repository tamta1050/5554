package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class leaveManagementPage {
	
	 WebDriver driver;
	
	// ApplyLeave //
	
	@FindBy(xpath="//button[@title='Apply Leave']//*[name()='svg']")
	WebElement ApplyLeave;
	
	// Leave type box // 
	@FindBy(xpath="//div[@class='oxd-select-text-input']") // 
	WebElement LeaveOption;
	
	// No Leave Message //
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2']")
	WebElement NoLeaveMessage;
	
	

	
	
	
	public leaveManagementPage(WebDriver driver)
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Methods //
	
	public void ClickApplyLeave() {
		ApplyLeave.click();
	}
	
	public void ClickLeaveOption() {
		LeaveOption.click();
	}
	
	public String IsLeavetypesAvailable() {
		return (NoLeaveMessage.getText());
	}

}
