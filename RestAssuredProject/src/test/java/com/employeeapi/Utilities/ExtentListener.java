package com.employeeapi.Utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentListener extends TestListenerAdapter {
	public  ExtentHtmlReporter htmlReport;
	public ExtentReports extent;
	public ExtentTest test;
	public void onFinish(ITestContext arg0) {
		extent.flush();
		Reporter.log(arg0.getName()+" Test finished.");
		
		
	}

	public void onStart(ITestContext arg0) {
		//extent=ExtentManager.getInstance();
		//test=extent.createTest(arg0.getName());
		//test=extent.createTest(arg0.getCurrentXmlTest().getName());
		//Specify the path of html report.
		htmlReport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myReport.html");
		//Title of report
		htmlReport.config().setDocumentTitle("Automation Report");
		//Set the report name like Functional Testing
		htmlReport.config().setReportName("Rest API Testing Report");
		htmlReport.config().setTheme(Theme.DARK);
	
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("Project Name","Employee Database API");
		extent.setSystemInfo("Host Name", "Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Pavan");
		
		Reporter.log(arg0.getName()+" Class Started.");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		//test.log(Status.FAIL, arg0.getThrowable());
		test=extent.createTest(arg0.getName());
		test.log(Status.FAIL, " Test case FAILED "+arg0.getName());
		test.log(Status.FAIL, "Test case FAILED "+arg0.getThrowable());
		Reporter.log(arg0.getMethod().getMethodName()+" Test *Failed* "+arg0.getThrowable());
		
	}

	public void onTestSkipped(ITestResult arg0) {
		//test.log(Status.SKIP, arg0.getThrowable());
		test=extent.createTest(arg0.getName());
		test.log(Status.SKIP, " Test case SKIPPED "+arg0.getName());
		test.log(Status.SKIP, " Test case SKIPPED "+arg0.getThrowable());
		Reporter.log(arg0.getMethod().getMethodName()+" Test skipped "+arg0.getThrowable());
		
		
	}

	public void onTestStart(ITestResult arg0) {
		//test.log(Status.INFO, arg0.getName()+" started.");
		test=extent.createTest(arg0.getName());
		test.log(Status.INFO,arg0.getMethod().getMethodName()+" Test Started.");
		Reporter.log(arg0.getMethod().getMethodName()+" Test started.");
		
		
	}

	public void onTestSuccess(ITestResult arg0) {
		//test.log(Status.PASS, arg0.getMethod().getMethodName()+" Passed.");
		test=extent.createTest(arg0.getName());//Create an entry for report
		test.log(Status.PASS, "Test Case PASSED "+arg0.getName());
		Reporter.log(arg0.getMethod().getMethodName()+" Test passed.");
	}

	
}
