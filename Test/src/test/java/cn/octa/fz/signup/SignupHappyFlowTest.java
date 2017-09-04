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


public class SignupHappyFlowTest extends AbstractTest {
	
	@DataProvider(name = "SignupHappyFlowTest")
	public static Object[][]  provider(){
		return  DataFactory.getData(SignUpData.class, "signup/signupHappyFlow");
	}
		
	@Test(dataProvider = "SignupHappyFlowTest", groups = {"signup"})
	public void test(SignUpData data) throws Exception{
		
		String userName = data.getUsername() + System.currentTimeMillis();
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// go to signup page
		SignUpPageExt signUpPageExt = loginPageExt.gotoSignUpPage();
		
		HomePageExt homePageExt = signUpPageExt.signupSuccess(userName, data.getPassword(), data.getConfirmpwd());
		
		assertTrue(homePageExt.getWelcomeButton().getText().contains(homePageExt.TITLE));
		
	}
}
