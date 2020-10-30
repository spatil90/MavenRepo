package com.practice.maven;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basic {
	WebDriver cd;
	Properties props;
	WebDriverWait wait;
	public WebDriver DriverInitialization() throws IOException {
		props=new Properties();
		FileInputStream f=new FileInputStream("C:\\Users\\CHETAN\\git\\MavenAppRemoteRepo\\Automation\\src\\main\\java\\data.properties");
		
		props.load(f);
		String Browser_name=props.getProperty("Browser");
		if(Browser_name.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Snehal\\Drivers\\chromedriver.exe");
			 cd=new ChromeDriver();
		}
		
		if(Browser_name.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Snehal\\Drivers\\geckodriver.exe");
			 cd=new FirefoxDriver();
		}
		
		if(Browser_name.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Snehal\\Drivers\\IEDriverServer.exe");
			 cd=new InternetExplorerDriver();
		}
		
		
	cd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	return cd;
	}
	
	public void getScreenShot(String testcaseName, WebDriver cd) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)cd;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}

}
