package cn.octa.fuzhou.page.extend;

import org.openqa.selenium.WebDriver;

import basicTool.WaitTool;
import cn.octa.fuzhou.page.LoginPage;

public class LoginPageExt extends LoginPage {

	public LoginPageExt(WebDriver driver) {
		super(driver);
	}

	/**
	 * Fill form for login
	 * @param username
	 *               - inputed username
	 * @param password
	 *               - inputed password
	 * @return
	 *               - SignUpPageExt
	 */
	
	protected LoginPageExt login(String username, String password){
		
		getUserNameTextField().clear();
		getUserNameTextField().click();
		getUserNameTextField().sendKeys(username);
		
		getPasswordTextField().clear();
		getPasswordTextField().click();
		getPasswordTextField().sendKeys(password);
		return this;
	}
	
	/**
	 * Login successfully
	 * @param name
	 *         - username
	 * @param password
	 *         - password
	 * @return
	 * @throws Exception
	 */
	public HomePageExt loginToHomePage(String name , String password) throws Exception{
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, getLoginButton());
		login(name,password);
		return click(getLoginButton(), HomePageExt.class);
	}
	/**
	 * login failed
	 * @param name
	 *         - username
	 * @param password
	 *         - password
	 * @return
	 * @throws Exception
	 */
	public LoginPageExt loginFailed(String name , String password) throws Exception{
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, getLoginButton());
		login(name,password);
		return click(getLoginButton(), LoginPageExt.class);
	}
	
	/**
	 * go to login page or assert for click login button only
	 * @return
	 * @throws Exception
	 */
	public LoginPageExt gotoLoginPage() throws Exception {
		return click(getLoginButton(), LoginPageExt.class);
	}
	
	/**
	 * go to signup page
	 * @return
	 * @throws Exception
	 */
	public SignUpPageExt gotoSignUpPage() throws Exception{
		return click(getSignupFirstButton(), SignUpPageExt.class);
	}
}
