package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainScreen {
	private String baseUrl="https://webapp.fieldpulse.com/auth/login";
	WebDriver driver;
	public MainScreen(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(css="#icon_email")
	public WebElement EmailField;
	
	@FindBy(css="#password")
	public WebElement PasswordField;
	
	@FindBy(css=".btn")
	public WebElement LoginButton;
	
	public void openPage() {
		driver.get(baseUrl);
	}
	
}
