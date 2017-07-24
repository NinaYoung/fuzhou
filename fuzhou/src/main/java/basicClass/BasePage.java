package basicClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * this page is to define elements on the menu
 * @author YN
 *
 */
public class BasePage extends AbstractPage{

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	//首页
	@FindBy(css = "a[href*='home']")
	private WebElement homeLink;
	
	//数据库
	@FindBy(css = "a[href*='dataBase']")
	private WebElement dataBaseLink;
	
	//可信审计
	@FindBy(css = "a[href*='environment']")
	private WebElement environmentLink;
	
	//白名单
	@FindBy(css = "a[href*='whitelist']")
	private WebElement whitelistLink;
	
	//插件
	@FindBy(css = "a[href*='plugin']")
	private WebElement pluginLink;
	
	//系统审计
	@FindBy(css = "a[href*='systemCheck']")
	private WebElement systemCheckLink;
	
	//WAF防火墙
	@FindBy(css = "a[href*='WafWall']")
	private WebElement wafWallLink;
	
	//数据库审计
	@FindBy(css = "a[href*='databaseAudit']")
	private WebElement databaseAuditLink;
	
	//全球感知
	@FindBy(css = "a[href*='MapAttack']")
	private WebElement mapAttackLink;
	
	//区块链
	@FindBy(css = "a[href*='BoxLine']")
	private WebElement boxLineLink;
	
	//大数据分析
	@FindBy(css = "a[href*='BigData']")
	private WebElement bigDataLink;
	
    public final String TITLE = "欢迎您";
	
	@FindBy(css = "#basic-nav-dropdown")
	private WebElement welcomeButton;

	@FindBy(css = "ul.dropdown-menu > li:first-child a")
	private WebElement changePasswordButton;
	
	public WebElement getMsgOkButton() {
		return msgOkButton;
	}

	@FindBy(css = "ul.dropdown-menu > li:last-child a")
	private WebElement logoutButton;

	@FindBy(css = "#Password:last-child")
	private WebElement currentPwdTextField;

	@FindBy(css = "input#newPassword:last-child")
	private WebElement newPasswordTextField;
	
	@FindBy(css = "input#confirmPassword:last-child")
	private WebElement confirmPwdTextField;
	
	//修改密码取消按钮
	@FindBy(css = ".modalCancelBtn")
	private WebElement cancelButton;
	
	//修改密码提交按钮
	@FindBy(css = ".modalSubmitBtn")
	private WebElement submitButton;
	
	//修改密码弹框里的关闭按钮
	@FindBy(css = ".close")
	private WebElement xButton;
	
	//修改完密码之后的确认按钮
	@FindBy(css = ".btnOkMsgBox.btnMsgBox")
	private WebElement msgOkButton;
	
	
	public WebElement getBigDataLink() {
		return bigDataLink;
	}

	public String getTITLE() {
		return TITLE;
	}

	public WebElement getWelcomeButton() {
		return welcomeButton;
	}

	public WebElement getChangePasswordButton() {
		return changePasswordButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getCurrentPwdTextField() {
		return currentPwdTextField;
	}

	public WebElement getNewPasswordTextField() {
		return newPasswordTextField;
	}

	public WebElement getConfirmPwdTextField() {
		return confirmPwdTextField;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getxButton() {
		return xButton;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}
	
	public WebElement getDataBaseLink() {
		return dataBaseLink;
	}

	public WebElement getEnvironmentLink() {
		return environmentLink;
	}

	public WebElement getWhitelistLink() {
		return whitelistLink;
	}

	public WebElement getPluginLink() {
		return pluginLink;
	}

	public WebElement getSystemCheckLink() {
		return systemCheckLink;
	}

	public WebElement getWafWallLink() {
		return wafWallLink;
	}

	public WebElement getDatabaseAuditLink() {
		return databaseAuditLink;
	}

	public WebElement getMapAttackLink() {
		return mapAttackLink;
	}

	public WebElement getBoxLineLink() {
		return boxLineLink;
	}
	
}
