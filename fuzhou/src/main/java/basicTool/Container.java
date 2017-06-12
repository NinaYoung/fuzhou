package basicTool;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class Container {

    protected int index;
    protected List<WebElement> parentElement;

    public Container(List<WebElement> parentElement) {
        this.parentElement = parentElement;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getAmount() {
        return parentElement.size();
    }

    protected WebElement getElementByText(By by, String text) throws Exception {
        for (WebElement element : parentElement) {
            if (element.findElement(by).getText().equals(text))
                return element.findElement(by);
        }
        throw new Exception("Element with text '" + text + "' was not foun!");
    }

    protected WebElement getElementByPartialText(By by, String text) throws Exception {
        for (WebElement element : parentElement) {
            if (element.findElement(by).getText().contains(text))
                return element.findElement(by);
        }
        throw new Exception("Element with partial text '" + text + "' was not foun!");
    }

    protected WebElement getElementByPartialValue(By by, String text) throws Exception {
        for (WebElement element : parentElement) {
            if (element.findElement(by).getAttribute("value").contains(text)) {
                return element.findElement(by);
            }
        }
        throw new Exception("Element with partial text '" + text + "' was not foun!");
    }

    protected int getElementIndexByText(By by, String text) {
        for (WebElement element : parentElement) {
            if (element.findElement(by).getText().equals(text))
                return parentElement.indexOf(element);
        }
        return -1;
    }

    protected int getElementIndexByPartialText(By by, String text) {
        for (WebElement element : parentElement) {
            if (element.findElement(by).getText().contains(text))
                return parentElement.indexOf(element);
        }
        return -1;
    }

    protected int getElementIndexByPartialValue(By by, String text) {
        for (WebElement element : parentElement) {
            if (element.findElement(by).getAttribute("value").contains(text))
                return parentElement.indexOf(element);
        }
        return -1;
    }

    protected WebElement getElement(int index, By by) {
        return parentElement.get(index).findElement(by);
    }

    protected WebElement getElement(By by) {
        return parentElement.get(index).findElement(by);
    }

    protected String getElement(int index) {
        return parentElement.get(index).getText();
    }

}
