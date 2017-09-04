package cn.octa.fz.whitelist;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fz.data.WhiteListData;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;
import cn.octa.fz.page.extend.WhiteListPageExt;

import basicClass.AbstractTest;
import basicTool.StringHelper;
import basicTool.WaitTool;
import dataTool.DataFactory;
import junit.framework.Assert;

public class WhiteListAddDuplicatedWlTest extends AbstractTest {

	@DataProvider(name = "WhiteListAddDuplicatedWl")
	private Object[][] provider(){
		return DataFactory.getData(WhiteListData.class, "whitelist/WhiteListAddDuplicatedWl");
	}
	
	@Test(dataProvider = "WhiteListAddDuplicatedWl", groups = {"whiteList"})
	public void test(WhiteListData data) throws Exception{
		
		String fileHash = StringHelper.getRandomString(40);
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		 
		// Go to whiteList page
		WhiteListPageExt whiteListPageExt = homePageExt.gotoWhiteListPage();
		
		// Click add button
		whiteListPageExt.clickAddButton();
		// Add white list
		whiteListPageExt.fill(data.getHostname(), fileHash, data.getFilepath(), data.getIp());
		whiteListPageExt.clickAddWlConfirmButton();
		Assert.assertTrue(whiteListPageExt.getMsgContentLabel().getText().contains(data.getSuccessMsg()));
		whiteListPageExt.clickConfirmMsgButton();
		driver.navigate().refresh();
		
		// Goto the last page to check if add or not
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, whiteListPageExt.getPageJumpContainer().get(0));
		whiteListPageExt.gotoLastPage();
		WaitTool.waitUnitElementIsInvisible(driver, whiteListPageExt.getLoadingLabel());
		whiteListPageExt.getWlContainer().getElement(whiteListPageExt.getWhiteListContainer().size()-1, whiteListPageExt.getWlHostName()).getText().contains(data.getHostname());
		whiteListPageExt.getWlContainer().getElement(whiteListPageExt.getWhiteListContainer().size()-1, whiteListPageExt.getWlFileHash()).getText().contains(fileHash);
		whiteListPageExt.getWlContainer().getElement(whiteListPageExt.getWhiteListContainer().size()-1, whiteListPageExt.getWlFilePath()).getText().contains(data.getFilepath());
		whiteListPageExt.getWlContainer().getElement(whiteListPageExt.getWhiteListContainer().size()-1, whiteListPageExt.getWlIp()).getText().contains(data.getIp());
		
		// Click add button
		whiteListPageExt.clickAddButton();
		// Add white list 
		whiteListPageExt.fill(data.getHostname(), fileHash, data.getFilepath(), data.getIp());
		whiteListPageExt.clickAddWlConfirmButton();
		Assert.assertTrue(whiteListPageExt.getMsgContentLabel().getText().contains(data.getFailedMsg()));
		whiteListPageExt.clickConfirmMsgButton();
		
	}
}
