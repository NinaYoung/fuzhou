package basicTool;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;

import basicTool.window.WindowsUtil;


public class SeleniumUtils {
	
	protected WebDriver driver;
	
	private SeleniumUtils(WebDriver driver) {
	        this.driver = driver;
	    }

	public static synchronized SeleniumUtils getInstance(WebDriver driver) {
		return new SeleniumUtils(driver);
	}
    /**
     * Switch selenium driver to another window. If objective window is not specified, will switch to a window that is not the current one.
     * 
     * @param windowHandler the window handler which you want to switch to.
     * @return If objective window is specified, will return null; else return
     *         the previous windows handler.
     */
    public String switchWindow(String windowHandler) {
        if (windowHandler != null && !windowHandler.isEmpty()) {
        	driver.switchTo().window(windowHandler);
            return null;
        }
        
        final String parentHandle = driver.getWindowHandle();
        System.out.println("parentHandle" + parentHandle);
        new WebDriverWait(driver, 5000).until(new Function<WebDriver, Boolean>() {

            @Override
            public Boolean apply(WebDriver webDriver) {
                // TODO Auto-generated method stub
                for (String handle : driver.getWindowHandles()) {
                	System.out.println("handle:" + handle);
                    if (!handle.contains(parentHandle)) {
                    	driver.switchTo().window(handle);
                        return true;
                    }
                }
                return false; 
            }
        });
        return parentHandle;
    }
    
    /**
     * Switch selenium driver to another window. Will switch to a window that is not the current one.
     * 
     * @return If objective window is specified, will return null; else return
     *         the previous windows handler.
     */
    public String switchWindow() {
        return switchWindow(null);
    }

    /**
     * Capture pop-up window and close it, and then return back to origin one
     */
    public void switchToPopupWindow() {
        String parent = switchWindow();
        driver.close();
        switchWindow(parent);
    }
    
    /**
     * Switch to iframe
     * @param frameElement the iframe element
     */
    public void switchToFrame( WebElement frameElement) {
    	driver.switchTo().frame(frameElement);
    }
    
//    /**
//     * After switching to iframe and take screenshot
//     * @param frameElement the iframe element
//     * @param targetElement the iframe element expected to wait.
//     */
//    public static void handleIframeElement(AbstractElement target, AbstractElement expected) {
//        try {
//            target.clickonly();        
//            WebDriverWaitUtils.waitUntilElementIsVisible(expected.getLocator());            
//        }finally{
//            
//        }   
//    }
//    
    /**
     * Switch back to a parent frame
     * 
     * @param level The number of frames you want to get out from
     * @throws InterruptedException
     */
    public void switchToParentFrame( int level) throws InterruptedException {
        for(int i = 0; i < level; i++) {
        	driver.switchTo().parentFrame();
        }
        
        Thread.sleep(5000);
    }

    /**
     * Switch back to the main content or first frame of the page
     * meanwhile get a screenshot
     * @throws InterruptedException
     */
    public void switchToMainFrame() throws InterruptedException {
    	driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }
    
    public void openBlankPage() {
        driver.get("about:blank");
    }
    
    public void clearcookies() {
       driver.manage().deleteAllCookies();
    }
    
    /**
     * reset the size of the browser
     * @param width, the width of this browser that you want
     * @param height, the height of the browser that you want
     */
    public void reSizeBrowser(int width, int height) {
        Dimension d = new Dimension(width,height);
        driver.manage().window().setSize(d);
    }
   
    /**
     * Scroll the scrollbar to the bottom in a web element
     * @param webElement the webElement
     */
    public void scrollBottom(WebElement webElement) {
        String javascript = "arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor) driver).executeScript(javascript,webElement);
    }
    
    /**
     * Scroll to the up of a web page
     */
    public void scrollToTopOfPage() {
        String javascript = "window.scrollTo(0, 0)";
        ((JavascriptExecutor) driver).executeScript(javascript);
    }
    
}