package basicTool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTool {

    /**
     * Default wait time for an element. 60 seconds.
     * <p>
     * This value should be access through the getDefaultWait4Element static method, to ensure that any application
     * specific overrides are applied
     */
    public static final int DEFAULT_WAIT_4_ELEMENT = 60;
    private static int defaultWait4Element = DEFAULT_WAIT_4_ELEMENT;

    /**
     * Set the default value used by this tool for element timeout. If not set, the default is DEFAULT_WAIT_4_ELEMENT
     * timeout.
     * 
     * @param timeoutInSeconds
     *            the new timeout value. If <code>null</code> the value reverts back to DEFAULT_WAIT_4_ELEMENT.
     */
    public static void setDefaultWait4Element(Integer timeoutInSeconds) {
        defaultWait4Element = timeoutInSeconds == null ? WaitTool.DEFAULT_WAIT_4_ELEMENT : timeoutInSeconds;
    }

    /**
     * Get the default value used by this tool for element timeout. If not set using the
     * <code>setDefaultWait4Element</code> method, the default is DEFAULT_WAIT_4_ELEMENT timeout.
     * 
     * @return the timeout value.
     */
    public static int getDefaultWait4Element() {
        return defaultWait4Element;
    }

    /**
     * Default wait time for a page to be displayed. 12 seconds. The average web page load time is 6 seconds in 2012.
     * Based on your tests, please set this value. "0" will nullify implicitlyWait and speed up a test.
     * <p>
     * This value should be access through the getDefaultWait4Element static method, to ensure that any application
     * specific overrides are applied
     */
    public static final int DEFAULT_WAIT_4_PAGE = 60;
    private static int defaultWait4Page = DEFAULT_WAIT_4_PAGE;

    /**
     * Set the default value used by this tool for page load timeout. If not set, the default is DEFAULT_WAIT_4_ELEMENT
     * timeout. Note that this timeout may also be used for element arrive, after an AJAX call.
     * 
     * @param timeoutInSeconds
     *            the new timeout value. If <code>null</code> the value reverts back to DEFAULT_WAIT_4_PAGE.
     */
    public static void setDefaultWait4Page(Integer timeoutInSeconds) {
        defaultWait4Page = timeoutInSeconds == null ? WaitTool.DEFAULT_WAIT_4_PAGE : timeoutInSeconds;
    }

    /**
     * Get the default value used by this tool for page load timeout. If not set using the
     * <code>setDefaultWait4Element</code> method, the default is DEFAULT_WAIT_4_ELEMENT timeout. Note that this timeout
     * may also be used for element arrive, after an AJAX call.
     * 
     * @return the timeout value.
     */
    public static int getDefaultWait4Page() {
        return defaultWait4Page;
    }

    /**
     * Default polling interval for an element by selenium is 500 milliseconds as specified by
     * WebDriverWait.DEFAULT_SLEEP_TIMEOUT.
     * <p>
     * This value should be access through the getDefaultPolling4Element static method, to ensure that any application
     * specific overrides are applied
     */
    public static final long DEFAULT_POLLING_4_ELEMENT = WebDriverWait.DEFAULT_SLEEP_TIMEOUT;
    private static long defaultPolling4Element = DEFAULT_POLLING_4_ELEMENT;

    /**
     * Set the default value used by this tool for element polling. If not set, the default is DEFAULT_POLLING_4_ELEMENT
     * time period.
     * 
     * @param timeoutInMilliSeconds
     *            the new polling value. If <code>null</code> the value reverts back to DEFAULT_POLLING_4_ELEMENT.
     */
    public static void setDefaultPolling4Element(Integer timeoutInMilliSeconds) {
        defaultPolling4Element = timeoutInMilliSeconds == null || timeoutInMilliSeconds <= DEFAULT_POLLING_4_ELEMENT
                ? DEFAULT_POLLING_4_ELEMENT : timeoutInMilliSeconds;
    }

    /**
     * Get the default value used by this tool for element polling. If not set using the
     * <code>setDefaultPolling4Element</code> method, the default is DEFAULT_POLLING_4_ELEMENT time period.
     * 
     * @return the timeout value.
     */
    public static long getDefaultPolling4Element() {
        return defaultPolling4Element;
    }

    /**
     * Wait for an expected an expectedCondition.
     *
     * @param driver
     *            The driver object to be used
     * @param expectedCondition
     *            The condition to wait for. See the <code>ExpectedConditions</code> class for the conditions one can
     *            wait for.
     * @param timeOutInSeconds
     *            The time in seconds to wait until returning a failure
     * @return the element returned by the condition provided
     * @throws TimeoutException
     *             if the timeout expires
     * @throws RuntimeException
     *             Wait will ignore instances of NotFoundException that are encountered (thrown) by default in the
     *             'until' condition, BUT immediately propagate all others.
     */
    public static <V> V waitFor(WebDriver driver, ExpectedCondition<V> expectedCondition, int timeOutInSeconds) {
        return new WebDriverWait(driver, timeOutInSeconds, defaultPolling4Element).until(expectedCondition);
    }

    /**
     * Wait for an expected an expectedCondition.
     *
     * @param driver
     *            The driver object to be used
     * @param expectedCondition
     *            The condition to wait for. See the <code>ExpectedConditions</code> class for the conditions one can
     *            wait for.
     * @param webElement
     *            The time in seconds to wait until returning a failure
     * @return the element returned by the condition provided
     * 
     * @throws NoFindWebElement
     *             can't find element
     */
    public static <V> Boolean waitFor(WebDriver driver, int timeOutInSeconds, final WebElement webElement) {
        return WaitTool.waitFor(driver, new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {
                    if (webElement.isDisplayed())
                        return true;

                return false;
            }
        }, timeOutInSeconds);

    }
    
    /**
     * Wait for an expected element invisible.
     * 
     * @param driver
     *            The driver object to be used
     * @param webElement
     *            The time in seconds to wait until returning a failure
     * @throws TimeoutException
     *             if the timeout expires
     * @throws RuntimeException
     *             Wait will ignore instances of NotFoundException that are encountered (thrown) by default in the
     *             'until' condition, BUT immediately propagate all others.
     */
    public static void waitUnitElementIsInvisible(WebDriver driver, By elementLocator){
    	ExpectedCondition<Boolean> condition = ExpectedConditions.invisibilityOfElementLocated(elementLocator);
    	waitFor(driver, condition);
    }

    /**
     * Wait for an expected an expectedCondition.
     * 
     * @param driver
     *            The driver object to be used
     * @param expectedCondition
     *            The condition to wait for. See the <code>ExpectedConditions</code> class for the conditions one can
     *            wait for.
     * @return the element returned by the condition provided
     * @throws TimeoutException
     *             if the timeout expires
     * @throws RuntimeException
     *             Wait will ignore instances of NotFoundException that are encountered (thrown) by default in the
     *             'until' condition, BUT immediately propagate all others.
     */
    public static <V> V waitFor(WebDriver driver, ExpectedCondition<V> expectedCondition) {
        return waitFor(driver, expectedCondition, defaultWait4Page);
    }

    /**
     * Expected for an element to appear on the refreshed web-page. And returns the first WebElement using the given
     * method.
     *
     * This method is to deal with dynamic pages.
     * 
     * Some sites I (Mark) have tested have required a page refresh to add additional elements to the DOM. Generally you
     * (Chon) wouldn't need to do this in a typical AJAX scenario.
     * 
     * @return the condition expectation
     * 
     * @author Mark Collin
     */
    public static ExpectedCondition<WebElement> elementAppearsOnRefresh(final By by) {
        return new ExpectedCondition<WebElement>() {

            @Override
            public WebElement apply(WebDriver driverObject) {
                // refresh the page
                // ****************
                driverObject.navigate().refresh();
                WebElement element = driverObject.findElement(by);
                return element.isDisplayed() ? element : null;
            }
        };
    }

    /**
     * Expect Text to be present in the given element, regardless of being displayed or not.
     *
     * @param locator
     *            selector of the given element, which should contain the text
     * @param text
     *            The text we are looking
     * 
     * @return the condition expectation
     */
    public static ExpectedCondition<Boolean> textPresent(final By locator, final String text) {
        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driverObject) {
                // is the Text in the DOM
                return driverObject.findElement(locator).getText().contains(text);
            }
        };
    }

    /**
     * Expect Condition of JavaScript.
     * 
     * @param javaScript
     *            The javaScript condition we are waiting. e.g. {@literal"return (xmlhttp.readyState >= 2 &&
     *            xmlhttp.status == 200)"}
     * @return the condition expectation
     **/
    public static ExpectedCondition<Boolean> javaScriptCondition(final String javaScript) {
        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driverObject) {
                return (Boolean) ((JavascriptExecutor) driverObject).executeScript(javaScript);
            }
        };
    }

    /**
     * Expect the completion of Ajax jQuery processing by checking "return jQuery.active == 0" condition.
     * 
     * @return the condition expectation
     **/
    public static ExpectedCondition<Boolean> jQueryProcessingDone() {
        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driverObject) {
                return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active == 0");
            }
        };
    }

    /**
     * Expect the current document itself and its sub-resources (such as images, frames, etc) is loaded completed. It
     * checks if the document.readyState becomes "complete".
     * 
     * @return the condition expectation
     */
    public static ExpectedCondition<Boolean> pageLoadDone() {
        // wait for Javascript to load
        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driverObject) {
                return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
    }

    /**
     * Coming to implicit wait, If you have set it once then you would have to explicitly set it to zero to nullify it -
     */
    public static void nullifyImplicitWait(WebDriver driver) {
        // nullify implicitlyWait()
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    /**
     * Set driver implicitlyWait() time.
     */
    public static void setImplicitWait(WebDriver driver, int waitTime_InSeconds) {
        driver.manage().timeouts().implicitlyWait(waitTime_InSeconds, TimeUnit.SECONDS);
    }

    /**
     * Reset ImplicitWait. To reset ImplicitWait time you would have to explicitly set it to zero to nullify it before
     * setting it with a new time value.
     */
    public static void resetImplicitWait(WebDriver driver) {
        // nullify implicitlyWait()
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        // reset implicitlyWait
        driver.manage().timeouts().implicitlyWait(getDefaultWait4Page(), TimeUnit.SECONDS);
    }

    /**
     * Reset ImplicitWait.
     * 
     * @param newWaittime_InSeconds
     *            a new wait time in seconds
     */
    public static void resetImplicitWait(WebDriver driver, int newWaittime_InSeconds) {
        // nullify implicitlyWait()
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        // reset implicitlyWait
        driver.manage().timeouts().implicitlyWait(newWaittime_InSeconds, TimeUnit.SECONDS);
    }

    public static class NoFindWebElement extends Exception {
        public NoFindWebElement() {
        }

        public NoFindWebElement(String message) {
            super(message);
        }
    }

}
