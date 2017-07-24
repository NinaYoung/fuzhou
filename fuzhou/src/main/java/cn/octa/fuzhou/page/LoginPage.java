package cn.octa.fuzhou.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.AbstractPage;
import basicTool.WaitTool;

public class LoginPage extends AbstractPage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, userNameTextField);
	}
	
	@FindBy(css = "#login-box #username")
	private WebElement userNameTextField;
	
	@FindBy(css = "#login-box #password")
	private WebElement passwordTextField;
	
	@FindBy(css = ".first-login-btn")
	private WebElement loginButton;
	
	@FindBy(css = ".first-register-btn.common-login-style")
	private WebElement signupFirstButton;
	
	@FindBy(css = ".http-warning span")
	private WebElement warningLabel;
	
	@FindBy(css = ".checkusers")
	private WebElement checkUserLabel;
	
	@FindBy(css = "#login-box div.checkpasses")
	private WebElement checkPasswordLoginLabel;

	public WebElement getCheckUserLabel() {
		return checkUserLabel;
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
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getSignupFirstButton() {
		return signupFirstButton;
	}
	
}
