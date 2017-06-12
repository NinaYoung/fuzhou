package com.octa.fuzhou.signup;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.octa.fuzhou.data.signup.SignUpData;
import com.octa.fuzhou.page.extend.HomePageExt;
import com.octa.fuzhou.page.extend.LoginPageExt;
import com.octa.fuzhou.page.extend.SignUpPageExt;

import basicClass.AbstractTest;
import basicTool.WaitTool;
import dataTool.DataFactory;


public class SignupHappyFlowTest extends AbstractTest {
	
	@DataProvider(name = "SignupHappyFlowTest")
	public static Object[][]  provider(){
		return  DataFactory.getData(SignUpData.class, "signup/signup");
	}
		
	@Test(dataProvider = "SignupHappyFlowTest")
	public void test(SignUpData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// go to signup page
		SignUpPageExt signUpPageExt = loginPageExt.gotoSignUpPage();
		
		HomePageExt homePageExt = signUpPageExt.signupSuccess(data.getUsername(), data.getPassword(), data.getConfirmpwd());
		
		assertTrue(homePageExt.getWelcomeButton().getText().contains(homePageExt.TITLE));
		takeScreenshot(driver.getTitle());
		
	}
}
