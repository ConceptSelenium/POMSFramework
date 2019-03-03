package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DefaultPage;
import pages.LoginEmailPage;
import pages.LoginPasswordPage;

public class LoginPasswordPageTest extends BaseTest{

	DefaultPage defaultPage;
	LoginEmailPage emailPage;
	LoginPasswordPage passwordPage;
	public LoginPasswordPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException{
		initalization();
		defaultPage = new DefaultPage();
		emailPage = defaultPage.clickSignIn();
		passwordPage = emailPage.enterEmailContinue();
	}
	
	@Test
	public void displayCreateAccountBtn(){
		Assert.assertEquals(passwordPage.loginViaOTPVisible(), true);
	}
	
	@Test
	public void enterPwdAndLogin(){
		passwordPage.enterPasswordAndLogin();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	

}
