package com.octa.fuzhou.trustedAudit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.octa.fuzhou.data.trustedAudit.TrustedAuditPageJumpData;
import com.octa.fuzhou.page.extend.HomePageExt;
import com.octa.fuzhou.page.extend.LoginPageExt;
import com.octa.fuzhou.page.extend.TrustedAuditPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class TrustedAuditListPageJumpTest extends AbstractTest {

	@DataProvider(name = "TrustedAuditListPageJump")
	public Object[][] provider(){
		return DataFactory.getData(TrustedAuditPageJumpData.class, "trustedAudit/pageJump");
	}
	
	@Test(dataProvider = "TrustedAuditListPageJump")
	public void test(TrustedAuditPageJumpData data) throws Exception{
	
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());

		// Go to trusted audit page
		TrustedAuditPageExt trustedAuditPageExt = homePageExt.gotoTrustedAuditPage();
		
		// Show list tab
		trustedAuditPageExt.clickListShowTab();
		
		// Input letters
		trustedAuditPageExt.fillListPageJumpNum(data.getLetters());
		
		// Input number 0
		trustedAuditPageExt.fillListPageJumpNum(data.getNum0());
		
		// Input large number
		trustedAuditPageExt.fillListPageJumpNum(data.getLargeNum());
		
		// Click page jump button, leave text field empty
		trustedAuditPageExt.clickListPageJumpButton();
		trustedAuditPageExt.clickMsgOkButton();
		
		// Click "<", no change
		trustedAuditPageExt.jumpToPreviousPage();
		
		// Click ">", jump to 2nd page
		trustedAuditPageExt.jumpToNextPage();
		
		// Normal jump
		trustedAuditPageExt.fillListPageJumpNum(data.getCorrectNum());
		trustedAuditPageExt.clickListPageJumpButton();
		
		// click the last page number
		trustedAuditPageExt.jumpToNumPage(trustedAuditPageExt.getListPageJumpContainer().get(trustedAuditPageExt.getListPageJumpContainer().size()-2));
		
		// Click ">", no change
		trustedAuditPageExt.jumpToNextPage();
		
		// Click "<", jump to the last page -1
		trustedAuditPageExt.jumpToPreviousPage();
	}
}
