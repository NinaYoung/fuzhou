package dvwa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DVWASecurityPageExt extends DVWASecurityPage {

	protected DVWASecurityPageExt(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * change level
	 * @param level
	 * @return
	 * @throws Exception
	 */
	public DVWASecurityPageExt changeLevel(String level) throws Exception{
		Select select = new Select(getSecuritySelectList());
		select.selectByValue(level);
		return click(getSubmitButton(), DVWASecurityPageExt.class);
	}
}
