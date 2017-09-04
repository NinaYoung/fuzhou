package cn.octa.fz.login;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fz.data.SignUpData;
import cn.octa.fz.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import basicTool.WaitTool;
import dataTool.DataFactory;

public class LoginNegativeFlowTest extends AbstractTest{

	@DataProvider(name = "SignupNegativeFlow")
	public static Object[][] provider(){
		return DataFactory.getData(SignUpData.class, "login/login");
	}
	
	@Test(dataProvider = "SignupNegativeFlow", groups = {"login"})
	public void test(SignUpData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver); 
		
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, loginPageExt.getLoginButton());
		
	    // Leave username and password empty, click login button
		loginPageExt.gotoLoginPage();
		assertTrue(loginPageExt.getCheckUserLabel().getText().trim().contains(data.getEnterUserName()));
		
		// Leave password empty, enter username, click login button
		loginPageExt.loginFailed(data.getUsername(), null);
		assertTrue(loginPageExt.getCheckPasswordLoginLabel().getText().contains(data.getEnterPassword()));
		
		// Leave username empty, enter password, click login button
		loginPageExt.loginFailed(null, data.getPassword());
		assertTrue(loginPageExt.getCheckUserLabel().getText().contains(data.getEnterUserName()));
		
		// Invalid username, valid password
		loginPageExt.loginFailed(data.getUserNameInvalid(), data.getPassword());
		assertTrue(loginPageExt.getWarningLabel().getText().contains(data.getWrongMsg()));
		
		// Valid username, invalid password
		loginPageExt.loginFailed(data.getUsername(), data.getPasswordInvalid());
		assertTrue(loginPageExt.getWarningLabel().getText().contains(data.getWrongMsg()));
		
		// Invalid username and password
		loginPageExt.loginFailed(data.getUserNameInvalid(), data.getPasswordInvalid());
		assertTrue(loginPageExt.getWarningLabel().getText().contains(data.getWrongMsg()));
		
	}
}
