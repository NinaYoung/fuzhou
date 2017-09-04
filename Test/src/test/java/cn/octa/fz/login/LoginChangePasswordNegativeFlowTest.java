package cn.octa.fz.login;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fz.data.ChangePasswordData;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;
import junit.framework.Assert;

public class LoginChangePasswordNegativeFlowTest extends AbstractTest {

	@DataProvider(name = "LoginChangePasswordNegativeFlow")
	public static Object[][]  provider(){
		return  DataFactory.getData(ChangePasswordData.class, "login/changePasswordNegative");
	}
	
	@Test(dataProvider = "LoginChangePasswordNegativeFlow", groups = {"login"})
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
		Assert.assertTrue(homePageExt.getPopUpMsgLabel().getText().contains(data.getPopUpMsg()));
		homePageExt.clickMsgOkButton();
		
		// New password less than 6 chars
		homePageExt.changePassword(data.getPassword(), data.getNewPwdLess6(), data.getNewPwdLess6());
		Assert.assertTrue(homePageExt.getChangePwdMsgLabel().getText().contains(data.getInvalidPwdMsg()));
		
		// New password more than 18 chars
		homePageExt.changePassword(data.getPassword(), data.getNewPwdMore18(), data.getNewPwdMore18());
		Assert.assertTrue(homePageExt.getChangePwdMsgLabel().getText().contains(data.getInvalidPwdMsg()));
		
		// Invalid new password
		homePageExt.changePassword(data.getPassword(), data.getInvalidNewPwd(), data.getInvalidNewPwd());
		Assert.assertTrue(homePageExt.getChangePwdMsgLabel().getText().contains(data.getInvalidPwdMsg()));
		
		// new pwd not equal confirm pwd
		homePageExt.changePassword(data.getPassword(), data.getNewPassword(), data.getPassword());
		Assert.assertTrue(homePageExt.getChangePwdMsgLabel().getText().contains(data.getDiffernetPwdMsg()));
		
		homePageExt.cancelChangePassword();
	}
}
