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
 * Test Case to validate search existing issues by JIRA's search field
 */

@RunWith(SerenityRunner.class)
public class SearchIssue {

	@Managed
	WebDriver browser;	
	
	@Steps
	JIRAUser jiraUser;
	
	@Test
	public void userShouldBeAbleToSearchIssue() throws InterruptedException {
		
		//Given
		jiraUser.isOnHomePage();
		
		//And
		jiraUser.enterUserDetails(UserDetails.emailid, "kiran1ly4friends@gmail.com");
		
		//And
		jiraUser.performedAction(ActionType.Continue);
		
		//And
		jiraUser.enterUserDetails(UserDetails.password, "kiran476");
		
		//When
		jiraUser.performedAction(ActionType.Login);
		Thread.sleep(10000);
				
		//And
		jiraUser.shouldBeOnPage("System dashboard - Jira");		
		Thread.sleep(2000);
		
		//Then
		jiraUser.searchIssue("New-7");		
		Thread.sleep(5000);
		
	}
}
