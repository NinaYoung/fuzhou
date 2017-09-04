package cn.octa.fz.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicClass.BasePage;
import basicTool.WaitTool;

public class WhiteListPage extends BasePage {

	public WhiteListPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, addWhiteListButton);
	}

	@FindBy(css = "#whiteListTitle")
	private WebElement addWhiteListButton;
	
	@FindBy(css = ".btn.btn-sm.btn-default")
	private WebElement deleteWhiteListButton;
	
	/**
	 * 主机名 下拉菜单
	 */
	@FindBy(css = ".whitelist div.sticker div.logs-select:nth-child(4)")
	private WebElement whiteListSelectList;
	
	private By whiteListDropdownArrow = By.cssSelector(".whitelist div.sticker div.logs-select:nth-child(4) .select-img");
	private By whiteListMenuItem = By.cssSelector(".whitelist div.sticker div.logs-select:nth-child(4) div.list-block li");
	
	@FindBy(css = "#whitelistKey")
	private WebElement whiteListKeyTextField;
	
	@FindBy(css = ".whiteListSearch.btn.btn-sm.btn-primary")
	private WebElement whiteListSearchButton;
	
	@FindBy(css = ".whiteListTable .thead .select-all")
	private WebElement selectAllCheckBox;
	
	/**
	 * 白名单Container
	 */
	@FindBy(css = ".clearfix .white-tr")
	private List<WebElement> whiteListContainer;
	//container内的多选框
	private By whiteListCheckBox = By.cssSelector(".clearfix .white-tr .select-all");
	//序号
	private By wlIndex = By.cssSelector(".clearfix .wl-index");
	//主机名
	private By wlHostName = By.cssSelector(".clearfix .wl-type");
	//文件（数据）哈希
	private By wlFileHash = By.cssSelector(".clearfix .wl-filedata-num");
	//文件路径
	private By wlFilePath = By.cssSelector(".clearfix .wl-filename-hint");
	//IP
	private By wlIp = By.cssSelector(".clearfix .wl-ip");
	//Edit button
	private By wlEditButton = By.cssSelector(".clearfix .img-write");
	//Delete Button
	private By wlDeleteButton = By.cssSelector(".clearfix .img-delete");
	
	/**
	 * 页面跳转部分
	 */
	@FindBy(css = ".pagination li")
	private List<WebElement> pageJumpContainer;
	
	@FindBy(css = ".pageNum")
	private WebElement pageJumpTextField;
	
	@FindBy(css = ".searchNum")
	private WebElement pageJumpButton;
	
	/**
	 * 添加白名单
	 */
	//主机名
	@FindBy(css = "#newName")
	private WebElement addWlHostNameTextField;
	//文件哈希
	@FindBy(css = "#newText")
	private WebElement addWlFileHashTextField;
	//文件路径
	@FindBy(css = "#newUrl")
	private WebElement addWlFilePathTextField;
	//IP
	@FindBy(css = "#newIP")
	private WebElement addWlIpTextField;
	
	@FindBy(css = ".modalSubmitBtn.btn.btn-xs.btn-primary")
	private WebElement addWlConfirmButton;
	
	@FindBy(css = ".modalCancelBtn.btn.btn-xs.btn-default")
	private WebElement addWlCancelButton;
	
	// Msg
	@FindBy(css = "div.whitelist+div .messageBox .msgContent")
	private WebElement msgContentLabel;
    // Confirm msg button
	@FindBy(css = ".btnOkMsgBox.btnMsgBox")
	private WebElement confirmButton;
	
	// loading 
	private By loadingLabel = By.cssSelector(".loadingText");

	// Error msg
	@FindBy(css = "#hostName")
	private WebElement hostNameMsgLabel;
	
	@FindBy(css = "#hashName")
	private WebElement fileHashMsgLabel;
	
	@FindBy(css = "#urlName")
	private WebElement filePathMsgLabel;
	
	@FindBy(css = "#ipName")
	private WebElement ipMsgLabel;
	
	@FindBy(css = "#header")
	private WebElement headerLabel;
	
	public By getLoadingLabel() {
		return loadingLabel;
	}

	public WebElement getHostNameMsgLabel() {
		return hostNameMsgLabel;
	}

	public WebElement getFileHashMsgLabel() {
		return fileHashMsgLabel;
	}

	public WebElement getFilePathMsgLabel() {
		return filePathMsgLabel;
	}

	public WebElement getIpMsgLabel() {
		return ipMsgLabel;
	}

	public WebElement getHeaderLabel() {
		return headerLabel;
	}

	public WebElement getConfirmButton() {
		return confirmButton;
	}

	public WebElement getMsgContentLabel() {
		return msgContentLabel;
	}

	public WebElement getAddWlHostNameTextField() {
		return addWlHostNameTextField;
	}

	public WebElement getAddWlFileHashTextField() {
		return addWlFileHashTextField;
	}

	public WebElement getAddWlFilePathTextField() {
		return addWlFilePathTextField;
	}

	public WebElement getAddWlIpTextField() {
		return addWlIpTextField;
	}

	public WebElement getAddWlConfirmButton() {
		return addWlConfirmButton;
	}

	public WebElement getAddWlCancelButton() {
		return addWlCancelButton;
	}

	public WebElement getAddWhiteListButton() {
		return addWhiteListButton;
	}

	public WebElement getDeleteWhiteListButton() {
		return deleteWhiteListButton;
	}

	public WebElement getWhiteListSelectList() {
		return whiteListSelectList;
	}

	public By getWhiteListDropdownArrow() {
		return whiteListDropdownArrow;
	}

	public By getWhiteListMenuItem() {
		return whiteListMenuItem;
	}

	public WebElement getWhiteListKeyTextField() {
		return whiteListKeyTextField;
	}

	public WebElement getWhiteListSearchButton() {
		return whiteListSearchButton;
	}

	public WebElement getSelectAllCheckBox() {
		return selectAllCheckBox;
	}

	public List<WebElement> getWhiteListContainer() {
		return whiteListContainer;
	}

	public By getWhiteListCheckBox() {
		return whiteListCheckBox;
	}

	public By getWlIndex() {
		return wlIndex;
	}

	public By getWlHostName() {
		return wlHostName;
	}

	public By getWlFileHash() {
		return wlFileHash;
	}

	public By getWlFilePath() {
		return wlFilePath;
	}

	public By getWlIp() {
		return wlIp;
	}

	public By getWlEditButton() {
		return wlEditButton;
	}

	public By getWlDeleteButton() {
		return wlDeleteButton;
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
