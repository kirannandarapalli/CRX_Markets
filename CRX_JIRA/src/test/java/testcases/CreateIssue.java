package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import model.ActionType;
import model.IssueType;
import model.UserDetails;
import model.Validation;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import steps.JIRAUser;

/**
 * @author Kiran Nandarapalli
 * Test Case to validate the creating an issue in JIRA
 */

@RunWith(SerenityRunner.class)
public class CreateIssue {

	@Managed
	WebDriver browser;	
	
	@Steps
	JIRAUser jiraUser;

	@Test
	public void userShouldBeAbleToCreateIssue() throws InterruptedException {
		
		//Given
		jiraUser.isOnHomePage();
		
		//And
		jiraUser.enterUserDetails(UserDetails.emailid, "kiran1ly4friends@gmail.com");
		
		//And
		jiraUser.performedAction(ActionType.Continue);
		
		//And
		jiraUser.enterUserDetails(UserDetails.password, "kiran476");
		
		//And
		jiraUser.performedAction(ActionType.Login);
				
		//When
		jiraUser.shouldBeOnPage("System dashboard - Jira");		
		Thread.sleep(2000);
		
		//And
		jiraUser.performedAction(ActionType.create);	
		Thread.sleep(5000);
		
		//And
		jiraUser.shouldBeOnPage("Create issue - Jira");
				
		//And
		jiraUser.enterIssueDetails("newtest (NEW)", IssueType.bug, "Dummy Summary", "BlankDescription");
		
		//Then
		jiraUser.performedAction(ActionType.createSubmit);
		Thread.sleep(3000);
		
		//And
		jiraUser.verifyIssueCreated(Validation.newIssueCreated);
		
	}
}
