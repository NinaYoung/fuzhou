package dvwa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicTool.WaitTool;

public class DVWASqliPage extends DVWABasePage {

	protected DVWASqliPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, userIdTextField);
	}

	@FindBy(css = "input[name='id']")
	public WebElement userIdTextField;
	
	@FindBy(css = "input[name='Submit']")
	public WebElement submitButton;

	public WebElement getUserIdTextField() {
		return userIdTextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
}
