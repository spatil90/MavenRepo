package com.pageObjects.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver cd;
	
	//private By demo_button=By.xpath("//a[text(),'Demo Website!']");
	private By demo_button=By.xpath("//*[@id=\"block-block-57\"]/div/div/a");
	
	
	
	public HomePage(WebDriver cd) {
		this.cd=cd;
	}



	public WebElement getDemoWebsiteButton() {
		return cd.findElement(demo_button);
	}

}
