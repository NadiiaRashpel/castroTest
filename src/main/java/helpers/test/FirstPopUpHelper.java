package helpers.test;

import components.FirstPopUp;

public class FirstPopUpHelper {

	public void skipFirstPopup(FirstPopUp popUp){	
		
		popUp.goToValidatePopup();
		popUp.clickOnSkipButton();
	}
	
}
