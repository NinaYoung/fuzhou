package basicTool.frame;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import basicTool.WaitTool;

public class WindowsUtil {
    protected WebDriver driver;
    private String preservedWindow = null;

    private WindowsUtil(WebDriver driver) {
        this.driver = driver;
    }

    public static synchronized WindowsUtil getInstance(WebDriver driver) {
        return new WindowsUtil(driver);
    }

    /**
     * Explicitly switch the window to a new window. This method is already invoked by all methods in this class, where
     * applicable.
     * 
     * @return
     */
    public String switchWindow() {
        preservedWindow = driver.getWindowHandle();
        WaitTool.waitFor(driver, new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver input) {
                Set<String> windows = driver.getWindowHandles();
                return windows.size() > 1;
            }

        }, WaitTool.getDefaultWait4Page());
        Set<String> windows = driver.getWindowHandles();
        for (String wh : windows) {
            if (wh.equals(preservedWindow))
                continue;
            driver.switchTo().window(wh);
            break;
        }
        return preservedWindow;
    }

    /**
     * Explicitly switch from the new window to previous window. This method is already invoked by all methods in this
     * class, where applicable.
     * 
     * @return
     */
    public String switchBackToPreviousWindow() throws Exception {
        if (this.preservedWindow == null) {
            Set<String> windows = driver.getWindowHandles();
            if (windows.size() == 0)
                throw new Exception("No window available.");
            preservedWindow = windows.iterator().next();
        }
        driver.switchTo().window(preservedWindow);
        preservedWindow = null;
        return preservedWindow;
    }

    /**
     * obtain windows's count.
     * 
     * @return
     */
    public int getCurrentWindowCount() throws Exception {
        try {
            WaitTool.waitFor(driver, new ExpectedCondition<Boolean>() {

                public Boolean apply(WebDriver input) {
                    Set<String> windows = driver.getWindowHandles();
                    return windows.size() > 1;
                }

            }, 30);
        } catch (Exception e) {

        }
        return driver.getWindowHandles().size();
    }

}
