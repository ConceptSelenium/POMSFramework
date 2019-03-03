package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseTest;


public class RegistrationPage extends BaseTest{


	public RegistrationPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ap_customer_name")
	@CacheLookup
	WebElement name;
	
	
	@FindBy(id="ap_phone_number")
	WebElement phone;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	public AmazonPhoneVerifcationPage registration(String name, String phone, String password){
		this.name.sendKeys(name);
		this.phone.sendKeys(phone);
		this.password.sendKeys(password);
		
		continueButton.click();
		
		return new AmazonPhoneVerifcationPage();
	}
	
	
	
	
}
