package cn.octa.fuzhou.whitelist;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fuzhou.data.WhiteListData;
import cn.octa.fuzhou.page.extend.HomePageExt;
import cn.octa.fuzhou.page.extend.LoginPageExt;
import cn.octa.fuzhou.page.extend.WhiteListPageExt;

import basicClass.AbstractTest;
import basicTool.WaitTool;
import dataTool.DataFactory;
import junit.framework.Assert;

public class WhiteListAddHappyFlowTest extends AbstractTest {

	@DataProvider(name = "WhiteListAddHappyFlow")
	private Object[][] provider(){
		return DataFactory.getData(WhiteListData.class, "whitelist/whitelist");
	}
	
	@Test(dataProvider = "WhiteListAddHappyFlow")
	public void test(WhiteListData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		
		// Go to whiteList page
		WhiteListPageExt whiteListPageExt = homePageExt.gotoWhiteListPage();
		
		// Click add button
		whiteListPageExt.clickAddButton();
		// Add white list
		whiteListPageExt.fill(data.getHostname(), data.getFilehash(), data.getFilepath(), data.getIp());
		whiteListPageExt.clickAddWlConfirmButton();
		Assert.assertTrue(whiteListPageExt.getMsgContentLabel().getText().contains(data.getSuccessMsg()));
		whiteListPageExt.clickConfirmMsgButton();
		driver.navigate().refresh();
		
		// Goto the last page to check if add or not
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, whiteListPageExt.getPageJumpContainer().get(0));
		whiteListPageExt.gotoLastPage();
		WaitTool.waitUnitElementIsInvisible(driver, whiteListPageExt.getLoadingLabel());
	}
}
