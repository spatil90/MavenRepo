package com.practice.maven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.maven.TestPage;

public class Testing extends Basic{
	WebDriver cd;
	private static Logger log =LogManager.getLogger(Basic.class.getName());
	
	@BeforeTest
	public void initializeDriver() throws IOException {
		cd=DriverInitialization();
		cd.get(props.getProperty("TestUrl"));
		cd.manage().window().maximize();
	}
	
	@Test
	public void ClosePopup() throws InterruptedException {
		TestPage tp=new TestPage(cd);
		wait = new WebDriverWait(cd, 5);
		//wait.until(ExpectedConditions.visibilityOf(tp.closepopup()));
		
		if(tp.closepopupsize()>0) {
		tp.getClosePopupButton().click();
		log.info("Default pop up closed");
		}
		else
			log.info("Pop up not displayed");
	}
	@Test(dependsOnMethods="ClosePopup", alwaysRun=true)
	public void getInputForms() {
		TestPage tp=new TestPage(cd);
		tp.getInputForms().click();
		log.info("Clicked on Input Forms");
	}
	
		@AfterTest
	public void CloseBrowser() {
		cd.close();
	}

}
