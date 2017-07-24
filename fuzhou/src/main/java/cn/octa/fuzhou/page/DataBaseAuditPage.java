package cn.octa.fuzhou.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.BasePage;
import basicTool.WaitTool;

public class DataBaseAuditPage extends BasePage {

	public DataBaseAuditPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, currentIpSelectList);
	}

	@FindBy(css = ".button-group div.btn-toolbar:first-child")
	private WebElement currentIpSelectList;
	
	private By currentIpArrow = By.cssSelector(".button-group div.btn-toolbar:first-child .select-img");
	private By currentIpMenuItem = By.cssSelector(".button-group div.btn-toolbar:first-child .list-block");
	
	/**
	 * 白名单操作部分
	 */
	@FindBy(css = ".button-whitelist.btn.btn-sm.btn-primary")
	private WebElement operateWhiteListButton;
	
	@FindBy(css = ".setting-tabs li:first-child")
	private WebElement setWhiteListUserButton;
	
	@FindBy(css = ".setting-tabs li:last-child")
	private WebElement setWhiteListActionButton;
	
	@FindBy(css = "#add-white-user")
	private WebElement addWhiteListTextField;
	
	@FindBy(css = ".whitelist-setting div.tab-content:nth-child(3) .bt-add")
	private WebElement addWhiteListUserButton;
	
	@FindBy(css = ".whitelist-setting div.tab-content:nth-child(4) .bt-add")
	private WebElement addWhiteListActionButton;
	
	@FindBy(css = ".list-user-name .bt-delete")
	private WebElement deleteWhiteListUserButton;
	
	@FindBy(css = ".list-user-action .bt-delete")
	private WebElement deleteWhiteListActionButton;
	
	//白名单用户container
	@FindBy(css = ".list-user-name li")
	private List<WebElement> wlUserNameContainer;
	
	private By wlUserNameCheckBox = By.cssSelector(".list-user-name li input");
	private By whlUserName = By.cssSelector(".list-user-name li span.whiteName");
	//白名单用户里的页面跳转部分
	@FindBy(css = ".tab-content form .pagination li")
	private List<WebElement> wlUserPageJumpContainer;
	
	//白名单行为container
	@FindBy(css = ".list-user-action li")
	private List<WebElement> wlActionContainer;
	
	private By wlActionCheckBox = By.cssSelector(".list-user-action li input");
	private By wlAction = By.cssSelector(".list-user-name li span.whiteAction");
	//白名单行为里的页面跳转部分
	@FindBy(css = ".tab-content form+div.pagination-all li")
	private List<WebElement> wlActionPageJumpContainer;
	
	/**
	 * 审计日志部分
	 */
	@FindBy(css = ".group-left button")
	private WebElement exportLogsButton;
	
	@FindBy(css = "#logs-keyword")
	private WebElement logsKeyTextField;
	
	@FindBy(css = ".group-right button")
	private WebElement searchLogsButton;
	
	@FindBy(css = ".logsDetail")
	private List<WebElement> logsDetailContainer;
	
	private By date = By.cssSelector(".logsDetail td:first-child");
	private By user = By.cssSelector(".logsDetail td:nth-child(2)");
	private By host = By.cssSelector(".logsDetail td:nth-child(3)");
	private By dateBase = By.cssSelector(".logsDetail td:nth-child(4)");
	private By table = By.cssSelector(".logsDetail td:nth-child(5)");
	private By eequesInstruction = By.cssSelector(".logsDetail td:last-child");
	
	//页面跳转部分
	@FindBy(css = ".logs-container .pagination-all li")
	private List<WebElement> pageJumpContainer;
	
	@FindBy(css = ".pageNum")
	private WebElement pageJumpTextField;
	
	@FindBy(css = ".searchNum")
	private WebElement pageJumpButton;
	
	public WebElement getCurrentIpSelectList() {
		return currentIpSelectList;
	}
	public By getCurrentIpArrow() {
		return currentIpArrow;
	}
	public By getCurrentIpMenuItem() {
		return currentIpMenuItem;
	}
	public WebElement getOperateWhiteListButton() {
		return operateWhiteListButton;
	}
	public WebElement getSetWhiteListUserButton() {
		return setWhiteListUserButton;
	}
	public WebElement getSetWhiteListActionButton() {
		return setWhiteListActionButton;
	}
	public WebElement getAddWhiteListTextField() {
		return addWhiteListTextField;
	}
	public WebElement getAddWhiteListUserButton() {
		return addWhiteListUserButton;
	}
	public WebElement getAddWhiteListActionButton() {
		return addWhiteListActionButton;
	}
	public WebElement getDeleteWhiteListUserButton() {
		return deleteWhiteListUserButton;
	}
	public WebElement getDeleteWhiteListActionButton() {
		return deleteWhiteListActionButton;
	}
	public List<WebElement> getWlUserNameContainer() {
		return wlUserNameContainer;
	}
	public By getWlUserNameCheckBox() {
		return wlUserNameCheckBox;
	}
	public By getWhlUserName() {
		return whlUserName;
	}
	public List<WebElement> getWlUserPageJumpContainer() {
		return wlUserPageJumpContainer;
	}
	public List<WebElement> getWlActionContainer() {
		return wlActionContainer;
	}
	public By getWlActionCheckBox() {
		return wlActionCheckBox;
	}
	public By getWlAction() {
		return wlAction;
	}
	public List<WebElement> getWlActionPageJumpContainer() {
		return wlActionPageJumpContainer;
	}
	public WebElement getExportLogsButton() {
		return exportLogsButton;
	}
	public WebElement getLogsKeyTextField() {
		return logsKeyTextField;
	}
	public WebElement getSearchLogsButton() {
		return searchLogsButton;
	}
	public List<WebElement> getLogsDetailContainer() {
		return logsDetailContainer;
	}
	public By getDate() {
		return date;
	}
	public By getUser() {
		return user;
	}
	public By getHost() {
		return host;
	}
	public By getDateBase() {
		return dateBase;
	}
	public By getTable() {
		return table;
	}
	public By getEequesInstruction() {
		return eequesInstruction;
	}
	public List<WebElement> getPageJumpContainer() {
		return pageJumpContainer;
	}
	public WebElement getPageJumpTextField() {
		return pageJumpTextField;
	}
	public WebElement getPageJumpButton() {
		return pageJumpButton;
	}
	
}
