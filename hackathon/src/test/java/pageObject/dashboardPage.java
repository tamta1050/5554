package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class dashboardPage {
	
	WebDriver driver;
	public dashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String GetTitle() {
		return (driver.getTitle());
	}

}
