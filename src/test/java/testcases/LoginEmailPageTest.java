package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DefaultPage;
import pages.LoginEmailPage;

public class LoginEmailPageTest extends BaseTest{

	DefaultPage defaultPage;
	LoginEmailPage loginEmailPage;
	
	public LoginEmailPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException{
		initalization();
		defaultPage = new DefaultPage();
		loginEmailPage = defaultPage.clickSignIn();
	}
	
	@Test
	public void validateTitle(){
		Assert.assertEquals(loginEmailPage.validatePageTitle(), "Amazon Sign In");
	}
	
	@Test
	public void displayAccountCreationButton(){
		Assert.assertEquals(loginEmailPage.displayCreateAccountButton(), true);
	}
	
	@Test
	public void enterEmailAndContinue() throws IOException{
		loginEmailPage.enterEmailContinue();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
}
