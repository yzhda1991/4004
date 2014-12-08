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

public class loanStepDefine {
	WebDriveController wdc = WebDriveController.getInstance();
	WebDriver driver = wdc.getDriver();

	@Given("^User login in system as \"([^\"]*)\" \"([^\"]*)\"$")
	public void User_login_in_system_as(String arg1, String arg2)
			throws Throwable {
		driver.navigate().to("http://localhost:8080/WebApp5/");
		driver.findElement(By.id("loginForm:username")).sendKeys(arg1);
		driver.findElement(By.name("loginForm:j_idt28")).sendKeys(arg2);
		driver.findElement(By.id("loginForm:confirmPassword")).click();

	}

	@When("^User clicked on online library system button$")
	public void User_clicked_on_online_library_system_button() throws Throwable {
		WebElement we = driver.findElement(By.id("j_idt21:userApplication"));
		Assert.assertNotNull(we);
		we.click();
	}

	@When("^User enter (\\d+) for searching book$")
	public void User_enter_for_searching_book(String arg1) throws Throwable {
		WebElement isbn = driver.findElement(By
				.id("checkOutItemsView:checkOutItemsForm:ISBN"));
		Assert.assertNotNull(isbn);
		isbn.sendKeys(String.valueOf(arg1));
		driver.findElement(
				By.id("checkOutItemsView:checkOutItemsForm:memberFindTitles"))
				.click();
	}

	@Then("^User clicked check out to borrow book$")
	public void User_clicked_check_out_to_borrow_book() throws Throwable {

		driver.findElement(
				By.id("checkOutItemsView:checkOutItemsForm:selectTitles"))
				.click();
	}

	@Then("^System promote success message in loan page$")
	public void System_promote_success_message_for_loan_creation()
			throws Throwable {

		WebElement messageError = driver.findElement(By
				.id("checkOutItemsView:checkOutItemsForm:successMessagePane"));
		Assert.assertNotNull(messageError);

	}

	@Then("^System promote fail message in loan page$")
	public void System_promote_fail_message_in_loan_page() throws Throwable {
		WebElement messageError = driver.findElement(By
				.id("checkOutItemsView:checkOutItemsForm:messagePane"));
		Assert.assertNotNull(messageError);
	}

	@Then("^System found loan record$")
	public void System_found_loan_record() throws Throwable {
		WebElement loantable = driver.findElement(By
				.id("loansPage:loanForm:loanTable"));
		Assert.assertNotNull(loantable);
	}

	@Then("^User checked return option for it's book and submit$")
	public void User_checked_return_option_for_it_s_book_and_submit()
			throws Throwable {
		driver.findElement(By.id("loansPage:loanForm:loanTable:0:returns"))
				.click();
		driver.findElement(By.id("loansPage:loanForm:submit")).click();
	}

	@Then("^User clicked submit$")
	public void User_checked_renew_option_for_it_s_book_and_submit()
			throws Throwable {

		driver.findElement(By.id("loansPage:loanForm:submit")).click();
	}

	@Then("^Librarian clik submit button$")
	public void Librarian_check_for_submit() throws Throwable {
		driver.findElement(By.id("checkOutItemsView:checkOutItemsForm:Author"))
				.sendKeys("");
		driver.findElement(
				By.name("checkOutItemsView:checkOutItemsForm:j_idt41"))
				.sendKeys("");
		// driver.findElement(By.id("deleteTitlesView:deleteTitlesForm:submit")).click();
	}

	@Then("^System found available item record with (\\d+),(\\d+) for borrow$")
	public void system_found_Book(String arg1, String arg2) throws Throwable {
		{
			WebElement table = driver.findElement(By
					.id("checkOutItemsView:checkOutItemsForm:titlesTable"));
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

					if (column.getText().equals(arg2)) {

						if (j.hasNext()) {
							column = j.next();
							if (column.getText().equals(arg1)) {

								driver.findElement(
										By.id("checkOutItemsView:checkOutItemsForm:titlesTable:"
												+ ((count + 1) < 0 ? 0 : count)
												+ ":checked")).click();

							}
						}
					}
				}
				count++;

			}
		}
	}

	@Then("^system found Book (\\d+) (\\d+) on its loan for return$")
	public void system_found_Book_on_its_loan(String arg1, String arg2)
			throws Throwable {
		WebElement table = driver.findElement(By
				.id("loansPage:loanForm:loanTable"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Iterator<WebElement> i = rows.iterator();
		Assert.assertNotNull(table);

		while (i.hasNext()) {
			WebElement row = i.next();
			List<WebElement> columns = row.findElements(By.tagName("td"));
			Iterator<WebElement> j = columns.iterator();
			int count = 1;
			while (j.hasNext()) {
				WebElement column = j.next();
				if (column.getText().equals(arg1)) {
					if (j.hasNext())
						column = j.next();
					if (column.getText().equals(arg2)) {
						driver.findElement(
								By.id("loansPage:loanForm:loanTable:"
										+ ((count - 1) < 0 ? 0 : count)
										+ ":returns")).click();
					}
				}
			}
			count++;

		}
	}

	@Then("^system found Book (\\d+) (\\d+) on its loan for renew$")
	public void system_found_Book_on_its_loan_for_renew(String arg1, String arg2)
			throws Throwable {
		WebElement table = driver.findElement(By
				.id("loansPage:loanForm:loanTable"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Iterator<WebElement> i = rows.iterator();
		Assert.assertNotNull(table);

		while (i.hasNext()) {
			WebElement row = i.next();
			List<WebElement> columns = row.findElements(By.tagName("td"));
			Iterator<WebElement> j = columns.iterator();
			int count = 0;
			while (j.hasNext()) {
				WebElement column = j.next();
				if (column.getText().equals(arg1)) {
					if (j.hasNext())
						column = j.next();
					if (column.getText().equals(arg2)) {
						driver.findElement(
								By.id("loansPage:loanForm:loanTable:"
										+ ((count+1) < 0 ? 0 : count)
										+ ":renewals")).click();
						return;
					}
				}count++;
			}
			

		}
	}

}
