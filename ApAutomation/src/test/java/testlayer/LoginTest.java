package testlayer;

import java.com.odoo.ap.pagelayer.Homepage;
import java.com.odoo.ap.pagelayer.Loginpage;
import java.com.odoo.ap.testbase.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

	@Test
	public void verifyLoginWithValidDetails()
	{
		String expected_result = "My Portal | testing";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.enterEmail("test@gmail.com");
		loginpage_obj.enterPassword("Test@1234");
		loginpage_obj.clickOnLoginButton();
		
		String actual_result = driver.getTitle();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);	
	}
	
	@Test
	public void verifyLoginWithInValidDetails()
	{
		String expected_result = "Wrong login/password";
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		
		homepage_obj.clickOnSignInLink();
		loginpage_obj.enterEmail("test@gmail.com");
		loginpage_obj.enterPassword("Test");
		loginpage_obj.clickOnLoginButton();
		
		String actual_result = loginpage_obj.getErrorMessage();
		System.out.println(actual_result);
		
		Assert.assertEquals(actual_result, expected_result);	
	}
}
