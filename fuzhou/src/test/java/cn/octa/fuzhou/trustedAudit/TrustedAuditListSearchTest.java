package cn.octa.fuzhou.trustedAudit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fuzhou.data.TrustedAuditData;
import cn.octa.fuzhou.page.extend.HomePageExt;
import cn.octa.fuzhou.page.extend.LoginPageExt;
import cn.octa.fuzhou.page.extend.TrustedAuditPageExt;

import basicClass.AbstractTest;
import basicTool.WaitTool;
import dataTool.DataFactory;

public class TrustedAuditListSearchTest extends AbstractTest {
	
	/**
	 * fz-13 fz-21 fz-22 fz-23 fz-24 fz-25
	 * 上面六个case统一用这段脚本
	 */
	@DataProvider(name = "TrustedAuditListSearch")
	public Object[][] provider(){
		return DataFactory.getData(TrustedAuditData.class, "trustedAudit/trustedAudit");
	}
	
	@Test(dataProvider = "TrustedAuditListSearch")
	public void test(TrustedAuditData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		
		// Go to trusted audit page
		TrustedAuditPageExt trustedAuditPageExt = homePageExt.gotoTrustedAuditPage();
		
		// Show list tab
		trustedAuditPageExt.clickListShowTab();
		
		// Select Web Backend
		trustedAuditPageExt.getListTab2SelectList().selectByLabel(data.getSearchField());
		
		// Loop the 3rd selectList 
		int optionLength = trustedAuditPageExt.getListTab3SelectList().getAllAvailableOptions().size();
		for(int i = 0; i < optionLength; i++){
			trustedAuditPageExt.getListTab3SelectList().selectByIndex(i);
			trustedAuditPageExt.clickListSearchButton();
			WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, trustedAuditPageExt.getListSearchButton());
		}
	}

}
