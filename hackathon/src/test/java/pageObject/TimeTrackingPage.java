package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeTrackingPage {

    WebDriver driver;

    // WebElements
    @FindBy(xpath="//a[@href=\"/web/index.php/time/viewTimeModule\"]")
    WebElement TimeOption;

    @FindBy(xpath="//span[normalize-space()='Attendance']")
    WebElement Attendence;

    @FindBy(xpath="//a[normalize-space()='Punch In/Out']")
    WebElement PunchButton;

    @FindBy(xpath="//input[@placeholder='hh:mm']")
    WebElement PunchInTime;

    @FindBy(xpath="//button[normalize-space()='In']")
    WebElement PunchInButton;

    @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2']")
    WebElement VerifyPunchIn;

    @FindBy(xpath="//button[normalize-space()='Out']")
    WebElement PunchOutButton;

    public TimeTrackingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with the elements

    public void clickTimeOption() {
        TimeOption.click();
    }

    public void clickAttendance() {
        Attendence.click();
    }

    public void clickPunchButton() {
        PunchButton.click();
    }

    public void setPunchInTime(String time) {
        PunchInTime.clear(); // Clear any pre-existing time
        PunchInTime.sendKeys(time); // Send the desired time
    }

    public void clickPunchInButton() {
        PunchInButton.click();
    }

    public WebElement getVerifyPunchIn() {
        return VerifyPunchIn;
    }

    public void clickPunchOutButton() {
        PunchOutButton.click();
    }
}
