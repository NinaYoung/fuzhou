package cn.octa.fuzhou.trustedAudit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fuzhou.data.TrustedAuditPageJumpData;
import cn.octa.fuzhou.page.extend.HomePageExt;
import cn.octa.fuzhou.page.extend.LoginPageExt;
import cn.octa.fuzhou.page.extend.TrustedAuditPageExt;

import basicClass.AbstractTest;
import basicTool.WaitTool;
import dataTool.DataFactory;

public class TrustedAuditMLPageJumpTest extends AbstractTest {
	
	@DataProvider(name = "TrustedAuditMLPageJump")
	public Object[][] provider(){
		return DataFactory.getData(TrustedAuditPageJumpData.class, "trustedAudit/pageJump");
	}
	
	@Test(dataProvider = "TrustedAuditMLPageJump")
	public void test(TrustedAuditPageJumpData data) throws Exception{
	
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());

		// Go to trusted audit page
		TrustedAuditPageExt trustedAuditPageExt = homePageExt.gotoTrustedAuditPage();
		
		// Show list tab
		trustedAuditPageExt.clickMLShowTab();
		Thread.sleep(WaitTool.DEFAULT_POLLING_4_ELEMENT);
		
		// Input letters
		trustedAuditPageExt.fillMLPageJumpNum(data.getLetters());
		
		// Input number 0
		trustedAuditPageExt.fillMLPageJumpNum(data.getNum0());
		
		// Input large number
		trustedAuditPageExt.fillMLPageJumpNum(data.getLargeNum());
		
		// Click page jump button, leave text field empty
		trustedAuditPageExt.getMlPageJumpTextField().clear();
		trustedAuditPageExt.clickMLPageJumpButton();
		trustedAuditPageExt.clickMsgOkButton();
		
		// Click "<", no change
		trustedAuditPageExt.mlJumpToPreviousPage();
		
		// Click ">", jump to 2nd page
		trustedAuditPageExt.mlJumpToNextPage();
		
		// Normal jump
		trustedAuditPageExt.fillMLPageJumpNum(data.getCorrectNum());
		trustedAuditPageExt.clickMLPageJumpButton();
		
		// click the last page number
		trustedAuditPageExt.jumpToNumPage(trustedAuditPageExt.getMlPageJumpContainer().get(trustedAuditPageExt.getMlPageJumpContainer().size()-2));
		
		// Click ">", no change
		trustedAuditPageExt.mlJumpToNextPage();
		
		// Click "<", jump to the last page -1
		trustedAuditPageExt.mlJumpToPreviousPage();
	}

}
