package basicClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * this class is for test script to extend, containing webDriver setup and tearDown
 * @author YN
 *
 */
public class AbstractTest {

	protected WebDriver driver;
	
	@Parameters({"browser"})  
	@BeforeMethod(groups = {"signup","login","trustedAudit","whiteList","dataBase"})
	public void setUp(String browser) throws Exception {
		if(browser.contains("firefox")){
			driver = new FirefoxDriver();
		}else{
			System.setProperty("webdriver.chrome.driver", "");
			driver = new ChromeDriver();
		}
		driver.get(AbstractData.getUrl());
//		driver.get(testEnv);
	}
	
	@AfterMethod(groups = {"signup","login","trustedAudit","whiteList","dataBase"})
	public void tearDown() throws Exception{
		this.driver.quit(); 
	}
	
	protected void takeScreenshot(String title) throws IOException{
		File screenShotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(screenShotFile, new File("/test-output/screenshots/"+ title +".png"));
	}
}
