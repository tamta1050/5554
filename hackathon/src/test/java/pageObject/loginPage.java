package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// Page Factory Approach //
public class loginPage {
	
	WebDriver driver;
	// WebElmenents //
	
	
	
	@FindBy(xpath="//input[@placeholder=\"Username\"]")
	WebElement username;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]")
	WebElement ErrorMessage;
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	    WebElement ProfileDropdown;
	 
	@FindBy(xpath="//a[normalize-space()='Logout']")
	    WebElement LogoutBotton;
	
	
	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	// Methods //
	
	public void UserName(String name) {
		username.sendKeys(name);
	}
	
	public void PassWord(String pass) {
		password.sendKeys(pass);
	}
	
	public void ButtonLogin() {
		loginButton.click();
	}
	
	public String InvalidText() {
		return (ErrorMessage.getText());
	}
	
	public void ClickprofileDropDown() {
		ProfileDropdown.click();
	}
	
	public void ClickLogoutButton() {
		LogoutBotton.click();
	}
	
	

}