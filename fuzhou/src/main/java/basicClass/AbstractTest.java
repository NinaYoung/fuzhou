package basicClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * this class is for test script to extend, containing webDriver setup and tearDown
 * @author YN
 *
 */
public class AbstractTest {

	protected WebDriver driver  = new FirefoxDriver();
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		driver.get(AbstractData.getUrl());
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		this.driver.quit(); 
	}
	
	protected void takeScreenshot(String title) throws IOException{
		File screenShotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(screenShotFile, new File("/test-output/screenshots/"+ title +".png"));
	}
}
