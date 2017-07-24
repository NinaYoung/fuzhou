package cn.octa.fuzhou.database;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fuzhou.data.DataBaseData;
import cn.octa.fuzhou.page.extend.DataBasePageExt;
import cn.octa.fuzhou.page.extend.HomePageExt;
import cn.octa.fuzhou.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;

public class DatabaseAddDBHappyFlowTest extends AbstractTest {

	@DataProvider(name = "DatabaseAddDBHappyFlow")
	public Object[][] provider(){
		return DataFactory.getData(DataBaseData.class, "database/dataBase");
	}
	
	@Test(dataProvider = "DatabaseAddDBHappyFlow")
	public void test(DataBaseData data) throws Exception{
		
		// Init pages
		LoginPageExt loginPageExt = new LoginPageExt(driver);
		
		// Login
		HomePageExt homePageExt = loginPageExt.loginToHomePage(data.getUsername(), data.getPassword());
		
		// Go to dataBase page
		DataBasePageExt dataBasePageExt = homePageExt.gotoDataBasePage();
		
		// Add dataBase
		dataBasePageExt.clickAddDataBaseButton();
		dataBasePageExt.fillAddDBForm(data.getDbName(), data.getDbType(), data.getIp(), data.getDbPort(), data.getDbUser(), data.getDbPassword());
		dataBasePageExt.clickAddDBConfirmButton();
		
		// Go to host list to check if the dataBase added successfully
		dataBasePageExt.checkHostList();
		int index = dataBasePageExt.getHostIndex(dataBasePageExt.getHOST_IP(), data.getIp());
		System.out.println(index);
		dataBasePageExt.showDataBaseList(index);
	}
}
