package cn.octa.fz.page.extend;

import org.apache.xalan.templates.ElemElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basicTool.Container;
import cn.octa.fz.page.WAFPage;

public class WAFPageExt extends WAFPage {
	
	BasePageExt basePageExt = new BasePageExt(driver);
	
	Container defenceHostContainer;

	public WAFPageExt(WebDriver driver) {
		super(driver);
		defenceHostContainer = new Container(getDefenceHostContainer());
		// TODO Auto-generated constructor stub
	}

	public BasePageExt getBasePageExt() {
		return basePageExt;
	}

	/**
	 * 点击 防护设置 按钮
	 * @return
	 * @throws Exception
	 */
	public WAFPageExt clickSetDefenceButton() throws Exception{
		return click(getSetDefenseButton(), WAFPageExt.class);
	}
	
	/**
	 * get index of this host
	 * @param by
	 * @param host
	 * @return
	 */
	public int getHostIndex(By by, String host){
		return defenceHostContainer.getElementIndexByText(by, host);
	}
	
	/**
	 * change http defence status
	 * @param host
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public WAFPageExt changeDefenceStatus(String host, String status) throws Exception{
		int index = defenceHostContainer.getElementIndexByText(getHost(), host);
		WebElement element = defenceHostContainer.getElement(index, getHttpDefence());
		boolean elementStatus= element.getAttribute("class").contains("selectBtnSet0");
		switch(status){
		case "alarm":
			if(elementStatus == true)
				return click(element, WAFPageExt.class);
	     break;
		case "defence":
			if(elementStatus == false)
				return click(element,WAFPageExt.class);
	     break;
	     default:
	    	 return this;		
		}
		return this;
	}
	
	/**
	 * after changing http status, confirm message
	 * @return
	 * @throws Exception
	 */
	public WAFPageExt confirmMsg() throws Exception{
		return click(getMsgConfirmButton(), WAFPageExt.class);
	}
}
