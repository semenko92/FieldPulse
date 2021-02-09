package BasePage;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase{
	protected static Logger log;
	public static WebDriver driver;
	public WebDriver createWebDriver(String browser) {
		switch (browser) {
		case "chrome":
			driver=this.chromeWebDriver();
			break;
		case "firefox":
			driver=this.firefoxWebDriver();
			break;
			default:
				driver=this.chromeWebDriver();
				break;
		}

		return driver;
			}
	public static WebDriver chromeWebDriver() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver2");
		
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	public static WebDriver firefoxWebDriver() {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver 2");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	

}
