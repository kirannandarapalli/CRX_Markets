package pages;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

/**
 * @author Kiran Nandarapalli
 *
 */

public class JIRAEditIssuePage extends PageObject{

	//User opened the existing issue
    public void openIssue() {      
    	getDriver().findElement(By.xpath("//*[@id='issuetable']/tbody/tr[1]/td[2]/a")).click();
    }
    
    //User clicked Edit button to edit the issue
	public void editIssue() {
		$("#edit-issue").click();
	}
	
	//User updated the summary of the issue
	public void updateSummary(String summary) {
		$("#summary").setWindowFocus();
		$("#summary").sendKeys(summary);		
	}
	
	//User updated the description of the issue
	public void updateDescription(String description) {
		$("#description").setWindowFocus();
		$("#description").clear();
		$("#description").sendKeys(description);
	}
	
	//User submitted the issue
	public void editSubmit() {
		$("#edit-issue-submit").setWindowFocus();
		$("#edit-issue-submit").click();		
	}
}
