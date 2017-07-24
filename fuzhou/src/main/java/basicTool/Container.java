package basicTool;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basicClass.AbstractContainer;

public class Container extends AbstractContainer {

	public Container(List<WebElement> parentElement) {
		super(parentElement);
	}
	
	/**
	 * using by to get an element at the index  
	 */
	public WebElement getElement(int index, By by) {
		return super.getElement(index, by);
	}
	
	/**
	 * using by to get an element and the element matchs text
	 */
	public int getElementIndexByText(By by, String text){
		return super.getElementIndexByText(by, text);
	}
}
