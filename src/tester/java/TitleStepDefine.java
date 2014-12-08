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

	@When("^Librarian clicked on maintain Title$")
	public void Librarian_clicked_on_maintain_Title() throws Throwable {
		WebElement we = driver.findElement(By.id("j_idt21:maintainTitles"));
		Assert.assertNotNull(we);
		we.click();
	}

	@When("^Librarian input (\\d+),\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void Librarian_input_(String arg1, String arg2, String arg3,
			String arg4) throws Throwable {
		WebElement isbn = driver.findElement(By.id("maintainTitleForm:ISBN"));
		WebElement title = driver.findElement(By
				.name("maintainTitleForm:j_idt51"));
		Select authorDropDown = new Select(driver.findElement(By
				.name("maintainTitleForm:j_idt53")));
		Select publisherDropDown = new Select(driver.findElement(By
				.name("maintainTitleForm:j_idt56")));

		Assert.assertNotNull(isbn);
		Assert.assertNotNull(title);
		Assert.assertNotNull(authorDropDown);
		Assert.assertNotNull(publisherDropDown);

		isbn.sendKeys(String.valueOf(arg1));
		title.sendKeys(arg2);
		authorDropDown.selectByVisibleText(arg3);
		publisherDropDown.selectByVisibleText(arg4);
	}

	@When("^Librarian clicked on create title button$")
	public void Librarian_clicked_on_create_title_button() throws Throwable {
		WebElement we = driver.findElement(By
				.id("maintainTitleForm:createTitle"));
		Assert.assertNotNull(we);
		we.click();
	}


	@When("^Librarian clicked on search title button$")
	public void Librarian_clicked_on_search_title_button() throws Throwable {
		driver.findElement(By.id("maintainTitleForm:findAvailableItems"))
				.click();
	}

	@Then("^System promote success message in title page$")
	public void System_promote_success_message_for_title_creation()
			throws Throwable {
		WebElement messageError = driver.findElement(By
				.id("maintainTitleForm:successMessagePane"));
		Assert.assertNotNull(messageError);
	}

	@Then("^System promote fail message in title page$")
	public void System_promote_fail_message_for_title_creation()
			throws Throwable {
		WebElement messageError = driver.findElement(By
				.id("maintainTitleForm:messagePane"));
		Assert.assertNotNull(messageError);
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
