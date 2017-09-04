package basicClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basicTool.WaitTool;
import basicTool.frame.FrameNavigator;

/**
 * this class is the basic class for pages to extend, there are some basic methods
 * @author YN
 *
 */
public class AbstractPage{

  

	protected WebDriver driver;
    public static final int DefaultWaitElementTime4Page = 60;
    protected final FrameNavigator frameNavigator;

    /**
     * Construct a Component Page Object until the page loaded.
     * 
     * @param driver
     *            the Selenium 2 WebDriver used by this class to manipulate the application
     * 
     * @throws TimeoutException
     *             if the timeout expires
     * 
     */
    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.frameNavigator = new FrameNavigator(driver, this);
        WaitTool.waitFor(driver, WaitTool.pageLoadDone());
        PageFactory.initElements(driver, this);
    }

    /**
     * Is this element currently displayed or not? This method avoids the problem of having to parse an element's
     * "style" attribute.
     * 
     * @param driver
     *            the instance of WebDriver manipulated
     * @return Whether or not the element is displayed
     */

    protected static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return false;
    }

    /**
     * Explicitly switch the current frame to the default frame for this page. This method is already invoked by all
     * methods in this class, where applicable.
     */
    protected void switchFrame() {
        frameNavigator.switchFrame();
    }

    /**
     * Explicitly switch the current frame to the frame of a WebElement. This method is already invoked by all methods
     * in this class, where applicable.
     * 
     * @param element
     *            the WebElement used to determine the target frame.
     */
    protected void switchFrame(WebElement element) {
        frameNavigator.switchFrame(element);
    }

    /**
     * take a screenshot before click 
     * @throws IOException
     */
    private void clickBefore() throws IOException{
    	File screenShotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	long date = new Date().getTime();
    	FileUtils.copyFile(screenShotFile, new File("test-output/screenshots/"+ date +".png"));
    }
    /**
     * take a screenshot after click to show the original page
     * @throws IOException
     */
    private void clickAfter() throws IOException{
    	File screenShotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	long date = new Date().getTime();
    	FileUtils.copyFile(screenShotFile, new File("test-output/screenshots/"+ date +".png"));
    }
    
    /**
     * A simple click mehtod
     * 
     * @param element
     *            the element you want to click
     */
    protected void click(WebElement element) {
        switchFrame(element);
        isDisplayed(element);
        element.click();

    }
    
    /**
     * Click one webElement to wait next page
     * 
     * @param element
     *            click on element
     * @param nextPageClass
     *            expect pageobject's class
     * @return
     * @throws Exception
     */
    protected <W extends AbstractPage> W click(WebElement element, Class<W> nextPageClass) throws Exception {
    	clickBefore();
        click(element);
        clickAfter();
        return nextPageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
    }

    /**
     * Click one webElement to wait next webElement
     * 
     * @param element
     *            click on element
     * @param expectedElement
     *            except to get element
     * @return
     * @throws Exception
     */
    protected WebElement click(WebElement element, WebElement expectedElement) throws Exception {
    	clickBefore();
        click(element);
        clickAfter();
        return ((WebElement) WaitTool.waitFor(this.driver, ExpectedConditions.visibilityOf(expectedElement),
                WaitTool.getDefaultWait4Page()));
    }

    /**
     * Set content into webElement
     * 
     * @param element
     *            need to fill content element
     * @param content
     *            want to fill content
     */
    protected void setInputText(WebElement element, String content) {
        switchFrame(element);
        element.clear();
        element.sendKeys(new CharSequence[] { content });
    }

    /**
     * 
     * @param element
     * 
     *            move to element
     * 
     * @return
     * 
     *         after page
     * 
     * @throws Exception
     */
    protected <W extends AbstractPage> W moveToElement(WebElement element) throws Exception {
        new Actions(driver).moveToElement(element).build().perform();
        return (W) this;
    }

    /**
     * 
     * @param element
     * 
     *            move to element and click
     * @return
     * 
     *         after page
     * @throws Exception
     */
    protected <W extends AbstractPage> W moveToAndClickElement(WebElement element) throws Exception {
        (new Actions(driver)).moveToElement(element).click().perform();
        return (W) this;
    }

    /**
     * 
     * @param element
     * 
     *            click element and hold on
     * @return
     * 
     *         after page
     * @throws Exception
     */
    protected <W extends AbstractPage> W clickAndHold(WebElement element) throws Exception {
        (new Actions(driver)).clickAndHold(element).build().perform();
        return (W) this;
    }

    /**
     * 
     * @param name
     *            will click element's name
     * @param elementList
     *            have the same css element list that you want to click
     * @return want to get element
     * @throws Exception
     *             no have element
     */
    protected WebElement getWebElementByName(String name, List<WebElement> elementList) throws Exception {
        for (WebElement a : elementList) {
            if (a.getText().trim().equals(name))
                return a;
        }

        throw new Exception("No such element in this List");
    }

    /**
     * 
     * @param name
     *            will click element's name
     * @param elementList
     *            have the same css element list that you want to click
     * @return want to get element's index
     * @throws Exception
     *             no have element
     */
    protected int getWebElementIndexByName(String name, List<WebElement> elementList) throws Exception {

        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().trim().equals(name))
                return i;
        }

        throw new Exception("No such element in this List");
    }

}

