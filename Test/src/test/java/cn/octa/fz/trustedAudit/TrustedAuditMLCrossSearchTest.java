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

public class TrustedAuditMLCrossSearchTest extends AbstractTest {
	
	@DataProvider(name = "TrustedAuditMLCrossSearch")
	public Object[][] provider(){
		return DataFactory.getData(TrustedAuditData.class, "trustedAudit/trustedAuditMLCrossSearch");
	}
	
	@Test(dataProvider = "TrustedAuditMLCrossSearch", groups = {"trustedAudit"})
	public void test(TrustedAuditData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());

		// Go to trusted audit page
		TrustedAuditPageExt trustedAuditPageExt = homePageExt.gotoTrustedAuditPage();

		// Show ML
		trustedAuditPageExt.clickMLShowTab();
		
		// Search PCR
		trustedAuditPageExt.fillMLKeyWordTextField("10");
		trustedAuditPageExt.clickMLSearchButton();
		Thread.sleep(WaitTool.DEFAULT_POLLING_4_ELEMENT);
		
		// Search type
		trustedAuditPageExt.getMlTabSelectList().selectByLabel("类型");
		trustedAuditPageExt.fillMLKeyWordTextField(data.getCompleteData());
		trustedAuditPageExt.clickMLSearchButton();
		Thread.sleep(WaitTool.DEFAULT_POLLING_4_ELEMENT);
		
		// Search 模板哈希
		trustedAuditPageExt.getMlTabSelectList().selectByLabel("模板哈希");
		trustedAuditPageExt.fillMLKeyWordTextField(data.getFuzzyData());
		trustedAuditPageExt.clickMLSearchButton();
		Thread.sleep(WaitTool.DEFAULT_POLLING_4_ELEMENT);
		
		// Search 文件路径
		trustedAuditPageExt.getMlTabSelectList().selectByLabel("文件路径");
		trustedAuditPageExt.fillMLKeyWordTextField(data.getIncorrectData());
		trustedAuditPageExt.clickMLSearchButton();
		Thread.sleep(WaitTool.DEFAULT_POLLING_4_ELEMENT);
		
		// Leave empty in textField, click search button
		trustedAuditPageExt.fillMLKeyWordTextField(null);
		trustedAuditPageExt.clickMLSearchButton();
		Thread.sleep(WaitTool.DEFAULT_POLLING_4_ELEMENT);
	}

}
