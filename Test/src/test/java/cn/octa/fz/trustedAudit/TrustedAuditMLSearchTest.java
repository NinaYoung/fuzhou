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

/**
 * fz-26 fz-28 fz-29 fz-30 fz-31
 * @author YN
 *
 */
public class TrustedAuditMLSearchTest extends AbstractTest {
	
	@DataProvider(name = "TrustedAuditMLSearch")
	public Object[][] provider(){
		return DataFactory.getData(TrustedAuditData.class, "trustedAudit/trustedAuditMLSearch");
	}
	
	@Test(dataProvider = "TrustedAuditMLSearch", groups = {"trustedAudit"})
	public void test(TrustedAuditData data) throws Exception{
	
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());

		// Go to trusted audit page
		TrustedAuditPageExt trustedAuditPageExt = homePageExt.gotoTrustedAuditPage();
		
		// Show ML
		trustedAuditPageExt.clickMLShowTab();
		
		// Select PCR
		trustedAuditPageExt.getMlTabSelectList().selectByLabel(data.getSearchField());
		
		// Search cnplete data
		trustedAuditPageExt.fillMLKeyWordTextField(data.getCompleteData());
		trustedAuditPageExt.clickMLSearchButton();
		Thread.sleep(WaitTool.DEFAULT_POLLING_4_ELEMENT);
		
		// Search fuzzy data
		trustedAuditPageExt.fillMLKeyWordTextField(data.getFuzzyData());
		trustedAuditPageExt.clickMLSearchButton();
		Thread.sleep(WaitTool.DEFAULT_POLLING_4_ELEMENT);
		
		// Search incorrect data
		trustedAuditPageExt.fillMLKeyWordTextField(data.getIncorrectData());
		trustedAuditPageExt.clickMLSearchButton();
		Thread.sleep(WaitTool.DEFAULT_POLLING_4_ELEMENT);
		
		// Leave empty in textField, click search button
		trustedAuditPageExt.fillMLKeyWordTextField(null);
		trustedAuditPageExt.clickMLSearchButton();
		Thread.sleep(WaitTool.DEFAULT_POLLING_4_ELEMENT);
	}

}
