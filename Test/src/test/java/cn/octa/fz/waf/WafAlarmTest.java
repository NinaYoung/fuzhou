package cn.octa.fz.waf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basicClass.AbstractData;
import basicClass.AbstractTest;
import basicClass.SecurityLevel;
import basicTool.WaitTool;
import cn.octa.fz.data.WafAttackData;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;
import cn.octa.fz.page.extend.WAFPageExt;
import dataTool.DataFactory;
import dvwa.DVWABasePageExt;
import dvwa.DVWALoginPage;
import dvwa.DVWALoginPageExt;
import dvwa.DVWASecurityPageExt;
import dvwa.DVWASqliPageExt;

public class WafAlarmTest extends AbstractTest {
	
	@DataProvider(name = "alarm", parallel = true)
	public Object[][] provider(){
		return DataFactory.getData(WafAttackData.class, "waf/alarm");
	}

	@Test(dataProvider = "alarm", groups = {"waf"})
	public void test(WafAttackData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		
		// Go to Waf page
		WAFPageExt wafPageExt = homePageExt.gotoWafPage();
		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, wafPageExt.getRadarLabel());
		
		// Record data in radar graph
		wafPageExt.getRadarLabel().click();
		String attackDetails = wafPageExt.getRadarAttackDetailsLabel().getText();
		String attack[] = attackDetails.split("\r\n");
		System.out.println(attackDetails);
		for(int i=0; i<attack.length; i++){
			System.err.println(attack[i]);
		}
		
        // Change status to alarm
		wafPageExt.clickSetDefenceButton();
		wafPageExt.changeDefenceStatus(data.getHostname(), data.getStatus());
		if(wafPageExt.getMsgConfirmButton().isDisplayed())
		       wafPageExt.confirmMsg();
		
		
		// DVWA 
		driver.get(AbstractData.getDvwaUrl());
		DVWALoginPageExt dvwaLoginPageExt = new DVWALoginPageExt(driver);
		DVWABasePageExt dvwaBasePageExt = dvwaLoginPageExt.login();//java.lang.IllegalAccessException: Class basicClass.AbstractPage can not access a member of class dvwa.DVWABasePageExt with modifiers "protected"
		DVWASecurityPageExt  dvwaSecurityPageExt = dvwaBasePageExt.gotoSecurityPage();
		dvwaSecurityPageExt.changeLevel(SecurityLevel.LOW.toString());
		DVWASqliPageExt dvwaSqliPageExt = dvwaSecurityPageExt.getDvwaBasePageExt().gotoSqliPage();
		dvwaSqliPageExt.sqlInjection();
		
	}
}
