package com.octa.fuzhou.page.extend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basicClass.BasePage;

public class BasePageExt extends BasePage {

	public BasePageExt(WebDriver driver) {
		super(driver);
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
	 *        confirm change password successfully button
	 * @throws Exception
	 */
	public WebElement changePassword(String currentPassword, String newPassword, String confirmPwd) throws Exception{
		
		fill(currentPassword, newPassword, confirmPwd);
		return click(getSubmitButton(), getMsgOkButton());
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
	/**
	 * go to home page
	 * @return
	 * @throws Exception
	 */
	public BasePageExt gotoHomePage() throws Exception{
		return click(getHomeLink(), BasePageExt.class);
	}
	
	/**
	 * go to database page
	 * @return
	 * @throws Exception
	 */
	public DataBasePageExt gotoDataBasePage() throws Exception{
		return click(getDataBaseLink(), DataBasePageExt.class);
	}
	
	/**
	 * go to trusted audit page
	 * @return
	 * @throws Exception
	 */
	public TrustedAuditPageExt gotoTrustedAuditPage() throws Exception{
		return click(getEnvironmentLink(), TrustedAuditPageExt.class);
	}
	
	/**
	 * go to white list page
	 * @return
	 * @throws Exception
	 */
	public WhiteListPageExt gotoWhiteListPage() throws Exception{
		return click(getWhitelistLink(), WhiteListPageExt.class);
	}
	
	/**
	 * click message ok button to confirm changing password successfully
	 * @return
	 * @throws Exception
	 */
	public BasePageExt clickMsgOkButton() throws Exception{
		return click(getMsgOkButton(), BasePageExt.class);
	}
	
}
