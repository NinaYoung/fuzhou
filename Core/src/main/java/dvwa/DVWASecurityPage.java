package dvwa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicTool.WaitTool;

public class DVWASecurityPage extends DVWABasePage {

	DVWABasePageExt dvwaBasePageExt = new DVWABasePageExt(driver);
	
	protected DVWASecurityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, securitySelectList);
	}

	@FindBy(css = "select[name='security']")
	public WebElement securitySelectList;

	@FindBy(css = "input[name='seclev_submit']")
	public WebElement submitButton;

	public WebElement getSecuritySelectList() {
		return securitySelectList;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public DVWABasePageExt getDvwaBasePageExt() {
		return dvwaBasePageExt;
	}

}
