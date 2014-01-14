package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSingIn extends Component {

public static final String SINGINGFORM = "//div[@class = 'card signin-card clearfix']";
public static final String LOGINFIELD = ".//input[@id = 'Email']";
public static final String PASSWDFIELD = ".//input[@id = 'Passwd']";
public static final String SINGINBUTTON = ".//input[@id = 'signIn']";
	@FindBy(xpath = GoogleSingIn.SINGINGFORM)
	private WebElement singInForm;		
	public static GoogleSingIn getGoogle(WebDriver driver) {
		GoogleSingIn singInForm = PageFactory.initElements(driver, GoogleSingIn.class);
		return singInForm;
	}
	
	@FindBy(xpath = GoogleSingIn.LOGINFIELD)
	private WebElement loginField;
	@FindBy(xpath = GoogleSingIn.PASSWDFIELD)
	private WebElement passwdField;
	@FindBy(xpath = GoogleSingIn.SINGINBUTTON)
	private WebElement singInButton;
	
	public WebElement getSingInForm() {
		return singInForm;
	}
	public WebElement getLoginField() {
		return loginField;
	}
	public WebElement getPasswdField() {		
		return passwdField;
	}
	public WebElement getSingInButton() {		
		return singInButton;
	}
}
