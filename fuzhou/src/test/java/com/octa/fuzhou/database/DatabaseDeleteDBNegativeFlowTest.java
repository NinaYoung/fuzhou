package com.octa.fuzhou.database;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.octa.fuzhou.data.database.DataBaseData;
import com.octa.fuzhou.page.extend.DataBasePageExt;
import com.octa.fuzhou.page.extend.HomePageExt;
import com.octa.fuzhou.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class DatabaseDeleteDBNegativeFlowTest extends AbstractTest {

	@DataProvider(name = "DatabaseDeleteDBNegativeFlow")
	public Object[][] provider(){
		return DataFactory.getData(DataBaseData.class, "database/dataBase");
	}
	
	@Test(dataProvider = "DatabaseDeleteDBNegativeFlow")
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
		
		// Delete dataBase
		dataBasePageExt.clickDataBaseButton(hostIndex, dataBasePageExt.getDB_DELETE(), data.getDbIndex());
		
		// Click confirm button but leave text fields empty
		dataBasePageExt.clickDeleteDBConfirmButton();
		
		// Incorrect user and password
		dataBasePageExt.fillDeleteDBForm(data.getId(), data.getId());
		dataBasePageExt.clickDeleteDBConfirmButton();
		
		// Correct user, leave password empty
		dataBasePageExt.fillDeleteDBForm(data.getDbUser(), null);
		dataBasePageExt.clickDeleteDBConfirmButton();
		
		// Leave user empty, correct password
		dataBasePageExt.fillDeleteDBForm(null, data.getDbPassword());
		dataBasePageExt.clickDeleteDBConfirmButton();
		
		// Correct user, Incorrect password
		dataBasePageExt.fillDeleteDBForm(data.getDbUser(), data.getId());
		dataBasePageExt.clickDeleteDBConfirmButton();
		
		// Incorrect user, correct password
		dataBasePageExt.fillDeleteDBForm(data.getId(), data.getDbPassword());
		dataBasePageExt.clickDeleteDBConfirmButton();
		
		dataBasePageExt.clickDeleteDBCancelButton();
		
	}
}
