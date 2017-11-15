package steps;

import static org.assertj.core.api.Assertions.assertThat;

import model.ActionType;
import model.IssueType;
import model.UserDetails;
import model.Validation;
import net.thucydides.core.annotations.Step;
import pages.CurrentPage;
import pages.JIRACreatePage;
import pages.JIRADashboardPage;
import pages.JIRAEditIssuePage;
import pages.JIRAHomePage;

/**
 * @author Kiran Nandarapalli
 *
 */

public class JIRAUser {

	private JIRAHomePage jiraHomePage;
	private JIRADashboardPage jiraDashboardpage;
	private JIRACreatePage jiraCreatePage;
	private JIRAEditIssuePage jiraEditIssuePage;
	private CurrentPage currentPage;
	
	
	@Step("User Opened JIRA Login Page")
	public void isOnHomePage() {
		jiraHomePage.open();	
	}

	@Step
	public void performedAction(ActionType actionType) throws InterruptedException {
		if (actionType == ActionType.create)
			jiraDashboardpage.create();
		else if (actionType == ActionType.createSubmit)
			jiraCreatePage.createSubmit();
		else if (actionType == ActionType.issuesTab)
			jiraDashboardpage.issuesTabClick();
		else if (actionType == ActionType.selectMyOpenIssues)
			jiraDashboardpage.selectMyOpenIssues();
		else if (actionType == ActionType.openIssue)
			jiraEditIssuePage.openIssue();
		else if (actionType == ActionType.editIssue)
			jiraEditIssuePage.editIssue();
		else if (actionType == ActionType.editSubmit)
			jiraEditIssuePage.editSubmit();
		else
		jiraHomePage.action(actionType);
	}

	@Step("User entered login details")
	public void enterUserDetails(UserDetails userdetails, String string) {
		if (userdetails == UserDetails.emailid)
		jiraHomePage.enterUserName(string);
		else if (userdetails == UserDetails.password)
			jiraHomePage.enterUserPassword(string);
	}
	
    @Step
    public void shouldBeOnPage(String message) throws InterruptedException {
        assertThat(currentPage.getTitle()).isEqualTo(message);
    }

    @Step("User entered issue details")
	public void enterIssueDetails(String project, IssueType issueType, String summary, String description) throws InterruptedException {
		jiraCreatePage.selectProject(project);
		Thread.sleep(2000);
		jiraCreatePage.selectIssueType(issueType);
		Thread.sleep(2000);
		jiraCreatePage.setSummary(summary);
		Thread.sleep(2000);
		jiraCreatePage.setDescription(description);
		Thread.sleep(2000);
	}
    
    @Step("User updated issue details")
	public void updateIssueDetails(String summary, String description) throws InterruptedException {
    	jiraEditIssuePage.updateSummary(summary);
		Thread.sleep(1000);
		jiraEditIssuePage.updateDescription(description);
		Thread.sleep(1000);
	}
    
    @Step
	public void searchIssue(String searchKey) throws InterruptedException {
		jiraDashboardpage.search(searchKey);
	}
    
    @Step
    public void verifyIssueCreated(Validation newIssuecreated) {
        jiraCreatePage.verify();
    }

}
