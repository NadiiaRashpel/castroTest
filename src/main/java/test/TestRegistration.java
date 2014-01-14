package test;

import helpers.test.FirstPopUpHelper;
import helpers.test.HeaderHelper;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import components.FirstPopUp;
import components.Google;
import components.GoogleInbox;
import components.GoogleSingIn;
import components.Header;
import components.RegistrationForm;
import dataProvider.TestDataProvider;

public class TestRegistration extends TestBase {
	Header header;
	FirstPopUp popUp;
	RegistrationForm regForm;
	Google googleHeaderLinks;	
	GoogleSingIn singInForm;
	GoogleInbox inbox;
	@BeforeMethod
	public void setUpMethod() {
		header = PageFactory.initElements(driver, Header.class);
		popUp = PageFactory.initElements(driver, FirstPopUp.class);
		regForm = PageFactory.initElements(driver, RegistrationForm.class);
		googleHeaderLinks = PageFactory.initElements(driver, Google.class);
		singInForm=  PageFactory.initElements(driver, GoogleSingIn.class);
		inbox = PageFactory.initElements(driver, GoogleInbox.class);
	}

	@Test(dataProvider = "baseDataProvider", dataProviderClass = TestDataProvider.class)
	public void testCheckEmailAfterregistration(String login, String password,
			String firstname, String lastname) throws InterruptedException {
		goToMainPage();
		// click on Skip		
		Actions ac = new Actions(driver);
		WebElement form = popUp.getvalidatePopup();
		WebElement el = form;		
		el = popUp.getvalidatePopup();
		ac.moveToElement(el);

		el = popUp.getSkipButton();
		ac.moveToElement(el);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", el);
		
		//click on Sing in
		WebElement elem= header.getSingInLink();
		ac.moveToElement(elem);		
		executor.executeScript("arguments[0].click();", elem);
		
		
		//fill registration form
		//WebElement registrForm = regForm.getRegForm();
		WebElement firstName = regForm.getFirstNameField();
		firstName.clear();
		firstName.sendKeys(firstname);		
		
		WebElement lastName = regForm.getLastNameField();
		lastName.clear();
		lastName.sendKeys(lastname);
		
		WebElement email = regForm.getEmailField();
		email.clear();
		email.sendKeys(login);
		
		WebElement confirmEmail = regForm.getConfirmEmailField();
		confirmEmail.clear();
		confirmEmail.sendKeys(login);
	
	  WebElement confirmPassword = regForm.getPasswordField();
		confirmPassword.clear();
		confirmPassword.sendKeys(password);
		
		WebElement passWord = regForm.getConfirmPasswordField();
		passWord.clear();
		passWord.sendKeys(password);
		
		WebElement rForm = regForm.getRegForm();		
		WebElement buttonRegister = rForm.findElement(By.xpath(".//div/button"));
		
		
		ac.moveToElement(buttonRegister);		
		executor.executeScript("arguments[0].click();", buttonRegister);
		
	
		Thread.sleep(10000);
	
		goToEmailPage();
		WebElement goToLogin = googleHeaderLinks.getLoginLink();
		ac.moveToElement(goToLogin);	

		executor.executeScript("arguments[0].click();", goToLogin);		
		WebElement loginForm = singInForm.getSingInForm();
		singInForm.getLoginField().sendKeys(login);
		singInForm.getPasswdField().sendKeys(password);
		WebElement loginButton = singInForm.getSingInButton();
		executor.executeScript("arguments[0].click();", loginButton);
		
		WebElement goToMail =googleHeaderLinks.getMailLink();
		executor.executeScript("arguments[0].click();", goToMail);
		
//		WebElement welcomeLetter = inbox.getWelcomeLetter();
//		executor.executeScript("arguments[0].click();", welcomeLetter);  
		WebElement welcomeLetter = driver.findElement(By.xpath("//tr[.//descendant::span[@email='info@castro.co.il'] and descendant::b[starts-with(.,'Welcome, ')]]"));
		executor.executeScript("arguments[0].click();", welcomeLetter);  
		
		WebElement textLetter = inbox.getTextLetter();
//		//Assert.assertTrue(textLetter.getText().contains(login) & textLetter.getText().contains(password));
		WebElement redirectLink = inbox.getRedirectLink();
		executor.executeScript("arguments[0].click();", redirectLink);  
		
		WebElement welcomeMsg = driver.findElement(By.xpath("//p[@class='welcome-msg']"));
		Assert.assertTrue(firstname.equalsIgnoreCase(welcomeMsg.getText().substring(3).trim()));
		
		Thread.sleep(10000);
	}
}




