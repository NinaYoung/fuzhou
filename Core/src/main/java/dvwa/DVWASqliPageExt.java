package dvwa;

import org.openqa.selenium.WebDriver;

public class DVWASqliPageExt extends DVWASqliPage {

	protected DVWASqliPageExt(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public DVWASqliPageExt sqlInjection() throws Exception{
		getUserIdTextField().clear();
		getUserIdTextField().sendKeys("1' or '1'='1");
		return click(getSubmitButton(), DVWASqliPageExt.class);
	}
}
