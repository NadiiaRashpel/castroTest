package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import test.TestRegistration;


public class Header extends Component {

	public static final String HEADERCONTAINER = ".//div[@class = 'header-container']";	
	public static final String SINGINLINK = ".//li[@id='top-login-link']/a";

	@FindBy(xpath = Header.HEADERCONTAINER)
	private WebElement headercontainer;	

	@FindBy(xpath = Header.SINGINLINK)
	private WebElement singinLink;

	public static Header getHeaderContainer(WebDriver driver) {
		Header headerContainer = PageFactory.initElements(driver, Header.class);
		return headerContainer;
	}

	public WebElement getHeaderContainer() {
		return headercontainer;
	}
	
	public WebElement getSingInLink(){
		return singinLink;
	}

	public static void clickOnSingInLink(Header headerContainer){
		Reporter.log("Sing in");
		headerContainer.getSingInLink().click();		
	}

}
