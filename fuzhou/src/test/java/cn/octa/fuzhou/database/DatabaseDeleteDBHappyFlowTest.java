package cn.octa.fuzhou.database;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fuzhou.data.DataBaseData;
import cn.octa.fuzhou.page.extend.DataBasePageExt;
import cn.octa.fuzhou.page.extend.HomePageExt;
import cn.octa.fuzhou.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class DatabaseDeleteDBHappyFlowTest extends AbstractTest {

	@DataProvider(name = "DatabaseDeleteDBHappyFlow")
	public Object[][] provider(){
		return DataFactory.getData(DataBaseData.class, "database/dataBase");
	}
	
	@Test(dataProvider = "DatabaseDeleteDBHappyFlow")
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
//		int dbIndex = dataBasePageExt.getDataBaseIndex(dataBasePageExt.getDB_TAG(), data.getDbName());
		dataBasePageExt.clickDataBaseButton(hostIndex, dataBasePageExt.getDB_DELETE(), data.getDbIndex());
		dataBasePageExt.fillDeleteDBForm(data.getDbUser(), data.getDbPassword());
		dataBasePageExt.clickDeleteDBConfirmButton();
		
		// if topogy page is displayed after deleting, goto check host list again
		if(dataBasePageExt.getTopologyLink().getAttribute("class").contains("base-select")){
			dataBasePageExt.checkHostList();
			dataBasePageExt.showDataBaseList(hostIndex);
		}
	}
}
