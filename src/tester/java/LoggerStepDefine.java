package tester.java;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import logger.SystemLogger;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoggerStepDefine {
	
	WebDriveController wdc = WebDriveController.getInstance();
	WebDriver driver = wdc.getDriver();
	
	
	@Given("^record Logger \"([^\"]*)\"$")
	public void record_Logger(String arg1) throws Throwable {
	   SystemLogger.getInstance().WriteLogtoAll(arg1);
	}
	
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
	
	
	@When("^Librarian is on maintain title page$")
	public void Librarian_is_on_maintain_title_page() throws Throwable {
		if (wdc.isOnMaintainTitlePage())
			return;

		if (!wdc.isLibrarianLogIn())
			Assert.fail("system log in as not a Librarian user");

		try {
			driver.findElement(By.id("j_idt21:maintainTitles")).click();
		} catch (org.openqa.selenium.NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		}
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
	
	

}
