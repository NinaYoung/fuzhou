package com.octa.fuzhou.page.extend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.octa.fuzhou.data.signup.ChangePasswordData;
import com.octa.fuzhou.page.HomePage;

public class HomePageExt extends HomePage {

	public HomePageExt(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * click welcome button
	 * @return
	 * @throws Exception
	 */
	public HomePageExt clickWelcomeButton() throws Exception{
		return click(getWelcomeButton(), HomePageExt.class);
	}
	
	/**
	 * Click change password button to change password
	 * @return
	 * @throws Exception
	 */
	public HomePageExt gotoChangePassword() throws Exception{
		return click(getChangePasswordButton(), HomePageExt.class);
	}
	
	/**
	 * click cancel button to cancel 
	 * @return
	 * @throws Exception
	 */
	public HomePageExt cancelChangePassword() throws Exception{
		return click(getCancelButton(), HomePageExt.class);
	}

	/**
	 * click X to cancel
	 * @return
	 * @throws Exception
	 */
	public HomePageExt xToCancelChangePassword() throws Exception{
		return click(getxButton(), HomePageExt.class);
	}
	
	/**
	 * fill change password form
	 * @param currentPassword
	 *            - current password
	 * @param newPassword
	 *            - the password you want to change
	 * @param confirmPwd
	 *            - confirm the new password
	 */
	protected void fill(String currentPassword, String newPassword, String confirmPwd){
		getCurrentPwdTextField().sendKeys(currentPassword);
		getNewPasswordTextField().sendKeys(newPassword);
        getConfirmPwdTextField().sendKeys(confirmPwd);
        
	}
	
	/**
	 *  change password
	 * @param currentPassword
	 *            - current password
	 * @param newPassword
	 *            - the password you want to change
	 * @param confirmPwd
	 *            - confirm the new password
	 * @return
	 * @throws Exception
	 */
	public HomePageExt ChangePassword(String currentPassword, String newPassword, String confirmPwd) throws Exception{
		
		fill(currentPassword, newPassword, confirmPwd);
		return click(getSubmitButton(), HomePageExt.class);
	}
	
	/**
	 * logout to LoginPageExt
	 * @return
	 * @throws Exception
	 */
	public LoginPageExt logout() throws Exception{
		click(getWelcomeButton(), HomePageExt.class);
		return click(getLogoutButton(), LoginPageExt.class);
	}
}
