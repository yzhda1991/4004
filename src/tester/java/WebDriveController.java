package tester.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriveController {

	private static WebDriveController instance;
	private WebDriver driver;
	private UserEnum currentUserType;
	private String currentUser ="";
	private static final  String _LIBRARIAN_PAGE_IDENTIFIER = "j_idt21";
	private static final String _LOANPAGE_PAGE_IDENTIFIER ="checkOutItemsView:checkOutItemsForm";
	private static final String _MAINTAINUSER_PAGE_IDENTIFIER ="maintainUserForm:createUser";
	private static final String _MAINTAINTITLE_PAGE_IDENTIFIER ="maintainTitleForm";
	private static final String _MAINTAINITEM_PAGE_IDENTIFIER ="maintainTitleForm:findAllItems";
	
	private WebDriveController(){
		driver = new FirefoxDriver();
		driver.navigate().to("http://localhost:8080/WebApp5/");
	}
	
	public synchronized static WebDriveController getInstance() {
		if (instance == null) {

			synchronized (WebDriveController.class) {
				if (instance == null)
					instance = new WebDriveController();

			}
		}
		return instance;
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public boolean loginAsLibrarian(String username,String password){
		
		if(isLibrarianLogIn())
		   if(!driver.getCurrentUrl().startsWith("http://localhost:8080/WebApp5/")){
			   driver.navigate().to("http://localhost:8080/WebApp5/");
		   }
		   driver.findElement(By.id("loginForm:username")).sendKeys("admin");
		   driver.findElement(By.name("loginForm:j_idt28")).sendKeys("COMP5104");
		   driver.findElement(By.id("loginForm:confirmPassword")).click();
		   if(driver.findElement(By.id(_LIBRARIAN_PAGE_IDENTIFIER))!=null){
			   currentUserType = UserEnum.Librarian;
			   currentUser = username;
		   }
		   return isLibrarianLogIn();
	}
	
	public boolean loginAsMember(String username,String password){
		
		if(isLibrarianLogIn()) return true;
		if(isMemberLogIn()) logout();
		
		if(isLibrarianLogIn())
			 if(!driver.getCurrentUrl().startsWith("http://localhost:8080/WebApp5/")){
				   driver.navigate().to("http://localhost:8080/WebApp5/");
			   }
		
			   driver.findElement(By.id("loginForm:username")).sendKeys("admin");
			   driver.findElement(By.name("loginForm:j_idt28")).sendKeys("COMP5104");
			   driver.findElement(By.id("loginForm:confirmPassword")).click();
			   if(driver.findElement(By.id(_LIBRARIAN_PAGE_IDENTIFIER))!=null){
				   currentUserType = UserEnum.Member;
				   currentUser = username;
			   }
			   return isLibrarianLogIn();	
	}
	
	public boolean logout()throws org.openqa.selenium.NoSuchElementException{
		if(isLogOut()) return true;
		if(!driver.getCurrentUrl().startsWith("http://localhost:8080/WebApp5/")){
			   driver.navigate().to("http://localhost:8080/WebApp5/");
		   }
		
		driver.findElement(By.id("j_idt21:logOut")).click();
		 currentUser = "";
		return isLogOut();
	}
	
	

	public boolean isLibrarianLogIn() {
		return currentUserType == UserEnum.Librarian;
	}
	
	public boolean isMemberLogIn(){
		return currentUserType == UserEnum.Member;
	}
	
	public boolean isLogOut(){
		return currentUserType == UserEnum.NotLogIn;
	}
	
	public String getCurrentUser(){
		return isLogOut()?"":currentUser;
	}
	
	public boolean isOnMaintainTitlePage()throws org.openqa.selenium.NoSuchElementException{
		
		try{
			return (driver.findElement(By.id(_MAINTAINTITLE_PAGE_IDENTIFIER))!=null);
		}catch(org.openqa.selenium.NoSuchElementException ex){
			return false;
		}
	}
	public boolean isOnLibrarianPage()throws org.openqa.selenium.NoSuchElementException{
		try{
			return (driver.findElement(By.id(_LIBRARIAN_PAGE_IDENTIFIER))!=null);
		}catch(org.openqa.selenium.NoSuchElementException ex){
			return false;
		}
		
	}
	public boolean isOnMaintainUserPage(){
		try{
			return (driver.findElement(By.id(_MAINTAINUSER_PAGE_IDENTIFIER))!=null);
		}catch(org.openqa.selenium.NoSuchElementException ex){
			return false;
		}
		
	}
	public boolean isOnLibrarySystemPage(){
		try{
			return (driver.findElement(By.id(_LOANPAGE_PAGE_IDENTIFIER))!=null);
		}catch(org.openqa.selenium.NoSuchElementException ex){
			return false;
		}
		
	}
	public boolean isOnMaintainItem(){
		try{
			return (driver.findElement(By.id(_MAINTAINITEM_PAGE_IDENTIFIER))!=null);
		}catch(org.openqa.selenium.NoSuchElementException ex){
			return false;
		}
		
	}
	
}

