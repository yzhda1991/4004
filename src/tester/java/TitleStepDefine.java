package tester.java;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TitleStepDefine {

	WebDriveController wdc = WebDriveController.getInstance();
	WebDriver driver = wdc.getDriver();


	@When("^Librarian input (\\d+),\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" on maintain title page$")
	public void Librarian_input_on_maintain_title_page(int arg1, String arg2,
			String arg3, String arg4) throws Throwable {
		driver.findElement(By.id("maintainTitleForm:ISBN")).sendKeys(
				String.valueOf(arg1));
		driver.findElement(By.name("maintainTitleForm:j_idt109")).sendKeys(arg2);
		Select authorSelect = new Select(driver.findElement(By
				.name("maintainTitleForm:j_idt111")));
		authorSelect.selectByVisibleText(arg3);
		Select PublisherSelect = new Select(driver.findElement(By
				.name("maintainTitleForm:j_idt114")));
		PublisherSelect.selectByVisibleText(arg4);
	}

	@When("^Librarian clicked on create title button on maintain title page$")
	public void Librarian_clicked_on_create_title_button() throws Throwable {
		WebElement we = driver.findElement(By
				.id("maintainTitleForm:createTitle"));
		Assert.assertNotNull(we);
		we.click();
	}


	@When("^Librarian clicked on search title button on maintain title page$")
	public void Librarian_clicked_on_search_title_button() throws Throwable {
		driver.findElement(By.id("maintainTitleForm:findAvailableItems"))
				.click();
	}

	@Then("^System promote success message in title page contains \"([^\"]*)\"$")
	public void System_promote_success_message_in_title_page_contains(String arg1) throws Throwable {

		String successMessage = driver.findElement(
				By.id("maintainTitleForm:successMessagePane")).getText();
		
		Assert.assertTrue("log message contains <" + arg1 + "> ",
				successMessage.contains(arg1));
	}

	@Then("^System promote fail message in title page contains (\\d+)$")
	public void System_promote_fail_message_in_title_page_contains(String arg1) throws Throwable {

		WebElement messageError = driver.findElement(By
				.id("maintainTitleForm:messagePane"));
		Assert.assertNotNull(messageError);
		
		String erorMessage = driver.findElement(By.id("maintainTitleForm:messagePane")).getText();
	    Assert.assertTrue("log message contains <"+arg1+"> ",erorMessage.contains(arg1));
		
		
	}

	@Then("^System found title info (\\d+)$")
	public void System_found_title_info(String arg1) throws Throwable {
		driver.findElement(
				By.id("deleteTitlesView:deleteTitlesForm:dataTable:0:checked"))
				.click();
	}

	@Then("^Librarian clicked on delete Title$")
	public void Librarian_clicked_on_delete_Title() throws Throwable {
		driver.findElement(By.id("deleteTitlesView:deleteTitlesForm:submit"))
				.click();
	}
	
	@Then("^Librarian clicked on create Item$")
	public void Librarian_clicked_on_create_Item() throws Throwable {
	    driver.findElement(By.id("deleteTitlesView:deleteTitlesForm:createItem")).click();
	}
	
	
}
