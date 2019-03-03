package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class LoginEmailPage extends BaseTest{

	public LoginEmailPage() throws IOException {
		super();
		//Initialization of Page Factory
		PageFactory.initElements(driver, this);
	}
	
	//2. Page Factory
	@FindBy(id="ap_email")
	WebElement email;

	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(id="createAccountSubmit")
	WebElement createAccount;
	
	//3. Create Operation methods
	
	public LoginPasswordPage enterEmailContinue() throws IOException{
		email.sendKeys(p.getProperty("username"));
		continueButton.click();
		return new LoginPasswordPage();
	}
	
	public String validatePageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean displayCreateAccountButton(){
		return createAccount.isDisplayed();
	}
	
	public RegistrationPage clickCreateAccountButton() throws IOException{
		createAccount.click();
		return new RegistrationPage();
	}

}
