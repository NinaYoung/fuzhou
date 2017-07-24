package cn.octa.fuzhou.page;

import java.awt.MenuItem;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basicTool.WaitTool;
import cn.octa.fuzhou.page.extend.BasePageExt;

public class DataBasePage extends BasePageExt {

	public DataBasePage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, addDataBaseButton);
	}

	/**
	 * add data base
	 */
	@FindBy(css = ".plugAction.databaseBtnAdd")
	private WebElement addDataBaseButton;

	@FindBy(css = ".addDatabaseName")
	private WebElement addDataBaseNameTextField;

	@FindBy(css = ".addDatabaseType")
	private WebElement addDataBaseTypeSelectList;
	
	private By typeArrow = By.cssSelector(".addDatabaseType");
	private By typeMenuItem = By.cssSelector("input.addDatabaseType+div.showExitMsg p");

	@FindBy(css = ".addDatabaseIp")
	private WebElement addDatabaseIpSelectList;
	
	private By ipArrow = By.cssSelector(".addDatabaseIp");
	private By ipMenuItem = By.cssSelector("input.addDatabaseIp+div.showExitMsg p");

	@FindBy(css = ".addDatabasePort")
	private WebElement addDatabasePortTextField;

	@FindBy(css = ".addDatabaseUser")
	private WebElement addDatabaseUserTextField;

	@FindBy(css = ".addDatabasePwd")
	private WebElement addDatabasePwdTextField;

	@FindBy(css = ".addNewDatabase .editBtnCancle.plugAction")
	private WebElement addDataBaseCancelButton;

	@FindBy(css = ".addNewDatabase .editBtnConform.plugAction")
	private WebElement addDataBaseConfirmButton;

	/**
	 * search
	 */
	@FindBy(css = ".my-dropdown-list")
	private WebElement searchSelectList;
	
	private By arrow = By.cssSelector(".my-dropdown-list .select-img");
	private By MenuItem = By.cssSelector(".my-dropdown-list .list-block");
	
	@FindBy(css = ".searchPlugin input")
	private WebElement searchDataBaseTextField;

	@FindBy(css = ".searchGo.plugAction")
	private WebElement searchButton;

	// topology link on tab
	@FindBy(css = "ul.clearfix.databaseListUl li:first-child")
	private WebElement topologyLink;

	// host link on tab
	@FindBy(css = "ul.clearfix.databaseListUl li:last-child")
	private WebElement hostListLink;

	/**
	 * host list container
	 */
	@FindBy(css = ".dataList-content .databaseHostList tr")
	private List<WebElement> hostListContainer;
	// element locate for host list
	private final By HOST_IP = By.cssSelector(".databaseHostList tr td:first-child");
	private final By HOST_TAG = By.cssSelector(".databaseHostList tr td:nth-child(2)");
	private final By HOST_RUNNING_TIME = By.cssSelector(".databaseHostList tr td:nth-child(3)");
	private final By HOST_INPUT_STREAM = By.cssSelector(".databaseHostList tr td:nth-child(7)");
	private final By HOST_OUTPUT_STREAM = By.cssSelector(".databaseHostList tr td:last-child");

	/**
	 * database container
	 */
	@FindBy(css = ".showDatabaseHostList")
	private List<WebElement> dataBaseContainer;
	@FindBy(css = "tbody tr")
	private List<WebElement> dataBaseContentContainer;
	// element locate for database container
	private final By DB_TAG = By.cssSelector(".baseHostList tr td:first-child");
	private final By DB_TYPE = By.cssSelector(".baseHostList tr td:nth-child(2)");
	private final By DB_PORT = By.cssSelector(".baseHostList tr td:nth-child(3)");
	private final By DB_CAPACITY = By.cssSelector(".baseHostList tr td:nth-child(4)");
	private final By DB_EDIT = By.cssSelector(".baseHostList tr td:nth-child(5) button:first-child");
	private final By DB_DELETE = By.cssSelector(".baseHostList tr td:nth-child(5) button:last-child");

	/**
	 * edit database
	 */
	@FindBy(css = ".editDatabaseName")
	private WebElement editDataBaseTextField;

	@FindBy(css = ".editDatabaseUser")
	private WebElement editDatabaseUserTextField;

	@FindBy(css = ".editDatabasePwd")
	private WebElement editDatabasePwdTextField;

	@FindBy(css = ".databaseCover .database-content>div:nth-child(3)>div.editDatabaseCover>div.editDatabase>p:nth-child(6) button:first-child")
	private WebElement editDatabaseCancelButton;

	@FindBy(css = ".databaseCover .database-content>div:nth-child(3)>div.editDatabaseCover>div.editDatabase>p:nth-child(6) button:last-child")
	private WebElement editDatabaseConfirmButton;

	/**
	 * delete database
	 */
	@FindBy(css = ".delDatabaseUser")
	private WebElement deleteDatabaseUserTextField;

	@FindBy(css = ".delDatabasePwd")
	private WebElement deleteDatabasePwdTextField;

	@FindBy(css = ".databaseCover .editDatabase > p:nth-child(5) button:first-child")
	private WebElement deleteDatabaseCancelButton;

	@FindBy(css = ".databaseCover .editDatabase > p:nth-child(5) button:last-child")
	private WebElement deleteDatabaseConfirmButton;

	/**
	 * change page
	 */
	@FindBy(css = ".pagination li")
	private List<WebElement> pageJumpContainer;

	@FindBy(css = "#pageJumpNum")
	private WebElement pageJumpNumTextField;

	@FindBy(css = ".searchNum")
	private WebElement pageJumpButton;

	public WebElement getAddDataBaseButton() {
		return addDataBaseButton;
	}

	public WebElement getSearchDataBaseTextField() {
		return searchDataBaseTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getTopologyLink() {
		return topologyLink;
	}

	public WebElement getHostListLink() {
		return hostListLink;
	}

	public List<WebElement> getHostListContainer() {
		return hostListContainer;
	}

	public List<WebElement> getDataBaseContainer() {
		return dataBaseContainer;
	}

	public By getHOST_IP() {
		return HOST_IP;
	}

	public By getHOST_TAG() {
		return HOST_TAG;
	}

	public By getHOST_RUNNING_TIME() {
		return HOST_RUNNING_TIME;
	}

	public By getHOST_INPUT_STREAM() {
		return HOST_INPUT_STREAM;
	}

	public By getHOST_OUTPUT_STREAM() {
		return HOST_OUTPUT_STREAM;
	}

	public By getDB_TAG() {
		return DB_TAG;
	}

	public By getDB_TYPE() {
		return DB_TYPE;
	}

	public List<WebElement> getDataBaseContentContainer() {
		return dataBaseContentContainer;
	}

	public By getDB_PORT() {
		return DB_PORT;
	}

	public By getDB_CAPACITY() {
		return DB_CAPACITY;
	}

	public By getDB_EDIT() {
		return DB_EDIT;
	}

	public By getDB_DELETE() {
		return DB_DELETE;
	}

	public WebElement getAddDataBaseNameTextField() {
		return addDataBaseNameTextField;
	}

	public WebElement getAddDataBaseTypeSelectList() {
		return addDataBaseTypeSelectList;
	}

	public By getTypeArrow() {
		return typeArrow;
	}

	public By getTypeMenuItem() {
		return typeMenuItem;
	}

	public WebElement getAddDatabaseIpSelectList() {
		return addDatabaseIpSelectList;
	}

	public By getIpArrow() {
		return ipArrow;
	}

	public By getIpMenuItem() {
		return ipMenuItem;
	}

	public WebElement getAddDatabasePortTextField() {
		return addDatabasePortTextField;
	}

	public WebElement getAddDatabaseUserTextField() {
		return addDatabaseUserTextField;
	}

	public WebElement getAddDatabasePwdTextField() {
		return addDatabasePwdTextField;
	}

	public WebElement getAddDataBaseCancelButton() {
		return addDataBaseCancelButton;
	}

	public WebElement getAddDataBaseConfirmButton() {
		return addDataBaseConfirmButton;
	}

	public WebElement getEditDataBaseTextField() {
		return editDataBaseTextField;
	}

	public WebElement getEditDatabaseUserTextField() {
		return editDatabaseUserTextField;
	}

	public WebElement getEditDatabasePwdTextField() {
		return editDatabasePwdTextField;
	}

	public WebElement getEditDatabaseCancelButton() {
		return editDatabaseCancelButton;
	}

	public WebElement getEditDatabaseConfirmButton() {
		return editDatabaseConfirmButton;
	}

	public WebElement getDeleteDatabaseUserTextField() {
		return deleteDatabaseUserTextField;
	}

	public WebElement getDeleteDatabasePwdTextField() {
		return deleteDatabasePwdTextField;
	}

	public WebElement getDeleteDatabaseCancelButton() {
		return deleteDatabaseCancelButton;
	}

	public WebElement getDeleteDatabaseConfirmButton() {
		return deleteDatabaseConfirmButton;
	}

	public List<WebElement> getPageJumpContainer() {
		return pageJumpContainer;
	}

	public WebElement getPageJumpNumTextField() {
		return pageJumpNumTextField;
	}

	public WebElement getPageJumpButton() {
		return pageJumpButton;
	}

	public WebElement getSearchSelectList() {
		return searchSelectList;
	}

	public By getArrow() {
		return arrow;
	}

	public By getMenuItem() {
		return MenuItem;
	}
}
