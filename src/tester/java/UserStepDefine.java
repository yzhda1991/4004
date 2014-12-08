package tester.java;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserStepDefine {
	
	WebDriveController wdc = WebDriveController.getInstance();
	WebDriver driver = wdc.getDriver();
	WebElement searchResult = null;
	

	
	@Given("^System log in as Librarian \"([^\"]*)\" \"([^\"]*)\"$")
	public void System_log_in_as_Librarian(String arg1, String arg2) throws Throwable  {

		if (!wdc.isLibrarianLogIn()) {
			wdc.loginAsLibrarian(arg1, arg2);
		}
		if(!wdc.getCurrentUser().equals(arg1)){
			wdc.logout();
			wdc.loginAsLibrarian(arg1, arg2);
		}
		
		Assert.assertTrue("system log in as Librarian",wdc.isLibrarianLogIn());

	}

	@When("^Librarian is on maintain user page$")
	public void Librarian_clicked_on_Maintatin_User_button() throws Throwable {
		
			
		if(wdc.isOnMaintainUserPage()) return;
		
		if(!wdc.isLibrarianLogIn()) Assert.fail("system log in as not a Librarian user");
		
		try{
		driver.findElement(By.id("j_idt21:maintainMembers")).click();
		}catch(org.openqa.selenium.NoSuchElementException ex){
			System.out.println(ex.getMessage());
		}
		
		
		
	}

	@When("^Librarian input \"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" on maintain user page$")
	
	public void Librarian_input_(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
		driver.findElement(By.id("maintainUserForm:Family-Name")).sendKeys(arg1);
		driver.findElement(By.id("maintainUserForm:Given-Name")).sendKeys(arg2);
		driver.findElement(By.id("maintainUserForm:Middle-Initial")).sendKeys(arg3);
		driver.findElement(By.id("maintainUserForm:Email-Address")).sendKeys(arg4);
		driver.findElement(By.id("maintainUserForm:User-Name")).sendKeys(arg5);
		driver.findElement(By.id("maintainUserForm:Password")).sendKeys(arg6);
		
	}
	

	@Given("^Librarian input \"([^\"]*)\" at userName field in maintain user page$")
	public void Librarian_input_at_userName_field_in_maintain_user_page(String arg1) throws Throwable {
		driver.findElement(By.id("maintainUserForm:User-Name")).sendKeys(arg1);
	}

	@When("^Librarian clicked on search User button on maintain user page$")
	public void Librarian_clicked_on_search_User_button() throws Throwable {
	   driver.findElement(By.id("maintainUserForm:findUser")).click();
	}
	@When("^Librarian clicked on create User button on maintain user page$")
	public void Librarian_clicked_on_create_User_button() throws Throwable {
		driver.findElement(By.id("maintainUserForm:createUser")).click();
	}

	@Then("^System find available user info \"([^\"]*)\"$")
	public void System_find_available_user_info(String arg1) throws Throwable {
		searchResult =null;
		 try{
		WebElement table = driver.findElement(By
				.id("j_idt117:dataTable"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Iterator<WebElement> i = rows.iterator();
		Assert.assertNotNull(table);
		int count = -1;
		while (i.hasNext()) {
			WebElement row = i.next();
			List<WebElement> columns = row.findElements(By.tagName("td"));
			Iterator<WebElement> j = columns.iterator();
			while (j.hasNext()) {
				WebElement column = j.next();
				if (column.getText().equals(arg1)) {
						searchResult = driver.findElement(
								By.id("j_idt117:dataTable:"
										+ ((count+1)<0?0:count) + ":checked"));
						return;
					}
				}count++;
			}
		 }
		 catch(org.openqa.selenium.NoSuchElementException ex){
				System.out.println(ex.getMessage());
			}
		Assert.assertNotNull("system find content matched with user input",searchResult!=null);
	}
	
	@Then
	("^Librarian clicked on delete user button on maintain user pages$")
	public void Librarian_clicked_on_delete_user_button_on_maintain_user_pages() throws Throwable {
	    Assert.assertNotNull("available content's checkbox found",searchResult);
	    searchResult.click();
	    try{
			driver.findElement(By.id("j_idt117:submit")).click();
			}catch(org.openqa.selenium.NoSuchElementException ex){
				System.out.println(ex.getMessage());
			}
	}
	
	@Then("^System promote success message in user page contains \"([^\"]*)\"$")
	public void System_promote_success_message_in_user_page_contains(String arg1)
			throws Throwable {

		String successMessage = driver.findElement(
				By.id("maintainUserForm:successMessagePane")).getText();
		Assert.assertTrue("log message contains <" + arg1 + "> ",
				successMessage.contains(arg1));
	}

	
	@Then("^System promote fail message in user page contains \"([^\"]*)\"$")
	public void System_promote_fail_message_in_user_page_contains(String arg1) throws Throwable {
	    String erorMessage = driver.findElement(By.id("maintainUserForm:messagePane")).getText();
	    Assert.assertTrue("log message contains <"+arg1+"> ",erorMessage.contains(arg1));
	}

}
