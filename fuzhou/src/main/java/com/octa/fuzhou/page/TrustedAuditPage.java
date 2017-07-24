package com.octa.fuzhou.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.octa.fuzhou.page.extend.BasePageExt;

import basicTool.WaitTool;

public class TrustedAuditPage extends BasePageExt{

	public TrustedAuditPage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, graphShowLink);
	}

	/**
	 * 图表显示页面元素
	 */
	//图表显示
	@FindBy(css = "#tabs-tab-1")
	private WebElement graphShowLink;
	
	// 搜索选择项
	@FindBy(css = ".graphicDisplay div.sticker div.logs-select:nth-child(2)")
	private WebElement graph2SelectList;

	private By graph2DropdownArrow = By.cssSelector(".graphicDisplay div.sticker div.logs-select:nth-child(2) .select-img");
	private By graph2MenuItem = By.cssSelector(".graphicDisplay div.sticker div.logs-select:nth-child(2) div.list-block li");

	@FindBy(css = ".graphicSaerch")
	private WebElement graphSearchButton;
	
	/**
	 * 列表显示页面元素
	 */
	//列表显示
	@FindBy(css = "#tabs-tab-2")
	private WebElement listShowLink;
	
	@FindBy(css = "#tabs-pane-2 div.sticker div.logs-select:nth-child(3)")
	private WebElement list2SelectList;
	
	private By list2DropdownArrow = By.cssSelector("#tabs-pane-2 div.sticker div.logs-select:nth-child(3) div.select-img");
	private By list2MenuItem = By.cssSelector("#tabs-pane-2 div.sticker div.logs-select:nth-child(3) div.list-block li");
	
	
	@FindBy(css = "#tabs-pane-2 div.sticker div.logs-select:nth-child(2)")
	private WebElement list3SelectList;
	
	private By list3DropdownArrow = By.cssSelector("#tabs-pane-2 div.sticker div.logs-select:nth-child(2) > div.select-img");
	private By list3MenuItem = By.cssSelector("#tabs-pane-2 div.sticker div.logs-select:nth-child(2) div.list-block li");
	
	@FindBy(css = ".listSaerch")
	private WebElement listSearchButton;
	
	//页面跳转部分
	@FindBy(css = "#tabs-pane-2 .pagination li")
	private List<WebElement> listPageJumpContainer;
	
	@FindBy(css = "#tabs-pane-2 .pageNum")
	private WebElement listPageJumpTextField;
	
	@FindBy(css = "#tabs-pane-2 .searchNum")
	private WebElement listPageJumpButton;
	
	/**
	 * ML显示页面元素
	 */
	//ML显示
	@FindBy(css = "#tabs-tab-3")
	private WebElement mlShowLink;
		
	@FindBy(css = "#ml-select-ml .item-selected")
	private WebElement mlSelectList;
	
	private By mlDropdownArrow = By.cssSelector(".ml .my-dropdown-list div.select-img");
	private By mlMenuItem = By.cssSelector(".ml .my-dropdown-list .list-block li");
	
	@FindBy(css = "#mllistKey")
	private WebElement mlKeyWordTextFiled;
	
	@FindBy(css = ".mlSearch")
	private WebElement mlSearchButton;
	
	// 页面跳转部分
	@FindBy(css = "#tabs-pane-3 .pagination li")
	private List<WebElement> mlPageJumpContainer;

	@FindBy(css = "#tabs-pane-3 .pageNum")
	private WebElement mlPageJumpTextField;

	@FindBy(css = "#tabs-pane-3 .searchNum")
	private WebElement mlPageJumpButton;
	
	@FindBy(css = ".btnOkMsgBox.btnMsgBox")
	private WebElement msgOkButton;
	
	public WebElement getMsgOkButton() {
		return msgOkButton;
	}

	public WebElement getGraph2SelectList() {
		return graph2SelectList;
	}

	public By getGraph2DropdownArrow() {
		return graph2DropdownArrow;
	}

	public By getGraph2MenuItem() {
		return graph2MenuItem;
	}

	public WebElement getGraphSearchButton() {
		return graphSearchButton;
	}

	public WebElement getList2SelectList() {
		return list2SelectList;
	}

	public By getList2DropdownArrow() {
		return list2DropdownArrow;
	}

	public By getList2MenuItem() {
		return list2MenuItem;
	}

	public WebElement getList3SelectList() {
		return list3SelectList;
	}

	public By getList3DropdownArrow() {
		return list3DropdownArrow;
	}

	public By getList3MenuItem() {
		return list3MenuItem;
	}

	public WebElement getListSearchButton() {
		return listSearchButton;
	}

	public List<WebElement> getListPageJumpContainer() {
		return listPageJumpContainer;
	}

	public WebElement getListPageJumpTextField() {
		return listPageJumpTextField;
	}

	public WebElement getListPageJumpButton() {
		return listPageJumpButton;
	}

	public WebElement getMlSelectList() {
		return mlSelectList;
	}

	public By getMlDropdownArrow() {
		return mlDropdownArrow;
	}

	public By getMlMenuItem() {
		return mlMenuItem;
	}

	public WebElement getMlKeyWordTextFiled() {
		return mlKeyWordTextFiled;
	}

	public WebElement getMlSearchButton() {
		return mlSearchButton;
	}

	public List<WebElement> getMlPageJumpContainer() {
		return mlPageJumpContainer;
	}

	public WebElement getMlPageJumpTextField() {
		return mlPageJumpTextField;
	}

	public WebElement getMlPageJumpButton() {
		return mlPageJumpButton;
	}
	
	public WebElement getGraphShowLink() {
		return graphShowLink;
	}

	public WebElement getListShowLink() {
		return listShowLink;
	}

	public WebElement getMlShowLink() {
		return mlShowLink;
	}

}
