package com.octa.fuzhou.page.extend;

import org.openqa.selenium.WebDriver;

import com.octa.fuzhou.page.WhiteListPage;

public class WhiteListPageExt extends WhiteListPage {

	public WhiteListPageExt(WebDriver driver) {
		super(driver);
	}

	/**
	 * click add white list button
	 * @return
	 * @throws Exception
	 */
	public WhiteListPageExt clickAddButton() throws Exception{
		return click(getAddWhiteListButton(), WhiteListPageExt.class);
	}
	
	/**
	 * fill add-white-list form
	 * @param hostName
	 *          -  host name
	 * @param fileHash
	 *          -  file hash
	 * @param filePath
	 *          -  file path
	 * @param ip
	 *          -  ip
	 */
	public void fill(String hostName, String fileHash, String filePath, String ip){
		
		getAddWlHostNameTextField().clear();
		getAddWlHostNameTextField().sendKeys(hostName);
		getAddWlFileHashTextField().clear();
		getAddWlFileHashTextField().sendKeys(fileHash);
		getAddWlFilePathTextField().clear();
		getAddWlFilePathTextField().sendKeys(filePath);
		getAddWlIpTextField().clear();
		getAddWlIpTextField().sendKeys(ip);
		
	}
	
	/**
	 * click confirm button to add a new white list
	 * @return
	 * @throws Exception
	 */
	public WhiteListPageExt clickAddWlConfirmButton() throws Exception{
		return click(getAddWlConfirmButton(), WhiteListPageExt.class);
	}
	
	/**
	 * click confirm button to cancel add a new white list
	 * @return
	 * @throws Exception
	 */
	public WhiteListPageExt clickAddWlCancelButton() throws Exception{
		return click(getAddWlCancelButton(), WhiteListPageExt.class);
	}
	
	/**
	 * go to the last page of white list
	 * @return
	 * @throws Exception
	 */
	public WhiteListPageExt gotoLastPage() throws Exception{
		return click(getPageJumpContainer().get(getPageJumpContainer().size()-2), WhiteListPageExt.class);
	}
	
	/**
	 * clcik this button to confirm some message 
	 * @return
	 * @throws Exception
	 */
	public WhiteListPageExt clickConfirmMsgButton() throws Exception{
		return click(getConfirmButton(), WhiteListPageExt.class);
	}
}
