package cn.octa.fuzhou.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.BasePage;
import basicTool.WaitTool;

public class WAFPage extends BasePage {

	public WAFPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, setDefenseButton);
	}

	/**
	 * 页码部分
	 */
	@FindBy(css = ".pagination li")
	private List<WebElement> pageJumpContainer;
	
	@FindBy(css = ".pageNum")
	private WebElement pageJumpTextField;
	
	@FindBy(css = ".searchNum")
	private WebElement pageJumpButton;
	
	/**
	 * 防护设置部分
	 */
	@FindBy(css = ".setDefense")
	private WebElement setDefenseButton;
	
	@FindBy(css = "#serachContent")
	private WebElement serachContentTextField;
	
	@FindBy(css = "#searchContentFor")
	private WebElement searchContentButton;
	
	//防护设置下的主机列表
	@FindBy(css = ".boxPagePart table tbody tr")
	private List<WebElement> defenceHostContainer;
	
	private By host = By.cssSelector(".boxPagePart table tbody tr td:first-child");
	private By ip = By.cssSelector(".boxPagePart table tbody tr td:last-child");
	private By httpDefence = By.cssSelector(".selectHttpBtn.selectBtnSet0");
	
	/**
	 * 防护设置 - 页码
	 */
	@FindBy(css = ".boxPagePart .pagination li")
	private List<WebElement> defencePageJumpContainer;

	public List<WebElement> getPageJumpContainer() {
		return pageJumpContainer;
	}

	public WebElement getPageJumpTextField() {
		return pageJumpTextField;
	}

	public WebElement getPageJumpButton() {
		return pageJumpButton;
	}

	public WebElement getSetDefenseButton() {
		return setDefenseButton;
	}

	public WebElement getSerachContentTextField() {
		return serachContentTextField;
	}

	public WebElement getSearchContentButton() {
		return searchContentButton;
	}

	public List<WebElement> getDefenceHostContainer() {
		return defenceHostContainer;
	}

	public By getHost() {
		return host;
	}

	public By getIp() {
		return ip;
	}

	public By getHttpDefence() {
		return httpDefence;
	}

	public List<WebElement> getDefencePageJumpContainer() {
		return defencePageJumpContainer;
	}
	
	
}
