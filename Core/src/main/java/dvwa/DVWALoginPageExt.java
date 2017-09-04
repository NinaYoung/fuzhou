package dvwa;

import org.openqa.selenium.WebDriver;

public class DVWALoginPageExt extends DVWALoginPage {

	public DVWALoginPageExt(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * login to DVWA
	 * @return
	 * @throws Exception
	 */
	public DVWABasePageExt login() throws Exception{
		
		getUserNameTextField().clear();
		getUserNameTextField().sendKeys("admin");
		getPasswordTextField().clear();
		getPasswordTextField().sendKeys("password");
		
		return click(getLoginButton(), DVWABasePageExt.class);
	}
}
