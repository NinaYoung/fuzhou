package com.octa.fuzhou.database;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.octa.fuzhou.data.database.DataBaseData;
import com.octa.fuzhou.page.extend.DataBasePageExt;
import com.octa.fuzhou.page.extend.HomePageExt;
import com.octa.fuzhou.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import basicTool.WaitTool;
import dataTool.DataFactory;

public class DatabaseEditDBHappyFlowTest extends AbstractTest {

	@DataProvider(name = "DatabaseEditDBHappyFlow")
	public Object[][] provider(){
		return DataFactory.getData(DataBaseData.class, "database/dataBase");
	}
	
	@Test(dataProvider = "DatabaseEditDBHappyFlow")
	public void test(DataBaseData data) throws Exception{
	
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());

		// Go to dataBase page
		DataBasePageExt dataBasePageExt = homePageExt.gotoDataBasePage();
		
	    // Check host list
		dataBasePageExt.checkHostList();
		
//		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, dataBasePageExt.getHostListContainer().get(0));
		int hostIndex = dataBasePageExt.getHostIndex(dataBasePageExt.getHOST_IP(), data.getIp());
		dataBasePageExt.showDataBaseList(hostIndex);
		
		// Edit dataBase
		dataBasePageExt.clickDataBaseButton(hostIndex, dataBasePageExt.getDB_EDIT(), data.getDbIndex());
		dataBasePageExt.fillEditDBForm(data.getEditName()+System.currentTimeMillis(), data.getDbUser(), data.getDbPassword());
		dataBasePageExt.clickEditDBConfirmButton();
		
		// if topogy page is displayed after editing, goto check host list again
		if(dataBasePageExt.getTopologyLink().getAttribute("class").contains("base-select")){
			dataBasePageExt.checkHostList();
			dataBasePageExt.showDataBaseList(hostIndex);
		}
		
	}
}
