package cn.octa.fz.database;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fz.data.DataBaseData;
import cn.octa.fz.page.extend.DataBasePageExt;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class DatabaseEditDBHappyFlowTest extends AbstractTest {

	@DataProvider(name = "DatabaseEditDBHappyFlow")
	public Object[][] provider(){
		return DataFactory.getData(DataBaseData.class, "database/dataBaseEditDBHappyFlow");
	}
	
	@Test(dataProvider = "DatabaseEditDBHappyFlow", groups = {"dataBase"})
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
		
//		WaitTool.waitFor(driver, WaitTool.DEFAULT_WAIT_4_ELEMENT, dataBasePageExt.getHostListContainer().get(0));
		int hostIndex = dataBasePageExt.getHostIndex(dataBasePageExt.getHOST_IP(), data.getIp());
		dataBasePageExt.showDataBaseList(hostIndex);
		
		// Edit dataBase
		Thread.sleep(2000);
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
