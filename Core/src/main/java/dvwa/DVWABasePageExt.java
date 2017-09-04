package dvwa;

import org.openqa.selenium.WebDriver;

public class DVWABasePageExt extends DVWABasePage {

	protected DVWABasePageExt(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * go to security page
	 * @return
	 * @throws Exception
	 */
	public DVWASecurityPageExt gotoSecurityPage() throws Exception{
		return click(getSecurityLink(), DVWASecurityPageExt.class);
	}
	
	/**
	 * go to sqli page
	 * @return
	 * @throws Exception
	 */
	public DVWASqliPageExt gotoSqliPage() throws Exception{
		return click(getSqliLink(), DVWASqliPageExt.class);
	}
}
