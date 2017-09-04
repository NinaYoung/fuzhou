package cn.octa.fz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.BasePage;
import basicTool.WaitTool;

public class SystemCheckPage extends BasePage {

	public SystemCheckPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, scanImmediatelyButton);
	}

	@FindBy(css = ".btn.btn-lg.btn-primary")
	private WebElement scanImmediatelyButton;
	
	@FindBy(css = ".btn.btn-lg.btn-default")
	private WebElement confirmManuallyButton;
	
	/**
	 * 人工确认页面
	 */
	@FindBy(css = "#immediatelyAffirm")
	private WebElement confirmImmediatelyButton;
	
}
