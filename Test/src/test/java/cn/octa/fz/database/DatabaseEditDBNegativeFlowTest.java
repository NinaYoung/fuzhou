package cn.octa.fz.database;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fz.data.DataBaseData;
import cn.octa.fz.page.extend.DataBasePageExt;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class DatabaseEditDBNegativeFlowTest extends AbstractTest {

	@DataProvider(name = "DatabaseEditDBNegativeFlow")
	public Object[][] provider(){
		return DataFactory.getData(DataBaseData.class, "database/dataBaseEditDBNegativeFlow");
	}
	
	@Test(dataProvider = "DatabaseEditDBNegativeFlow", groups = {"dataBase"})
	public void test(DataBaseData data) throws Exception{
	
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);

		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());

		driver.manage().window().maximize();
		// Go to dataBase page
		DataBasePageExt dataBasePageExt = homePageExt.gotoDataBasePage();
		
	    // Check host list
		dataBasePageExt.checkHostList();
		int hostIndex = dataBasePageExt.getHostIndex(dataBasePageExt.getHOST_IP(), data.getIp());
		dataBasePageExt.showDataBaseList(hostIndex);
		
		// Edit dataBase
		int dbIndex = dataBasePageExt.getDataBaseIndex(dataBasePageExt.getDB_TAG(), data.getDbName());
		if(dbIndex < 0 ){
			dbIndex = 0;
		}
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
