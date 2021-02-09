package Tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BasePage.TestBase;
import PageObjects.MainScreen;


public class LoginTest extends TestBase {
	
	WebDriver driver;
	MainScreen mainScreen;
	
	@Test
	public void loginTest() {
		mainScreen=new MainScreen(driver);
		
	mainScreen.openPage();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn-flat")));
	String expectedText = "Forgot Password?";
	String actualText = driver.findElement(By.cssSelector(".btn-flat")).getText();
	Assert.assertEquals(actualText, expectedText);
	mainScreen.EmailField.sendKeys("romantest@fieldpulse.com");
	mainScreen.PasswordField.sendKeys("qwerty");
	mainScreen.LoginButton.click();
	}

	@BeforeTest
	@Parameters({"testName","browser"})
	public void beforeTest(String testName, String browser) {

		driver=createWebDriver(browser);
		mainScreen=new MainScreen(driver);
		
}
}
