package pages;

import model.ActionType;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * @author Kiran Nandarapalli
 *
 */

@DefaultUrl("https://newcrx.atlassian.net")
public class JIRAHomePage extends PageObject{
	
	//User entered Email id in username field
	public void enterUserName(String string) {
		$("#username").sendKeys(string);
	}
	
	//User entered password
	public void enterUserPassword(String string) {
		$("#password").sendKeys(string);
	}
	
	//User clicked Login button
	public void action(ActionType actiontype) throws InterruptedException {
		if ((actiontype == ActionType.Continue) || (actiontype == ActionType.Login))
		$("#login-submit").click();
		Thread.sleep(10000);
	}
}
