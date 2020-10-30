package com.pageObjects.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestPage {
	WebDriver cd;
	By closepopupbutton=By.id("at-cv-lightbox-close");
	By InputForms=By.xpath("//ul[@class='nav navbar-nav']/li[1]/a[1]");
	
	public TestPage(WebDriver cd) {
		this.cd=cd;
	}
	
	public WebElement closepopup() {
		return cd.findElement(closepopupbutton);
	}
	
	public WebElement getInputForms() {
		return cd.findElement(InputForms);
	}

}
