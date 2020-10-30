package com.practice.maven;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends Basic implements ITestListener{
	
	ExtentReports extent=ExtentReporter.getReportObject();
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		 test=extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test case passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		
		// TODO Auto-generated method stub
		WebDriver cd=null;
		String testMethodName=result.getMethod().getMethodName();
		
		try {
			cd=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("cd").get(result.getInstance());
		} 
		catch(Exception e) {
			
		}
		
		try {
			getScreenShot(testMethodName, cd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
