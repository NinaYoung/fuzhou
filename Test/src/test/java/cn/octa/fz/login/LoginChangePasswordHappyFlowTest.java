package cn.octa.fz.login;

import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;

import cn.octa.fz.data.ChangePasswordData;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class LoginChangePasswordHappyFlowTest extends AbstractTest{

	@DataProvider(name = "LoginChangePasswordHappyFlow")
	public static Object[][]  provider(){
		return  DataFactory.getData(ChangePasswordData.class, "login/changePasswordSuccess");
	}
	
	@Test(dataProvider = "LoginChangePasswordHappyFlow", groups = {"login"})
	public void test(ChangePasswordData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver); 
		
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		
		// Go to change password
		homePageExt.clickWelcomeButton();
		homePageExt.gotoChangePassword();
		
        // Change password
        homePageExt.changePassword(data.getPassword(), data.getNewPassword(), data.getConfirmNewPwd());
        homePageExt.clickMsgOkButton();
        
        // Logout 
        homePageExt.logout();
        
        // Login again 
        loginPageExt.loginToHomePage(data.getUsername(), data.getNewPassword());
        
		// Go to change password
		homePageExt.clickWelcomeButton();
		homePageExt.gotoChangePassword();

		// Change password
		homePageExt.changePassword(data.getNewPassword(), data.getPassword(), data.getPassword());
		homePageExt.clickMsgOkButton();
	}
}
