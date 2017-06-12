package basicClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * this page is to define elements on the menu
 * @author YN
 *
 */
public class BasePage extends AbstractPage {

	protected BasePage(WebDriver driver) {
		super(driver);
	}
	
	//首页
	@FindBy(css = "a[href*='home']")
	private WebElement homeLink;
	
	//数据库
	@FindBy(css = "a[href*='DataBase']")
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
