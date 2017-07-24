package com.octa.fuzhou.database;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.octa.fuzhou.data.database.DataBaseData;
import com.octa.fuzhou.page.extend.DataBasePageExt;
import com.octa.fuzhou.page.extend.HomePageExt;
import com.octa.fuzhou.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class DatabaseEditDBNegativeFlowTest extends AbstractTest {

	@DataProvider(name = "DatabaseEditDBNegativeFlow")
	public Object[][] provider(){
		return DataFactory.getData(DataBaseData.class, "database/dataBase");
	}
	
	@Test(dataProvider = "DatabaseEditDBNegativeFlow")
	public void test(DataBaseData data) throws Exception{
	
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());

		// Go to dataBase page
		DataBasePageExt dataBasePageExt = homePageExt.gotoDataBasePage();
		
	    // Check host list
		dataBasePageExt.checkHostList();
		int hostIndex = dataBasePageExt.getHostIndex(dataBasePageExt.getHOST_IP(), data.getIp());
		dataBasePageExt.showDataBaseList(hostIndex);
		
		// Edit dataBase
		int dbIndex = dataBasePageExt.getDataBaseIndex(dataBasePageExt.getDB_TAG(), data.getDbName());
		dataBasePageExt.clickDataBaseButton(hostIndex, dataBasePageExt.getDB_EDIT(), dbIndex);
		
		// Click confirm button but leave text fields empty
		dataBasePageExt.clickEditDBConfirmButton();
		
		// Leave dbUser and dbPwd empty
		dataBasePageExt.fillEditDBForm(data.getEditName(), null, null);
		dataBasePageExt.clickEditDBConfirmButton();
		
		// Invalid dbName
//		dataBasePageExt.fillEditDBForm(data.getInvalidDbName(), data.getDbUser(), data.getDbPassword());
//		dataBasePageExt.clickEditDBConfirmButton();
		
		// Incorrect password
		dataBasePageExt.fillEditDBForm(data.getEditName(), data.getDbUser(), data.getId());
		dataBasePageExt.clickEditDBConfirmButton();
		
		// Incorrect dbName
		dataBasePageExt.fillEditDBForm(data.getEditName(), data.getId(), data.getDbPassword());
		dataBasePageExt.clickEditDBConfirmButton();
		
		dataBasePageExt.clickEditCancelButton();
	}
}
