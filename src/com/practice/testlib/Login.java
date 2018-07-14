package com.practice.testlib;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.commonlib.DataPool;
import com.commonlib.ReportingLib;


import static com.practice.objectRepo.Login_ObjectRepo.*;

public class Login extends BaseTest{
	static WebDriver driver=null;
	protected static final Logger LOG = Logger.getLogger(ReportingLib.class);

	/*public void loginToAmazon(String feature, String useCaseId, String testcaseId, boolean isHardConstraint,int rowNum) {

		try {

			test = extent.createTest("verifyLoginPageTitle", "Checking login page Title");
			Map<String, String> testdata = DataPool.loadCSV("Login.csv", rowNum);
			Map<String, String> setData = utility.setMasterData();
			String hostName = setData.get("hostName");
			driver.get(hostName);
			//test.log(Status.INFO, hostName + " is opened");

			String pageTitle = driver.getTitle();
			String expPageTitle = setData.get("welcomePageTitle");
			boolean result = pageTitle.equals(expPageTitle);
			Assert.assertTrue(result);

			if(result) { // adding screenshots to log
				test.pass("Login page title is verified successfully",
						MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build()); }
			else { 
				test.pass("Login page title is not verified",
						MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build()); }

			// adding screenshots to test
			test.addScreenCaptureFromPath("screenshot.png");
			//test.log(Status.INFO, "Verified");

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(byYourOrders).click();
			String userName = DataPool.getData(testdata, "Username");
			driver.findElement(byEmail).sendKeys(userName);
			test.log(Status.INFO, "Email Id is entered");

			driver.findElement(byContinueBtn).click();
			test.log(Status.INFO, "Clicked on Continue Button");

			String inputTypeForUN = DataPool.getData(testdata, "InputTypeForUN");

			if (inputTypeForUN.equals("invalid")) {
				test = extent.createTest("verifyInvalidUNErrorMsg", "Checking invalid username error message");
				String expErrorMsg = DataPool.getData(testdata, "ErrorMsg");
				String errorMsg = driver.findElement(byUNErrorMsg).getText();
				Assert.assertTrue(errorMsg.trim().equals(expErrorMsg));
				if (errorMsg.trim().equals(expErrorMsg)) {
					test.pass("Error message for invalid username is verified successfully",
					MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());
				} else {
					test.fail("Error message for invalid username is not verified",
					MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());

				}

			} else {
				String password = DataPool.getData(testdata, "Password");
				driver.findElement(byPassword).sendKeys(password);
				test.log(Status.INFO, "Password is entered");

				driver.findElement(bySignInBtn).click();
				test.log(Status.INFO, "Clicked on Sign In Button");

				String inputTypeForPSW = DataPool.getData(testdata, "InputTypeForPSW");

				if (inputTypeForPSW.equals("invalid")) {
					test = extent.createTest("verifyInvalidPSWErrorMsg", "Checking invalid password error message");
					String expErrorMsg = DataPool.getData(testdata, "ErrorMsg");
					String errorMsg = driver.findElement(byPSWErrorMsg).getText();
					Assert.assertTrue(errorMsg.equals(expErrorMsg));
					if (errorMsg.equals(expErrorMsg)) {
						test.pass("Error message for invalid password is verified successfully",MediaEntityBuilder.createScreenCaptureFromPath("screenshot2.png").build());
					} else {
						test.fail("Error message for invalid password is not verified",MediaEntityBuilder.createScreenCaptureFromPath("screenshot2.png").build());

					}
				}
				else
				{
				test.log(Status.INFO, "Attempting to Sign in as \" + userName + \" (clicking \\\"Login\\\" button)");

				test= extent.createTest("verifyHomePageTitle", "Checking home page title");
				pageTitle = driver.getTitle();
				expPageTitle = setData.get("welcomePageTitle");
				result = pageTitle.equals(expPageTitle);
				Assert.assertTrue(result);
				if (result) {
					test.pass("User is able to login successfully",
					 MediaEntityBuilder.createScreenCaptureFromPath("screenshot2.png").build());

				} else {
					test.fail("User is not able to login",
							MediaEntityBuilder.createScreenCaptureFromPath("screenshot3.png").build());
				}
				driver.quit();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	 */


	static
	{
		try {

			Map<String, String> setData = utility.setMasterData();		
			String browserName = setData.get("browserName");
			String hostName = setData.get("server.host.name");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if(browserName.equals("Chrome"))
			{
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
				driver=new ChromeDriver();
			}
			else if(browserName.equals("Firefox"))
			{
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "Firefox");

				System.setProperty("webdriver.getko.driver", System.getProperty("user.dir")+"/getkodriver");
				driver=new FirefoxDriver();
			}
			else if(browserName.equals("IE"))
			{
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/internetExplorerDriver");
				driver=new InternetExplorerDriver();
			}
			driver.get(hostName);

		} catch (IOException e) {
			LOG.warn("Exception occurred in static block");
			e.printStackTrace();
		}



	}

	@SuppressWarnings("unchecked")
	public void loginToAmazon(String feature, String usecaseID, String testcaseID, boolean isHardConstraint, int rowNum) {

		PropertyConfigurator.configure("Log4j.properties");
        Utility.checkElementExistence(byYourOrders, 60);
		try {

			Map<String, String> testdata = DataPool.loadCSV("Login.csv", rowNum);
			Map<String, String> setData = utility.setMasterData();
			String pageTitle = driver.getTitle();
			
			String expPageTitle = setData.get("welcomePageTitle");
			boolean result = pageTitle.equals(expPageTitle);
			//Assert.assertTrue(result);

			if(result)
			{
				report.pass(feature, usecaseID, testcaseID, "Welcome page title should verify successfully", "Welcome page title is verified successfully", "Pass", true);
			}
			else
			{
				report.fail(feature, usecaseID, testcaseID, isHardConstraint, "Welcome page title should verify successfully", "Welcome page title is not verified", "Fail", true);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(byYourOrders).click();
			String userName = DataPool.getData(testdata, "Username");
			driver.findElement(byEmail).sendKeys(userName);

			driver.findElement(byContinueBtn).click();
			Utility.waitForElementPresence(byUNErrorMsg, 60);
			String inputTypeForUN = DataPool.getData(testdata, "InputTypeForUN");

			if (inputTypeForUN.equals("invalid")) {
				String expErrorMsg = DataPool.getData(testdata, "ErrorMsg");
				String errorMsg = driver.findElement(byUNErrorMsg).getText();
				//Assert.assertTrue(errorMsg.trim().equals(expErrorMsg));
				if (errorMsg.trim().equals(expErrorMsg)) 
				{
					report.pass(feature, usecaseID, testcaseID, "Expected Error msg for wrong username should be "+expErrorMsg, "Actual Error message for wrong username is "+errorMsg, "Pass", false);
				}
				else
				{
					report.fail(feature, usecaseID, testcaseID, isHardConstraint,"Expected Error msg for wrong username should be "+expErrorMsg, "Actual Error message for wrong username is "+errorMsg, "Fail", true);
				}

			} else {
				String password = DataPool.getData(testdata, "Password");
				driver.findElement(byPassword).sendKeys(password);

				driver.findElement(bySignInBtn).click();
				Utility.waitForElementPresence(byCartBtn, 60);

				String inputTypeForPSW = DataPool.getData(testdata, "InputTypeForPSW");

				if (inputTypeForPSW.equals("invalid")) {
					String expErrorMsg = DataPool.getData(testdata, "ErrorMsg");
					String errorMsg = driver.findElement(byPSWErrorMsg).getText();
					//Assert.assertTrue(errorMsg.equals(expErrorMsg));
					if (errorMsg.equals(expErrorMsg)) 
					{
						report.pass(feature, usecaseID, testcaseID, "Expected Error msg for wrong password should be "+expErrorMsg, "Actual Error message for wrong password is "+errorMsg, "Pass", false);
					}
					else
					{
						report.fail(feature, usecaseID, testcaseID, isHardConstraint,"Expected Error msg for wrong password should be "+expErrorMsg, "Actual Error message for wrong password is "+errorMsg, "Fail", true);
					}
				}
				//test.log(Status.INFO, "Attempting to Sign in as \" + userName + \" (clicking \\\"Login\\\" button)");

				// logger= extent.createTest("verifyHomePageTitle", "Checking home page title");
				pageTitle = driver.getTitle();
				expPageTitle = setData.get("welcomePageTitle");
				result = pageTitle.equals(expPageTitle);
				//Assert.assertTrue(result);
				if (result) 	{
					report.pass(feature, usecaseID, testcaseID, "Home page title should verify successfully", "Home page title is verified successfully", "Pass", false);
				}
				else
				{
					report.fail(feature, usecaseID, testcaseID, isHardConstraint, "Home page title should verify successfully", "Home page title is not verified", "Fail", true);
				}
				driver.quit();

			}
		} catch (Exception e) {
			report.fail(feature, usecaseID, testcaseID, "User should able to login", "Exception occurred while login","Exception occurred",e, true);
		}

	}

	/*public void logout() {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(byYourOrders)).build().perform();
			driver.findElement(bySignOutBtn).click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	 */
	
	/*
	 *//**
	 * 
	 * This function will take screenshot
	 * 
	 * @param webdriver
	 * 
	 * @param fileWithPath
	 * 
	 * @throws Exception
	 * 
	 *//*

	public static void takeSnapShot(String screenshotName) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(System.getProperty("user.dir") + "/test-screenshots/" + screenshotName);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}*/
}
