package com.octa.fuzhou.login;

import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;

import com.octa.fuzhou.data.signup.ChangePasswordData;
import com.octa.fuzhou.page.extend.HomePageExt;
import com.octa.fuzhou.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class LoginChangePasswordHappyFlowTest extends AbstractTest{

	@DataProvider(name = "LoginChangePasswordHappyFlow")
	public static Object[][]  provider(){
		return  DataFactory.getData(ChangePasswordData.class, "login/changePassword");
	}
	
	@Test(dataProvider = "LoginChangePasswordHappyFlow")
	public void test(ChangePasswordData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver); 
		
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		
		// Go to change password
		homePageExt.clickWelcomeButton();
		homePageExt.gotoChangePassword();
		
		// Click cancel button
		homePageExt.cancelChangePassword();
		
		homePageExt.clickWelcomeButton();
		homePageExt.gotoChangePassword();
		
		// Click X
		homePageExt.xToCancelChangePassword();
		
		homePageExt.clickWelcomeButton();
		homePageExt.gotoChangePassword();
		
        // Change password
        homePageExt.ChangePassword(data.getPassword(), data.getNewPassword(), data.getConfirmNewPwd());
		
        takeScreenshot(driver.getTitle());
	}
}
