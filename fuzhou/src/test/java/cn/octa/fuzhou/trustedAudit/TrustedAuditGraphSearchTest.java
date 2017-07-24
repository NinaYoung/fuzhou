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

public class TrustedAuditGraphSearchTest extends AbstractTest {

	@DataProvider(name = "TrustedAuditGraphSearch")
	public Object[][] provider(){
		return DataFactory.getData(TrustedAuditData.class, "trustedAudit/trustedAudit");
	}
	
	@Test(dataProvider = "TrustedAuditGraphSearch")
	public void test(TrustedAuditData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		
		// Go to trusted audit page
		TrustedAuditPageExt trustedAuditPageExt = homePageExt.gotoTrustedAuditPage();
		
		int optionLength = trustedAuditPageExt.getGraphTab2SelectList().getAllAvailableOptions().size();
		for(int i = 0; i < optionLength; i++){
			trustedAuditPageExt.getGraphTab2SelectList().selectByIndex(i);
			trustedAuditPageExt.clickGraphSeachButton();
			WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, trustedAuditPageExt.getGraphSearchButton());
		}
	}
}
