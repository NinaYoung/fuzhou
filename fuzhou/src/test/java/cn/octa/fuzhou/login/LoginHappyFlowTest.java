package cn.octa.fuzhou.login;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fuzhou.data.SignUpData;
import cn.octa.fuzhou.page.extend.HomePageExt;
import cn.octa.fuzhou.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class LoginHappyFlowTest extends AbstractTest{

	@DataProvider(name = "LoginHappyFlow")
	public static Object[][]  provider(){
		return  DataFactory.getData(SignUpData.class, "login/login");
	}
		
	@Test(dataProvider = "LoginHappyFlow")
	public void test(SignUpData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver); 
//		HomePageExt homePageExt = new HomePageExt(driver); 
		
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		//WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, homePageExt.getWelcomeButton());
		takeScreenshot(driver.getTitle());
		
//		DataBasePageExt dataBasePageExt = homePageExt.gotoDataBasePage();
//		dataBasePageExt.checkHostList().showDataBaseList(0);
//		dataBasePageExt.generateHostListContainer();
//		
		
		// prepare for moving to canvas
		
//		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, homePageExt.getWelcomeButton());
//		assertTrue(homePageExt.getWelcomeButton().getText().contains(homePageExt.TITLE));
//		
//		Actions action = new Actions(driver);
//		action.moveToElement(homePageExt.getTotalAttackLabel()).click().perform();
		
		
	}
}
