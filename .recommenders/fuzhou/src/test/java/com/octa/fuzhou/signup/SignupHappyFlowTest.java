package com.octa.fuzhou.signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SignupHappyFlowTest {
 
//	@Test(dataProvider= "111")
	public static void main(String[] args){
		String url = "https:\\/\\/www.baidu.com" ;
		WebDriver driver = new FirefoxDriver();
		// Open baidu using FF
		driver.navigate().to(url);

		// Locate elements
		WebElement searchTextField = driver.findElement(By.id("kw"));
		WebElement searchButton = driver.findElement(By.id("su"));

		// Fill info and search
		searchTextField.sendKeys("bafenliang");
		searchButton.click();
	}
}
