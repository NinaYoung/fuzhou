package cn.octa.fz.signup;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fz.data.SignUpData;
import cn.octa.fz.page.extend.LoginPageExt;
import cn.octa.fz.page.extend.SignUpPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class SignupNegativeFlowTest extends AbstractTest{
	
	

	@DataProvider(name = "SignupNegativeFlow")
	public static Object[][] provider(){
		return DataFactory.getData(SignUpData.class, "signup/signupNegativeFlow");
	}
	
	@Test(dataProvider = "SignupNegativeFlow", groups = {"signup"})
	public void test(SignUpData data) throws Exception{
		
		System.out.println("driver is null?" + driver.toString());
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// go to signup page
		SignUpPageExt signUpPageExt = loginPageExt.gotoSignUpPage();
	
		// Username less than 6
		signUpPageExt.signupFaild(data.getUserNameLess6(), data.getPassword(), data.getConfirmpwd());
		assertTrue(signUpPageExt.getCheckUserLabel().getText().contains(data.getCheckMessage()));
		assertTrue(signUpPageExt.getWarningLabel().getText().contains(data.getCheckUserWarning()));
		
		// Username more than 18
		signUpPageExt.signupFaild(data.getUserNameMore18(), data.getPassword(), data.getConfirmpwd());
		assertTrue(signUpPageExt.getCheckUserLabel().getText().contains(data.getCheckMessage()));
		assertTrue(signUpPageExt.getWarningLabel().getText().contains(data.getCheckUserWarning()));
		
		// Invalid username
		signUpPageExt.signupFaild(data.getUserNameInvalid(), data.getPassword(), data.getConfirmpwd());
		assertTrue(signUpPageExt.getCheckUserLabel().getText().contains(data.getCheckMessage()));
		assertTrue(signUpPageExt.getWarningLabel().getText().contains(data.getCheckUserWarning()));
		
		// Password less than 6
		signUpPageExt.signupFaild(data.getUsername(), data.getPasswordLess6(), data.getPasswordLess6());
		assertTrue(signUpPageExt.getCheckPasswordSignUpLabel().getText().contains(data.getCheckMessage()));
		assertTrue(signUpPageExt.getWarningLabel().getText().contains(data.getCheckPwdWarning()));
		
		// Password more than 18
		signUpPageExt.signupFaild(data.getUsername(), data.getPasswordMore18(), data.getPasswordMore18());
		assertTrue(signUpPageExt.getCheckPasswordSignUpLabel().getText().contains(data.getCheckMessage()));
		assertTrue(signUpPageExt.getWarningLabel().getText().contains(data.getCheckPwdWarning()));
		
		// Invalid password 
		signUpPageExt.signupFaild(data.getUsername(), data.getPasswordInvalid(), data.getPasswordInvalid());
		assertTrue(signUpPageExt.getCheckPasswordSignUpLabel().getText().contains(data.getCheckMessage()));
		assertTrue(signUpPageExt.getWarningLabel().getText().contains(data.getCheckPwdWarning()));
				
		// Different password, confirmPassword
		signUpPageExt.signupFaild(data.getUsername(), data.getPassword(), data.getPasswordInvalid());
		assertTrue(signUpPageExt.getWarningLabel().getText().contains(data.getCheckPwdDifferent()));
		takeScreenshot(driver.getTitle());
		
	}
}
