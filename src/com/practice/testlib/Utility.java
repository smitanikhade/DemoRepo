package com.practice.testlib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utility extends BaseTest{
	static WebDriver driver=null;
public Map<String, String> setMasterData() throws IOException
{
	Map<String, String> setData=new HashMap<String, String>();
	FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"//src//commandCenter.properties"));
    Properties prop=new Properties();
    prop.load(fis);
    setData.put("hostName", prop.getProperty("server.host.name"));
    setData.put("welcomePageTitle", prop.getProperty("welcome.page.title"));
    setData.put("browserName", prop.getProperty("browserName"));
	return setData;
	
}

/**
 * Method: checkElement_Existance
 * Description: This is wrapper method to check the existence of any web element on the page
 * @param getCommandCenter()
 * @param byElement - By identification of element existence on page
 * @author Mahesh Chewale   Creation Date: 18-Dec-2013   Modified Date: 
 */

public static boolean checkElementExistence(By byElement,int... sTimeInSecond)
{
  try 
  {
    int iLength = sTimeInSecond.length;
    WebDriverWait wait=null;
    if(iLength>0)
    {
       wait = new WebDriverWait(driver, sTimeInSecond[0]);
    }
    else
    {
       wait = new WebDriverWait(driver, 10);
    }
   wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
   WebElement ele= driver.findElement(byElement);
   return ele.isDisplayed();
  }
  catch(Exception e)
  {
    return false;
  }
}

/**
 * Method: waitToElementExist
 * Description: This is wrapper method wait for element existence
 * @param getCommandCenter()
 * @param byElement - By identification of element existence on page
 * @author Mahesh Chewale   Creation Date: 18-Dec-2013   Modified Date: 
 */

public static boolean waitToElementExist(By byElement,int iTimeInSecond)
{
  try 
  {
    WebDriver driver=null;
   WebDriverWait wait = new WebDriverWait(driver, iTimeInSecond);
   wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
   WebElement ele= driver.findElement(byElement);
   return ele.isDisplayed();
  }
  catch(Exception e)
  {
    return false;
  }
}

/**
 * Method: waitForElementPresence
 * Description: This is wrapper method wait for element visibility
 * @param getCommandCenter()
 * @param byElement - By identification of element existence on page
 * @author Santhanalakshmi Selvaraj   Creation Date: 07-Aug-2014   Modified Date: 19-Aug-2014
 */

public static boolean waitForElementPresence(By byElement,int iTimeInSecond)
{
  try 
  {
   WebDriverWait wait = new WebDriverWait(driver, iTimeInSecond);
   wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
   WebElement element= driver.findElement(byElement);
   
   return element.isDisplayed();
  }
  catch(Exception e)
  {
    

    report.info("Element not fount in "+iTimeInSecond+" seconds.");
    return false;
  }
}
/**
 * Method: waitForElementToBeClickable
 * Description: This is wrapper method wait for element to be clickable
 * @param getCommandCenter()
 * @param byElement - By identification of element to be clickable on page
 * @author Santhanalakshmi Selvaraj   Creation Date: 07-Aug-2014   Modified Date: 19-Aug-2014
 */

public static boolean waitForElementToBeclickable(By byElement,int iTimeInSecond)
{
  try 
  {
   WebDriverWait wait = new WebDriverWait(driver, iTimeInSecond);
   wait.until(ExpectedConditions.elementToBeClickable(byElement));
   WebElement element= driver.findElement(byElement);
   return element.isDisplayed();
  }
  catch(Exception e)
  {
 
  report.info("Element not fount in "+iTimeInSecond+" seconds.");
    return false;
  }
}

/**
 * Method: waitForElementInvisible
 * Description: This is wrapper method wait for element invisibility
 * @param getCommandCenter()
 * @param byElement - By identification of element not existing on page
 * @author Santhanalakshmi Selvaraj   Creation Date: 07-Aug-2014   Modified Date: 17-Mar-2016
 */

public static boolean waitForElementToBeInvisible(By byElement,int iTimeInSecond)
{
  try 
  {
   WebDriverWait wait = new WebDriverWait(driver, iTimeInSecond);
   wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
   WebElement element= driver.findElement(byElement);
   return element.isDisplayed();
  }
  catch(Exception e)
  {
  	
  	report.info("Element not fount in "+iTimeInSecond+" seconds.");
    return false;
  }
}

/**
 * Method: waitToElementExist
 * Description: This is wrapper method wait for element existence
 * @param getCommandCenter()
 * @param byElement - By identification of element existence on page
 * @author Mahesh Chewale   Creation Date: 18-Dec-2013   Modified Date: 
 */


/**
 * Method: waitForframeToBeAvailableAndSwitchToIt
 * Description: This is wrapper method wait for frame To Be Available And Switch To It
 * @param getCommandCenter()
 * @param byElement - By identification of frame to be available and switch to it
 * @author Santhanalakshmi Selvaraj   Creation Date: 22-Apr-2016   
 */

public static boolean waitForframeToBeAvailableAndSwitchToIt(By byElement,int iTimeInSecond)
{
  try 
  {
   WebDriverWait wait = new WebDriverWait(driver, iTimeInSecond);
   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(byElement));
   WebElement element= driver.findElement(byElement);
   return element.isDisplayed();
  }
  catch(Exception e)
  {
  report.info("Element not fount in "+iTimeInSecond+" seconds.");
    return false;
  }
}

public static boolean waitToElementDisappear(By byElement,int iTimeInSecond)
{
  try 
  {
   WebDriverWait wait = new WebDriverWait(driver, iTimeInSecond);
   wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(byElement)));
   WebElement ele= driver.findElement(byElement);
   return ele.isDisplayed();
  }
  catch(Exception e)
  {
  report.info("Element not fount in "+iTimeInSecond+" seconds.");
    return false;
  }
}


}
