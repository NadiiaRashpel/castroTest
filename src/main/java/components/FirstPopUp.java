package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.TestRegistration;


public class FirstPopUp extends Component{

	public static final String WELCOMEPOPUP= ".//div[@id='fancybox-wrap']";
	public static final String SKIPBUTTON= "//*[@id='newsletter-validate-popup']/a";
	public static final String VALIDATEPOPUP = ".//form[@id='newsletter-validate-popup']";
	
	@FindBy(xpath = FirstPopUp.WELCOMEPOPUP)
	private WebElement welcomePopup;
	
	@FindBy(xpath = FirstPopUp.SKIPBUTTON)
	private WebElement skipButton;
	
	@FindBy(xpath = FirstPopUp.VALIDATEPOPUP)
	private WebElement validatePopup;
	
	public static FirstPopUp getWelcomePopup(WebDriver driver) {
		FirstPopUp welcomePopup = PageFactory.initElements(driver, FirstPopUp.class);
		return welcomePopup;
	}
	public WebElement getWelcomePopup() {
		return welcomePopup;
	} 
	public WebElement getvalidatePopup(){
				return validatePopup;
			}
	
	public WebElement getSkipButton(){
		return skipButton;
	}
	
	public void goToValidatePopup(){
		Actions ac = new Actions(driver);
		ac.moveToElement(getvalidatePopup());
	}
	
	public void clickOnSkipButton(){
		Actions ac = new Actions(driver);
		ac.moveToElement(getSkipButton());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", getSkipButton());
	}
	
	
	
}
