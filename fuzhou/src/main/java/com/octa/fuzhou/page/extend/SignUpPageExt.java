package com.octa.fuzhou.page.extend;

import org.openqa.selenium.WebDriver;

import com.octa.fuzhou.page.SignUpPage;

import basicTool.WaitTool;

public class SignUpPageExt extends SignUpPage {

	public SignUpPageExt(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}

	
	/**
	 * Fill form for signup
	 * @param username  
	 *               - inputed username
	 * @param password
	 *               - inputed password
	 * @param confirmPassword
	 *               - inputed confirm password
	 * @return
	 *               - SignUpPageExt
	 */
	public SignUpPageExt fill(String username, String password, String confirmPassword){
		
		// Input info
		getSignupFirstButton().click();
		getUserNameTextField().clear();
		getUserNameTextField().sendKeys(username);
		getPasswordTextField().clear();
		getPasswordTextField().sendKeys(password);
		getConfirmPasswordTextField().clear();
		getConfirmPasswordTextField().sendKeys(confirmPassword);
		
		getCompanyNameLabel().click();
		return this;
	}
	
	/**
	 * sign up successfully
	 * @param username  
	 *               - inputed username
	 * @param password
	 *               - inputed password
	 * @param confirmPassword
	 *               - inputed confirm password
	 * @return
	 * @throws Exception
	 */
	public HomePageExt signupSuccess(String username, String password, String confirmPassword) throws Exception{
		
		fill(username, password, confirmPassword);
		return click(getSignupSecondButton(), HomePageExt.class);
		
	}
	
	/**
	 * sign up failed
	 * @param username  
	 *               - inputed username
	 * @param password
	 *               - inputed password
	 * @param confirmPassword
	 *               - inputed confirm password
	 * @return
	 * @throws Exception
	 */
	public SignUpPageExt signupFaild(String username, String password, String confirmPassword) throws Exception{
		
		fill(username, password, confirmPassword);
		return click(getSignupSecondButton(), SignUpPageExt.class);
		
	}
}
