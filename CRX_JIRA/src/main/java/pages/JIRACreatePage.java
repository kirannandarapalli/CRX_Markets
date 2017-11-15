package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import model.IssueType;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;


/**
 * @author Kiran Nandarapalli
 *
 */

public class JIRACreatePage extends PageObject{

	//User selected the project in drop down
	public void selectProject(String project) {
		$("#project-field").setWindowFocus();
		$("#project-field").clear();
		$("#project-field").submit();
		$("#project-field").sendKeys(project);
		
	}

	//User selected issue type
	public void selectIssueType(IssueType issueType) {
		$("#issuetype-field").setWindowFocus();
		$("#issuetype-field").sendKeys(issueType.name());
		
	}

	//User entered the summary
	public void setSummary(String summary) {
		$("#summary").setWindowFocus();
		$("#summary").sendKeys(summary);
		
	}

	//User entered the description
	public void setDescription(String description) {
		$("#description").setWindowFocus();
		$("#description").sendKeys(description);
		
	}

	//User clicked the create button
	public void createSubmit() {
		$("#create-issue-submit").setWindowFocus();
		$("#create-issue-submit").click();
	
	}

	//Verifying new issue is created or not
	public void verify( ) {
		try{
		    WebDriverWait wait = new WebDriverWait(getDriver(), 3);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"aui-flag-container\"]/div/div/a")));
		}catch(Throwable e){
		    System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
		}
	}
}
