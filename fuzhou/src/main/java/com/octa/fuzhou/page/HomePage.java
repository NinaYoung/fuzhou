package com.octa.fuzhou.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.octa.fuzhou.page.extend.BasePageExt;

import basicTool.WaitTool;

public class HomePage extends BasePageExt{

	public HomePage(WebDriver driver) {
		super(driver);
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, repairButton);
	}
	
	//每日拦截威胁次数图表
	@FindBy(css = "#Totalattack canvas")
	private WebElement totalAttackLabel;
	
	//攻击类型统计
	@FindBy(css = "#typeAttack canvas")
	private WebElement typeAttackLabel;
	
	//地理位置相关图标
	@FindBy(css = "#worldMap canvas")
	private WebElement worldMapLabel;
	
	//攻击来源占比图表
	@FindBy(css = "#first-chart canvas")
	private WebElement attackSourceLabel;
	
	//防御安全雷达图
	@FindBy(css = "#radarChart canvas")
	private WebElement radarChartLabel;
	
	//可信修复
	@FindBy(css = ".repair a")
	private WebElement repairButton;
	
	//可信优化
	@FindBy(css = ".optimize a")
	private WebElement optimizeButton;
	
	//修复漏洞
	@FindBy(css = ".loophole a")
	private WebElement loopholeButton;
	
	//pullHeader 部分的可信修复，可信优化，修复漏洞按钮
	@FindBy(css = ".pullHeader div.operation a:first-child")
	private WebElement repairPullHeaderButton;
	
	@FindBy(css = ".pullHeader div.operation a:nth-child(2)")
	private WebElement optimizePullHeaderButton;
	
	@FindBy(css = ".pullHeader div.operation a:last-child")
	private WebElement loopholePullHeaderButton;
	
	//右下角全球云健康球
	@FindBy(css = ".totalScoreBox div.map-score")
	private WebElement mapScoreLabel;
	
	public WebElement getTypeAttackLabel() {
		return typeAttackLabel;
	}
	public WebElement getWorldMapLabel() {
		return worldMapLabel;
	}
	public WebElement getRadarChartLabel() {
		return radarChartLabel;
	}
	public WebElement getTotalAttackLabel() {
		return totalAttackLabel;
	}
	public String getTITLE() {
		return TITLE;
	}
	public WebElement getAttackSourceLabel() {
		return attackSourceLabel;
	}
	public WebElement getRepairButton() {
		return repairButton;
	}
	public WebElement getOptimizeButton() {
		return optimizeButton;
	}
	public WebElement getLoopholeButton() {
		return loopholeButton;
	}
	public WebElement getRepairPullHeaderButton() {
		return repairPullHeaderButton;
	}
	public WebElement getOptimizePullHeaderButton() {
		return optimizePullHeaderButton;
	}
	public WebElement getLoopholePullHeaderButton() {
		return loopholePullHeaderButton;
	}
	public WebElement getMapScoreLabel() {
		return mapScoreLabel;
	}
	
}
