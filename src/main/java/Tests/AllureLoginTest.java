package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BasePage.TestBase;
import PageObjects.MainScreen;
import io.qameta.allure.Step;

public class AllureLoginTest extends TestBase {
	WebDriver driver;
	MainScreen mainScreen;
	
	 @Test(description="Check the possibility to Login")
	 public void allureLoginTest() {
		 mainScreen.openPage();
		 openURLPage();
		 addEmailAndPassword();
	 }	 
		 @Step("Open URLPage")
		 public void openURLPage() {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn-flat")));
				String expectedText = "Forgot Password?";
				String actualText = driver.findElement(By.cssSelector(".btn-flat")).getText();
				Assert.assertEquals(actualText, expectedText);
		 }
		 
		 @Step("Add email and password")
		 private void addEmailAndPassword() {
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

