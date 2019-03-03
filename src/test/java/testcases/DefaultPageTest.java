package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DefaultPage;
import pages.LoginEmailPage;

public class DefaultPageTest extends BaseTest{
	
	DefaultPage defaultPage;
	LoginEmailPage loginEmailPage;
	
	@BeforeMethod
	public void setup() throws IOException{
		initalization();
		defaultPage = new DefaultPage();
	}
	
	@Test
	public void validatePageTitle(){
		Assert.assertEquals(defaultPage.validatePageTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	@Test
	public void validateSearchBoxDisplay(){
		Assert.assertEquals(defaultPage.displaySearchBar(), true);
	}
	
	@Test
	public void clickSignInButton() throws IOException{
		loginEmailPage = defaultPage.clickSignIn();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	public DefaultPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
