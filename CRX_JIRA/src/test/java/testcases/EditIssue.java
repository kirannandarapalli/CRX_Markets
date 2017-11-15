package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import model.ActionType;
import model.UserDetails;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import steps.JIRAUser;

/**
 * @author Kiran Nandarapalli
 * Test Case to validate editing an existing open issue in JIRA
 */

@RunWith(SerenityRunner.class)
public class EditIssue {

	@Managed
	WebDriver browser;	
	
	@Steps
	JIRAUser jiraUser;
	
	@Test
	public void userShouldBeAbleToEditIssue() throws InterruptedException {
		
		
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
		jiraUser.performedAction(ActionType.issuesTab);		
		Thread.sleep(2000);
		
		//And
		jiraUser.performedAction(ActionType.selectMyOpenIssues);		
     	Thread.sleep(5000);
     	
     	//And
     	jiraUser.shouldBeOnPage("[My open issues] Issue navigator - Jira");     	
     	
     	//And
     	jiraUser.performedAction(ActionType.openIssue);     	
     	Thread.sleep(2000);
     	
     	//And
     	jiraUser.shouldBeOnPage("[NEW-7] Automated Summary from serinity test - Jira");  
     	
     	//Then
     	jiraUser.performedAction(ActionType.editIssue);     	
     	Thread.sleep(3000);
     	
     	//And
     	jiraUser.updateIssueDetails("Automated Summary from serinity test", "Automated Description from serinity test");
     	
     	//And
     	jiraUser.performedAction(ActionType.editSubmit);     	
     	Thread.sleep(3000);
	}
}
