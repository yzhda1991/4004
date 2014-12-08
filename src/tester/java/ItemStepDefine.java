package tester.java;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ItemStepDefine {
	WebDriveController wdc = WebDriveController.getInstance();
	WebDriver driver = wdc.getDriver();


	@When("^Librarian input (\\d+)$")
	public void Librarian_input(String arg1) throws Throwable {
		WebElement  isbn = driver.findElement(By.id("maintainTitleForm:ISBN"));
		Assert.assertNotNull(isbn);
		isbn.sendKeys(arg1);
		
	}

	@When("^Librarian clicked on Search button$")
	public void Librarian_clicked_on_Search_button() throws Throwable {
		WebElement we = driver.findElement(By
				.id("maintainTitleForm:findAvailableItems"));
		Assert.assertNotNull(we);
		we.click();
	}
	
	@When("^Librarian clicked on maintain Item$")
	public void Librarian_clicked_on_maintain_Item() throws Throwable {
		WebElement  we = driver.findElement(By.id("j_idt21:maintainItems"));
		Assert.assertNotNull(we);
		we.click();
	}

	@When("^Librarian input (\\d+) on maintain item page$")
	public void Librarian_input_on_maintain_item_page(String arg1) throws Throwable {
	    driver.findElement(By.xpath("//input[@id='maintainTitleForm:ISBN']")).sendKeys(arg1);
	}

	@When("^Librarian clicked on Search button on maintain item page$")
	public void Librarian_clicked_on_Search_button_on_maintain_item_page() throws Throwable {
	   driver.findElement(By.id("maintainTitleForm:findAllItems")).click();
	}


	@Then("^Librarian clicked on Create Item$")
	public void Librarian_clicked_on_Create_Item() throws Throwable {
		
		WebElement we = driver.findElement(By
				.id("deleteTitlesView:deleteTitlesForm:createItem"));
		Assert.assertNotNull(we);
		we.click();
		
	}
	
	
	@Then("^System found item record with (\\d+),(\\d+)$")
	public void System_found_item_record_with_(String arg1, String arg2) throws Throwable {
		WebElement table = driver.findElement(By
				.id("deleteTitlesView:deleteTitlesForm:dataTable"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Iterator<WebElement> i = rows.iterator();
		Assert.assertNotNull(table);
		
		while (i.hasNext()) {
			WebElement row = i.next();
			List<WebElement> columns = row.findElements(By.tagName("td"));
			Iterator<WebElement> j = columns.iterator();
			while (j.hasNext()) {
				WebElement column = j.next();
				if (column.getText().equals(arg1)) {
					if (j.hasNext())
						column = j.next();
					if (column.getText().equals(arg2)) {
						driver.findElement(
								By.id("deleteTitlesView:deleteTitlesForm:dataTable:"
										+ 0 + ":checked")).click();
					}
				}
			}
			
		}
	}

	

	@Then("^System promote success message for item deletation$")
	public void System_promote_success_message_for_item_deletation() throws Throwable {

		WebElement messageError = driver.findElement(By
				.id("maintainTitleForm:successMessagePane"));
		Assert.assertNotNull(messageError);
	}
	
	
	
}
