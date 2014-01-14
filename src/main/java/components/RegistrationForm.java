package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegistrationForm extends Component{
	public static final String REGISTRATIONFORM = ".//div[@class = 'account-create']";
	public static final String FIRSTNAMEFIELD = ".//input[@id='firstname']";
	public static final String LASTNAMEFIELD = ".//input[@id='lastname']";
	public static final String EMAILFIELD = ".//input[@id='email_address']";
	public static final String CONFIRMEMAILFIELD = ".//input[@id='confirm_email_address']";
	public static final String PASSWORDFIELD = ".//input[@id='password']";
	public static final String CONFIRMPASSWORDFIELD = ".//input[@id='confirmation']";
	public static final String REGISTERBUTTON = ".//div/button";
	@FindBy(xpath = RegistrationForm.REGISTRATIONFORM)
	private WebElement regForm;	
	
	public static RegistrationForm getRegistrationForm(WebDriver driver) {
		RegistrationForm regForm = PageFactory.initElements(driver, RegistrationForm.class);
		return regForm;
	}
	
	@FindBy(xpath = RegistrationForm.FIRSTNAMEFIELD)
	private WebElement firstNameField;
	@FindBy(xpath = RegistrationForm.LASTNAMEFIELD)
	private WebElement lastNameField;
	@FindBy(xpath = RegistrationForm.EMAILFIELD)
	private WebElement emailField;
	@FindBy(xpath = RegistrationForm.CONFIRMEMAILFIELD)
	private WebElement confirmEmailField;
	@FindBy(xpath = RegistrationForm.PASSWORDFIELD)
	private WebElement passwordField;
	@FindBy(xpath = RegistrationForm.CONFIRMPASSWORDFIELD)
	private WebElement confirmPasswordField;
	@FindBy(xpath = RegistrationForm.REGISTERBUTTON)
	private WebElement registerButton;

	public WebElement getRegForm() {
		return regForm;
	}
	public WebElement getFirstNameField() {
		return firstNameField;
	}
	public WebElement getLastNameField() {
		return lastNameField;
	}
	public WebElement getEmailField() {		
		return emailField;
	}
	public WebElement getConfirmEmailField() {		
		return confirmEmailField;
	}
	public WebElement getPasswordField() {		
		return passwordField;
	}
	public WebElement getConfirmPasswordField() {		
		return confirmPasswordField;
	}
	public WebElement getRegisterButton() {		
		return registerButton;
	}
}
