package test;

import helpers.Reports.ScreenShotOnFailure;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;


import configuration.WebDriverFactory;



public class TestBase {
	protected WebDriver driver;
	protected String baseUrl = "http://www.castro.com/en/?___from_store=he";	
	protected String emailUrl = "http://www.google.com";
	
	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(System.getProperty("webdriver.browser", "firefox"));
		driver = WebDriverFactory.getDriver(cap);
		ScreenShotOnFailure.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void goToMainPage() {
		driver.get(baseUrl);
	}
	public void goToEmailPage() {
		driver.get(emailUrl);
	}
	
	@AfterSuite
	public void tearDown() throws Exception {		
		//driver.quit();
	}
}
