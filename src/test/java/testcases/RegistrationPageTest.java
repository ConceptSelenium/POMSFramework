package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DefaultPage;
import pages.LoginEmailPage;
import pages.RegistrationPage;
import utilities.GenericUtilities;

public class RegistrationPageTest extends BaseTest{

	DefaultPage defaultPage;
	LoginEmailPage emailPage;
	RegistrationPage regPage;
	
	GenericUtilities obj= new GenericUtilities();
	Object data[][] = null;
	
	public RegistrationPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException{
		initalization();
		defaultPage = new DefaultPage();
		emailPage = defaultPage.clickSignIn();
		regPage = emailPage.clickCreateAccountButton();
	}
	
	@Test(dataProvider="registationData")
	public void newRegistration(String name, String phone, String password){
		regPage.registration(name, phone, password);
	}
	
	@DataProvider(name="registationData")
	public Object[][] regData() throws IOException{
		data = obj.ReadExcel("RegistrationData");
		return data;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
