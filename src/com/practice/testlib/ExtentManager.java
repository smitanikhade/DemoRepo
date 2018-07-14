package com.practice.testlib;

import java.util.Calendar;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	String packageName = new Exception().getStackTrace()[1].getClassName().toString();// gets

	@BeforeSuite
	public void setUp()
	{
		Calendar cal = Calendar.getInstance();// this is used to generate a time
		String token[] = packageName.split("\\.");
		int t = token.length;
		String filename = token[t-1]; 
		String reportFilename = filename + "_" + (cal.get(Calendar.MONTH) + 1) + cal.get(Calendar.DATE) + cal.get(Calendar.YEAR)
	    + cal.get(Calendar.HOUR) + cal.get(Calendar.MINUTE);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/src/com/practice/testresult/"+reportFilename+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "Mac Sierra");
		extent.setSystemInfo("Host Name", "Krishna");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Krishna Sakinala");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
		htmlReporter.config().setReportName("My Own Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterSuite
	public void tearDown()
	{
		extent.flush();
	}
}

