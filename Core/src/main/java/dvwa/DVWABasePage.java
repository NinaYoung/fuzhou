package dvwa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.AbstractPage;
import basicTool.WaitTool;

public class DVWABasePage extends AbstractPage {
	
	protected DVWABasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, securityLink);
	}

	@FindBy(css = "a[href='vulnerabilities/sqli/']")
	public WebElement sqliLink;
	
	@FindBy(css = "a[href='../../security.php']")
	public WebElement securityLink;

	public WebElement getSqliLink() {
		return sqliLink;
	}

	public WebElement getSecurityLink() {
		return securityLink;
	}

}
