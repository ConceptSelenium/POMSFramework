package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class LoginPasswordPage extends BaseTest{

	public LoginPasswordPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement loginButton;
	
	@FindBy(id="continue")
	WebElement loginViaOTP;
	
	public boolean loginViaOTPVisible(){
		return loginViaOTP.isDisplayed();
	}
	
	public HomePage enterPasswordAndLogin(){
		password.sendKeys(p.getProperty("password"));
		loginButton.click();
		return new HomePage();
	}
}
