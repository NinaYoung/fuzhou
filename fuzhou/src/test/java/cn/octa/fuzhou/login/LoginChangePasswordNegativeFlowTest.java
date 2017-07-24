package cn.octa.fuzhou.login;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fuzhou.data.ChangePasswordData;
import cn.octa.fuzhou.page.extend.HomePageExt;
import cn.octa.fuzhou.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class LoginChangePasswordNegativeFlowTest extends AbstractTest {

	@DataProvider(name = "LoginChangePasswordNegativeFlow")
	public static Object[][]  provider(){
		return  DataFactory.getData(ChangePasswordData.class, "login/changePassword");
	}
	
	@Test(dataProvider = "LoginChangePasswordNegativeFlow")
	public void test(ChangePasswordData data) throws Exception{
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		
		// Go to change password
		homePageExt.clickWelcomeButton();
		homePageExt.gotoChangePassword();
		
		// Click X
		homePageExt.xToCancelChangePassword();

		homePageExt.clickWelcomeButton();
		homePageExt.gotoChangePassword();
		
		// Invalid current password
		homePageExt.changePassword(data.getInvalidCurrentPwd(), data.getNewPassword(), data.getConfirmNewPwd());
		homePageExt.clickMsgOkButton();
		
		// New password less than 6 chars
		homePageExt.changePassword(data.getPassword(), data.getNewPwdLess6(), data.getNewPwdLess6());
		
		// New password more than 18 chars
		homePageExt.changePassword(data.getPassword(), data.getNewPwdMore18(), data.getNewPwdMore18());
		
		// Invalid new password
		homePageExt.changePassword(data.getPassword(), data.getInvalidNewPwd(), data.getInvalidNewPwd());
		homePageExt.clickMsgOkButton();
		
		// new pwd not equal confirm pwd
		homePageExt.changePassword(data.getPassword(), data.getNewPassword(), data.getPassword());
		
		homePageExt.cancelChangePassword();
	}
}
