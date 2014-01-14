package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleInbox extends Component{
	public static final String WELCOMELETTER = ".//tr[.//descendant::span[@email='info@castro.co.il'] and descendant::b[starts-with(.,'Welcome, ')]]";
	public static final String TEXTLETTER = ".//tbody/tr/td/p";
	public static final String REDIRECTLINK = ".//a[contains(@href,'https://www.castro.com/en/customer/account/') and text() ='Login']";
	@FindBy(xpath = GoogleInbox.WELCOMELETTER)
	private WebElement welcomeLetter;	
	
	public static GoogleInbox getWelcomeLetter(WebDriver driver) {
		GoogleInbox welcomeLetter = PageFactory.initElements(driver, GoogleInbox.class);
		return welcomeLetter;
	}
	@FindBy(xpath = GoogleInbox.TEXTLETTER)
	private WebElement textLetter;	
	@FindBy(xpath = GoogleInbox.REDIRECTLINK)
	private WebElement redirectLink;
	
	public WebElement getWelcomeLetter() {		
		return welcomeLetter;
	}
	public WebElement getTextLetter() {		
		return textLetter;
	}
	public WebElement getRedirectLink() {		
		return redirectLink;
	}

}
