package cn.octa.fz.database;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.octa.fz.data.DataBaseData;
import cn.octa.fz.page.extend.DataBasePageExt;
import cn.octa.fz.page.extend.HomePageExt;
import cn.octa.fz.page.extend.LoginPageExt;

import basicClass.AbstractTest;
import dataTool.DataFactory;
import junit.framework.Assert;

public class DatabaseDeleteDBNegativeFlowTest extends AbstractTest {

	@DataProvider(name = "DatabaseDeleteDBNegativeFlow")
	public Object[][] provider(){
		return DataFactory.getData(DataBaseData.class, "database/dataBaseDeleteDBNegativeFlow");
	}
	
	@Test(dataProvider = "DatabaseDeleteDBNegativeFlow", groups = {"dataBase"})
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
		
		// Delete dataBase
		dataBasePageExt.clickDataBaseButton(hostIndex, dataBasePageExt.getDB_DELETE(), data.getDbIndex());
		
		// Click confirm button but leave text fields empty
		dataBasePageExt.clickDeleteDBConfirmButton();
		Assert.assertTrue(dataBasePageExt.getErrorMsgLabel().getText().contains(data.getDelMsg()));
		
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
