package com.octa.fuzhou.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.AbstractPage;
import basicTool.WaitTool;

public class HomePage extends AbstractPage{

	protected HomePage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, welcomeButton);
	}

	public final String TITLE = "欢迎您";
	
	@FindBy(css = "#basic-nav-dropdown")
	private WebElement welcomeButton;

	@FindBy(css = "ul.dropdown-menu > li:first-child a")
	private WebElement changePasswordButton;
	
	@FindBy(css = "ul.dropdown-menu > li:last-child a")
	private WebElement logoutButton;
	
	@FindBy(css = "#Totalattack canvas")
	private WebElement totalAttackLabel;
	
	@FindBy(css = "#typeAttack canvas")
	private WebElement typeAttackLabel;
	
	@FindBy(css = "#worldMap canvas")
	private WebElement worldMapLabel;
	
	@FindBy(css = "#radarChart canvas")
	private WebElement radarChartLabel;
	
	@FindBy(css = "#Password:last-child")
	private WebElement currentPwdTextField;

	@FindBy(css = "input#newPassword:last-child")
	private WebElement newPasswordTextField;
	
	@FindBy(css = "input#confirmPassword:last-child")
	private WebElement confirmPwdTextField;
	
	@FindBy(css = ".modalCancelBtn")
	private WebElement cancelButton;
	
	@FindBy(css = ".modalSubmitBtn")
	private WebElement submitButton;
	
	@FindBy(css = ".close")
	private WebElement xButton;
	
	public WebElement getxButton() {
		return xButton;
	}
	public WebElement getCurrentPwdTextField() {
		return currentPwdTextField;
	}
	public WebElement getNewPasswordTextField() {
		return newPasswordTextField;
	}
	public WebElement getConfirmPwdTextField() {
		return confirmPwdTextField;
	}
	public WebElement getCancelButton() {
		return cancelButton;
	}
	public WebElement getSubmitButton() {
		return submitButton;
	}
	public WebElement getTypeAttackLabel() {
		return typeAttackLabel;
	}
	public WebElement getWorldMapLabel() {
		return worldMapLabel;
	}
	public WebElement getRadarChartLabel() {
		return radarChartLabel;
	}
	public WebElement getTotalAttackLabel() {
		return totalAttackLabel;
	}
	public String getTITLE() {
		return TITLE;
	}
	public WebElement getWelcomeButton() {
		return welcomeButton;
	}
	public WebElement getChangePasswordButton() {
		return changePasswordButton;
	}
	public WebElement getLogoutButton() {
		return logoutButton;
	}
}
