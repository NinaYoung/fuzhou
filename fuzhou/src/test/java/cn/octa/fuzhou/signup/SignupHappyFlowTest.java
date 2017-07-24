package cn.octa.fuzhou.signup;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fuzhou.data.SignUpData;
import cn.octa.fuzhou.page.extend.HomePageExt;
import cn.octa.fuzhou.page.extend.LoginPageExt;
import cn.octa.fuzhou.page.extend.SignUpPageExt;

import basicClass.AbstractTest;
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
