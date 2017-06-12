package com.octa.fuzhou.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.AbstractPage;
import basicTool.WaitTool;

public class SignUpPage extends AbstractPage{

	protected SignUpPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, confirmPasswordTextField);
	}

	
	@FindBy(css = ".homeIDlogin")
	private WebElement companyNameLabel;

	@FindBy(css = ".box-background.regis #username")
	private WebElement userNameTextField;
	
	@FindBy(css = ".box-background.regis #password")
	private WebElement passwordTextField;
	
	@FindBy(css = "#confirmpassword")
	private WebElement confirmPasswordTextField;
	
	@FindBy(css = ".first-login-btn")
	private WebElement loginButton;
	
	@FindBy(css = ".first-register-btn.common-login-style")
	private WebElement signupFirstButton;
	
	@FindBy(css = ".login-btn.first-register-btn")
	private WebElement signupSecondButton;
	
	@FindBy(css = ".checkuser")
	private WebElement checkUserLabel;
	
	@FindBy(css = "#register-box div.checkpass")
	private WebElement checkPasswordSignUpLabel;
	
	@FindBy(css = "#login-box div.checkpass")
	private WebElement checkPasswordLoginLabel;
	
	@FindBy(css = ".http-warning")
	private WebElement warningLabel;
	
	
	public WebElement getCompanyNameLabel() {
		return companyNameLabel;
	}

	public WebElement getCheckUserLabel() {
		return checkUserLabel;
	}

	public WebElement getCheckPasswordSignUpLabel() {
		return checkPasswordSignUpLabel;
	}

	public WebElement getCheckPasswordLoginLabel() {
		return checkPasswordLoginLabel;
	}

	public WebElement getWarningLabel() {
		return warningLabel;
	}

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getSignupFirstButton() {
		return signupFirstButton;
	}

	public WebElement getSignupSecondButton() {
		return signupSecondButton;
	}
	
	

}
