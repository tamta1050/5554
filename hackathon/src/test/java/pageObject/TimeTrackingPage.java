package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// Page Factory Approach //
public class TimeTrackingPage {
	
	WebDriver driver;
	
	
	// WebElmenents //
	
	
	// Time Option //
	@FindBy(xpath="//a[@class='oxd-main-menu-item active']")
	WebElement TimeOption;
	
	// Attendence //
	@FindBy(xpath="//span[normalize-space()='Attendance']")
	WebElement Attendence;
	
	// PunchIn / PunchOut //
	@FindBy(xpath="//a[normalize-space()='Punch In/Out']")
	WebElement PunchButton;
	
	// Timing of Punch In //
	@FindBy(xpath="//input[@placeholder='hh:mm']")
	WebElement PunchInTime;
	
	// PunchIn Button //
	@FindBy(xpath="//button[normalize-space()='In']")
	    WebElement PunchInButton;
	 
	// PunchIntime Verify //
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2']")
	    WebElement VerifyPunchIn;
	
	// PunchOut Button //
	
	@FindBy(xpath="//button[normalize-space()='Out']")
	WebElement PunchOutButton;
	
	
	
	public TimeTrackingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Methods //
	
	public void ClickTimeOption() {
		TimeOption.click();
	}
	
	public void ClickAttendance() {
		Attendence.click();
	}
	
	public void ClickPunchButton() {
		PunchButton.click();
	}
	
	public void ClickPunchInTime(String timing) {
		WebElement time = PunchInTime;
		time.click();
		time.clear();
		time.sendKeys(timing);
	}
	public void ClickPunchInButton() {
		PunchInButton.click();
	}
	
	public String VerifyPunchInTime() {
		return (VerifyPunchIn.getText());
	}
	
	public void ClickPunchOutButton() {
		PunchOutButton.click();
	}
	
	
	
}
	