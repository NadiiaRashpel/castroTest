package helpers.Reports;

import helpers.Core.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;


import configuration.TestConfig;

public class ScreenShotOnFailure extends TestListenerAdapter {
	  private static final String NAME = "<a href=\"%s\"><img src=\"%<s\" width=200 height=150></a><br>";
	  private static WebDriver driver;

	   @Override
	   public void onTestFailure(ITestResult tr) {
	    File scrFile = ((TakesScreenshot) driver)
	      .getScreenshotAs(OutputType.FILE);
	    DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ssaa");
	    String destDir = "target/surefire-reports/html/screenshots/";
	    new File(destDir).mkdirs();
	    String destFile = dateFormat.format(new Date()) + ".png";
	    System.out.println(destFile);
	    System.setProperty("org.uncommons.reportng.escape-output", "false");
	    System.out.println(destDir);
	    try {
	     FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
	    } catch (IOException e) {
	     e.printStackTrace();
	    }
	    Reporter.log(String.format(NAME, "screenshots/" + destFile));

	   }
	   
	   public static void setDriver(WebDriver d){
	    driver = d;
	   }
	 }
	  
	
/*	private static final Logger LOG = Logger.getLogger(ScreenShotOnFailure.class);
	@Override
	public void onTestFailure(ITestResult tr) {
		WebDriver driver = WebDriverFactory.getDriver(TestConfig
				.getCapabilities());
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ssaa");
		String destDir = "target/surefire-reports/html/screenshots";
		new File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + ".png";

		try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			LOG.error("Creating file isn't possible",e);
			e.printStackTrace();
		}
		Reporter.setEscapeHtml(false);
		Reporter.log("Saved <a href=../screenshots/" + destFile
				+ ">Screenshot</a>");
	}*/

	/*@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailure(tr);
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		ITestContext context = tr.getTestContext();
		

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	    Date date = new Date();
		
		
		
		try {
			String outputDir = context.getOutputDirectory();
			Robot robot = new Robot();
			// Capture the screen shot of the area of the screen defined by the
			// rectangle
			BufferedImage bi = robot
					.createScreenCapture(new Rectangle(900, 900));
			File newFile = new File(outputDir, "ss_"
					+ tr.getMethod().getMethodName() +"_"+ dateFormat.format(date)+".png");
			ImageIO.write(bi, "jpg", newFile);
			tr.setAttribute("screenshot", newFile.getName());
			tr.setAttribute("screenshotURL", newFile.getAbsolutePath());
			String logString = String
					.format("<br /><a href='%s'><img src='%s' hight='100' width='100' /></a>",
							newFile.getAbsolutePath(),
							newFile.getAbsolutePath());

			Reporter.log(logString);

		} catch (Exception e) {
			System.out.println("error generating screenshot: " + e);
		}
	}*/


