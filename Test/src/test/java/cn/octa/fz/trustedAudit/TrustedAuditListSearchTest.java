package cn.octa.fz.trustedAudit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fz.data.TrustedAuditData;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;
import cn.octa.fz.page.extend.TrustedAuditPageExt;

import basicClass.AbstractTest;
import basicTool.WaitTool;
import dataTool.DataFactory;

public class TrustedAuditListSearchTest extends AbstractTest {
	
	/**
	 * fz-13 fz-21 fz-22 fz-23 fz-24 fz-25
	 * 上面六个case统一用这段脚本
	 */
	@DataProvider(name = "TrustedAuditListSearch", parallel = true)
	public Object[][] provider(){
		return DataFactory.getData(TrustedAuditData.class, "trustedAudit/trustedAuditListSearch");
	}
	
	@Test(dataProvider = "TrustedAuditListSearch", groups = {"trustedAudit"})
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
