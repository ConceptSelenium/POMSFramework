package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class DefaultPage extends BaseTest{

	public DefaultPage() throws IOException {
		super(); // parent class construcor has been called and should be 1st item in the child class constructor
		//1. Initialize Page Factory
		PageFactory.initElements(driver, this);
	}
	
	//2. Page Factory
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	

	@FindBy(xpath="//span[contains(text(),'Hello. Sign in')]")
	WebElement signInButton;
	
	//3. Operation methods
	
	public String validatePageTitle(){
		return driver.getTitle();
	}
	
	public boolean displaySearchBar(){
		return searchBox.isDisplayed();
	}
	
	public LoginEmailPage clickSignIn() throws IOException{
		signInButton.click();
		return new LoginEmailPage();
	}

}
