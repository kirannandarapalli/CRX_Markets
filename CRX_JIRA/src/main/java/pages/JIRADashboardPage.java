package pages;

import net.serenitybdd.core.pages.PageObject;

/**
 * @author Kiran Nandarapalli
 *
 */

public class JIRADashboardPage extends PageObject{

	////User clicked Create button in dashboard page
	public void create() {
		$("#create_link").click();
	}

	//User entered the summary
	public void issuesTabClick() {
		$("#find_link").click();
	}

	//User clicked My Open Issues link
	public void selectMyOpenIssues() {
		$("#filter_lnk_my_lnk").setWindowFocus();
		$("#filter_lnk_my_lnk").click();
	}

	//User is searching the existing issues through JIRA's search field
	public void search(String searchkey) throws InterruptedException {
		$("#quickSearchInput").setWindowFocus();
		Thread.sleep(1000);
		$("#quickSearchInput").sendKeys(searchkey);
		Thread.sleep(1000);
		$("#quickSearchInput").submit();
		Thread.sleep(1000);
	}
}
