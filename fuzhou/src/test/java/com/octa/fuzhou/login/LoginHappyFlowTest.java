package com.octa.fuzhou.login;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.octa.fuzhou.data.signup.SignUpData;
import com.octa.fuzhou.page.extend.HomePageExt;
import com.octa.fuzhou.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import basicTool.WaitTool;
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
		
		// prepare for moving to canvas
		
//		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, homePageExt.getWelcomeButton());
//		assertTrue(homePageExt.getWelcomeButton().getText().contains(homePageExt.TITLE));
//		
//		Actions action = new Actions(driver);
//		action.moveToElement(homePageExt.getTotalAttackLabel()).click().perform();
		
		
	}
}
