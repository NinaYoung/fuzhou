package cn.octa.fz.signup;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fz.data.SignUpData;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;
import cn.octa.fz.page.extend.SignUpPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class SignupDuplicatedUserTest extends AbstractTest{

	@DataProvider(name = "SignupDuplicatedUser")
	public static Object[][] provider(){
		return DataFactory.getData(SignUpData.class, "signup/signupDuplicatedUser");
	}
	
	@Test(dataProvider = "SignupDuplicatedUser", groups = {"signup"})
	public void test(SignUpData data) throws Exception{
		
		String userName = data.getUsername() + System.currentTimeMillis();
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);
		
		// go to signup page
		SignUpPageExt signUpPageExt = loginPageExt.gotoSignUpPage();
		
		// Check duplicated user signup
		HomePageExt homePageExt = signUpPageExt.signupSuccess(userName, data.getPassword(), data.getConfirmpwd());
	   
		// Logout 
		homePageExt.logout();
				
		signUpPageExt.signupFaild(data.getUsername(), data.getPassword(), data.getConfirmpwd());
		assertTrue(signUpPageExt.getWarningLabel().getText().contains(data.getCheckDuplicatedUser()));
		
	}
}
