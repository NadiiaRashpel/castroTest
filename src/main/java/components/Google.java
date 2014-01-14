package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google extends Component{

	public static final String LOGINLINK = "//div/a[contains(@href,'https://accounts.google.com/') and text() ='Войти']";
	public static final String MAILLINK = "//div/a[contains(@href,'https://mail.google.com/mail/') and text() ='Почта']";
	@FindBy(xpath = Google.LOGINLINK)
	private WebElement loginLink;	
	
	public static Google getGoogle(WebDriver driver) {
		Google loginLink = PageFactory.initElements(driver, Google.class);
		return loginLink;
	}
	@FindBy(xpath = Google.MAILLINK)
	private WebElement mailLink;
	
	public WebElement getLoginLink() {
		return loginLink;
	}
	public WebElement getMailLink() {		
		return mailLink;
	}
	
}
