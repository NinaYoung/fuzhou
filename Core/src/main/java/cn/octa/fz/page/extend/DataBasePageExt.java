package cn.octa.fz.page.extend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basicTool.Container;
import basicTool.SelectList;
import cn.octa.fz.page.DataBasePage;

public class DataBasePageExt extends DataBasePage {
	
	Container hostListContainer = null;
	Container dataBaseContainer = null;
	SelectList typeSelectList = null;
	SelectList ipSelectList = null;

	public DataBasePageExt(WebDriver driver) {
		super(driver);
		hostListContainer = new Container(getHostListContainer());
		dataBaseContainer = new Container(getDataBaseContainer());
		typeSelectList = new SelectList(driver, getAddDataBaseTypeSelectList(), getTypeMenuItem(), getTypeArrow());
		ipSelectList = new SelectList(driver, getAddDatabaseIpSelectList(), getIpMenuItem(), getIpArrow());
	}

	/**
	 * click topology on the tab
	 * @return
	 * @throws Exception
	 */
    public DataBasePageExt checkTopology() throws Exception{
    	return click(getTopologyLink(), DataBasePageExt.class);
    }
	/**
	 * click host list on the tab
	 * @return
	 * @throws Exception
	 */
    public DataBasePageExt checkHostList() throws Exception{
    	return click(getHostListLink(), DataBasePageExt.class);
    }
    
    /**
     * get index of this ip
     * @param by
     * @param ip
     * @return
     */
    public int getHostIndex(By by, String ip){
    	return hostListContainer.getElementIndexByText(by, ip);
    }
    
    /**
     * get index of this dbName
     * @param by
     * @param dbName
     * @return
     */
    public int getDataBaseIndex(By by, String dbName){
    	return dataBaseContainer.getElementIndexByText(by, dbName);
    }
    /**
     * expand host list to show database list
     * @param index  
     *         the index of host
     * @return
     * @throws Exception
     */
    public DataBasePageExt showDataBaseList(int index) throws Exception{
    	return click(getHostListContainer().get(index), DataBasePageExt.class);
    }
	
//    /**
//     * generate host list container
//     */
//	public void generateHostListContainer(){
//		hostListContainer = new Container(getHostListContainer());
//	}
//	
//	/**
//     * generate data base container
//     */
//	public void generateDataBaseContainer(){
//		dataBaseContainer = new Container(getDataBaseContainer());
//	}
	
    /**
     * click add data base button
     * @return
     * @throws Exception
     */
    public DataBasePageExt clickAddDataBaseButton() throws Exception{
    	return click(getAddDataBaseButton(), DataBasePageExt.class);
    }

    /**
     * @param dbName
     *           - the dataBase name you want to add
     * @param dbType
     *           - the dataBase type
     * @param ip
     *           - the host ip that host the database
     * @param port
     *           - the port
     * @param dbUser
     *           - the dataBase user name
     * @param dbPassword
     *           - the dataBase password
     * @return DataBasePageExt
     * @throws Exception
     */
    public DataBasePageExt fillAddDBForm(String dbName, String dbType, String ip, String port, String dbUser, String dbPassword) throws Exception{
    	
    	getAddDataBaseNameTextField().sendKeys(dbName);
    	typeSelectList.selectByLabel(dbType);
    	ipSelectList.selectByLabel(ip);
    	
    	getAddDatabasePortTextField().sendKeys(port);
    	getAddDatabaseUserTextField().sendKeys(dbUser);
    	getAddDatabasePwdTextField().sendKeys(dbPassword);
    	
    	return this;
    }
    
    /**
     * click add db confirm button
     * @return
     * @throws Exception
     */
    public DataBasePageExt clickAddDBConfirmButton() throws Exception{
    	return click(getAddDataBaseConfirmButton(), DataBasePageExt.class);
    }
    
    /**
     * click edit button at specified index
     * @param by
     * @param index
     * @return
     * @throws Exception
     */
    public DataBasePageExt clickDataBaseButton(int hostIndex, By by, int index) throws Exception{
    	WebElement element = getDataBaseContainer().get(hostIndex).findElements(by).get(index);
    	return click(element, DataBasePageExt.class);
    }
    
    /**
     * fill edit data base form
     * @param newName
     *          - the database name you want to change to
     * @param dbUser
     *          - dataBase manager username
     * @param dbPassword
     *          - dataBase manager password
     * @return
     */
    public DataBasePageExt fillEditDBForm(String newName, String dbUser, String dbPassword){
    	
    	getEditDataBaseTextField().sendKeys(newName);
    	getEditDatabaseUserTextField().sendKeys(dbUser);
    	getEditDatabasePwdTextField().sendKeys(dbPassword);
    	
    	return this;
    }
    
    /**
     * click edit dataBase confirm button
     * @return
     * @throws Exception
     */
    public DataBasePageExt clickEditDBConfirmButton() throws Exception{
    	return click(getEditDatabaseConfirmButton(), DataBasePageExt.class);
    }
    
    /**
     * fill delete dataBase form
     * @param dbUser
     *          - dataBase manager username
     * @param dbPassword
     *          - dataBase manager password
     * @return
     */
    public DataBasePageExt fillDeleteDBForm(String dbUser, String dbPassword){
    	
    	getDeleteDatabaseUserTextField().sendKeys(dbUser);
    	getDeleteDatabasePwdTextField().sendKeys(dbPassword);
    	
    	return this;
    }
    
    /**
     * click delete dataBase confirm button
     * @return
     * @throws Exception
     */
    public DataBasePageExt clickDeleteDBConfirmButton() throws Exception{
    	return click(getDeleteDatabaseConfirmButton(), DataBasePageExt.class);
    }
    
    /**
     * click cancel button to cancel edit dataBase
     * @return
     * @throws Exception
     */
    public DataBasePageExt clickEditCancelButton() throws Exception{
    	return click(getEditDatabaseCancelButton(), DataBasePageExt.class);
    }
    
    /**
     * click cancel button to cancel delete dataBase
     * @return
     * @throws Exception
     */
    public DataBasePageExt clickDeleteDBCancelButton() throws Exception{
    	return click(getDeleteDatabaseCancelButton(), DataBasePageExt.class);
    }
}

