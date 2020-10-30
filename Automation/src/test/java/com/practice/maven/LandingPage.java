package com.practice.maven;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.pageObjects.maven.HomePage;
import com.pageObjects.maven.TestPage;

public class LandingPage extends Basic {
	WebDriver cd;
	private static Logger log =LogManager.getLogger(Basic.class.getName());

	@BeforeTest
	public void initializeDriver() throws IOException {
		cd = DriverInitialization();
		log.info("Driver is initialised");
		cd.get(props.getProperty("Url"));
		log.info("Home page is launched");
		cd.manage().window().maximize();
	}

	@Test
	public void navigateToTestPage() throws InterruptedException {

		HomePage hp = new HomePage(cd);
		hp.getDemoWebsiteButton().click();
		log.info("Clicked on Demo button");
		TestPage tp = new TestPage(cd);
		wait = new WebDriverWait(cd, 5);
		if(tp.closepopup().isDisplayed()) {
			tp.closepopup().click();
			log.info("Default pop up closed");
			}
			else
				log.info("Pop up not displayed");
		
	}
	/*
	 * @Test public void CheckPopupDisplay() throws InterruptedException { TestPage
	 * tp=new TestPage(cd); wait=new WebDriverWait(cd,10);
	 * wait.until(ExpectedConditions.elementToBeClickable(By.id(
	 * "at-cv-lightbox-close"))); Thread.sleep(5000);
	 * //Assert.assertTrue(tp.closepopup().isDisplayed()); }
	 */

	/*
	 * @Test() public void ClosePopup() throws InterruptedException {
	 * 
	 * TestPage tp=new TestPage(cd); Thread.sleep(5000); tp.closepopup().click();
	 * Thread.sleep(5000); }
	 */

	@AfterTest
	public void CloseBrowser() {
		cd.close();
	}

}
